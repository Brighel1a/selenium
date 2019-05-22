package summer.litecart.Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class AppManager {
  public static WebDriver wd;
  private Properties properties;
  private AdminAuthorization adminAuthorization;
  private AdminLitecartMenu adminLitecartMenu;
  private String browser;
  private UsersLitecartMenu usersLitecartMenu;

  public AppManager(String browser)  {
    this.browser = browser;
    properties = new Properties();
  }

  public void startWD() throws IOException{
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    String TestFor = properties.getProperty("TestFor");
    if(browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if(browser.equals(BrowserType.FIREFOX)){
      wd = new FirefoxDriver();
    } else if(browser.equals(BrowserType.IE)){
      wd = new InternetExplorerDriver();
    }

    if(TestFor.equals("Admin")) {
      wd.get(properties.getProperty("UrlAdminSite"));
      adminAuthorization = new AdminAuthorization(wd);
      adminLitecartMenu = new AdminLitecartMenu(wd);
      adminAuthorization.loginToLitecart(wd, properties.getProperty("LoginAdmin"), properties.getProperty("PasswordAdmin"));
    }
    if(TestFor.equals("User")){
      wd.get(properties.getProperty("UrlUsersSite"));
      usersLitecartMenu = new UsersLitecartMenu(wd);
    }
    }


  public AdminAuthorization getAdminAuthorization() {
    return adminAuthorization;
  }

  public AdminLitecartMenu getAdminLitecartMenu() {
    return adminLitecartMenu;
  }

  public void setAdminAuthorization(AdminAuthorization adminAuthorization) {
    this.adminAuthorization = adminAuthorization;
  }

  public UsersLitecartMenu getUsersLitecartMenu() {
    return usersLitecartMenu;
  }

  public void setUsersLitecartMenu(UsersLitecartMenu usersLitecartMenu) {
    this.usersLitecartMenu = usersLitecartMenu;
  }

  public void setAdminLitecartMenu(AdminLitecartMenu adminLitecartMenu) {
    this.adminLitecartMenu = adminLitecartMenu;
  }
}
