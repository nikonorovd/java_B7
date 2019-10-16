package ru.stqa.d7.addressbook.Tests;

import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

  @Test
  public void testContactPhones(){
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfofromEditForm = app.contact().infoFromEditForm(contact);

    assertThat( contact.getHome(), equalTo(cleaned (contactInfofromEditForm.getHome() ) ));
    assertThat( contact.getMobile(), equalTo( cleaned(contactInfofromEditForm.getMobile() )) );
    assertThat( contact.getWork(), equalTo( cleaned (contactInfofromEditForm.getWork() )) );

  }

  public String cleaned(String phone){
    return phone.replaceAll( "\\s", "" ).replaceAll( "-()", "" );
  }
}
