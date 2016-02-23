import java.util.List;
import org.sql2o.*;

public class Category {
  private int id;
  private String name;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Category(String name) {
    this.name = name;
  }

  public static List<Category> all() {
    String sql = "SELECT id, name FROM Categories";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Category.class);
    }
  }

  @Override
  public boolean equals(Object otherCategory){
    if (!(otherCategory instanceof Category)) {
      return false;
    } else {
      Category newCategory = (Category) otherCategory;
      return this.getName().equals(newCategory.getName());
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO Categories(name) VALUES (:name)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .executeUpdate()
        .getKey();
    }
  }

  public static Category find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM Categories where id=:id";
      Category Category = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Category.class);
      return Category;
    }
  }

  public List<Task> getTasks() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM tasks where categoryId=:id";
    return con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetch(Task.class);
  }
}
}



// import java.util.ArrayList;
//
// public class Category {
//   private static ArrayList<Category> instances = new ArrayList<Category>();
//
//   private String mName;
//   private int mId;
//   private ArrayList<Task> mTasks;
//
//   public Category(String name) {
//     mName = name;
//     instances.add(this);
//     mId = instances.size();
//     mTasks = new ArrayList<Task>();
//   }
//
//   public String getName() {
//     return mName;
//   }
//
//   public int getId() {
//     return mId;
//   }
//
//   public static ArrayList<Category> all() {
//     return instances;
//   }
//
//   public ArrayList<Task> getTasks() {
//     return mTasks;
//   }
//
//   public static void clear() {
//     instances.clear();
//   }
//
//   public static Category find(int id) {
//     try {
//       return instances.get(id - 1);
//     } catch (IndexOutOfBoundsException exception) {
//       return null;
//     }
//   }
//
//   public void addTask(Task task) {
//     mTasks.add(task);
//   }
//
// }
