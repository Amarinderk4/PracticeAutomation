package com.Naveenautomation.Environment;

public enum Environment {
	DEV("https://naveenautomationlabsdev.com/opencart/index.php?route=account/login"),
	STAGE("https://naveenautomationlabsdev.com/opencart/index.php?route=account/login"),
	QA("https://naveenautomationlabsqa.com/opencart/index.php?route=account/login"),
	PROD("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	
	String url;
	
	private Environment(String url) {
		this.url=url;
		
	}
     public String getUrl() {
	return url;
}
}
