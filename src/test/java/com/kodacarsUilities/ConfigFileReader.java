package com.kodacarsUilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private static ConfigFileReader configReader;

	private final String propertyFilePath = "src//test//resources//config//Configuration.properties";

	private ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}

	}

	public static ConfigFileReader getInstance() {
		if (configReader != null) {
			return configReader;
		} else {
			configReader = new ConfigFileReader();
			return configReader;
		}
	}

	public String getLoginUrl() {
		String loginUrl = properties.getProperty("loginUrl");
		if (loginUrl != null)
			return loginUrl;
		else
			throw new RuntimeException(" Index url not specified in the Configuration.properties file.");
	}

	public String getRegisterUrl() {
		String registerUrl = properties.getProperty("registerUrl");
		if (registerUrl != null)
			return registerUrl;
		else
			throw new RuntimeException(" register url not specified in the Configuration.properties file.");
	}

	public String getUsername() {
		String username = properties.getProperty("username");
		if (username != null)
			return username;
		else
			throw new RuntimeException("username  not specified in the Configuration.properties file.");
	}

	public String getPassword() {
		String password = properties.getProperty("password");
		if (password != null)
			return password;
		else
			throw new RuntimeException("password not specified in the Configuration.properties file.");
	}



}
