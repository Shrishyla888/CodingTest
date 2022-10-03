package com.crm.comcast.genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpClass implements IRetryAnalyzer
{
int counter=0;
int retrylimit=4;
	public boolean retry(ITestResult result) {
		if (counter<retrylimit) {
			counter++;
			return true;	
		}
		return false;
	}

}
