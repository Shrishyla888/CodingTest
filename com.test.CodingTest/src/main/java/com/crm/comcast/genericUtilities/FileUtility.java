package com.crm.comcast.genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author 91636
 *
 */
public class FileUtility 
{
/**
 * it s used to get common data from property file based on key which is you have specified as argument
 * @return
 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/data.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
		
	}
}
