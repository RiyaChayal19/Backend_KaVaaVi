package CareerPage.KaVaaVi.Controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import CareerPage.KaVaaVi.Model.Job;
import CareerPage.KaVaaVi.Model.Internship;
import CareerPage.KaVaaVi.Model.Job_Application;
import CareerPage.KaVaaVi.dto.InternshipApplicationDTO;
import CareerPage.KaVaaVi.dto.JobApplicationDTO;
import jakarta.persistence.TypedQuery;
import CareerPage.KaVaaVi.Model.Internship_Application;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@RestController 
@RequestMapping("/api") 
@CrossOrigin(origins = "http://localhost:3000")
public class KaVaaViController {

    @Autowired
    private SessionFactory sessionFactory;
    @PersistenceContext  // Use @PersistenceContext to inject EntityManager
    private EntityManager entityManager;

    @PostMapping("/Job-Enter")
    public Job saveJob(@RequestBody Job job) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(job);
            tx.commit();
            System.out.println("Job saved: " + job);
        } catch (Exception e) {
            tx.rollback();
            System.err.println("Error saving job: " + e.getMessage());
            throw e;
        } finally {
            session.close();
        }
        return job; 
    }
    
    @GetMapping("/getJob")
    public List<Job> getJob() {
        // Open Hibernate session
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Job> jobList = null;

        try {
            jobList = session.createQuery("from Job", Job.class).list();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.err.println("Error fetching jobs: " + e.getMessage());
        } finally {
            session.close();
        }
        return jobList; 
    }
    
    @PutMapping("/update-job/{id}")
    public ResponseEntity<String> updateJob(@PathVariable int id, @RequestBody Job updatedJob) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            
            Job existingJob = session.get(Job.class, id);
            if (existingJob != null) {
                // Update the fields of the existing job with new data
                existingJob.setTitle(updatedJob.getTitle());
                existingJob.setDescription(updatedJob.getDescription());
                existingJob.setJob_Type(updatedJob.getJob_Type());
                existingJob.setLocation(updatedJob.getLocation());
                existingJob.setRequirement(updatedJob.getRequirement());
                existingJob.setPackage(updatedJob.getPackage());
                existingJob.setPosted_Date(updatedJob.getPosted_Date());
                existingJob.setApplication_Deadline(updatedJob.getApplication_Deadline());
                session.update(existingJob);
                tx.commit();
                return ResponseEntity.ok("Job updated successfully!");
            } else {
                return ResponseEntity.status(404).body("Job not found with ID: " + id);
            }
        } catch (Exception e) {
            tx.rollback();
            return ResponseEntity.status(500).body("Error updating job: " + e.getMessage());
        } finally {
            session.close();
        }
    }
  
    @DeleteMapping("/delete-job/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            Job existingJob = session.get(Job.class, id);
            if (existingJob != null) {
                session.delete(existingJob);
                tx.commit();
                return ResponseEntity.ok("Job deleted successfully!");
            } else {
                return ResponseEntity.status(404).body("Job not found with ID: " + id);
            }
        } catch (Exception e) {
            tx.rollback();
            return ResponseEntity.status(500).body("Error deleting job: " + e.getMessage());
        } finally {
            session.close();
        }
    }
    
    @PostMapping("/Internship-Enter")
    public Internship saveInternship(@RequestBody Internship internship) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(internship);
            tx.commit();
            System.out.println("Job saved: " + internship);
        } catch (Exception e) {
            tx.rollback();
            System.err.println("Error saving internship: " + e.getMessage());
            throw e;
        } finally {
            session.close();
        }
        return internship; 
    }
    
    @GetMapping("/getInternship")
    public List<Internship> getInternship() {
        // Open Hibernate session
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Internship> internshipList = null;

        try {
        	internshipList = session.createQuery("from Internship", Internship.class).list();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.err.println("Error fetching internship: " + e.getMessage());
        } finally {
            session.close();
        }
        return internshipList; 
    }
    
    @PutMapping("/update-internship/{id}")
    public ResponseEntity<String> updateInternship(@PathVariable int id, @RequestBody Internship updatedInternship) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            Internship existingInternship = session.get(Internship.class, id);
            if (existingInternship != null) {
                // Update the fields of the existing internship with new data from the request body
                existingInternship.setTitle(updatedInternship.getTitle());
                existingInternship.setDescription(updatedInternship.getDescription());
                existingInternship.setRequirement(updatedInternship.getRequirement());
                existingInternship.setDuration(updatedInternship.getDuration());
                existingInternship.setStipend(updatedInternship.getStipend());
                existingInternship.setLocation(updatedInternship.getLocation());
                existingInternship.setPosted_Date(updatedInternship.getPosted_Date());
                existingInternship.setApplication_Deadline(updatedInternship.getApplication_Deadline());
                session.update(existingInternship);
                tx.commit();
                return ResponseEntity.ok("Internship updated successfully!");
            } else {
                return ResponseEntity.status(404).body("Internship not found with ID: " + id);
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return ResponseEntity.status(500).body("Error updating internship: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    @DeleteMapping("/delete-internship/{id}")
    public ResponseEntity<String> deleteInternship(@PathVariable int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            Internship existingInternship = session.get(Internship.class, id);
            if (existingInternship != null) {
                session.delete(existingInternship);
                tx.commit();
                return ResponseEntity.ok("Internship deleted successfully!");
            } else {
                return ResponseEntity.status(404).body("Internship not found with ID: " + id);
            }
        } catch (Exception e) {
            tx.rollback();
            return ResponseEntity.status(500).body("Error deleting Internship: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    @PostMapping("/apply")
    public Job_Application applyForJob(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("mobile_no") String mobileNo,
            @RequestParam("designation") String designation,
            @RequestParam("branch") String branch,
            @RequestParam("passingYr") Integer passingYr,
            @RequestParam("experience") String experience,
            @RequestParam("domain") String domain,
            @RequestParam("resume") MultipartFile resumeFile) throws IOException {

        // Convert resume file to byte array
        byte[] resumeBytes = resumeFile.getBytes();

        // Create Job_Application instance
        Job_Application jobApplication = new Job_Application();
        jobApplication.setName(name);
        jobApplication.setEmail(email);
        jobApplication.setMobile_no(mobileNo);
        jobApplication.setDesignation(designation);
        jobApplication.setBranch(branch);
        jobApplication.setPassingYr(passingYr);
        jobApplication.setExperience(experience);
        jobApplication.setDomain(domain);
        jobApplication.setResume(resumeBytes);

        // Save job application in the database
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(jobApplication); // Auto-generated id will be handled by the database
            tx.commit();
            System.out.println("Job Application saved: " + jobApplication);
        } catch (Exception e) {
            tx.rollback();
            System.err.println("Error saving job application: " + e.getMessage());
            throw e;
        } finally {
            session.close();
        }

        return jobApplication; // Return the saved job application object
    }
         
        /*@GetMapping("/appled_job")
        public List<Job_Application> getAllJobApplications() {
            // Create a session to get data from the database
            Session session = sessionFactory.openSession();
            List<Job_Application> jobApplications = null;
            try {
                // Fetch all job applications from the table
                jobApplications = session.createQuery("FROM Job_Application", Job_Application.class).list();
                if (jobApplications == null || jobApplications.isEmpty()) {
                    throw new RuntimeException("No job applications found.");
                }
                System.out.println("All job applications retrieved: " + jobApplications);
            } catch (Exception e) {
                System.err.println("Error retrieving job applications: " + e.getMessage());
                throw e;
            } finally {
                session.close();
            }
            return jobApplications;
        }*/
    
    @GetMapping("/appled_job")
    public List<JobApplicationDTO> getAllJobApplications() {
        Session session = sessionFactory.openSession();
        List<JobApplicationDTO> jobApplications = new ArrayList<>();
        try {
            List<Job_Application> jobApplicationList = session.createQuery("FROM Job_Application", Job_Application.class).list();
            if (jobApplicationList == null || jobApplicationList.isEmpty()) {
                throw new RuntimeException("No job applications found.");
            }

            // Convert Job_Application entities to DTOs
            for (Job_Application application : jobApplicationList) {
                JobApplicationDTO dto = new JobApplicationDTO();
                dto.setId(application.getId());
                dto.setName(application.getName());
                dto.setEmail(application.getEmail());
                dto.setMobileNo(application.getMobile_no());
                dto.setDesignation(application.getDesignation());
                dto.setBranch(application.getBranch());
                dto.setPassingYr(application.getPassingYr());
                dto.setExperience(application.getExperience());
                dto.setDomain(application.getDomain());
                // Do not include resume in DTO
                jobApplications.add(dto);
            }
        } catch (Exception e) {
            System.err.println("Error retrieving job applications: " + e.getMessage());
            throw e;
        } finally {
            session.close();
        }
        return jobApplications;
    }

        
        // API for download the resume

          /*@GetMapping("/applications/{id}/resume")
            public ResponseEntity<byte[]> getResume(@PathVariable int id) {
                // Create a session to retrieve the resume
                Session session = sessionFactory.openSession();
                Job_Application application;
                try {
                    application = session.get(Job_Application.class, id);
                    if (application == null) {
                        throw new RuntimeException("Job application not found for id: " + id);
                    }
                    byte[] resumeBytes = application.getResume();

                    // Prepare headers for file download
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(org.springframework.http.MediaType.APPLICATION_PDF);
                    headers.setContentDispositionFormData("attachment", "resume_" + id + ".pdf");

                    return new ResponseEntity<>(resumeBytes, headers, HttpStatus.OK);

                } catch (Exception e) {
                    System.err.println("Error retrieving resume: " + e.getMessage());
                    throw new RuntimeException("Failed to retrieve resume.", e);
                } finally {
                    session.close();
                }
            }*/
    
    /*@GetMapping("/applications/{id}/resume")
    public ResponseEntity<byte[]> getResume(@PathVariable int id) {
        Session session = sessionFactory.openSession();
        Job_Application application;
        try {
            application = session.get(Job_Application.class, id);
            if (application == null) {
                throw new RuntimeException("Job application not found for id: " + id);
            }
            byte[] resumeBytes = application.getResume();

            // Prepare headers for file download
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM);  // General file download type
            headers.setContentDispositionFormData("attachment", "resume_" + id + ".pdf");

            return new ResponseEntity<>(resumeBytes, headers, HttpStatus.OK);

        } catch (Exception e) {
            System.err.println("Error retrieving resume: " + e.getMessage());
            throw new RuntimeException("Failed to retrieve resume.", e);
        } finally {
            session.close();
        }
    }*/
    //download api for job_Application
    @GetMapping("/applications/{id}/resume")
    public ResponseEntity<byte[]> getResume(@PathVariable int id) {
        Session session = sessionFactory.openSession();
        Job_Application application;
        try {
            application = session.get(Job_Application.class, id);
            if (application == null) {
                throw new RuntimeException("Job application not found for id: " + id);
            }
            byte[] resumeBytes = application.getResume();

            // Check if the resume data is present and valid
            if (resumeBytes == null || resumeBytes.length == 0) {
                throw new RuntimeException("No resume found for the provided ID.");
            }

            // Set proper headers for a PDF file
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(org.springframework.http.MediaType.APPLICATION_PDF); // Set to PDF type
            headers.setContentDispositionFormData("attachment", "resume_" + id + ".pdf"); // Set filename for download

            return new ResponseEntity<>(resumeBytes, headers, HttpStatus.OK);

        } catch (Exception e) {
            System.err.println("Error retrieving resume: " + e.getMessage());
            throw new RuntimeException("Failed to retrieve resume.", e);
        } finally {
            session.close();
        }
    }

        @PostMapping("/apply_internship")
        public Internship_Application applyForInternship(@RequestParam("name") String name,
                                           @RequestParam("email") String email,
                                           @RequestParam("mobile_no") String mobileNo,
                                           @RequestParam("designation") String designation,
                                           @RequestParam("branch") String branch,
                                           @RequestParam("passingYr") Integer passingYr,
                                           @RequestParam("domain") String domain,
                                           @RequestParam("experience") String experience,
                                           @RequestParam("resume") MultipartFile resumeFile) throws IOException {

            // Read resume file as byte array
            byte[] resumeBytes = resumeFile.getBytes();

            // Create Job_Application instance
            Internship_Application internshipApplication = new Internship_Application();
            internshipApplication.setName(name);
            internshipApplication.setEmail(email);
            internshipApplication.setMobile_no(mobileNo);
            internshipApplication.setDesignation(designation);
            internshipApplication.setBranch(branch);
            internshipApplication.setPassingYr(passingYr);
            internshipApplication.setDomain(domain);
            internshipApplication.setExperience(experience);
            internshipApplication.setResume(resumeBytes);
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            try {
                session.save(internshipApplication);
                tx.commit();
                System.out.println("Internship Application saved: " + internshipApplication);
            } catch (Exception e) {
                tx.rollback();
                System.err.println("Error saving internship application: " + e.getMessage());
                throw e;
            } finally {
                session.close();
            }

            return internshipApplication; // Return saved job application
            }
             
        @GetMapping("/internship_applications")
        public List<InternshipApplicationDTO> getAllInternshipApplications() {
            Session session = sessionFactory.openSession();
            List<InternshipApplicationDTO> internshipApplications = new ArrayList<>();
            try {
                List<Internship_Application> internshipApplicationList = session.createQuery("FROM Internship_Application", Internship_Application.class).list();
                if (internshipApplicationList == null || internshipApplicationList.isEmpty()) {
                    throw new RuntimeException("No internship applications found.");
                }

                // Convert Internship_Application entities to DTOs
                for (Internship_Application application : internshipApplicationList) {
                    InternshipApplicationDTO dto = new InternshipApplicationDTO();
                    dto.setId(application.getId());
                    dto.setName(application.getName());
                    dto.setEmail(application.getEmail());
                    dto.setMobile_no(application.getMobile_no());
                    dto.setDesignation(application.getDesignation());
                    dto.setBranch(application.getBranch());
                    dto.setPassingYr(application.getPassingYr());
                    dto.setExperience(application.getExperience());
                    dto.setDomain(application.getDomain());
                    // Do not include resume in DTO
                    internshipApplications.add(dto);
                }
            } catch (Exception e) {
                System.err.println("Error retrieving internship applications: " + e.getMessage());
                throw e;
            } finally {
                session.close();
            }
            return internshipApplications;
        }
       
        //download api for internship_Application
        @GetMapping("/internshp_applications/{id}/resume")
        public ResponseEntity<byte[]> getResumEntity(@PathVariable int id) {
            Session session = sessionFactory.openSession();
            Internship_Application application;
            try {
                application = session.get(Internship_Application.class, id);
                if (application == null) {
                    throw new RuntimeException("Internship application not found for id: " + id);
                }
                byte[] resumeBytes = application.getResume();

                // Check if the resume data is present and valid
                if (resumeBytes == null || resumeBytes.length == 0) {
                    throw new RuntimeException("No resume found for the provided ID.");
                }

                // Set proper headers for a PDF file
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(org.springframework.http.MediaType.APPLICATION_PDF); // Set to PDF type
                headers.setContentDispositionFormData("attachment", "resume_" + id + ".pdf"); // Set filename for download

                return new ResponseEntity<>(resumeBytes, headers, HttpStatus.OK);

            } catch (Exception e) {
                System.err.println("Error retrieving resume: " + e.getMessage());
                throw new RuntimeException("Failed to retrieve resume.", e);
            } finally {
                session.close();
            }
        }
        

        //to search job
        @GetMapping("/search")
        public List<Job> searchJobs(@RequestParam String skills) {
            // Split the skills string into an array of skills
            String[] skillArray = skills.split(",");
            
            // Ensure that we trim any excess spaces from the skills
            for (int i = 0; i < skillArray.length; i++) {
                skillArray[i] = skillArray[i].trim();
            }

            // Build the dynamic query string based on the number of skills
            StringBuilder queryStr = new StringBuilder("SELECT j FROM Job j WHERE ");
            for (int i = 0; i < skillArray.length; i++) {
                if (i > 0) {
                    queryStr.append(" AND "); // Adding 'AND' for subsequent skills
                }
                queryStr.append("LOWER(j.Requirement) LIKE :skill" + i); // Only search in 'Requirement' field
            }

            // Prepare the query with the dynamic conditions
            TypedQuery<Job> query = entityManager.createQuery(queryStr.toString(), Job.class);

            // Set parameters for each skill
            for (int i = 0; i < skillArray.length; i++) {
                query.setParameter("skill" + i, "%" + skillArray[i].toLowerCase() + "%");
            }

            // Execute the query and return the result
            return query.getResultList();
        }
        
        //search internship
        
        @GetMapping("/search_internship")
        public List<Internship> searchInternship(@RequestParam String skills) {
            // Split the skills string into an array of skills
            String[] skillArray = skills.split(",");
            
            // Ensure that we trim any excess spaces from the skills
            for (int i = 0; i < skillArray.length; i++) {
                skillArray[i] = skillArray[i].trim();
            }

            // Build the dynamic query string based on the number of skills
            StringBuilder queryStr = new StringBuilder("SELECT j FROM Internship j WHERE ");
            for (int i = 0; i < skillArray.length; i++) {
                if (i > 0) {
                    queryStr.append(" AND "); // Adding 'AND' for subsequent skills
                }
                queryStr.append("LOWER(j.Requirement) LIKE :skill" + i); // Only search in 'Requirement' field
            }

            // Prepare the query with the dynamic conditions
            TypedQuery<Internship> query = entityManager.createQuery(queryStr.toString(), Internship.class);

            // Set parameters for each skill
            for (int i = 0; i < skillArray.length; i++) {
                query.setParameter("skill" + i, "%" + skillArray[i].toLowerCase() + "%");
            }

            // Execute the query and return the result
            return query.getResultList();
        }

 }
