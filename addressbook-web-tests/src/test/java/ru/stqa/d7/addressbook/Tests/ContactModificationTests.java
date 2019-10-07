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
      app.contact().create(new ContactData ().withFirstname("Oleg").withMiddlename("Tokarev").withNickname( "OlegTok" ).withCompany( "Nike" ).withAddress( "Moscow" )
              .withHome( "+1" ).withMobile( "2652" ).withEmail( "info@nike.ru" ).withGroup( "[none]" ), true);
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData().withId (before.get(index).getId()).withFirstname(before.get( index ).getFirstname()).withMiddlename( before.get( index ).getMiddlename() )
            .withNickname( "OlegTok" ).withCompany( "Nike" ).withAddress( "Moscow" )
            .withHome( "+1" ).withMobile( "2652" ).withEmail( "info@nike.ru" ).withGroup( "[none]" );
    app.contact().modify( contact, index );
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
