package ru.stqa.d7.addressbook.Tests;

import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification(){

    app.getContactHelper().selectContact();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("Oleg", "Tokarev", "OlegTok", "Nike", "Moscow", "+1", "2652", "info@nike.ru"));
    app.getContactHelper().updateContact();
    app.getContactHelper().goToHomePage();
    }
}
