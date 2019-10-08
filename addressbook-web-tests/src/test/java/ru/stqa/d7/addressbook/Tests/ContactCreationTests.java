package ru.stqa.d7.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation()  {
    Set<ContactData> before = app.contact().all();
      ContactData contact = new ContactData().withFirstname("Oleg").withMiddlename("Tokarev").withNickname( "OlegTok" ).withCompany( "Nike" ).withAddress( "Moscow" )
              .withHome( "+1" ).withMobile( "2652" ).withEmail( "info@nike.ru" ).withGroup( "[none]" );
    app.goTo().contactPage();
    app.contact().create(contact, true);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() +1);


    contact.withId( after.stream().mapToInt( (c)->c.getId() ).max().getAsInt() );
    before.add( contact );
    Assert.assertEquals( before,  after );

  }

}
