package ru.stqa.d7.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData ().withFirstname("Oleg").withMiddlename("Tokarev").withNickname( "OlegTok" ).withCompany( "Nike" ).withAddress( "Moscow" )
              .withHome( "+1" ).withMobile( "2652" ).withEmail( "info@nike.ru" ).withGroup( "[none]" ), true);
    }
  }

  @Test
  public void testContactModification() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId (modifiedContact.getId()).withFirstname(modifiedContact.getFirstname()).withMiddlename( modifiedContact.getMiddlename() )
            .withNickname( "OlegTok" ).withCompany( "Nike" ).withAddress( "Moscow" )
            .withHome( "+1" ).withMobile( "2652" ).withEmail( "info@nike.ru" ).withGroup( "[none]" );
    app.contact().modify( contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() );

    before.remove( modifiedContact );
    before.add( contact );
    Assert.assertEquals( before,  after );

  }

}
