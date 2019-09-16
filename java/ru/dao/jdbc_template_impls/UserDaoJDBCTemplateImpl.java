package ru.dao.jdbc_template_impls;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.dao.UserDao;
import ru.models.User;
import ru.models.UserProduct;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserDaoJDBCTemplateImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDaoJDBCTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<User> findUserByName(String name) {
        try {

            List<User> userlist;
            userlist = jdbcTemplate.query(SqlQueriesList.SQL_QUERIES_ENUM_STRING_MAP.get(SqlQueriesEnum.SQL_SELECT_BY_NAME),
                    new UserRowMapper(), name);

            return Optional.of(userlist.get(0));

        } catch (IndexOutOfBoundsException Ex) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> find(Integer id) {
        try {

            List<User> userlist;
            userlist = jdbcTemplate.query(SqlQueriesList.SQL_QUERIES_ENUM_STRING_MAP.get(SqlQueriesEnum.SQL_SELECT_BY_ID), new UserRowMapper(), id);

            return Optional.of(userlist.get(0));

        } catch (IndexOutOfBoundsException Ex) {
            return Optional.empty();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        Iterator<User> iterator = jdbcTemplate.query(SqlQueriesList.SQL_QUERIES_ENUM_STRING_MAP.get(SqlQueriesEnum.SQL_SELECT_ALL),
                new UserRowMapper()).iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (!list.contains(user)) {
                list.add(user);
            }

        }
        return list;
    }



    @Override
    public void save(User model) {
        jdbcTemplate.update(SqlQueriesList.SQL_QUERIES_ENUM_STRING_MAP.get(SqlQueriesEnum.SQL_INSERT_USER), model.getName(),
                model.getPassword());
    }

    @Override
    public void update(User model) {
        jdbcTemplate.update(SqlQueriesList.SQL_QUERIES_ENUM_STRING_MAP.get(SqlQueriesEnum.SQL_UPDATE_USER_BY_NAME),
            model.getPassword(), model.getName());
}

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update(SqlQueriesList.SQL_QUERIES_ENUM_STRING_MAP.get(SqlQueriesEnum.SQL_DELETE_USER),
                id);
    }
    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update(SqlQueriesList.SQL_QUERIES_ENUM_STRING_MAP.get(SqlQueriesEnum.SQL_DELETE_USER_BY_NAME),
                name,name);
    }
}

class UserRowMapper implements RowMapper<User> {
    private Map<Integer, User> userList = new HashMap();

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        if (!userList.containsKey(id)) {
            String password = resultSet.getString("password");
            User user = new User(name, password, id);
            userList.put(id, user);
        }
        String productName = resultSet.getString("product_name");
        if (productName != null) {
            int price = resultSet.getInt("price");
            UserProduct userProduct = new UserProduct(productName, price, userList.get(id));
            userList.get(id).getUserProductList().add(userProduct);
        }
        return userList.get(id);
    }
}
