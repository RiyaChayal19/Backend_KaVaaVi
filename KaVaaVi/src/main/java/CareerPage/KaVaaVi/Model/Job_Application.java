package CareerPage.KaVaaVi.Model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
@Entity
public class Job_Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Enable auto-increment
    private int id;
    private String Name;
    private String Email;
    private String Mobile_no;
    private String Designation;
    private String Branch;
    private Integer PassingYr;
    private String Experience;
    private String Domain;

    @Lob
    private byte[] Resume;

    // Constructor
    public Job_Application() {
        super();
    }

    public Job_Application(int id, String name, String email, String mobile_no, String designation, String branch,
                           Integer passingYr, String experience, String domain, byte[] resume) {
        this.id = id;
        this.Name = name;
        this.Email = email;
        this.Mobile_no = mobile_no;
        this.Designation = designation;
        this.Branch = branch;
        this.PassingYr = passingYr;
        this.Experience = experience;
        this.Domain = domain;
        this.Resume = resume;
    } 
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getMobile_no() {
		return Mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		Mobile_no = mobile_no;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getBranch() {
		return Branch;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}

	public Integer getPassingYr() {
		return PassingYr;
	}

	public void setPassingYr(Integer passingYr) {
		PassingYr = passingYr;
	}

	public String getExperience() {
		return Experience;
	}

	public void setExperience(String experience) {
		Experience = experience;
	}

	public String getDomain() {
		return Domain;
	}

	public void setDomain(String domain) {
		Domain = domain;
	}

	public byte[] getResume() {
		return Resume;
	}

	public void setResume(byte[] resume) {
		Resume = resume;
	}

	@Override
    public String toString() {
        return "Job_Application [id=" + id + ", Name=" + Name + ", Email=" + Email + ", Mobile_no=" + Mobile_no
                + ", Designation=" + Designation + ", Branch=" + Branch + ", PassingYr=" + PassingYr + ", Experience="
                + Experience + ", Domain=" + Domain + ", Resume=" + "]";
    }
}
