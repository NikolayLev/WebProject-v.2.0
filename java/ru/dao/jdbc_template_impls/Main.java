package ru.dao.jdbc_template_impls;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.models.User;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class Main {
    //language=SQL
    private final String SQL_SELECT_ALL = "select project_user.id, project_user.name, password, project_product.name as product_name, project_product.price from project_user left join project_product on project_user.name = project_product.user_name";
    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT project_user.id as id, project_user.name as name , password, project_product.id as product_id, project_product.name as product_name, project_product.price FROM project_user left join project_product ON project_user.id = project_product.user_id where project_user.id = ?";
    //language=SQL
    //language=SQL
    String sql = "SELECT project_user.id as id, project_user.name as name , password, project_product.id as product_id," +
            " project_product.name as product_name, project_product.price FROM project_user left join project_product ON " +
            "project_user.id = project_product.user_id";
    //language=SQL
    private final String SQL_INSERT_USER = "INSERT INTO project_user(name, password) VALUES(?,?)";
    //language=SQL
    private final String SQL_DELETE_USER = "DELETE FROM project_user WHERE id = ?; DELETE FROM project_product where user_id = ?";
    //language=SQL
    private final String SQL_UPDATE_USER_BY_ID = "UPDATE project_user SET name=?, password=? WHERE id =?";
    //language=SQL
    private final String SQL_DELETE_USER_BY_NAME ="DELETE FROM project_user WHERE name = ?; DELETE FROM project_product where user_name = ?";
    //language=SQL
    private final String SQL_UPDATE_USER_BY_NAME ="UPDATE project_user SET password=? WHERE id =?";

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();

        properties.load(new FileInputStream("C:\\JAVA\\WebProject -v2\\src\\main\\resources\\db.properties"));
        String userName = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");
        String driver = properties.getProperty("db.driverClassName");
        String url = properties.getProperty("db.url");
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, userName, password);
        dataSource.setDriverClassName(driver);
        UserDaoJDBCTemplateImpl userDaoJDBCTemplate = new UserDaoJDBCTemplateImpl(dataSource);

        List<User> list =userDaoJDBCTemplate.findAll();
        int i = 0 ;


    }
}
