package com.murx.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	Properties properties;

	public void readPropertiesFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("murx.properties"));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		}
	}
	
	public String getPropertyValue(String key) {
		readPropertiesFile();
		return properties.getProperty(key);
	}
	
	public static void main(String[] args) {
		System.out.println(new ReadProperties().getPropertyValue("password"));
	}
}
