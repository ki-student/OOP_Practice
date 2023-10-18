class Card {
    int num;
    String shape;

    Card(int n, String s) {
        num = n;
        shape = s;
    }

    int getNumber() { return num; }
    String getShape() { return shape; }
}

public class CardDeck {
    int count;
    Card[] cards;

    CardDeck() {
        count = 3;
        cards = new Card[3];
        cards[0] = new Card((int) Math.floor(Math.random() * 9) + 2, "Diamond");
        cards[1] = new Card((int) Math.floor(Math.random() * 9) + 2, "Diamond");
        cards[2] = new Card((int) Math.floor(Math.random() * 9) + 2, "Diamond");
    }

    void deal() {
        if (count <= 0) {
            System.out.println("카드가 더 이상 없습니다");
        }
        else {
            System.out.printf("모양: %s, 번호: %d\n",
                    cards[count - 1].getShape(), cards[count - 1].getNumber());
            count--;
        }
    }

    int getCount() { return count; }
}

class Main {
    public static void main(String[] args) {
        CardDeck carddeck = new CardDeck();
        System.out.printf("남아 있는 카드: %d\n", carddeck.getCount());
        carddeck.deal();
        System.out.printf("남아 있는 카드: %d\n", carddeck.getCount());
        carddeck.deal();
        System.out.printf("남아 있는 카드: %d\n", carddeck.getCount());
        carddeck.deal();
        carddeck.deal();
    }
}