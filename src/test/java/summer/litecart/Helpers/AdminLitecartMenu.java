package summer.litecart.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class AdminLitecartMenu extends BaseHelper {

  public AdminLitecartMenu(WebDriver wd) {
    super(wd);
  }

  public List<String> getNameMainElementsOfMenu(){
    return wd.findElements(By.xpath(".//ul[@id='box-apps-menu']/li")).stream()
            .map(element->element.getText()).collect(Collectors.toList());
  }

  public List<String> getNameSubElementsOfMenu(String nameMainMenuElement){
    return wd.findElements(By.xpath(".//li[@id='app-"+nameMainMenuElement+"']/ul/li"))
            .stream().map(element->element.getText()).collect(Collectors.toList());
  }

  public List<WebElement> getAllMainElementsOfMenu(){
    return wd.findElements(By.xpath(".//ul[@id='box-apps-menu']/li"));
  }


  public String findHeadlineName(){
    return wd.findElement(By.xpath(".//h1/span/..")).getText();
  }

  public List<String> collectHeadline(){
    List<String> nameMainMenuElements = getNameMainElementsOfMenu();
    List<String> allHeadline = new ArrayList<>();
    for(String nameMainMenuElement: nameMainMenuElements){
      String nameElement = nameMainMenuElement;
      String nameMainMenuElementLoverCase = nameElement
              .chars()
              .map(s -> Character.isUpperCase(s) ? Character.toLowerCase(s):Character.toLowerCase(s))
              .mapToObj(s -> (char) s)
              .map(Object::toString)
              .collect(joining());

      WebElement mainMenuElement = wd.findElement(By.xpath(".//li[@id='app-"+ nameMainMenuElementLoverCase + "']"));
      mainMenuElement.click();
      allHeadline.add(findHeadlineName());
      List<String> subElements = getNameSubElementsOfMenu(nameMainMenuElementLoverCase);
      if(subElements!=null){
        for(int i=0; i<=subElements.size(); i++){
          String nameSubElement = subElements.get(i);
          String nameSubMenuElementLoverCase = nameSubElement
                  .chars()
                  .map(s -> Character.isUpperCase(s) ? Character.toLowerCase(s):Character.toLowerCase(s))
                  .mapToObj(s -> (char) s)
                  .map(Object::toString)
                  .collect(joining());
          WebElement subMenuElement = wd.findElement(By.xpath(".//li[@id='app-" + nameMainMenuElementLoverCase + "']/ul/li[@id='doc-" + nameSubMenuElementLoverCase + "']"));
          subMenuElement.click();
          allHeadline.add(findHeadlineName());
        }
      }
    }
    return allHeadline;
  }

}
