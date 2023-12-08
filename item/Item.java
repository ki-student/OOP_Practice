abstract class Item {
    private static int count = 1;
    private String name;
    private int price;
    private int number;
    private String category;
    private boolean inStock;

    public Item(String name, int price, String category, boolean inStock){
        this.name = name;
        this.price = price;
        this.category = category;
        this.inStock = inStock;
        number = count++;
    }
    public boolean isInStock(){return inStock;}
    public void setStockStatus(boolean status){inStock = status;}
    public int getPrice(){return price;}
    public int getNumber(){return number;}
    public String getName(){return name;}
    public String getCategory(){return category;}
    public abstract String getDescription();

    @Override
    public String toString() {
        String result = String.format("Name: %s\nPrice: %d\nNumber: %d\nIn stock: %b",
                name, price, number, inStock);
        return result;
    }
}
