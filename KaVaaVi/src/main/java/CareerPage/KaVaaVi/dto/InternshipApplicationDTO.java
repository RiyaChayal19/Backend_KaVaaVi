package CareerPage.KaVaaVi.dto;

public class InternshipApplicationDTO {
    private int id;
    private String name;
    private String email;
    private String mobile_no;
    private String designation;
    private String branch;
    private Integer passingYr;
    private String domain;
    private String experience;

    // Default constructor
    public InternshipApplicationDTO() {
        super();
    }

    // Constructor to initialize the DTO from the entity
    public InternshipApplicationDTO(int id, String name, String email, String mobile_no, 
                                     String designation, String branch, Integer passingYr, 
                                     String domain, String experience) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile_no = mobile_no;
        this.designation = designation;
        this.branch = branch;
        this.passingYr = passingYr;
        this.domain = domain;
        this.experience = experience;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Integer getPassingYr() {
        return passingYr;
    }

    public void setPassingYr(Integer passingYr) {
        this.passingYr = passingYr;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "InternshipApplicationDTO [id=" + id + ", name=" + name + ", email=" + email 
                + ", mobile_no=" + mobile_no + ", designation=" + designation 
                + ", branch=" + branch + ", passingYr=" + passingYr 
                + ", domain=" + domain + ", experience=" + experience + "]";
    }
}
