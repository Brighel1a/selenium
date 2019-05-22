package summer.litecart.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckHeadlinesTest extends BaseTest {

  @Test
  public void testCheckHeadlines(){
    List<String> headlines = app.getAdminLitecartMenu().collectHeadline();
    Assert.assertFalse(headlines.contains(null));
  }
}
