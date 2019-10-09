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
    assertThat(app.contact().count(), equalTo (before.size() +1));
    Contacts after = (Contacts) app.contact().all();
    assertThat( after, equalTo( before.withAdded
            (contact.withId( after.stream().mapToInt( (c)->c.getId() ).max().getAsInt() ))));
  }

  @Test
  public void testBadContactCreation()  {
    Contacts before = (Contacts) app.contact().all();
    ContactData contact = new ContactData().withFirstname("Oleg1").withMiddlename("Tokarev").withNickname( "OlegTok" ).withCompany( "Nike" ).withAddress( "Moscow" )
            .withHome( "+1" ).withMobile( "2652" ).withEmail( "info@nike.ru" ).withGroup( "[none]" );
    app.goTo().contactPage();
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo (before.size()));
    Contacts after = (Contacts) app.contact().all();
    assertThat( after, equalTo( before));
  }

}
