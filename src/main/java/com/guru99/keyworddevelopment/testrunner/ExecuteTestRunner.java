package com.guru99.keyworddevelopment.testrunner;

import com.guru99.keyworddevelopment.utils.ReusableFunction;

import java.io.IOException;

public class ExecuteTestRunner {

	public static void main(String[] args) throws IOException {
		ReusableFunction reusableFunction = new ReusableFunction();
		String[][] keywordData = reusableFunction.fetchDataFromExcel();

		for(int row = 1; row < keywordData.length; row++) {
			String function		= keywordData[row][3];
			String locator 		= keywordData[row][4];
			String locatorValue = reusableFunction.fetchProp(keywordData[row][5]);
			String parameter	= keywordData[row][6];
			String execute		= keywordData[row][7];

			System.out.println(function +"\t"+ locator +"\t"+ locatorValue +"\t"+ parameter);
			if(execute.equals("Y"))
			{
				if ("launchAppl".equals(function)) {
					reusableFunction.launchAppl();
				} else if ("fillText".equals(function)) {
					reusableFunction.fillText(locator, locatorValue, parameter);
				} else if ("click".equals(function)) {
					reusableFunction.click(locator, locatorValue);
				}
			}
		}
	}
}