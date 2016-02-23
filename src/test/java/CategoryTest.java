import org.junit.*;
import static org.junit.Assert.*;

public class CategoryTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Category.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Category firstCategory = new Category("Household chores");
    Category secondCategory = new Category("Household chores");
    assertTrue(firstCategory.equals(secondCategory));
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Category myCategory = new Category("Household chores");
    myCategory.save();
    assertTrue(Category.all().get(0).equals(myCategory));
  }

  @Test
  public void find_findCategoryInDatabase_true() {
    Category myCategory = new Category("Household chores");
    myCategory.save();
    Category savedCategory = Category.find(myCategory.getId());
    assertTrue(myCategory.equals(savedCategory));
  }
}



// import java.util.ArrayList;
//
// import org.junit.*;
// import static org.junit.Assert.*;
//
// public class CategoryTest {
//
//   @Test
//   public void getName_returnsName_true() {
//     Category testCategory = new Category("Home");
//     assertEquals("Home", testCategory.getName());
//   }
//
//   @Test
//   public void getId_returnsCategoryId() {
//     Category testCategory = new Category("Home");
//     assertTrue(Category.all().size() == testCategory.getId());
//   }
//
//   @Test
//   public void getTasks_initiallyReturnsEmptyArrayList() {
//     Category testCategory = new Category("Home");
//     assertTrue(testCategory.getTasks() instanceof ArrayList);
//   }
//
//   @Test
//   public void all_returnsAllInstancesOfTask_true() {
//     Category firstCategory = new Category("Home");
//     Category secondCategory = new Category("Home");
//     assertTrue(Category.all().contains(firstCategory));
//     assertTrue(Category.all().contains(secondCategory));
//   }
//
//   @Test
//   public void clear_removesAllCategoryInstancesFromMemory() {
//     Category testCategory = new Category("Home");
//     Category.clear();
//     assertEquals(Category.all().size(), 0);
//   }
//
//   @Test
//   public void find_returnsCategoryWithSameId() {
//     Category testCategory = new Category("Home");
//     assertEquals(Category.find(testCategory.getId()), testCategory);
//   }
//
//   @Test
//   public void addTask_addsTaskToList() {
//     Category testCategory = new Category("Bob's Used Tasks");
//     Task testTask = new Task("Mow the lawn");
//     testCategory.addTask(testTask);
//     assertTrue(testCategory.getTasks().contains(testTask));
//   }
// }
