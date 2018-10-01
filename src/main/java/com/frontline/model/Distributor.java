package com.frontline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Distributor {

	@Id
	@GeneratedValue
int distributorid;
String distributorname;
String distributordesc;
public int getDistributorid() {
	return distributorid;
}
public void setDistributorid(int distributorid) {
	this.distributorid = distributorid;
}
public String getDistributorname() {
	return distributorname;
}
public void setDistributorname(String distributorname) {
	this.distributorname = distributorname;
}
public String getDistributordesc() {
	return distributordesc;
}
public void setDistributordesc(String distributordesc) {
	this.distributordesc = distributordesc;
}
	

}
