package ru.stqa.d7.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.d7.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);

  }

  public void enterNewContact() {
    click_c(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void goToHomePage() {
    click_c(By.linkText("home page"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type_c(By.name("firstname"), contactData.getFirstname());
    click_c(By.name("middlename"));
    type_c(By.name("middlename"), contactData.getMiddlename());
    click_c(By.name("nickname"));
    type_c(By.name("nickname"), contactData.getNickname());
    click_c(By.name("company"));
    type_c(By.name("company"), contactData.getCompany());
    click_c(By.name("address"));
    type_c(By.name("address"), contactData.getAddress());
    click_c(By.name("mobile"));
    click_c(By.name("home"));
    type_c(By.name("home"), contactData.getHome());
    click_c(By.name("mobile"));
    type_c(By.name("mobile"), contactData.getMobile());
    click_c(By.name("email"));
    type_c(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(IsElementPresent(By.name("new_group")));
    }
  }

  public void selectContact(int index) {

    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void editContact() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void updateContact() {
    click(By.name("update"));
  }

  public void createContact(ContactData contact, boolean b) {
    fillContactForm(new ContactData("Oleg", "Tokarev", "OlegTok", "Nike", "Moscow",
            "+1", "2652", "info@nike.ru", "[none]"), true);
    enterNewContact();
    goToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }


  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void goToStartPage() {
    click(By.id("logo"));
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("input[type = 'checkbox'][name = 'selected[]']"));
    for (WebElement element : elements){
      String name = element.getText();
      int id =Integer.parseInt( element.getAttribute( "value" ));
      ContactData contact = new ContactData(id, name,null, null, null,null,null,null,null, null);
      contacts.add(contact);
    }
  return contacts;
  }
}

