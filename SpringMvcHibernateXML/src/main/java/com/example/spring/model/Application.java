package com.example.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="APPLICATION")
public class Application{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Application_Id")
	private int applicationId;
	
	
    @Column(name = "Name", nullable = false, length = 2000)
	private String name;	
	
	@Column(name = "Description", length = 2000)
	private String description;
	
	@NotNull
	@Digits(integer=18, fraction=0)
	@Column(name = "Status", nullable = false)
	private int status=1;
	
	
	@Column(name = "KeyWord", length = 400)
	private String keyword;
	
	
	@Column(name = "Bread_Crumb", length = 200)
	private String breadCrumb;
	
	
	@Column(name = "Button_Label", length = 20)
	private String buttonLabel;
	
	
	@Column(name = "Tab1_Text", length = 20)
	private String tab1Text;
	
	
	@Column(name = "Tab2_Text", length = 20)
	private String tab2Text;
	
	
	@Column(name = "Logo_Text", length = 20)
	private String logoText;
	
	/*@NotNull
	@Digits(integer=1, fraction=0)
	@Column(name = "DEFAULT_APPLICATION_FLAG", nullable = false, length = 5)
	private int deafaultApplicationFlag=0;*/
	
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getBreadCrumb() {
		return breadCrumb;
	}
	public void setBreadCrumb(String breadCrumb) {
		this.breadCrumb = breadCrumb;
	}
	public String getButtonLabel() {
		return buttonLabel;
	}
	public void setButtonLabel(String buttonLabel) {
		this.buttonLabel = buttonLabel;
	}
	public String getTab1Text() {
		return tab1Text;
	}
	public void setTab1Text(String tab1Text) {
		this.tab1Text = tab1Text;
	}
	public String getTab2Text() {
		return tab2Text;
	}
	public void setTab2Text(String tab2Text) {
		this.tab2Text = tab2Text;
	}
	public String getLogoText() {
		return logoText;
	}
	public void setLogoText(String logoText) {
		this.logoText = logoText;
	}
		
	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", name=" + name
				+ ", description=" + description + ", status=" + status
				+ ", keyword=" + keyword + ", breadCrumb=" + breadCrumb
				+ ", buttonLabel=" + buttonLabel + ", tab1Text=" + tab1Text
				+ ", tab2Text=" + tab2Text + ", logoText=" + logoText + "]";
	}
	
	
	
	
}

