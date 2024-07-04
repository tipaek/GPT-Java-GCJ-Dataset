import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        HashMap<String, String> a = new HashMap<>();
        a.put("2,2", "2 1");
        a.put("2,3", "1 3,2 3");
        a.put("2,4", "2 3,2 5");
        a.put("2,5", "1 5,2 5,2 7");
        a.put("3,2", "2 3,2 2");
        a.put("3,3", "2 5,2 2,3 5");
        a.put("3,4", "2 7,2 9,2 4,2 8");
        a.put("4,2", "2 5,2 4,2 3");
        a.put("4,3", "1 9,2 9,2 6,2 2,3 7");
        a.put("5,2", "2 7,2 6,2 5,2 4");
        a.put("6,2", "2 9,2 8,2 7,2 6,2 5");
        a.put("7,2", "2 11,2 10,2 9,2 8,2 7,2 6");

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int r = sc.nextInt();
            int s = sc.nextInt();
            String answ = a.get(s + "," + r).replace(",", "\n");
            System.out.printf("Case #%d: %d%n%s%n", i + 1, 1 + answ.length() - answ.replace("\n", "").length(), answ);
        }
    }
}
