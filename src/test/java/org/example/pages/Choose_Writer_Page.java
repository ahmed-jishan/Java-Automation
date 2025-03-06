package org.example.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.example.basedrivers.PageDriver;
import org.example.utilities.CommonMethods;
import org.example.utilities.ScreenShots;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Choose_Writer_Page extends CommonMethods {

    ExtentTest test;
    //ExcelUtils excelUtils = new ExcelUtils();
    JavascriptExecutor jse = (JavascriptExecutor)driver;//for scrolling page
    //constractor
    public Choose_Writer_Page(ExtentTest test){
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    //Locators
    //PageFactory annotation used for multiple xpath.
    @FindBys({
            @FindBy(xpath = "//section[@id='author-list']/div[3]/section/div[2]/div[48]/a/h2"),

    })
    WebElement view_writer;

    @FindBys({
            @FindBy(xpath = "//section[@id='author-list']/div[3]/section/div[3]/div/a[1]"),
    })
    WebElement page_number;

    @FindBys({
            @FindBy(xpath = "//h3[contains(text(),'সকল লেখকগণ')]"),
    })
    WebElement travel_path;

    @FindBys({
            @FindBy(xpath = "//section[contains(@class,'all-authors-section')]//div[1]//div[1]//p[1]//span[1]"),
    })
    WebElement slc_writer;

    @FindBys({
            @FindBy(xpath = "//div[@id='js--categoryIds']"),
    })
    WebElement travel_gs;

    @FindBys({
            @FindBy(xpath = "//label[contains(text(),'গল্প সমগ্র')]"),
    })
    WebElement clk_gs;
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

    public void choose_writer() throws IOException {
        try{
            jse.executeScript("arguments[0].scrollIntoView()",view_writer);
            sleep();
            test.info("Travel to Page order");
            if(view_writer.isDisplayed())
            {
                page_number.click();
                sleep();
                passCaseWithSC("You Successfully clicked on Page Number", "Travel_Page_Successfully");
            }

        } catch (Exception e) {
            failCase("Page Number was not locatable","Page_Found_failed");
        }

    }

    public void select_the_writer() throws IOException {
        try{
            jse.executeScript("arguments[0].scrollIntoView()",travel_path);
            sleep();
            test.info("Travel to the Dedicated Writer");
            if(slc_writer.isDisplayed())
            {
                slc_writer.click();
                sleep();
                passCaseWithSC("You have Select the Writer","Select_Writer_Successfully");
            }
        }catch(Exception e){
            failCase("Writer was not locatable", "Writer_Not_Found");
        }
    }

    public void filter_By_golpo() throws IOException {
        try{
            jse.executeScript("arguments[0].scrollIntoView()",travel_gs);
            sleep();
            jse.executeScript("arguments[0].scrollIntoView({block: 'center'});", clk_gs);
            sleep();
            if(clk_gs.isDisplayed())
            {
                clk_gs.click();
                passCaseWithSC("You have Successfully Clicked on গল্প সমগ্র","Clicked_গল্প সমগ্র _Successfully");

            }
        } catch (Exception e) {
            failCase("Golpo Somogro was not locatable", "গল্প সমগ্র_Page_Not_Found");

        }
    }

//select one book for add to cart
    @FindBys({
            @FindBy(xpath = "//h1[contains(text(),'কাজী নজরুল ইসলাম এর বই সমূহ')]"),
    })
    WebElement travel_bk;
    @FindBys({
            @FindBy(xpath = "//h4[contains(text(),'শ্রেষ্ঠ গল্প')]"),
    })
    WebElement select_the_book;

    public void select_book() throws IOException {
        try{
            jse.executeScript("arguments[0].scrollIntoView()", travel_bk);
            sleep();
            if(select_the_book.isDisplayed())
            {
                select_the_book.click();
                sleep();
                passCaseWithSC("Select the Book Successfully","Book Selected");
            }
        }catch(Exception e){
            failCase("Book cannot Found","Book selection Failed");
        }
    }


    //add to cart
    @FindBys({
            @FindBy(xpath = "//figure[@class='stock-available']"),
    })
    WebElement travel_add_cart;
    @FindBys({
            @FindBy(xpath = "//div[@class='details-btn']/div/div/a[2]"),
    })
    WebElement go_cart;
    public void add_cart() throws IOException {
        try{
            jse.executeScript("arguments[0].scrollIntoView()",travel_add_cart);
            sleep();
            if(go_cart.isDisplayed())
            {
                go_cart.click();
                sleep();
                passCaseWithSC("Add to Cart Successfully", "Add_cart_successfully");
            }
        }catch(Exception e){
            failCase("Add cart cannot Found", "Add_cart_Failed");
        }
    }

}
