package CareerPage.KaVaaVi.Model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
@Entity
public class Internship_Application {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY) // Enable auto-increment
     private int id;
	  String Name;
	  String Email;
	  String Mobile_no;
	  String Designation;
	  String Branch;
	  Integer PassingYr;
	  String Domain;
	  String Experience;
	    @Lob
	    @JsonIgnore
	  private byte[] Resume;
	public Internship_Application() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Internship_Application(int id, String name, String email, String mobile_no, String designation,
			String branch, Integer passingYr, String domain, String experience, byte[] resume) {
		super();
		this.id = id;
		Name = name;
		Email = email;
		Mobile_no = mobile_no;
		Designation = designation;
		Branch = branch;
		PassingYr = passingYr;
		Domain = domain;
		Experience = experience;
		Resume = resume;
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
	public String getDomain() {
		return Domain;
	}
	public void setDomain(String domain) {
		Domain = domain;
	}
	public String getExperience() {
		return Experience;
	}
	public void setExperience(String experience) {
		Experience = experience;
	}
	public byte[] getResume() {
		return Resume;
	}
	public void setResume(byte[] resume) {
		Resume = resume;
	}
	@Override
	public String toString() {
		return "Internship_Application [id=" + id + ", Name=" + Name + ", Email=" + Email + ", Mobile_no=" + Mobile_no
				+ ", Designation=" + Designation + ", Branch=" + Branch + ", PassingYr=" + PassingYr + ", Domain="
				+ Domain + ", Experience=" + Experience + ", Resume=" + Arrays.toString(Resume) + "]";
	}
	   
	
}
