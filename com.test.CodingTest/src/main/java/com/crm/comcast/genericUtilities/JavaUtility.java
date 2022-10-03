package com.crm.comcast.genericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author 91636
 *
 */

public class JavaUtility 
{
	/**
	 * it is used to generate random number
	 * @return
	 */
public int getRandomNumber() 
{
	Random random=new Random();
	int ranNum = random.nextInt(1000);
	return ranNum;
}
/**
 * its is used to get system date and time in IST format
 * @return
 */
public String getSystemDateAndTimeInISTFormat()
{
	Date date=new Date();
	return date.toString();
	
}

/**
 * its is used to get system date and time in required format
 * @return
 */
public String getSystemDateAndTime() {
	Date d=new Date();
	String date = d.toString();
	//System.out.println(date);
	String YYYY = date.split(" ")[5];
	String DD = date.split(" ")[2];
	int MM=d.getMonth()+1;
	String finalformat = YYYY+" "+DD+" "+MM;
	return finalformat ;
	
}
}
