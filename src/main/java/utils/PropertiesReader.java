package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	private static FileReader reader;
	private static String propertiesRoot = "src/test/resources/properties/";
	private static Properties properties = new Properties();

	public static String getPropertyValue(String propertyFileName, String propertyName) {
		String propertyPath = propertiesRoot + propertyFileName;

		try {
			reader = new FileReader(propertyPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			properties.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return properties.getProperty(propertyName);
	}
}
