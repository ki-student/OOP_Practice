import java.util.ArrayList;

class RandomUtil {
    public static int randIntInRange(int lower, int
            upper) {
        int num = ((int) (Math.random() *
                Integer.MAX_VALUE) % (upper - lower + 1)) + lower; return num;
    }
}

class BankUtil{
    static String generateAcctNum(int fLower, int fUpper, int sLower, int sUpper){
        return "" + RandomUtil.randIntInRange(fLower, fUpper) + '-'
                + RandomUtil.randIntInRange(sLower, sUpper);
    }
}

abstract class Account{
    private String owner;
    private int balance;
    private String number;
    private double interestRate;
    private boolean closed;

    public Account(String owner, double rate){
        this.owner = owner;
        interestRate = rate;
        balance = 0;
        closed = false;
        number = generateAcctNum();
    }
    public int getBalance(){return balance;}
    public void setBalance(int amount){balance = amount;}
    public String getOwner(){return owner;}
    public String getAcctNum(){return number;}
    public String toString(){
        return "Owner: " + owner + " Balance: " + balance + " Acct Number: " + number + " Closed: " + closed;
    }
    public void deposit(int amount){
        if (!closed){
            balance += amount;
            System.out.printf("%d원이 입금되었습니다.\n", balance);
        }
        else System.out.println("해지된 계좌입니다.");
    }
    public void withdraw(int amount) {
        if (!closed) {
            if (balance >= amount) {
                balance -= amount;
                System.out.printf("%d원이 출금되었습니다.\n", balance);
            } else System.out.printf("잔액 부족. 현재 잔액 : %d\n", balance);
        } else System.out.println("해지된 계좌입니다.");
    }
    public void close(){
        closed = true;
        System.out.printf("계좌 %s를 해지. %d원을 환급\n", number, balance);
    }
    public abstract String generateAcctNum();
}

class CheckingAccount extends Account {
    public CheckingAccount(String owner, double rate) {
        super(owner, rate);
    }

    @Override
    public String generateAcctNum() {
        return BankUtil.generateAcctNum(101, 200, 10000, 50000);
    }
}

class SavingsAccount extends Account{
    private int monthlyPayment;
    private int duration;
    private int paymentCount;

    public SavingsAccount(String owner, double rate, int amount, int duration) {
        super(owner, rate);
        if (duration != 6 && duration != 12) {
            close();
        }
        monthlyPayment = amount;
        this.duration = duration;
        paymentCount = 0;
    }
    @Override
    public void deposit(int amount) {
        if (amount != monthlyPayment) {
            System.out.println("입금액이 정해진 액수와 다릅니다");
        }
        else if (paymentCount == duration) {
            System.out.println("만기되었습니다. 더 이상 입금할 수 없습니다");
        }
        else {
            super.deposit(amount);
        }
    }
    @Override
    public String generateAcctNum() {
        return BankUtil.generateAcctNum(201, 300, 10000, 50000);
    }
}

public class BankMain {
    public static void main(String[] args) {
        ArrayList<Account> accts = new ArrayList<>();
        accts.add(new CheckingAccount("cho", 1.0));
        Account a = new SavingsAccount("cho", 3.5, 50000, 12);
        a.deposit(50000);
        a.deposit(5000);
        a.withdraw(50000);
        accts.add(a);

        for (Account c : accts){
            if (a.getOwner().equals("cho")){
                System.out.println(c);
            }
        }

        Account s = accts.get(0);
        s.close();
        s.deposit(100);
        System.out.println(s);
    }
}