package ru.dao.jdbc_template_impls;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class SqlQueriesList {
    //класс создан, чтобы sql запросы хранить в отдельном проперти файле и получать/изменять их быстро(пробный вариант):D
    static final Map<SqlQueriesEnum, String> SQL_QUERIES_ENUM_STRING_MAP = new TreeMap<>();


    private SqlQueriesList() {
    }

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\JAVA\\WebProject -v2\\src\\main\\resources\\sql_query.properties"));
            SQL_QUERIES_ENUM_STRING_MAP.put(SqlQueriesEnum.SQL_SELECT_BY_ID, properties.getProperty("SQL_SELECT_BY_ID"));
            SQL_QUERIES_ENUM_STRING_MAP.put(SqlQueriesEnum.SQL_DELETE_USER, properties.getProperty("SQL_DELETE_USER"));
            SQL_QUERIES_ENUM_STRING_MAP.put(SqlQueriesEnum.SQL_INSERT_USER, properties.getProperty("SQL_INSERT_USER"));
            SQL_QUERIES_ENUM_STRING_MAP.put(SqlQueriesEnum.SQL_SELECT_ALL, properties.getProperty("SQL_SELECT_ALL"));
            SQL_QUERIES_ENUM_STRING_MAP.put(SqlQueriesEnum.SQL_SELECT_BY_NAME, properties.getProperty("SQL_SELECT_BY_NAME"));
            SQL_QUERIES_ENUM_STRING_MAP.put(SqlQueriesEnum.SQL_UPDATE_USER_BY_ID, properties.getProperty("SQL_UPDATE_USER_BY_ID"));
            SQL_QUERIES_ENUM_STRING_MAP.put(SqlQueriesEnum.SQL_DELETE_USER_BY_NAME, properties.getProperty("SQL_DELETE_USER_BY_NAME"));
            SQL_QUERIES_ENUM_STRING_MAP.put(SqlQueriesEnum.SQL_UPDATE_USER_BY_NAME, properties.getProperty("SQL_UPDATE_USER_BY_NAME"));

        } catch (IOException e) {
            System.err.println("проблема с загрузкой проперти для SQL");
            throw new IllegalArgumentException();

        }


    }
}
