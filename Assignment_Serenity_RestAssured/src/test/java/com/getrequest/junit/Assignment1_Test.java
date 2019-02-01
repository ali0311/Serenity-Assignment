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
public class Assignment1_Test extends TestBase
{
	@Steps
	SerenitySteps steps;
	String alpha2_code ;
	
	///<Summary>
	/**URI : http://services.groupkt.com/country/get/iso2code/{alpha2_code} */
	///</Summary>
	
	@Title("REST web-service to search country by 2 character alphanumeric ISO code")
	@Test
	public void test01_GetDataWithIsoCode()
	{
		System.out.println("Test case no-1 : \n********Started************\n");
		alpha2_code = "IN";
		steps.passGetRequest("/country/get/iso2code/"+alpha2_code)
		.statusCode(200)
		.log()
		.all()
		.body("RestResponse.result.name", containsString("India"));
		
		System.out.println("Test case 1-----End----------");
	}
	
	
}
