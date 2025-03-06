package org.example.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.basedrivers.PageDriver;
import org.example.pages.*;
import org.example.utilities.CommonMethods;
import org.example.utilities.ExtentFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Writer_Test extends CommonMethods {
    ExtentReports extent;
    ExtentTest parrentTest;
    ExtentTest childTest;

    @BeforeClass
    public void open_url() throws InterruptedException {
        PageDriver.getCurrentDriver().get(url4);
        sleep();
        extent = ExtentFactory.getInstance();
        parrentTest = extent.createTest("<p style=\"color:green; font-size:14px\"><b>Rokomari.com</b></p>").assignAuthor("Tester_Jishan").assignDevice("Windows");
    }
    @Test
    public void rokomariWriter() throws IOException, InterruptedException {
        childTest = parrentTest.createNode("<p style=\"color:green; font-size:14px\"><b>Clickd Writer</b></p>");
        Writer_Page writer_page = new Writer_Page(childTest);
        writer_page.writer();

        PageDriver.getCurrentDriver().get(url5);
        sleep();
        childTest = parrentTest.createNode("<p style=\"color:green; font-size:14px\"><b>Page Travel</b></p>");
        Choose_Writer_Page choose_writer_page = new Choose_Writer_Page(childTest);
        choose_writer_page.choose_writer();

        PageDriver.getCurrentDriver().get(url6);
        sleep();
        childTest = parrentTest.createNode("<p style=\"color:green; font-size:14px\"><b>Select the Writer</b></p>");
        Choose_Writer_Page select_writer_page = new Choose_Writer_Page(childTest);
        select_writer_page.select_the_writer();

        PageDriver.getCurrentDriver().get(url7);
        sleep();
        childTest = parrentTest.createNode("<p style=\"color:green; font-size:14px\"><b>Select গল্প সমগ্র </b></p>");
        Choose_Writer_Page choose_golpo = new Choose_Writer_Page(childTest);
        choose_golpo.filter_By_golpo();

        PageDriver.getCurrentDriver().get(url8);
        sleep();
        childTest = parrentTest.createNode("<p style=\"color:green; font-size:14px\"><b>Select The Book শ্রেষ্ঠ গল্প </b></p>");
        Choose_Writer_Page choose_book = new Choose_Writer_Page(childTest);
        choose_book.select_book();

        PageDriver.getCurrentDriver().get(url9);
        sleep();
        childTest = parrentTest.createNode("<p style=\"color:green; font-size:14px\"><b>Add to Cart</b></p>");
        Choose_Writer_Page add_to_cart = new Choose_Writer_Page(childTest);
        add_to_cart.add_cart();

    }
    @AfterClass
    public void report(){
        extent.flush();
    }
}
