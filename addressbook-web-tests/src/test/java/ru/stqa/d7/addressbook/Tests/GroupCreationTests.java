package ru.stqa.d7.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCout();
    app.getGroupHelper().createGroup(new GroupData("Test1", null, null));
    int after = app.getGroupHelper().getGroupCout();
    Assert.assertEquals(after, before +1);


  }


}
