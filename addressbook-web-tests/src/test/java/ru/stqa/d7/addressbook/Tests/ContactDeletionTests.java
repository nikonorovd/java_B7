package ru.stqa.d7.addressbook.Tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{


  @Test
  public void testContactDeletion()  {
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().goToHomePage();



  }

}
