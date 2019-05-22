package summer.litecart.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseHelper{
  protected WebDriver wd;

  public BaseHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void type(By locator, String text){
    wd.findElement(locator).sendKeys(text);
  }

  public void click(By locator){
    wd.findElement(locator).click();
  }
}
