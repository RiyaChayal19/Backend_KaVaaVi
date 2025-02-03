package CareerPage.KaVaaVi.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Job {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Enable auto-increment
    private int Job_id;
    String Title;
    String Description;
    String Requirement;
    String Location;
    String Job_Type;
    String Package;
    Date Posted_Date;
    Date Application_Deadline;
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Job(int job_id, String title, String description, String requirement, String location, String job_Type,
			String package1, Date posted_Date, Date application_Deadline) {
		super();
		Job_id = job_id;
		Title = title;
		Description = description;
		Requirement = requirement;
		Location = location;
		Job_Type = job_Type;
		Package = package1;
		Posted_Date = posted_Date;
		Application_Deadline = application_Deadline;
	}
	public int getJob_id() {
		return Job_id;
	}
	public void setJob_id(int job_id) {
		Job_id = job_id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getRequirement() {
		return Requirement;
	}
	public void setRequirement(String requirement) {
		Requirement = requirement;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getJob_Type() {
		return Job_Type;
	}
	public void setJob_Type(String job_Type) {
		Job_Type = job_Type;
	}
	public String getPackage() {
		return Package;
	}
	public void setPackage(String package1) {
		Package = package1;
	}
	public Date getPosted_Date() {
		return Posted_Date;
	}
	public void setPosted_Date(Date posted_Date) {
		Posted_Date = posted_Date;
	}
	public Date getApplication_Deadline() {
		return Application_Deadline;
	}
	public void setApplication_Deadline(Date application_Deadline) {
		Application_Deadline = application_Deadline;
	}
	@Override
	public String toString() {
		return "Job [Job_id=" + Job_id + ", Title=" + Title + ", Description=" + Description + ", Requirement="
				+ Requirement + ", Location=" + Location + ", Job_Type=" + Job_Type + ", Package=" + Package
				+ ", Posted_Date=" + Posted_Date + ", Application_Deadline=" + Application_Deadline + "]";
	}
	
}
