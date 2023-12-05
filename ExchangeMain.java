class ExchangeRate{
    private String countryName;
    private double exchangeRate;
    private String currencyUnit;

    public ExchangeRate(String name, double rate, String unit){
        this.countryName = name;
        this.exchangeRate = rate;
        this.currencyUnit = unit;
    }
    public String getCountryName(){return countryName;}
    public double getExchangeRate(){return exchangeRate;}
    public String getCurrencyUnit(){return currencyUnit;}
    public String toString(){
        return String.format("%.2f %s", getExchangeRate(), getCurrencyUnit());
    }
}

class ExchangeBank{
    private ExchangeRate[] rate;
    private int count;

    public ExchangeBank(){
        rate = new ExchangeRate[5];
        count = 0;
    }
    public void add(String name, double rate, String monetaryUnit){
        if(count < 5){
            this.rate[count] = new ExchangeRate(name, rate, monetaryUnit);
            count++;
        }else System.out.println("over 5");
    }
    public double exchange(String from, String to, double amount){
        ExchangeRate fromRate = findExchangeRate(from);
        ExchangeRate toRate = findExchangeRate(to);

        if (fromRate != null && toRate != null) {
            double fromCountry = amount * fromRate.getExchangeRate();
            double convertedAmount = fromCountry / toRate.getExchangeRate();
            return convertedAmount;
        } else {
            return 0.0;
        }
    }
    public ExchangeRate findExchangeRate(String name){
        for (int i = 0; i < count; i++) {
            if (rate[i].getCountryName().equals(name)) {
                return rate[i];
            }
        }
        return null;
    }
}

public class ExchangeMain {
    public static void main(String[] args) {
        ExchangeBank exchangeBank = new ExchangeBank();

        // Adding exchange rates
        exchangeBank.add("미국", 1438.5, "달러");
        exchangeBank.add("중국", 197.82, "위안");
        exchangeBank.add("영국", 1628.24, "파운드");
        exchangeBank.add("유로", 1414.62, "유로");
        exchangeBank.add("스위스", 1439.08, "프랑");

        // Performing exchange
        double convertedAmount = exchangeBank.exchange("미국", "영국", 100);
        System.out.printf("Converted amount: %.2f 파운드\n", convertedAmount);

        // Finding exchange rate
        ExchangeRate ukExchangeRate = exchangeBank.findExchangeRate("영국");
        System.out.println("영국 환율: " + ukExchangeRate);
    }
}
