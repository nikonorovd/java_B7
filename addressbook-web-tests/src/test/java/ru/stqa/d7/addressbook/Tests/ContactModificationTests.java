package ru.stqa.d7.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().goToStartPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData ("Oleg", "Tokarev", "OlegTok", "Nike", "Moscow",
                      "+1", "2652", "info@nike.ru", "[none]"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().editContact();
    ContactData contact = new ContactData (before.get( before.size() - 1 ).getId(),"Oleg", "Tokarev", "OlegTok", "Nike", "Moscow",
                    "+1", "2652", "info@nike.ru", null);
    app.getContactHelper().fillContactForm(contact,false);
    app.getContactHelper().updateContact();
    app.getContactHelper().goToStartPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() );

    before.remove( before.size() - 1 );
    before.add( contact );
    Assert.assertEquals( new HashSet<Object>(before),  new HashSet<Object>(after) );

  }
}
