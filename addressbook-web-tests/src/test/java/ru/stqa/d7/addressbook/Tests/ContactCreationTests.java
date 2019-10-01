package ru.stqa.d7.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{


  @Test (enabled = false)
  public void testContactCreation()  {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.goTo().gotoContactPage();
    ContactData contact = new ContactData("Oleg", "Tokarev", "OlegTok", "Nike", "Moscow",
            "+1", "2652", "info@nike.ru","[none]");
    app.getContactHelper().createContact (contact, true);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() +1);

    before.add( contact );
    Comparator<? super ContactData> byId = (c1, c2 ) -> Integer.compare( c1.getId(), c2.getId() );
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals( before,  after );

  }

}
