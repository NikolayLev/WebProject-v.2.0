import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.dao.PasswordHashingImpl;
import ru.dao.jdbc_template_impls.UserDaoJDBCTemplateImpl;
import ru.models.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class JDBCTemplateTestClass {
   static Properties properties = new Properties();
   static UserDaoJDBCTemplateImpl userDaoJDBCTemplate;

    @BeforeClass
    public static void initClass() throws IOException {

        properties.load(new FileInputStream("C:\\JAVA\\WebProject -v2\\src\\main\\resources\\db.properties"));
        String userName = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");
        String driver = properties.getProperty("db.driverClassName");
        String url = properties.getProperty("db.url");
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, userName, password);
        dataSource.setDriverClassName(driver);
        userDaoJDBCTemplate = new UserDaoJDBCTemplateImpl(dataSource);

    }

    @Test
    public void findAllandFindByNameId() {

        List<User> userList = userDaoJDBCTemplate.findAll();
        Iterator<User> userIterator = userList.iterator();
        while (userIterator.hasNext()){
            User user = userIterator.next();
            System.out.println(user.getName()+" id = "+user.getId()+" Количество товаров "+ user.getUserProductList().size());
        }
        //Optional<User> user = userDaoJDBCTemplate.findUserByName("koliannn");
        //User user1;
        //if (!user.isEmpty()) {
        //    user1 = user.get();
        //   System.out.println("Пользователь есть "+user1.getName()+" id = "+user1.getId()+" Количество товаров "+ user1.getUserProductList().size());
        //}else {
        //    System.out.println("пользователя нет");
        //}
        //Optional<User> user2 = userDaoJDBCTemplate.findUserByName("moren");
        //User user3;
        //if (!user2.isEmpty()) {
        //    user3 = user2.get();
        //    System.out.println("Пользователь есть "+user3.getName()+" id = "+user3.getId()+" Количество товаров "+ user3.getUserProductList().size());
        //}else {
        //    System.out.println("пользователя нет");
        //}
//
        //Optional<User> user4 = userDaoJDBCTemplate.find(25);
        //User user5;
        //if (!user.isEmpty()) {
        //    user1 = user.get();
        //    System.out.println("Пользователь есть "+user1.getName()+" id = "+user1.getId()+" Количество товаров "+ user1.getUserProductList().size());
        //}else {
        //    System.out.println("пользователя нет");
        //}


    }
    @Test
    public void saveUserShouldCreateNewRowInDB(){

        //User user = new User("admin4",PasswordHashingImpl.getPasswordHashing.createHashFromPass("admin2"));
        ////userDaoJDBCTemplate.save(user);
        //user.setHashPass(PasswordHashingImpl.getPasswordHashing.createHashFromPass("admin4"));
        //userDaoJDBCTemplate.update(user);
        userDaoJDBCTemplate.delete(38);
        userDaoJDBCTemplate.delete(40);
        userDaoJDBCTemplate.deleteByName("admin3");
        userDaoJDBCTemplate.deleteByName("admin4");
        }
}
