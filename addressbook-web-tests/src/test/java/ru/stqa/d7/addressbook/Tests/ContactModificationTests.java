package ru.stqa.d7.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test (enabled = false)
  public void testContactModification() {
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData ("Oleg", "Tokarev", "OlegTok", "Nike", "Moscow",
                      "+1", "2652", "info@nike.ru", "[none]"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
//    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().editContact();
    ContactData contact = new ContactData
            (before.get( before.size() - 1 ).getId(),
                    before.get( before.size() - 1 ).getFirstname(),
                    before.get( before.size() - 1 ).getMiddlename(),
                    "OlegTok", "Nike", "Moscow",
                    "+1", "2652", "info@nike.ru", "[none]");
    app.getContactHelper().fillContactForm(contact,false);
    app.getContactHelper().updateContact();
    app.getContactHelper().goToStartPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() );

    before.remove( before.size() - 1 );
    before.add( contact );
    Comparator<? super ContactData> byId = (c1, c2 ) -> Integer.compare( c1.getId(), c2.getId() );
    before.sort(byId);
    after.sort( byId );
    Assert.assertEquals( before,  after );

  }
}
