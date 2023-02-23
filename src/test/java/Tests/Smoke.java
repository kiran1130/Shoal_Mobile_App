package Tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import helper.Helper;
import pages.Biometrics;
import pages.Deposit;
import pages.Email;
import pages.Home;
import pages.Login;
import pages.Logout;
import pages.MobileNumber;
import pages.Name;
import pages.Notifications;
import pages.OTP;
import pages.ProfileConfirmation;
import pages.ResetPin;
import pages.ResetPinConfirm;
import pages.ResetPinEmailVerification;
import pages.ResetPinSmsVerification;
import pages.SecurityPIN;
import pages.SetNewPin;
import pages.ShoalUserWelcome;
import pages.TermsAndConditions;
import pages.Welcome;

@Listeners(Tests.MainListeners.class)
public class Smoke {

	@Test
	public static void loginLogout() {
		Login pf = new Login(MainListeners.getDriver());
		Logout pfLogout = new Logout(MainListeners.getDriver());
		OTP pfOTP = new OTP(MainListeners.getDriver());

		pf.login();

		//Entering Security PIN - 123456 (Default)
		pfOTP.enterOTP();

		pfLogout.logout();
	}

	@Test
	public static void signUp() throws InterruptedException {
		Welcome pfWelcomePage = new Welcome(MainListeners.getDriver());
		Name pfNamePage = new Name(MainListeners.getDriver());
		MobileNumber pfMobNumberPage = new MobileNumber(MainListeners.getDriver());
		OTP pfOTP = new OTP(MainListeners.getDriver());
		Email pfEmailPage = new Email(MainListeners.getDriver());
		SecurityPIN pfSecurityPIN = new SecurityPIN(MainListeners.getDriver());
		Biometrics pfBiometricsPage = new Biometrics(MainListeners.getDriver());
		Notifications pfNotifications = new Notifications(MainListeners.getDriver());
		TermsAndConditions pfTnCPage= new TermsAndConditions(MainListeners.getDriver());
		ProfileConfirmation pfProfileConfirm = new ProfileConfirmation(MainListeners.getDriver());
		ShoalUserWelcome pfShoalWelcome = new ShoalUserWelcome(MainListeners.getDriver());
		Logout pfLogout = new Logout(MainListeners.getDriver());


		pfWelcomePage.clickSignUp();

		//Entering Name of the user.
		pfNamePage.enterName();
		pfNamePage.tapOnContinue();

		//Entering Mobile number and OTP
//		pfMobNumberPage.validateHeaderText();
		String mobNum = Helper.generateMobileNumber();
		pfMobNumberPage.enterMobNumber("7"+mobNum);
		pfOTP.enterOTP();

		//Entering Email and OTP
		pfEmailPage.enterEmail("Sam@mailinator.com");
		pfOTP.enterOTP();

		//Setting security PIN and Confirming the same
		pfSecurityPIN.setNewPIN(); //Setting new PIN as 123456
		pfSecurityPIN.confirmPIN();

		//declining the Biometrics request
		pfBiometricsPage.doItLater();

		//Declining the Notification request
		pfNotifications.enableNotifications();
		for(int i=0; i<20; i++) {

			pfTnCPage.swipeUp();
			Thread.sleep(300);
		}

		pfTnCPage.acceptTermsAndConditions();

		//Tapping Let's go on Confirmation screen
		pfProfileConfirm.clickOnLetsGo();

		pfShoalWelcome.clickOnExploreApp();

		Thread.sleep(3000);

		//logging Out
		pfLogout.logout();

	}

	@Test
	public void addFunds() throws InterruptedException {
		Login pfLogin = new Login(MainListeners.getDriver());
		Home pfhome = new Home(MainListeners.getDriver());
		Logout pfLogout = new Logout(MainListeners.getDriver());
		OTP pfOTP = new OTP(MainListeners.getDriver());

		//Logging In
		pfLogin.login();

		//Entering PIN
		pfOTP.enterOTP();

		//Adding funds
		pfhome.addFunds();

		Thread.sleep(6000);

		//Logging Out
		pfLogout.logout();

	}

	@Test
	public void deposit() throws InterruptedException {
		Login pfLogin = new Login(MainListeners.getDriver());
		Deposit pfDeposit = new Deposit(MainListeners.getDriver());
		Logout pfLogout = new Logout(MainListeners.getDriver());
		OTP pfOTP = new OTP(MainListeners.getDriver());

		pfLogin.login();
		pfOTP.enterOTP();
		pfDeposit.makeDeposit("100");
		pfLogout.logout();

	}

	@Test
	public void resetPin() {
		Welcome pfWelcome = new Welcome(MainListeners.getDriver());
		SecurityPIN pfSecurityPin = new SecurityPIN(MainListeners.getDriver());
		ResetPinSmsVerification pfResetPinSms = new ResetPinSmsVerification(MainListeners.getDriver());
		ResetPinEmailVerification pfResetPinEmail = new ResetPinEmailVerification(MainListeners.getDriver());
		Login pfLogin = new Login(MainListeners.getDriver());
		ResetPin pfResetPin = new ResetPin(MainListeners.getDriver());
		SetNewPin pfSetNewPin = new SetNewPin(MainListeners.getDriver());
		Logout pfLogout = new Logout(MainListeners.getDriver());
		ResetPinConfirm pfResetPinConfirm = new ResetPinConfirm(MainListeners.getDriver());

		pfWelcome.clickLoginLnk();
		WebElement txtNumber = pfLogin.getTxtMobileNumber();
		txtNumber.click();
		txtNumber.sendKeys("7150008457");
		WebElement btnLogin = pfLogin.getBtnLogin();
		btnLogin.click();
		pfSecurityPin.getLnkResetPin().click();
		pfResetPin.clickLetsGo();
		pfResetPinSms.enterOTP();
		pfResetPinEmail.enterOTP();
		pfSetNewPin.setNewPin();
		pfResetPinConfirm.clickDone();
		pfLogout.logout();

	}

}

