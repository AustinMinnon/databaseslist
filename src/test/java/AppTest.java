import java.util.ArrayList;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
//   extends FluentTest
//   public WebDriver webDriver = new HtmlUnitDriver();
//
//   @Override
//   public WebDriver getDefaultDriver() {
//       return webDriver;
//   }
//
//   @ClassRule
//   public static ServerRule server = new ServerRule();
//
//   @Test
//   public void rootTest() {
//       goTo("http://localhost:4567/");
//       assertThat(pageSource()).contains("Task list");
//   }
//
//   @Test
//   public void categoryIsCreatedTest() {
//     goTo("http://localhost:4567/");
//     click("a", withText("Add a New Category"));
//     fill("#name").with("Household chores");
//     submit(".btn");
//     assertThat(pageSource()).contains("Your category has been saved.");
//   }
//
//   @Test
//   public void categoryIsDisplayedTest() {
//     goTo("http://localhost:4567/categories/new");
//     fill("#name").with("Household chores");
//     submit(".btn");
//     click("a", withText("View categories"));
//     assertThat(pageSource()).contains("Household chores");
//   }
//
//   @Test
//   public void categoryTasksFormIsDisplayed() {
//     goTo("http://localhost:4567/categories/new");
//     fill("#name").with("Shopping");
//     submit(".btn");
//     click("a", withText("View categories"));
//     click("a", withText("Shopping"));
//     click("a", withText("Add a new task"));
//     assertThat(pageSource()).contains("Add a new Task to your Shopping");
// }
//
//   @Test
//   public void tasksIsAddedAndDisplayed() {
//     goTo("http://localhost:4567/categories/new");
//     fill("#name").with("Banking");
//     submit(".btn");
//     click("a", withText("View categories"));
//     click("a", withText("Banking"));
//     click("a", withText("Add a new task"));
//     fill("#description").with("Deposit paycheck");
//     submit(".btn");
//     assertThat(pageSource()).contains("Deposit paycheck");
// }

  // @Test
  // public void checkIfTaskDisplayed() {
  //     goTo("http://localhost:4567/");
  //     fill("#description").with("Wash the dishes");
  //     submit(".btn");
  //     click("a", withText("Go Back"));
  //     assertThat(pageSource()).contains("Wash the dishes");
  // }
  // @Test
  // public void multipleTasksAreDisplayedTest() {
  //   goTo("http://localhost:4567/tasks/new");
  //   fill("#description").with("Wash the dishes");
  //   submit(".btn");
  //   click("a", withText("Go Back"));
  //   click("a", withText("Add a new task"));
  //   fill("#description").with("Buy groceries");
  //   submit(".btn");
  //   click("a", withText("Go Back"));
  //   click("a", withText("View all tasks"));
  //   assertThat(pageSource()).contains("Wash the dishes");
  //   assertThat(pageSource()).contains("Buy groceries");
  // }
  // @Test
  // public void taskShowPageDisplaysDescription() {
  //   goTo("http://localhost:4567/tasks/new");
  //   fill("#description").with("Do the dishes");
  //   submit(".btn");
  //   click("a", withText("View tasks"));
  //   click("a", withText("Do the dishes"));
  //   assertThat(pageSource()).contains("Do the dishes");
  // }
//   @Test
// public void taskNotFoundMessageShown() {
//   goTo("http://localhost:4567/tasks/999");
//   assertThat(pageSource()).contains("Task not found");
// }
}
