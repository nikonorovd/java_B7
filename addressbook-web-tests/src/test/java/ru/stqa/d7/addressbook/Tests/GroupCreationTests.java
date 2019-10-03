package ru.stqa.d7.addressbook.Tests;

import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.GroupData;
import ru.stqa.d7.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase{

  @Test (enabled = false)
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before = (Groups) app.group().all();
    GroupData group = new GroupData().withName( "Test2" );
    app.group().create(group);
    Groups after = (Groups) app.group().all();
    assertThat(after.size(), equalTo(before.size() +1));

    assertThat( after, equalTo( before.withAdded
            (group.withId( after.stream().mapToInt( (g)->g.getId()).max().getAsInt() ))));
  }
}
