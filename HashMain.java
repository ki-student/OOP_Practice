import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Hash {
    private int hashBase;
    private int hashSize;

    public Hash(int hashBase, int hashSize){
        this.hashBase = hashBase;
        this.hashSize = hashSize;
    }
    public long getHashValue(String str){
        long hash = 0;
        int n = str.length();
        for (int i = 0; i < n; i++){
            hash += (long) (str.charAt(i) * Math.pow(hashBase, str.length() - i - 1));
        }
        return hash % hashSize;
    }
}

class HashTable {
    private int size;
    private Hash hash;
    private Map<Long, ArrayList<String>> map;

    public HashTable(int size) {
        this.size = size;
        hash = new Hash(7, size);
        this.map = new HashMap<Long, ArrayList<String>>();
    }
    public long power(long n1, int n2) {
        long n = 1;
        for (int i = 1; i <= n2; i++){
            n *= n1;
        }
        return n;
    }
    private boolean isInList(List<String> lst, String word) {
        for(String s : lst){
            if (s.equals(word)){
                return true;
            }
        }return false;
    }
    public long getHashValue(String word) {return hash.getHashValue(word);}

    // 4.5
    public void add(String word) {
        long val = hash.getHashValue(word);

        if (map.containsKey(val)){
            ArrayList<String> lst = map.get(val);
            if (!isInList(lst, word)){
                lst.add(word);
            }
        }
        else {
            ArrayList<String> lst = new ArrayList<String>();
            lst.add(word);
            map.put(val, lst);
        }
    }
    public void print() {
        for (Long n : map.keySet()) {
            ArrayList<String> lst = map.get(n);
            System.out.print(n + ": ");
            for (int i = 0; i < lst.size() - 1; i++) {
                System.out.printf("%s, ", lst.get(i));
            }
            System.out.printf("%s\n", lst.get(lst.size() - 1));
        }
    }
}

public class HashMain {
    private HashTable hashTable;
    private String splitChars;

    public HashMain(String chars) {
        hashTable = new HashTable(20);
        splitChars = chars;
    }
    public void print() {hashTable.print();}
    public void readFile(String filename) {
        try {
            BufferedReader f = new BufferedReader(new FileReader(filename));
            String line = f.readLine();
            while (line != null) {
                String[] arr = line.split(splitChars);
                for (String s : arr) {
                    if (!s.equals("")) {
                        hashTable.add(s);
                    }
                }
                line = f.readLine();
            }
        }
        catch(FileNotFoundException e){
                e.printStackTrace();
            }
        catch(Exception e){
                e.printStackTrace();
            }
    }

     public static void main(String[] args) {
            HashMain m = new HashMain("[\t\n :.,;!\"]");
            m.readFile("Final1data.txt");
            m.print();
        }
}