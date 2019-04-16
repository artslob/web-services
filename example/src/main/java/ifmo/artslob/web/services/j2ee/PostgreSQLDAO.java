package ifmo.artslob.web.services.j2ee;

import ifmo.artslob.web.services.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {
    private Connection connection;

    public PostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Person> getPersons(String name_param) {
        List<Person> persons = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from \"ifmo-ws.persons\"");
            while (rs.next()) {
                String name = rs.getString("name");
                if (name_param != null && !name.equalsIgnoreCase(name_param)) {
                    continue;
                }
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                Person person = new Person(name, surname, age);
                persons.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persons;
    }
}
