package com.qa.undostres.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.undostres.base.BaseTest;
import com.qa.undostres.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Story("US : Navigating to Page and doing payment")
public class LoginPageTest extends BaseTest {

	
	@Test
	@Description("TC_01: login Page url Test")
	@Severity(SeverityLevel.NORMAL)
	public void loginPageUrlTest() {
		String actUrl = loginPage.getLoginPageUrl();
		Assert.assertEquals(actUrl.contains(AppConstants.LOGIN_PAGE_URL_FRACTION), true);
	}

	@Test
	@Description("TC_02: Selectin operator as Telcel and fill the payment deatils")
	@Severity(SeverityLevel.NORMAL)
	public void selectingOperator() throws InterruptedException {
		loginPage.selectOperator();
		String actUrl=loginPage.navigatingToPaymentPage();
		Assert.assertEquals(actUrl.contains(AppConstants.PAYMENT_PAGE_URL), true);
		
	}
	
	@Test
	@Description("TC_03: Checking for successful payment ")
	@Severity(SeverityLevel.NORMAL)
	public void paymentPageTest() throws InterruptedException {
		loginPage.paymentPage();
		String actText=loginPage.rechargeSuccessFull();
		Assert.assertEquals(actText.contains(AppConstants.RECHARGE_SUCCESS_MESSG), true);
		
	}

	
	
	
	
	
}
