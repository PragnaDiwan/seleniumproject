package com.qa.opencart.constants;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static  final String LOGIN_PAGE_TITLE="Account Login";
	
	public static final String LOGIN_PAGE_URL_FRACTION="account";
	
	public static final String ACCOUNT_PAGE_TITLE="My Account";
	public static final String ACCOUNT_PAGE_HEADER="Your Store";
	
	public static final int DEFAULT_TIMEOUT=5;

	public static final String REGISTER ="Your Account";

	public static List<String> getexpectedaccseclist()
	{
		List<String>expectedlist=new ArrayList<String>();
		expectedlist.add("My Account");
		expectedlist.add("My Orders");
		expectedlist.add("My Affiliate Account");
		expectedlist.add("Newsletter");
		return expectedlist;
	}
}
