
package ua.nure.zhazhky.Practice8.db;

import ua.nure.zhazhky.Practice8.db.entity.Group;
import ua.nure.zhazhky.Practice8.db.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private static final String SQL_FIND_ALL_USERS = "SELECT * FROM users";
    private static final String SQL_FIND_ALL_GROUPS = "SELECT * FROM groups";
    private static final String SQL_INSERT_USER = "INSERT INTO users (login) VALUES (?)";
    private static final String SQL_INSERT_GROUP = "INSERT INTO groups (name) VALUES (?)";
    private static final String SQL_DELETE_GROUP = "DELETE FROM groups WHERE name = ?";
    private static final String SQL_INSERT_USERS_GROUPS = "INSERT INTO users_groups (user_id, group_id) VALUES (?, ?)";
    private static final String SQL_GET_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    private static final String SQL_GET_GROUP_BY_NAME = "SELECT * FROM groups WHERE name = ?";
    private static final String SQL_UPDATE_GROUP = "UPDATE groups SET name = ? WHERE id = ?";
    private static DBManager instance;
    static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/groups";
    public static Connection connection;

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if(connection == null){
                connection = DriverManager.getConnection(CONNECTION_URL, "root", "root");
                System.out.println("Connection established!");
            }
        }catch(SQLException e){
            throw new IllegalStateException("Cannot connect the database", e);
        }
        return connection;
    }

    public void insertUser(User user) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER);
        statement.setString(1, user.getLogin());
        statement.execute();
    }

    public List<User> findAllUsers() throws SQLException {
        Connection connection = getConnection();
        List<User> users = new ArrayList<>();
        PreparedStatement pstm = connection.prepareStatement(SQL_FIND_ALL_USERS);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            User user = new User();
            user.setLogin(rs.getString(2));
            users.add(user);
        }
        return users;
    }

    public void insertGroup(Group group) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT_GROUP);
        statement.setString(1, group.getName());
        statement.execute();
    }

    public List<Group> findAllGroups() throws SQLException {
        Connection connection = getConnection();
        List<Group> groups = new ArrayList<>();
        PreparedStatement pstm = connection.prepareStatement(SQL_FIND_ALL_GROUPS);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Group group = new Group();
            group.setName(rs.getString(2));
            groups.add(group);
        }
        return groups;
    }

    public User getUser(String login) throws SQLException {
        User user = new User();
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL_GET_USER_BY_LOGIN);
        statement.setString(1, login);
        ResultSet rs = statement.executeQuery();
        if(rs.next()){
            user.setId(Integer.valueOf(rs.getString(1)));
            user.setLogin(rs.getString(2));
        }
        return user;
    }

    public Group getGroup(String name) throws SQLException {
        Group group = new Group();
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL_GET_GROUP_BY_NAME);
        statement.setString(1, name);
        ResultSet rs = statement.executeQuery();
        if(rs.next()){
            group.setId(Integer.valueOf(rs.getString(1)));
            group.setName(rs.getString(2));
        }
        return group;
    }

    public void setGroupsForUser(User user, Group... groups) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USERS_GROUPS);
        try
        {
            connection.setAutoCommit(false);

            for (int i = 0; i < groups.length; i++) {
                statement.setString(1, String.valueOf(user.getId()));
                statement.setString(2, String.valueOf(groups[i].getId()));
                statement.execute();
            }
            connection.commit();
        }
        catch(Exception e)
        {
            connection.rollback();
        }
        finally
        {
//            connection.close();
        }
    }

    public void deleteGroup(Group group) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL_DELETE_GROUP);
        statement.setString(1, group.getName());
        statement.execute();
    }

    public void updateGroup(Group group) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_GROUP);
        statement.setString(1, group.getName());
        statement.setString(2, String.valueOf(group.getId()));
        statement.execute();
    }

    public Group getUserGroups(User user) {

        return null;
    }
}
