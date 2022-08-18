package green.progressive.common;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class Commons {
	public void click(WebElement element) {

		try {
			element.click();			
			Loggers.getLog(element + " This element has been clicked");
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			
			Loggers.getLog(element + " : This element is not found");
			Assert.fail();
		}
	}

	public String getText(WebElement element) {
		String valueString = null;
		try {
			valueString = element.getText();
			Loggers.getLog(element + " :has value---->" + valueString);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
		}
		return valueString;
	}
}
