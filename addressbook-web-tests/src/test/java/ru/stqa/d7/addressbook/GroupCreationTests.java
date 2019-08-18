package ru.stqa.d7.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {

    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("Test1", "Test2", "Test3"));
    submitGroupCreation();
    returnToGroupPage();

  }


}
