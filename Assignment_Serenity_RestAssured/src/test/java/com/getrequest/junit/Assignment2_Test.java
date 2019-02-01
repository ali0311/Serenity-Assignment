package com.getrequest.junit;
import static org.hamcrest.Matchers.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import static org.assertj.core.api.Assertions.assertThat;
import com.getrequest.cucumber.serenity.SerenitySteps;
import com.getrequest.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Assignment2_Test extends TestBase
{
	@Steps
	SerenitySteps steps;
	String countryCode ;
	String stateCode ;
	
	///<Summary>
	/**URI : http://services.groupkt.com/state/get/get/{countryCode}/{stateCode} */
	///</Summary>
	
	@Title("REST web-service to search state of a country")
	@Test
	public void test01_GetDataWithStateAndCountryCode()
	{
		System.out.println("Test case no-1 : \n********Started************\n");
		countryCode= "IND";
		stateCode = "UP" ;
		steps.passGetRequest("/state/get/"+countryCode+"/"+stateCode)
		.statusCode(200)
		.log()
		.all()
		.body("RestResponse.result.country", containsString("IND"))
		.and()
		.body("RestResponse.result.name", containsString("Uttar Pradesh"));
		
		System.out.println("Test case 1-----End----------");
	}
	
	
}
