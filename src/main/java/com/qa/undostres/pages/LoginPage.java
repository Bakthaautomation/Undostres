package com.qa.undostres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.undostres.constants.AppConstants;
import com.qa.undostres.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. By locator - OR
	
	private By selectOperator = By.xpath("//input[@data-qa='celular-operator']");
	private By selectNumberField= By.xpath("//input[@data-qa='celular-mobile']");
	private By selectAmount= By.xpath("//input[@data-qa='celular-amount']");
	private By selectAmountValue= By.xpath("(//li[@data-name='10'])[1]");
	private By clickOnPay= By.xpath("//button[@data-qa='celular-pay']");
	private By selectOperatorValue = By.xpath("//li[@data-show='$10 (Recarga Saldo)']");
	private By clickOnTarjeta= By.xpath("//span[@id='cardGly']");
	private By checkForTrajetaButton=By.xpath("//tr[@id='radio-n']");
	private By passValueInToNumbero= By.xpath("//input[@data-qa='numero-de-tarjeta-input']");
	private By passValueInToMes= By.xpath("//input[@data-qa='mes-input']");
	private By passValueInToAno= By.xpath("//input[@data-qa='expyear-input']");
	private By passValueInToCvv= By.xpath("//input[@data-qa='cvv-input']");
	private By passValueInToEmail= By.xpath("//input[@type='email']");
	private By clickOnPagar= By.xpath("//button[@id='paylimit']]");
	private By passvalueInToCorreo= By.xpath("//input[@id='usrname']");
	private By passvalueInToContra= By.xpath("//input[@id='psw']");
	private By successMes= By.xpath("//span[contains(text(),'Permanece en esta pantalla mientras procesamos tu pago.')]");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. page actions:
	@Step("getting login page url")
	public String getLoginPageUrl() {
		String url = eleUtil.waitForUrl(AppConstants.SMALL_DEFAULT_TIME_OUT, AppConstants.LOGIN_PAGE_URL_FRACTION);
		System.out.println("login page current url : " + url);
		return url;
	}

	@Step("Selecting Operator as Telcel")
	public void  selectOperator() throws InterruptedException {
		eleUtil.doSendKeys(selectNumberField,"8465433546");
		eleUtil.doClick(selectOperator);
		eleUtil.waitForElementPresence(selectOperator, 3000);
		eleUtil.doSelectValueFromDropDown(selectOperatorValue, "Telcel");
		eleUtil.doClick(selectAmount);
		eleUtil.waitForElementPresence(selectAmount, 3000);
		eleUtil.doSelectValueFromDropDown(selectAmountValue, "$10");
		eleUtil.waitForElementPresence(clickOnPay, 3000);
		eleUtil.doClick(clickOnPay);
	}
	@Step("Navigating to PaymentPage")
	public String navigatingToPaymentPage() {
		String paymentPageValue = eleUtil.doElementGetText(clickOnTarjeta);
		System.out.println("Payement page is : " + paymentPageValue);
		return paymentPageValue;
	}
	
	@Step("Payment page")
	public void  paymentPage() throws InterruptedException {
		eleUtil.wait(3000);
		eleUtil.waitForElementPresence(clickOnTarjeta, 3000);
		eleUtil.doClick(clickOnTarjeta);
		eleUtil.waitForElementPresence(checkForTrajetaButton, 3000);
		eleUtil.doSelectValueFromDropDown(checkForTrajetaButton, "Usar nueva tarjeta");
		eleUtil.doSendKeys(passValueInToNumbero, "4111111111111111");
		eleUtil.doSendKeys(passValueInToMes, "11");
		eleUtil.doSendKeys(passValueInToAno, "25");
		eleUtil.doSendKeys(passValueInToCvv, "111");
		eleUtil.doSendKeys(passValueInToEmail, "test@test.com");
		eleUtil.doClick(clickOnPagar);
		eleUtil.doSendKeys(passvalueInToCorreo, "automationexcersise@test.com");
		eleUtil.doSendKeys(passvalueInToContra, "123456");
		
	}
	
	@Step("Checking successful message")
	public String rechargeSuccessFull() {
		String successfulValue = eleUtil.doElementGetText(successMes);
		System.out.println("Payement done : " + successfulValue);
		return successfulValue;
	}
	
	
}
