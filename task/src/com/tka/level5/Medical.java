package com.tka.level5;

public class Medical {
Integer patientId;
String patientname;
String patientDisease;
String patientCity;
public Medical() {
	super();
	// TODO Auto-generated constructor stub
}
public Medical(Integer patientId, String patientname, String patientDisease, String patientCity) {
	super();
	this.patientId = patientId;
	this.patientname = patientname;
	this.patientDisease = patientDisease;
	this.patientCity = patientCity;
}
public Integer getPatientId() {
	return patientId;
}
public void setPatientId(int patientId) {
	this.patientId = patientId;
}
public String getPatientname() {
	return patientname;
}
public void setPatientname(String patientname) {
	this.patientname = patientname;
}
public String getPatientDisease() {
	return patientDisease;
}
public void setPatientDisease(String patientDisease) {
	this.patientDisease = patientDisease;
}
public String getPatientCity() {
	return patientCity;
}
public void setPatientCity(String patientCity) {
	this.patientCity = patientCity;
}
@Override
public String toString() {
	return "Medical [patientId=" + patientId + ", patientname=" + patientname + ", patientDisease=" + patientDisease
			+ ", patientCity=" + patientCity + "]";
}

}
