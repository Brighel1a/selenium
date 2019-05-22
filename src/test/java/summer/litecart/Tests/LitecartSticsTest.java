package summer.litecart.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LitecartSticsTest extends BaseTest{

  @Test
  public static void testLitecartStics(){


    List<String> allVisiblePopularProdacts = app.getUsersLitecartMenu().goToPopular().findVisibleProdacts();
    List<String> allVisiblePopularStics = app.getUsersLitecartMenu().findVisibleStics();
    Assert.assertEquals(allVisiblePopularProdacts.size(), allVisiblePopularStics.size());

    List<String> allVisibleLatestProdacts = app.getUsersLitecartMenu().goToLatest().findVisibleProdacts();
    List<String> allVisibleLatestStics = app.getUsersLitecartMenu().findVisibleStics();
    Assert.assertEquals(allVisibleLatestProdacts.size(), allVisibleLatestStics.size());

    List<String>  allVisibleCampaignProdacts = app.getUsersLitecartMenu().goToCampaign().findVisibleProdacts();
    List<String>  allVisibleCampaignStics = app.getUsersLitecartMenu().findVisibleStics();
    Assert.assertEquals(allVisibleCampaignProdacts.size(), allVisibleCampaignStics.size());
  }
}
