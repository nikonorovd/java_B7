package ru.stqa.d7.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().goToStartPage();
    app.getNavigationHelper().gotoContactPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData ("Oleg", "Tokarev", "OlegTok", "Nike", "Moscow",
                      "+1", "2652", "info@nike.ru", "[none]"), true);
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData
            ("Oleg", "Tokarev", "OlegTok", "Nike", "Moscow",
                    "+1", "2652", "info@nike.ru", null), false);
    app.getContactHelper().updateContact();
    app.getContactHelper().goToHomePage();
    app.getContactHelper().goToStartPage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before );
  }
}
