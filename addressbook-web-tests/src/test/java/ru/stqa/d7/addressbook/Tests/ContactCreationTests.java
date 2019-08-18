package ru.stqa.d7.addressbook.Tests;

import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() throws Exception {

    app.gotoContactPage();
    app.fillContactForm(new ContactData("Oleg", "Tokarev", "OlegTok", "Nike", "Moscow", "+1", "2652", "info@nike.ru"));
    app.enterNewContact();
    app.goToHomePage();

  }

}
