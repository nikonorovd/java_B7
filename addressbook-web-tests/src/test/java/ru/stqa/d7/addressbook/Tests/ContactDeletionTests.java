package ru.stqa.d7.addressbook.Tests;

import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoContactPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Oleg", "Tokarev", "OlegTok", "Nike", "Moscow",
              "+2", "2652", "info@nike.ru", "[none]"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();


  }

}
