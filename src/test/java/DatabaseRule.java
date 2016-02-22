import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  protect void before() {
    DB.sql2o = new Sql2o ("jdbc:postgresql://localhost:5432/to_do_test", null, null);
  }

  protected void after() {
    try(Connection con = DM.sql2o.open()) {
      String deleteTasksQuery = "DELETE FROM tasks *;";
      con.createQuery(deleteTasksQuery).executeUpdate();
    }
  }
}
