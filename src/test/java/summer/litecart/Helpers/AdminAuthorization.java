package summer.litecart.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminAuthorization extends BaseHelper{

  public AdminAuthorization(WebDriver wd) {
    super(wd);
  }

  public void loginToLitecart(WebDriver wd, String login, String password){
    type(By.cssSelector("input[name='username']"), login);
    type(By.cssSelector("input[name='password']"), password);
    click(By.cssSelector("button"));
  }
}
