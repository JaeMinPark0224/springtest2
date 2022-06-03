package kh.spring.myboard.member.model.vo;

import java.sql.Date;

/*ID          NOT NULL VARCHAR2(15) 
PASSWD      NOT NULL VARCHAR2(15) 
NAME        NOT NULL VARCHAR2(20) 
EMAIL                VARCHAR2(30) 
GENDER               CHAR(1)      
AGE                  NUMBER       
PHONE                CHAR(13)     
ADDRESS              VARCHAR2(50) 
ENROLL_DATE          DATE */

public class Member {
	private String id;
	private String passwd;
	private String name;
	private String email ;
	private String gender;
	private String age;
	private String phone;
	private String address;
	private Date enroll_date;
	@Override
	public String toString() {
		return "Member [id=" + id + ", passwd=" + passwd + ", name=" + name + ", email=" + email + ", gender=" + gender
				+ ", age=" + age + ", phone=" + phone + ", address=" + address + ", enroll_date=" + enroll_date + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getEnroll_date() {
		return enroll_date;
	}
	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}
	
}
