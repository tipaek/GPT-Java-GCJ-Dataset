import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nam = sc.nextInt();
        for (int tr = 0; tr < nam; tr++) {
            sc.nextLine();
            int S = sc.nextInt();
            ArrayList<String> al = new ArrayList<>();
            String longest = "";
            sc.nextLine();
            for (int i = 0; i < S; i++) {
                String temp = sc.nextLine();
                if (temp.length() > longest.length()) longest = temp;
                al.add(temp);
            }
            boolean good = true;
            for (String t : al)
                if (!longest.contains(t.substring(1))) good = false;

            if (good) System.out.println(longest.substring(1));
            else System.out.println("*");
        }
    }
}
