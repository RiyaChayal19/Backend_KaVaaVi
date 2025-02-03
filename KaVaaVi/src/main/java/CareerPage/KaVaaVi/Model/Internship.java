package CareerPage.KaVaaVi.Model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
public class Internship {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Internship_id;

    private String Title;
    private String Description;
    private String Requirement;
    private String Duration;
    private String Stipend;
    private String Location;
    // Change Date to LocalDate
    private LocalDate Posted_Date;
    private LocalDate Application_Deadline;

    // Default constructor
    public Internship() {}

    // Parameterized constructor
    public Internship(int internship_id, String title, String description, String requirement, String duration,
                      String stipend, String location, LocalDate posted_Date, LocalDate application_Deadline) {
        this.Internship_id = internship_id;
        this.Title = title;
        this.Description = description;
        this.Requirement = requirement;
        this.Duration = duration;
        this.Stipend = stipend;
        this.Location = location;
        this.Posted_Date = posted_Date;
        this.Application_Deadline = application_Deadline;
    }

    // Getters and Setters
    public int getInternship_id() { return Internship_id; }
    public void setInternship_id(int internship_id) { Internship_id = internship_id; }

    public String getTitle() { return Title; }
    public void setTitle(String title) { Title = title; }

    public String getDescription() { return Description; }
    public void setDescription(String description) { Description = description; }

    public String getRequirement() { return Requirement; }
    public void setRequirement(String requirement) { Requirement = requirement; }

    public String getDuration() { return Duration; }
    public void setDuration(String duration) { Duration = duration; }

    public String getStipend() { return Stipend; }
    public void setStipend(String stipend) { Stipend = stipend; }

    public String getLocation() { return Location; }
    public void setLocation(String location) { Location = location; }

    public LocalDate getPosted_Date() { return Posted_Date; }
    public void setPosted_Date(LocalDate posted_Date) { Posted_Date = posted_Date; }

    public LocalDate getApplication_Deadline() { return Application_Deadline; }
    public void setApplication_Deadline(LocalDate application_Deadline) { Application_Deadline = application_Deadline; }

    @Override
    public String toString() {
        return "Internship [Internship_id=" + Internship_id + ", Title=" + Title + ", Description=" + Description
                + ", Requirement=" + Requirement + ", Duration=" + Duration + ", Stipend=" + Stipend + ", Location="
                + Location + ", Posted_Date=" + Posted_Date + ", Application_Deadline=" + Application_Deadline + "]";
    }
}
