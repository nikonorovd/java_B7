package ru.stqa.d7.addressbook.Tests;

import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation()  {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().createContact (new ContactData("Oleg", "Tokarev", "OlegTok", "Nike", "Moscow",
                    "+1", "2652", "info@nike.ru","[none]"), true);

  }

}
