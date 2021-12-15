package utils;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HELPER {


    /**
     * Waits for element to be not stale
     *
     * @param element
     */
    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            try {
                element.isDisplayed();
                break;
            } catch (StaleElementReferenceException st) {
                y++;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }

    /**
     * Waits for provided element to be clickable
     *
     * @param element
     * @param timeout
     * @return
     */
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /*
     * takes screenshot
     * @param name
     * take a name of a test and returns a path to screenshot takes
     */
    public static String getScreenshot(String name) {

        SimpleDateFormat df = new SimpleDateFormat("-yyyy-MM-dd-HH:mm");

        String date = df.format(new Date());

        // TakesScreenshot ---> interface from selenium which takes screenshots
        TakesScreenshot ts = (TakesScreenshot) Driver.get();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";

        File finalDestination = new File(target);
        // save the screenshot to the path given
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return target;
    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Waits for the provided element to be visible on the page
     *
     * @param element
     * @param timeToWaitInSec
     * @return
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }


    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        ExpectedCondition<Boolean> expectation2 = driver -> ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0").equals(true);
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), timeOutInSeconds);
            wait.until(expectation);
            wait.until(expectation2);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    /**
     * Wait for proper page title
     *
     * @param pageTitle
     */
    public static void waitForPageTitle(String pageTitle) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.titleIs(pageTitle));

    }

    public static List<String> getListOfString(List<WebElement> listOfWebElements) {
        List<String> listOfStrings = new ArrayList<>();
        for (WebElement element : listOfWebElements) {
            String value = element.getText().trim();
            //if there is no text
            //do not add this blank text into list
            if (value.length() > 0) {
                listOfStrings.add(value);
            }
        }
        return listOfStrings;
    }

    public static void readPDF(String path) {
        try {
            File pdf_file = new File(path);
            PDDocument document = PDDocument.load(pdf_file);
            PDFTextStripper pdfstripper = new PDFTextStripper();
            String ocr_text = pdfstripper.getText(document);
            System.out.println(ocr_text);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void dragAndDrop(WebElement dragPoint, WebElement dropPoint) {
        Actions builder = new Actions(Driver.get());
        builder.clickAndHold(dragPoint).perform();
        builder.pause(Duration.ofSeconds(1));
        builder.moveByOffset(10, 0).perform();
        builder.moveToElement(dropPoint).perform();
        builder.moveByOffset(10, 0).perform();
        builder.pause(Duration.ofSeconds(1));
        builder.release();
        builder.build();
        builder.perform();

    }
    public static String fetchTextByRegion(String path, String filename, int pageNumber) throws IOException {
        File file = new File(path + filename);
        PDDocument document = PDDocument.load(file);
        //Rectangle2D region = new Rectangle2D.Double(x,y,width,height);
        Rectangle2D region = new Rectangle2D.Double(0, 100, 550, 700);
        String regionName = "region";
        PDFTextStripperByArea stripper;
        PDPage page = document.getPage(pageNumber + 1);
        stripper = new PDFTextStripperByArea();
        stripper.addRegion(regionName, region);
        stripper.extractRegions(page);
        String text = stripper.getTextForRegion(regionName);
        return text;
    }

    public static String waitForSpinnerNotVisible(int timeOutInSeconds, WebDriver driver) {
      String elementXPath="//*[@class='spinner ng-star-inserted']";
        if ((driver == null) || (elementXPath == null) || elementXPath.isEmpty()) {

            return "Wrong usage of WaitforElementNotVisible()";
        }
        try {
            (new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.invisibilityOfElementLocated(By
                    .xpath(elementXPath)));
            return null;
        } catch (TimeoutException e) {
            return "Spinner is still visible";
        }
    }


}