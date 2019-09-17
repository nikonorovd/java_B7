package ru.stqa.d7.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation()  {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoContactPage();
    ContactData contact = new ContactData("Oleg", "Tokarev", "OlegTok", "Nike", "Moscow",
            "+1", "2652", "info@nike.ru","[none]");
    app.getContactHelper().createContact (contact, true);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() +1);

    contact.setId(after.stream().max( (o1, o2) -> Integer.compare( o1.getId(), o2.getId() ) ).get().getId());
    before.add( contact );
    Assert.assertEquals( new HashSet<Object>(before),  new HashSet<Object>(after) );

  }

}
