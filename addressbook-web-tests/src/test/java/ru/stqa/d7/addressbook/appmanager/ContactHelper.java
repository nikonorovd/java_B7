package ru.stqa.d7.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.d7.addressbook.model.ContactData;
import ru.stqa.d7.addressbook.model.Contacts;
import ru.stqa.d7.addressbook.model.Groups;

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

  private void editContactById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id +"'] img")).click();
  }

  public void updateContact() {
    click(By.name("update"));
  }

  public void create(ContactData contact, boolean b) {
    fillContactForm(new ContactData().withFirstname("Oleg").withMiddlename("Tokarev").withNickname( "OlegTok" ).withCompany( "Nike" ).withAddress( "Moscow" )
            .withHome( "+1" ).withMobile( "2652" ).withEmail( "info@nike.ru" ).withGroup( "[none]" ), true);
    enterNewContact();
    contactCache = null;
    goToHomePage();
  }

  public void modify(ContactData contact) {
    editContactById( contact.getId() );
    fillContactForm(contact,false);
    updateContact();
    contactCache = null;
    goToStartPage();
  }


  public void delete(ContactData Contact) {
    selectContactById( Contact.getId() );
    deleteContact();
    contactCache = null;
    goToStartPage();
  }
  public ContactData infoFromEditForm(ContactData contact) {
   initContactModificationById(contact.getId());
   String firstname = wd.findElement( By.name( "firstname" ) ).getAttribute( "value" );
   String middlename = wd.findElement( By.name( "lastname" ) ).getAttribute( "value" );
   String home = wd.findElement( By.name( "home" ) ).getAttribute( "value" );
   String mobile = wd.findElement( By.name( "mobile" ) ).getAttribute( "value" );
   String work = wd.findElement( By.name( "work" ) ).getAttribute( "value" );
   wd.navigate().back();
   return new ContactData().withId( contact.getId()).withFirstname( firstname ).withMiddlename(middlename).
           withHome( home ).withMobile( mobile ).withWork(work);
  }

  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement( By.cssSelector( String.format( "input[value='%s']",id ) ) );
    WebElement row = checkbox.findElement( By.xpath( "./../.." ) );
    List <WebElement>cells = row.findElements( By.tagName( "td" ) );
    cells.get(7).findElement( By.tagName( "a" ) ).click();
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

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void goToStartPage() {
    click(By.id("logo"));
  }


  private Contacts contactCache = null;


  public Contacts all() {
    if (contactCache != null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements){
      List<WebElement> cells = element.findElements(By.cssSelector("td"));
      String name = cells.get(2).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String address = cells.get(3).getText();
      String email = cells.get(4).getText();
      String[] phones = cells.get( 5 ).getText().split( "\n" );
      contactCache.add(new ContactData().withId(id).withFirstname( name).withAddress( address ).withEmail(email).withMiddlename( "" )
              .withHome( phones[0] ).withMobile( phones[1]).withWork( phones[2]));
    }
    return contactCache;
  }



}

