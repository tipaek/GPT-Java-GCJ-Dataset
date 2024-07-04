import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nam = sc.nextInt();
        sc.nextLine();
        for (int tr = 0; tr < nam; tr++) {
            int S = sc.nextInt();
            ArrayList<String> al = new ArrayList<>();
            String longest = "";
            sc.nextLine();
            String cur = "";
            for (int i = 0; i < S; i++) {
                String temp = sc.nextLine();
                if (temp.length() > longest.length()) {
                    longest = temp;
                    cur = longest.substring(1);
                }
                if (temp.length() == longest.length()) cur += temp.substring(1);
                al.add(temp);
            }
            //cur += longest;
            boolean good = true;
            for (String t : al)
                if (!longest.contains(t.substring(1))) good = false;

            if (good) System.out.println("Case: #" + (tr + 1) + ":" + cur);
            else System.out.println("Case: #" + (tr + 1) + ":" + " *");
        }
    }
}
