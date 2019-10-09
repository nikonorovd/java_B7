package ru.stqa.d7.addressbook.Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.GroupData;
import ru.stqa.d7.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if(app.group().all().size() == 0){
      app.group().create(new GroupData().withName( "Test1" ));
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete( deletedGroup );
    assertThat(app.group().cout(), equalTo(before.size() -1));
    Groups after = app.group().all();
    assertThat( after, equalTo( before.without( deletedGroup ) ) );
    }
}
