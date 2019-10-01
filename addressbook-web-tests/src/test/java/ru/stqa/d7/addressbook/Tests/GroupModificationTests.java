package ru.stqa.d7.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.d7.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("Test1", null, null));
    }
  }

  @Test
  public void testGroupModification (){

    List<GroupData> before = app.getGroupHelper().getGroupList();
    int index = before.size() -1;
    GroupData group= new GroupData(before.get(index).getId(),"Test1", "Test2", "Test3");
    app.getGroupHelper().modifyGroup( index, group );
    List<GroupData>after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() );

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before ,after);

  }

}
