package country;
public class country {
    String name, capital, currency;
    int population;
    public country(String name,String capital,int population,String currency){
        this.name=name;
        this.capital=capital;
        this.population=population;
        this.currency=currency;
    }
    
     public String getName() {
        return name;
    }
  
    public String getCapital() {
        return capital;
    }

    public String getCurrency() {
        return currency;
    }

    public int getPopulation() {
        return population;
    }
    
       public void setName(String name) {
        this.name = name;
    }
       public void setcapital(String capital) {
        this.capital = capital;
    }
    public void setcurrency(String currency) {
        this.currency = currency;
    }
    public void setpopulation(int population) {
        this.population = population;
    }
}
