package com.Naveenautomation.Pages;

public enum SideBarOptions {
	LOGIN("Login"),
	REGISTER("Register"),
	FORGOTTEN_PASSWORD("Forgotten_password"),
	MY_ACCOUNT("My_Account"),
	REWARD_POINTS("Reward_Points"),
	NEWSLETTER("Newsletter"),
	TRANSACTIONS("Transactions"),
	DOWNLOADS("Downloads"),
	RECURRING_PAYMENTS("Recurring Payments"),
   LOGOUT("Logout");

	private String sideNavigationBar;
	
	SideBarOptions(String menu){
		sideNavigationBar=menu;
	}
	
  String  getsideNavigationBarOptions() {
	  return sideNavigationBar;
	 
	  
  }


	
}


