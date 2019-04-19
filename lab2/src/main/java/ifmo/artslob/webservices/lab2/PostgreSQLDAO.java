package ifmo.artslob.webservices.lab2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {
    public int createCity(
            String name,
            String country,
            String founded,
            String population,
            String area
    ) {
        // TODO
        return 0;
    }

    public List<City> getCities(
            String name,
            String country,
            String founded,
            String population,
            String area
    ) {
        List<City> cities = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from \"ifmo-ws.cities\";");
            while (rs.next()) {
                City city = new City(
                        rs.getString("name"),
                        rs.getString("country"),
                        rs.getInt("founded"),
                        rs.getInt("population"),
                        rs.getInt("area")
                );
                cities.add(city);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cities;
    }

    public boolean updateCity(
            String id,
            String name,
            String country,
            String founded,
            String population,
            String area
    ) {
        // TODO
        return true;
    }

    public boolean deleteCity(String id) {
        // TODO
        return true;
    }
}
