package ru.stqa.d7.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.d7.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


  public void selectContactById(int id) {

    wd.findElement(By.cssSelector("input[value='" + id +"' ]")).click();
  }

  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void editContact(int index) {
    wd.findElements( By.xpath( "//img[@alt='Edit']" )).get(index).click();
//    click(By.xpath("//img[@alt='Edit']"));
  }

  public void updateContact() {
    click(By.name("update"));
  }

  public void create(ContactData contact, boolean b) {
    fillContactForm(new ContactData().withFirstname("Oleg").withMiddlename("Tokarev").withNickname( "OlegTok" ).withCompany( "Nike" ).withAddress( "Moscow" )
            .withHome( "+1" ).withMobile( "2652" ).withEmail( "info@nike.ru" ).withGroup( "[none]" ), true);
    enterNewContact();
    goToHomePage();
  }

  public void modify(ContactData contact, int index) {
    editContact( index );
    fillContactForm(contact,false);
    updateContact();
    goToStartPage();
  }

  public void delete(int index) {
    selectContact( index );
    deleteContact();
    goToStartPage();
  }

  public void delete(ContactData Contact) {
    selectContactById( Contact.getId() );
    deleteContact();
    goToStartPage();
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

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements){
      List<WebElement> cells = element.findElements(By.cssSelector("td"));
      String name = cells.get(2).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String address = cells.get(3).getText();
      String middlename = element.getText();
      contacts.add(new ContactData().withId(id).withFirstname( name).withMiddlename( middlename).withAddress( address ));
    }
  return contacts;
  }

  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements){
      List<WebElement> cells = element.findElements(By.cssSelector("td"));
      String name = cells.get(2).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String address = cells.get(3).getText();
      String middlename = element.getText();
      contacts.add(new ContactData().withId(id).withFirstname( name).withMiddlename( middlename).withAddress( address ));
    }
    return contacts;
  }

}

