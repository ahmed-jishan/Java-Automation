package org.example.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.example.basedrivers.PageDriver;
import org.example.utilities.CommonMethods;
import org.example.utilities.ScreenShots;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginFB_Page extends CommonMethods {

    ExtentTest test;
    //ExcelUtils excelUtils = new ExcelUtils();

    //constractor
    public LoginFB_Page(ExtentTest test){
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    //Locators
    //PageFactory annotation used for multiple xpath.
    @FindBys({
            @FindBy(xpath = "//button[normalize-space()='Facebook']"),
    })
    WebElement fb_login;

    //Screenshot+Report
    public void passCase(String message){
        test.pass("<p style=\"color:green; font-size:14px\"><b>" + message + "</b></p>");
    }

    public void passCaseWithSC(String message, String screenshotName) throws IOException {
        test.pass("<p style=\"color:green; font-size:14px\"><b>" + message + "</b></p>");
        String screenshotPath = ScreenShots.capture(PageDriver.getCurrentDriver(), ""+screenshotName+"");
        String dest = System.getProperty("user.dir")+ "\\screenshots\\" +screenshotName+".png";
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
    }

    public void failCase(String message, String screenshotName) throws IOException {
        test.pass("<p style=\"color:red; font-size:14px\"><b>" + message + "</b></p>");
        String screenshotPath = ScreenShots.capture(PageDriver.getCurrentDriver(), ""+screenshotName+"");
        String dest = System.getProperty("user.dir")+ "\\screenshots\\" +screenshotName+".png";
        test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());

        Throwable t = new InterruptedException("Exception");
        test.fail(t);
    }

    public void login() throws IOException {
        try{
            //excelUtils.ReadExcel();
            test.info("Please click on Facebook ");
            if(fb_login.isDisplayed())
            {
                fb_login.click();
                sleep();
                passCaseWithSC("You Successfully clicked", "Sign_in_success");
            }

        } catch (Exception e) {
            failCase("Facebook was not locatable","sign_in_failed");
        }
    }

}
