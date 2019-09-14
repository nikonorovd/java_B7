package ru.stqa.d7.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation()  {
    app.getContactHelper().goToStartPage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().createContact (new ContactData("Oleg", "Tokarev", "OlegTok", "Nike", "Moscow",
                    "+1", "2652", "info@nike.ru","[none]"), true);
    app.getContactHelper().goToStartPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }
  

}
