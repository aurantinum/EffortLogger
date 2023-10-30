package com.EffortLogger;

public class TEst {
	public static void main(String[] args) {
	      String passwd = "aasdfaZ!!Za44@"; 
	      String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
	      System.out.println(passwd.matches(pattern));
	   }
}
