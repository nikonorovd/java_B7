package ru.stqa.d7.addressbook.Tests;

import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.ContactData;
import ru.stqa.d7.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation()  {
   Contacts before = (Contacts) app.contact().all();
      ContactData contact = new ContactData().withFirstname("Oleg").withMiddlename("Tokarev").withNickname( "OlegTok" ).withCompany( "Nike" ).withAddress( "Moscow" )
              .withHome( "+1" ).withMobile( "2652" ).withEmail( "info@nike.ru" ).withGroup( "[none]" );
    app.goTo().contactPage();
    app.contact().create(contact, true);
    Contacts after = (Contacts) app.contact().all();
    assertThat(after.size(), equalTo (before.size() +1));

    assertThat( after, equalTo( before.withAdded
            (contact.withId( after.stream().mapToInt( (c)->c.getId() ).max().getAsInt() ))));
  }

}
