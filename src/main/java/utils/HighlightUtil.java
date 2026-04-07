package utils;

import driver.WebElementDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightUtil {

    public static void highlightElement(WebDriver driver, WebElement element) {

        if (element instanceof WebElementDecorator) {
            element = ((WebElementDecorator) element).getWrappedElement();
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }
}