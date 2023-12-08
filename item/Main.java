public class Main {
    public static void main(String[] args) {
        ShoppingMall sm = new ShoppingMall();
//        String name, int price, boolean inStock, String author, String isbn
        sm.add(new Book("재미있는 소설 1", 15000, true, "조자작", "0100-11-1111"));
        sm.add(new Book("어려운 철학 1", 18000, true, "아리스토 펠레스", "0100-11-2311"));
        sm.add(new Book("MZ세대의 이해 1", 12000, false, "이해랑", "0100-11-1132"));
        sm.add(new MusicCD("Dream", 14000, true, "수미", "Track1;여름엔 비;붉은 하늘"));
        sm.add(new MusicCD("You and I", 19000, false, "한아", "당신 그리고 나;사랑의 온도;노래가 좋아서;I am..."));
        sm.add(new MusicCD("Beautiful Days", 21000, true, "트렌드", "유리창에 비친 햇빛;홍지문 연가;조조 영화;이별 후에"));

        System.out.println("-------------------------------");
        System.out.println("Category가 MusicCD인 물품 출력");
        sm.printItemsInCategory("MusicCD");

        System.out.println("-------------------------------");
        System.out.println("가격 범위가 15000원 이상 20000미만인 물품 출력");
        sm.printItemsInPriceRange(15000, 20000);

        System.out.println("-------------------------------");
        System.out.println("가격 범위가 1000원 이상 10000원 미만인 물품 출력");
        sm.printItemsInPriceRange(1000, 10000);

        System.out.println("\n-------------------------------");
        System.out.println("물건의 재고가 없는 물품 출력");
        sm.printItemsDependsOnStockStatus(false);

        Item it = sm.findItem("You and I");
        it.setStockStatus(true);

        System.out.println("\n-------------------------------");
        System.out.println("물건의 재고가 없는 물품 출력");
        sm.printItemsDependsOnStockStatus(false);

        System.out.println("\n-------------------------------");
        System.out.println("물품 번호 2-5까지 출력");
        sm.printItemsWithinNumRange(2, 5);
    }
}
