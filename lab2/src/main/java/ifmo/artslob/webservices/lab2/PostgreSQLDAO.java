package ifmo.artslob.webservices.lab2;

import com.healthmarketscience.sqlbuilder.*;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbColumn;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSpec;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {
    private DbTable table;
    private DbColumn id_column;
    private DbColumn name_column;
    private DbColumn country_column;
    private DbColumn founded_column;
    private DbColumn population_column;
    private DbColumn area_column;

    PostgreSQLDAO() {
        this.table = new DbSpec().addDefaultSchema().addTable("\"ifmo-ws.cities\"");
        this.id_column = table.addColumn("id", Types.INTEGER, null);
        this.name_column = table.addColumn("name", Types.VARCHAR, 200);
        this.country_column = table.addColumn("country", Types.VARCHAR, 200);
        this.founded_column = table.addColumn("founded", Types.INTEGER, null);
        this.population_column = table.addColumn("population", Types.INTEGER, null);
        this.area_column = table.addColumn("area", Types.INTEGER, null);
    }

    int createCity(
            String name,
            String country,
            String founded,
            String population,
            String area
    ) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement stmt = connection.createStatement();
            String query = createInsertQuery(name, country, founded, population, area);
            logSqlQuery(query);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    List<City> getCities(
            String name,
            String country,
            String founded,
            String population,
            String area
    ) {
        List<City> cities = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = createSelectQuery(name, country, founded, population, area);
            logSqlQuery(query);
            ResultSet rs = connection.createStatement().executeQuery(query);
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

    boolean updateCity(
            String id,
            String name,
            String country,
            String founded,
            String population,
            String area
    ) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement stmt = connection.createStatement();
            String query = createUpdateQuery(id, name, country, founded, population, area);
            logSqlQuery(query);
            int rowsNumber = stmt.executeUpdate(query);
            return rowsNumber > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    boolean deleteCity(String id) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement stmt = connection.createStatement();
            String query = createDeleteQuery(id);
            logSqlQuery(query);
            int rowsNumber = stmt.executeUpdate(query);
            return rowsNumber > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private String createInsertQuery(
            String name,
            String country,
            String founded,
            String population,
            String area
    ) {
        return new InsertQuery(table)
                .addColumn(name_column, name)
                .addColumn(country_column, country)
                .addColumn(founded_column, founded)
                .addColumn(population_column, population)
                .addColumn(area_column, area)
                .validate()
                .toString();
    }

    private String createSelectQuery(
            String name,
            String country,
            String founded,
            String population,
            String area
    ) {
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
        return select.validate().toString();
    }

    private String createUpdateQuery(
            String id,
            String name,
            String country,
            String founded,
            String population,
            String area
    ) {
        return new UpdateQuery(table)
                .addCondition(BinaryCondition.equalTo(id_column, id))
                .addSetClause(name_column, name)
                .addSetClause(country_column, country)
                .addSetClause(founded_column, founded)
                .addSetClause(population_column, population)
                .addSetClause(area_column, area)
                .validate()
                .toString();
    }

    private String createDeleteQuery(String id) {
        return new DeleteQuery(table)
                .addCondition(BinaryCondition.equalTo(id_column, id))
                .validate()
                .toString();
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    private void logSqlQuery(String query) {
        System.err.println(query);
    }
}
