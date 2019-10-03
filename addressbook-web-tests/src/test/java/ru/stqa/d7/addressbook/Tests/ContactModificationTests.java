package ru.stqa.d7.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData ("Oleg", "Tokarev", "OlegTok", "Nike", "Moscow",
              "+1", "2652", "info@nike.ru", "[none]"), true);
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData
            (before.get(index).getId(),
                    before.get( index ).getFirstname(),
                    before.get( index ).getMiddlename(),
                    "OlegTok", "Nike", "Moscow",
                    "+1", "2652", "info@nike.ru", "[none]");
    app.contact().modify( contact );
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() );

    before.remove( index );
    before.add( contact );
    Comparator<? super ContactData> byId = (c1, c2 ) -> Integer.compare( c1.getId(), c2.getId() );
    before.sort(byId);
    after.sort( byId );
    Assert.assertEquals( before,  after );

  }

}
