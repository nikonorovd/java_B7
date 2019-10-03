package ru.stqa.d7.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData ("Oleg", "Tokarev", "OlegTok", "Nike", "Moscow",
              "+1", "2652", "info@nike.ru", "[none]"), true);
    }
  }

  @Test
  public void testContactDeletion() {
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
    app.contact().delete( index );
    List<ContactData> after = app.contact().list();
    Assert.assertEquals( after.size(), before.size() - 1 );


    before.remove( index );
    Assert.assertEquals( before, after );

  }


}
