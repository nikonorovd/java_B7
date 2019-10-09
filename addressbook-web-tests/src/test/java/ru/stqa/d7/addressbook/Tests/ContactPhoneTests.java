package ru.stqa.d7.addressbook.Tests;

import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.ContactData;

public class ContactPhoneTests extends TestBase {

  @Test (enabled = false)
  public void testContactPhones(){
    app.goTo().goToHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfofromEditForm = app.contact().infoFromEditForm(contact);
  }
}
