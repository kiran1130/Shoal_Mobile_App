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
	private static Login pf;
	private static Welcome pfWelcomePage;
	private static Logout pfLogout;
	private static Name pfNamePage;
	private static MobileNumber pfMobNumberPage;
	private static OTP pfOTP;
	private static Email pfEmailPage;
	private static SecurityPIN pfSecurityPIN;
	private static Biometrics pfBiometricsPage;
	private static Notifications pfNotifications;
	private static TermsAndConditions pfTnCPage;
	private static ProfileConfirmation pfProfileConfirm ;
	private static ShoalUserWelcome pfShoalWelcome;
	private static Login pfLogin;
	private static Home pfhome;
	private static Deposit pfDeposit;
	private static ResetPinSmsVerification pfResetPinSms;
	private static ResetPinEmailVerification pfResetPinEmail;
	private static ResetPin pfResetPin;
	private static SetNewPin pfSetNewPin;
	private static ResetPinConfirm pfResetPinConfirm;

	@Test
	public static void loginLogout() {
		pf = new Login(MainListeners.getDriver());
		pfWelcomePage = new Welcome(MainListeners.getDriver());
		pfLogout = new Logout(MainListeners.getDriver());

		pfWelcomePage.clickLoginLnk();
		pf.login(); //Login as existing user
		pfLogout.logout(); //Logout as existing user
	}

	@Test
	public static void signUp() throws InterruptedException {
		pfWelcomePage = new Welcome(MainListeners.getDriver());
		pfNamePage = new Name(MainListeners.getDriver());
		pfMobNumberPage = new MobileNumber(MainListeners.getDriver());
		pfOTP = new OTP(MainListeners.getDriver());
		pfEmailPage = new Email(MainListeners.getDriver());
		pfSecurityPIN = new SecurityPIN(MainListeners.getDriver());
		pfBiometricsPage = new Biometrics(MainListeners.getDriver());
		pfNotifications = new Notifications(MainListeners.getDriver());
		pfTnCPage= new TermsAndConditions(MainListeners.getDriver());
		pfProfileConfirm = new ProfileConfirmation(MainListeners.getDriver());
		pfShoalWelcome = new ShoalUserWelcome(MainListeners.getDriver());
		pfLogout = new Logout(MainListeners.getDriver());

		//Tap on Sign Up link
		pfWelcomePage.clickSignUp();

		//Entering Name of the user.
		pfNamePage.enterName();
		pfNamePage.tapOnContinue();

		//Entering Mobile number and OTP
		String mobNumber = Helper.generateMobileNumber();
		pfMobNumberPage.enterMobNumber("7"+mobNumber);
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
		pfNotifications.doItLater();
		
		
		//Swipe Up the Terms and Conditions screen
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
	public static void addFunds() throws InterruptedException {
		pfLogin = new Login(MainListeners.getDriver());
		pfhome = new Home(MainListeners.getDriver());
		pfLogout = new Logout(MainListeners.getDriver());
		pfOTP = new OTP(MainListeners.getDriver());

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
	public static void deposit() throws InterruptedException {
		pfLogin = new Login(MainListeners.getDriver());
		pfDeposit = new Deposit(MainListeners.getDriver());
		pfLogout = new Logout(MainListeners.getDriver());
		pfOTP = new OTP(MainListeners.getDriver());

		pfLogin.login();
		pfOTP.enterOTP();
		pfDeposit.makeDeposit("100");
		pfLogout.logout();

	}

	@Test
	public static void resetPin() {
		pfWelcomePage = new Welcome(MainListeners.getDriver());
		pfSecurityPIN = new SecurityPIN(MainListeners.getDriver());
		pfResetPinSms = new ResetPinSmsVerification(MainListeners.getDriver());
		pfResetPinEmail = new ResetPinEmailVerification(MainListeners.getDriver());
		pfLogin = new Login(MainListeners.getDriver());
		pfResetPin = new ResetPin(MainListeners.getDriver());
		pfSetNewPin = new SetNewPin(MainListeners.getDriver());
		pfLogout = new Logout(MainListeners.getDriver());
		pfResetPinConfirm = new ResetPinConfirm(MainListeners.getDriver());

		pfWelcomePage.clickLoginLnk();
		WebElement txtNumber = pfLogin.getTxtMobileNumber();
		txtNumber.click();
		txtNumber.sendKeys("7150008457");
		WebElement btnLogin = pfLogin.getBtnLogin();
		btnLogin.click();
		pfSecurityPIN.getLnkResetPin().click();
		pfResetPin.clickLetsGo();
		pfResetPinSms.enterOTP();
		pfResetPinEmail.enterOTP();
		pfSetNewPin.setNewPin();
		pfResetPinConfirm.clickDone();
		pfLogout.logout();

	}

}

