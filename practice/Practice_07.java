import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Practice_07 {
    private ArrayList<Double> resultList;

    public Practice_07() {
        resultList = new ArrayList<>();
    }

    public void sort(ArrayList<Double> list1, ArrayList<Double> list2) {
        int n1 = 0;
        int n2 = 0;
        double d1;
        double d2;
        while (true) {
            if (n1 == list1.size() || n2 == list2.size()) {
                break;
            }
            d1 = list1.get(n1);
            d2 = list2.get(n2);
            if (d1 > d2) {
                resultList.add(d1);
                n1++;
            }
            else if (d1 < d2) {
                resultList.add(d2);
                n2++;
            }
            else {
                resultList.add(d1);
                resultList.add(d2);
                n1++;
                n2++;
            }
        }
        if (list1.size() == n1) {
            for (int i = n2; i < list2.size(); i++) {
                resultList.add(list2.get(i));
            }
        }
        if (list2.size() == n2) {
            for (int i = n1; i < list1.size(); i++) {
                resultList.add(list1.get(i));
            }
        }
    }

    public void process(String filename1, String filename2) {
        Scanner r1 = openFile(filename1);
        Scanner r2 = openFile(filename2);
        ArrayList<Double> list1 = createList(r1);
        ArrayList<Double> list2 = createList(r2);
        sort(list1, list2);
    }

    public void printResultList() {
        for (Double d : resultList) {
            System.out.println(d);
        }
    }

    private Scanner openFile(String filename) {
        try {
            Scanner sc = new Scanner(new File(filename));
            return sc;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Double> createList(Scanner sc) {
        ArrayList<Double> lst = new ArrayList<Double>();
        try {
            while (sc.hasNext()) {
                lst.add(sc.nextDouble());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public static void main(String[] args) {
        final String filename1 = "P07Data1.txt";
        final String filename2 = "P07Data2.txt";

        Practice_07 p07 = new Practice_07();
        p07.process(filename1, filename2);
        p07.printResultList();
    }
}