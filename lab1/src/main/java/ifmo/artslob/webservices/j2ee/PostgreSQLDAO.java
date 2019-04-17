package ifmo.artslob.webservices.j2ee;

import com.healthmarketscience.sqlbuilder.BinaryCondition;
import com.healthmarketscience.sqlbuilder.SelectQuery;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbColumn;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSchema;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSpec;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbTable;
import ifmo.artslob.webservices.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {

    private Connection connection;

    public PostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    public List<City> getCities(
            String name,
            String country,
            String founded,
            String population,
            String area
    ) {
        List<City> cities = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(prepareQuery(name, country, founded, population, area));
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
            Logger.getLogger(ifmo.artslob.webservices.PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cities;
    }

    private String prepareQuery(
            String name,
            String country,
            String founded,
            String population,
            String area
    ) {
        DbSchema schema = new DbSpec().addDefaultSchema();
        DbTable table = schema.addTable("\"ifmo-ws.cities\"");
        DbColumn id_column = table.addColumn("id", Types.INTEGER, null);
        DbColumn name_column = table.addColumn("name", Types.VARCHAR, 200);
        DbColumn country_column = table.addColumn("country", Types.VARCHAR, 200);
        DbColumn founded_column = table.addColumn("founded", Types.INTEGER, null);
        DbColumn population_column = table.addColumn("population", Types.INTEGER, null);
        DbColumn area_column = table.addColumn("area", Types.INTEGER, null);
        SelectQuery select = new SelectQuery()
                .addColumns(id_column)
                .addColumns(name_column)
                .addColumns(country_column)
                .addColumns(founded_column)
                .addColumns(population_column)
                .addColumns(area_column);
        if (name != null && !name.isEmpty()) {
            select = select.addCondition(BinaryCondition.equalTo(name_column, name));
        }
        if (country != null && !country.isEmpty()) {
            select = select.addCondition(BinaryCondition.equalTo(country_column, country));
        }
        if (isInteger(founded)) {
            select = select.addCondition(BinaryCondition.equalTo(founded_column, founded));
        }
        if (isInteger(population)) {
            select = select.addCondition(BinaryCondition.equalTo(population_column, population));
        }
        if (isInteger(area)) {
            select = select.addCondition(BinaryCondition.equalTo(area_column, area));
        }
        String query = select.validate().toString();
        System.err.println(query);
        return query;
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}
