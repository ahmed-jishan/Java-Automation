package org.example.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.basedrivers.PageDriver;
import org.example.pages.LoginFB_Page;
import org.example.pages.Login_Page;
import org.example.pages.SignInWith_FB;
import org.example.utilities.CommonMethods;
import org.example.utilities.ExtentFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login_Test extends CommonMethods {
    ExtentReports extent;
    ExtentTest parrentTest;
    ExtentTest childTest;

    @BeforeClass
    public void open_url() throws InterruptedException {
        PageDriver.getCurrentDriver().get(url);
        sleep();
        extent = ExtentFactory.getInstance();
        parrentTest = extent.createTest("<p style=\"color:green; font-size:14px\"><b>Rokomari.com</b></p>").assignAuthor("Tester_Jishan").assignDevice("Windows");
    }
    @Test
    public void orangehrm_login() throws IOException, InterruptedException {
        childTest = parrentTest.createNode("<p style=\"color:green; font-size:14px\"><b>Login</b></p>");
        Login_Page login_page = new Login_Page(childTest);
        login_page.login();

        //LoginFB_Page Start
        PageDriver.getCurrentDriver().get(url2);
        sleep();

        // Create the login FB page object and perform the FB login click
        childTest = parrentTest.createNode("<p style=\"color:blue; font-size:14px\"><b>Get Facebook Page</b></p>");
        LoginFB_Page loginFB_page = new LoginFB_Page(childTest);
        loginFB_page.login(); // Click on Facebook login button
        //LoginFB_Page End

        //SignInWith_FB Start
        PageDriver.getCurrentDriver().get(url3);
        sleep();
        childTest = parrentTest.createNode("<p style=\"color:blue; font-size:14px\"><b>Login with Facebook</b></p>");
        SignInWith_FB signinWith_fb= new SignInWith_FB(childTest);
        signinWith_fb.login();
        //SignInWith_FB End


    }
    @AfterClass
    public void report(){
        extent.flush();
    }
}
