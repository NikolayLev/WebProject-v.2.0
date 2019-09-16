import org.junit.Test;
import ru.dao.hibernate_impls.HibernateUtil;
import ru.dao.hibernate_impls.UserDaoHibernateImpl;
import ru.models.User;

import java.util.List;
import java.util.Optional;

public class HibernateTest {
    @Test
    public void hibernateShouldReturnClassesFromDb() {
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl(HibernateUtil.getSessionFactory());
        User user = userDaoHibernate.find(25).get();

        int i = 10;
        List<User> userList = userDaoHibernate.findAll();
       // userDaoHibernate.delete(33);

        //User user2 = userDaoHibernate.findUserByName("koliannn").get();
        int ii = 10;
        userDaoHibernate.deleteByName("hello1");


    }
}

