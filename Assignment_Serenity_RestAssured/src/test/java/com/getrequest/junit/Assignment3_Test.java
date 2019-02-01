package com.getrequest.junit;
import static org.hamcrest.Matchers.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.getrequest.cucumber.serenity.SerenitySteps;
import com.getrequest.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Assignment3_Test extends TestBase
{
	@Steps
	SerenitySteps steps;
	String countryCode ;
	
	///<Summary>
	/**URI : http://services.groupkt.com/state/get/{countryCode}/all
	   When countryCode = IND */ 
	///</Summary>
	@Title("Validate details with valid country code")
	@Test
	public void test01_GetCorrectData()
	{
		System.out.println("Test case no-1 : \n********Started************\n");
		countryCode = "IND";
		
		steps.passGetRequest("/state/get/" +countryCode + "/all")
		.statusCode(200)
		.log()
		.all()
		.body("RestResponse.result",hasSize(36));
		
		System.out.println("Test case 1-----End----------");
	}
	
	/**When countryCode = Ind */
	@Title("Validate details with invalid country code")
	@Test
	public void test02_GetNoData()
	{
		System.out.println("Test case no-2 : \n********Started************\n");
		
		countryCode = "Ind";
		steps.passGetRequest("/state/get/" +countryCode + "/all")
		.statusCode(200)
		.log()
		.all()
		.body("RestResponse.result",hasSize(0));
		
		
		System.out.println("Test case 2-----End----------");
	}
}
