package CareerPage.KaVaaVi.dto;

public class JobApplicationDTO {

    private int id;
    private String name;
    private String email;
    private String mobileNo;
    private String designation;
    private String branch;
    private Integer passingYr;
    private String experience;
    private String domain;

    // Constructor
    public JobApplicationDTO() {}

    public JobApplicationDTO(int id, String name, String email, String mobileNo, String designation, String branch,
                             Integer passingYr, String experience, String domain) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
        this.designation = designation;
        this.branch = branch;
        this.passingYr = passingYr;
        this.experience = experience;
        this.domain = domain;
    }

    // Getters and Setters
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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        return "JobApplicationDTO [id=" + id + ", name=" + name + ", email=" + email + ", mobileNo=" + mobileNo
                + ", designation=" + designation + ", branch=" + branch + ", passingYr=" + passingYr + ", experience="
                + experience + ", domain=" + domain + "]";
    }
}

