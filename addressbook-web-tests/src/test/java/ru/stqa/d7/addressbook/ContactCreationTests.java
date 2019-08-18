package ru.stqa.d7.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() throws Exception {

    gotoContactPage();
    fillContactForm(new ContactData("Oleg", "Tokarev", "OlegTok", "Nike", "Moscow", "+1", "2652", "info@nike.ru"));
    enterNewContact();
    goToHomePage();

  }

}
