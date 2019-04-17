package ifmo.artslob.webservices;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {
    public List<City> getCities() {
        List<City> cities = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from \"ifmo-ws.cities\";");
            while (rs.next()) {
                String name = rs.getString("name");
                String country = rs.getString("country");
                int founded = rs.getInt("founded");
                int population = rs.getInt("population");
                int area = rs.getInt("area");
                City city = new City(name, country, founded, population, area);
                cities.add(city);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cities;
    }
}
