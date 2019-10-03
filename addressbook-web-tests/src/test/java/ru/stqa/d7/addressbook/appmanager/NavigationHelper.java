package ru.stqa.d7.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver wd) {
    super(wd);

  }

  public void groupPage() {

    if (IsElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && IsElementPresent(By.name("new"))){
      return;
    }
   click(By.linkText("groups"));
  }

  public void contactPage() {
    if (IsElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
            && IsElementPresent(By.name("add"))){
      return;
    }
    click(By.linkText("add new"));
  }

}
