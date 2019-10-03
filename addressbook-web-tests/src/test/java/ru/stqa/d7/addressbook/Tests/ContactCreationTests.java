package ru.stqa.d7.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation()  {
    List<ContactData> before = app.contact().list();
      ContactData contact = new ContactData("Oleg", "Tokarev", "OlegTok", "Nike", "Moscow",
            "+1", "2652", "info@nike.ru","[none]");
    app.goTo().contactPage();
    app.contact().create(contact, true);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() +1);

    before.add( contact );
    Comparator<? super ContactData> byId = (c1, c2 ) -> Integer.compare( c1.getId(), c2.getId() );
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals( before,  after );

  }

}
