package ru.stqa.d7.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() {

//    app.getNavigationHelper().gotoContactPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact( new ContactData( "Oleg", "Tokarev", "OlegTok", "Nike", "Moscow",
              "+2", "2652", "info@nike.ru", "[none]" ), true );
    }
    app.getContactHelper().goToStartPage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact( before.size() - 1 );
    app.getContactHelper().deleteContact();
    app.getContactHelper().goToStartPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals( after.size(), before.size() - 1 );


    before.remove( before.size() - 1 );
    Assert.assertEquals( before, after );

  }

}
