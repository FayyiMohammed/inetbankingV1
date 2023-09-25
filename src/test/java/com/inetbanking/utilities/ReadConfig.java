package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fin = new FileInputStream(src);
			pro = new Properties();
			pro.load(fin);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationUrl() {
		String url = pro.getProperty("baseURL");
		return url;

	}

	public String getUN() {
		String un = pro.getProperty("username");
		return un;

	}

	public String getPW() {
		String pw = pro.getProperty("password");
		return pw;

	}

	public String getChrome() {
		String chrome = pro.getProperty("chromepath");
		return chrome;

	}

	public String getIE() {
		String IE = pro.getProperty("msepath");
		return IE;

	}

	public String getFirefox() {
		String firefox = pro.getProperty("firefoxpath");
		return firefox;

	}

}
