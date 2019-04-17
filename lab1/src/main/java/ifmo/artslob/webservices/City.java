package ifmo.artslob.webservices;

public class City {
    private String name;
    private String country;
    private int founded;
    private int population;
    private int area;

    public City() {
    }

    public City(String name, String country, int founded, int population, int area) {
        this.name = name;
        this.country = country;
        this.founded = founded;
        this.population = population;
        this.area = area;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", founded=" + founded +
                ", population=" + population +
                ", area=" + area +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
