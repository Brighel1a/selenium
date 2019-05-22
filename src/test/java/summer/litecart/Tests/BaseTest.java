package summer.litecart.Tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import summer.litecart.Helpers.AppManager;

import java.io.IOException;

public class BaseTest {
  protected static final AppManager app = new AppManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeMethod
  public void startWD() throws IOException {
    app.startWD();
  }


  @AfterMethod
  public void stopWD(){
    app.wd.close();
  }
}
