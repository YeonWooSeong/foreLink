package ENTITY;

public class EmployeeEntity {	//직원내역 객체 클래스
	private int no;			//db의 시퀀스 값. 직원 구분을 위해 사용
	private String name;	//이름
	private String sex;		//성별
	private String phone;	//연락처
	//이메일 추가
	private String email; //이메일
	private String birth;	//생년월일
	private String license;		//자격증
	private String address;		//주소
	private String education;	//학력
	private String graduateDate;	//졸업년월
	private String skill;	//스킬
	private String job;		//업무
	private String grade;	//등급
	private String startdate;	//경력시작년월
	private String blankPeriod;	//공백기간
	private String totalCareer;	//총경력
	private String availdate;
	private String comment;
	private String description;
	
	public EmployeeEntity() {
		// TODO Auto-generated constructor stub
	}


	
	public String getAvaildate() {
		return availdate;
	}



	public void setAvaildate(String availdate) {
		this.availdate = availdate;
	}



	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getGraduateDate() {
		return graduateDate;
	}

	public void setGraduateDate(String graduateDate) {
		this.graduateDate = graduateDate;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBlankPeriod() {
		return blankPeriod;
	}

	public void setBlankPeriod(String blankPeriod) {
		this.blankPeriod = blankPeriod;
	}

	public String getTotalCareer() {
		return totalCareer;
	}

	public void setTotalCareer(String totalCareer) {
		this.totalCareer = totalCareer;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getdescription() {
		return description;
	}

	public String getComment() {
		return comment;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
