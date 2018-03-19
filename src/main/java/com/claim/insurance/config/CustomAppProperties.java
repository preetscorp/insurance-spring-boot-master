package com.claim.insurance.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:em.properties")
@ConfigurationProperties()
public class CustomAppProperties {
	String reportFolder;

	public String getReportFolder() {
		return reportFolder;
	}

	public void setReportFolder(String reportFolder) {
		this.reportFolder = reportFolder;
	}

}
