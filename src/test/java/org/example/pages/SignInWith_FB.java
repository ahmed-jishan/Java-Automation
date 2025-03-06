package org.example.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.example.basedrivers.PageDriver;
import org.example.utilities.CommonMethods;
//import org.example.utilities.ExcelUtils;
import org.example.utilities.ScreenShots;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

//class
public class SignInWith_FB extends CommonMethods {

    ExtentTest test;
    //ExcelUtils excelUtils = new ExcelUtils();

    //constractor
    public SignInWith_FB(ExtentTest test){
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    //Locators
    //PageFactory annotation used for multiple xpath.
    @FindBys({
            @FindBy(xpath = "//div[@id='loginform']/div[1]/input\n"),
            //@FindBy(xpath = "//input[@placeholder='Username']"),
    })
    WebElement username;

    @FindBys({
            @FindBy(xpath = "//div[@id='loginform']/div[2]/input\n"),
            //@FindBy(xpath = "//input[@placeholder='Password']")
    })
    WebElement password;

    @FindBys({
            @FindBy(xpath = "//div[@class='_xkt']/button"),
    })
    WebElement login_button;

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
            test.info("Please enter your email");
            if(username.isDisplayed())
            {
                username.sendKeys("iamjishanahmed@gmail.com");
                //username.sendKeys(excelUtils.username);//get data from excel file
                passCase("You have succssfully enter your email");
                    sleep();
                try {
                    test.info("Please enter your password");
                    if(password.isDisplayed())
                    {
                        password.sendKeys("##jishan4249");
                        //password.sendKeys(excelUtils.password);//get data from excel file
                        passCase("You have successfully enter your pssword");
                            sleep();
                        try{
                            test.info("Please Click on Login button");
                            if(login_button.isDisplayed())
                            {
                                login_button.click();
                                Thread.sleep(60000);
                                passCaseWithSC("You Successfully Logged in", "login_success");
                            }
                        }catch(Exception e){
                            failCase("Login button was not locatable", "login_failed");
                    }
                    }
                } catch (Exception e){
                    failCase("Password was not locatable", "password_failed");
                }
            }

        } catch (Exception e) {
            failCase("Username was not locatable","user_name_failed");
        }
    }

}
