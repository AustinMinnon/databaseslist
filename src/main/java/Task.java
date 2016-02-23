import java.util.List;
import org.sql2o.*;

public class Task {
  private int id;
  private int categoryId;
  private String description;

  public int getId() {
    return id;
  }

  public int getCategoryId() {
     return categoryId;
   }

  public String getDescription() {
    return description;
  }

  public Task(String description, int categoryId) {
    this.description = description;
    this.categoryId = categoryId;
  }

  @Override
  public boolean equals(Object otherTask){
    if (!(otherTask instanceof Task)) {
      return false;
    } else {
      Task newTask = (Task) otherTask;
      return this.getDescription().equals(newTask.getDescription()) &&
            this.getId() == newTask.getId() &&
            this.getCategoryId() == newTask.getCategoryId();
    }
  }

  public static List<Task> all() {
    String sql = "SELECT id, description, categoryId FROM Tasks";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Task.class);
    }
  }

  public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO Tasks (description, categoryId) VALUES (:description, :categoryId)";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("description", this.description)
      .addParameter("categoryId", this.categoryId)
      .executeUpdate()
      .getKey();
  }
  }
  public static Task find(int id) {
  try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM Tasks where id=:id";
    Task task = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Task.class);
    return task;
  }
  }
  public void update(String description) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE tasks SET description = :description) WHERE id = :id";
      con.createQuery(sql)
        .addParameter("description", description)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
    String sql = "DELETE FROM tasks WHERE id = :id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .executeUpdate();
    }
  }
 }



// import java.time.LocalDateTime;
// import java.util.ArrayList;
//
// public class Task {
//   private static ArrayList<Task> instances = new ArrayList<Task>();
//
//   private String mDescription;
//   private LocalDateTime mCreatedAt;
//   private boolean mCompleted;
//   private int mId;
//
//   public Task (String description) {
//     mDescription = description;
//     mCreatedAt = LocalDateTime.now();
//     mCompleted = false;
//     instances.add(this);
//     mId = instances.size();
//   }
//
//   public String getDescription() {
//     return mDescription;
//   }
//
//   public boolean isCompleted() {
//     return mCompleted;
//   }
//
//   public LocalDateTime getCreatedAt() {
//     return mCreatedAt;
//   }
//
//   public int getId() {
//     return mId;
//   }
//
//   public void completeTask() {
//     mCompleted = true;
//   }
//
//   public static ArrayList<Task> all() {
//     return instances;
//   }
//
//   public static Task find(int id) {
//     try {
//       return instances.get(id - 1);
//     } catch (IndexOutOfBoundsException e) {
//       return null;
//     }
//   }
//
//   public static void clear() {
//     instances.clear();
//   }
// }
