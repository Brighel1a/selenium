package summer.litecart.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsersLitecartMenu extends BaseHelper {
  private List<String> allVisibleProdacts=new ArrayList<>();
  private List<String> allVisibleStics;
  private List<WebElement> allWebProdacts;
  private List<WebElement> allInvisibleWebProdacts;
  private List<String> findProdacts;

  public UsersLitecartMenu(WebDriver wd) {
    super(wd);
  }


  public List<String> findVisibleProdacts(){
    allWebProdacts = wd.findElements(By.xpath(".//div[@class='image-wrapper']/img"));
    allInvisibleWebProdacts = wd.findElements(By.xpath(".//div[@style='display: none;']/descendant::div[@class='image-wrapper']/img"));

    for(int i = 0; i<allInvisibleWebProdacts.size(); i++){
      WebElement prodact = allInvisibleWebProdacts.get(i);
      allWebProdacts.removeIf(s -> s.equals(prodact));
    }
    allVisibleProdacts = allWebProdacts.stream().map(s->s.getAttribute("alt")).collect(Collectors.toList());


    return allVisibleProdacts;
  }

  public List<String> findVisibleStics(){
    allVisibleStics = wd.findElements(By.xpath(".//div[@class='image-wrapper']"))
            .stream().filter(s->s.isDisplayed()).map(s->s.getText()).filter(s -> !s.equals("")).collect(Collectors.toList());
    return allVisibleStics;
  }


  public UsersLitecartMenu goToPopular(){
    click(By.xpath(".//ul/li/a[text()='Popular Products']"));
    return this;
  }

  public UsersLitecartMenu goToCampaign(){
    click(By.xpath(".//ul/li/a[text()='Campaign Products']"));
    return this;
  }

  public UsersLitecartMenu goToLatest(){
    click(By.xpath(".//ul/li/a[text()='Latest Products']"));
    return this;
  }

  public List<String> getAllisibleProdacts() {
    return allVisibleProdacts;
  }

  public List<String> getAllVisibleStics() {
    return allVisibleStics;
  }

}
