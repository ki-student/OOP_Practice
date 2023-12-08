import java.util.ArrayList;

public class ShoppingMall {
    ArrayList<Item> items;

    public ShoppingMall() {
        items = new ArrayList<>();
    }

    public void add(Item item) {
        items.add(item);
    }

    public Item findItem(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public void printItemsInPriceRange(int price1, int price2) {
        boolean found = false; // 가격 범위 내의 물품이 있는지 여부를 확인하기 위한 플래그

        for (Item item : items) {
            if (item.getPrice() >= price1 && item.getPrice() < price2) {
                System.out.println(item);
                System.out.println(item.getDescription());
                found = true;
            }
        }
        if (!found) {
            System.out.printf("%d <= 물품 가격 < %d 인 물품이 없습니다\n", price1, price2);
        }
    }

    public void printItemsInCategory(String category) {
        boolean found = false;

        for (Item item : items) {
            if (item.getCategory().equals(category)) {
                System.out.println(item);
                System.out.println(item.getDescription());
                found = true;
            }
        }
        if (!found) {
            System.out.println("분류항목 category 에 해당되는 물품이 없습니다");
        }
    }

    public void printItemsWithinNumRange(int num1, int num2) {
        boolean found = false; // 물품 번호 범위 내의 물품이 있는지 여부를 확인하기 위한 플래그

        for (Item item : items) {
            if (item.getNumber() >= num1 && item.getNumber() <= num2) {
                System.out.println(item);
                System.out.println(item.getDescription());
                found = true;
            }
        }
        if (!found) {
            System.out.printf("분류 번호 %d 이상 %d 이하에 해당되는 물품이 없습니다\n", num1, num2);
        }
    }

    public void printItemsDependsOnStockStatus(boolean inStock) {
        for (Item item : items) {
            if (item.isInStock() == inStock) {
                System.out.println(item);
                System.out.println(item.getDescription());
            }
        }
    }
}