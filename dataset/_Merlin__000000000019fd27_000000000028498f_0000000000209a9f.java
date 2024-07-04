//package googleCodeJam;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            int count = 0;
            String sNew = "";
            for (int j = 0; j < s.length(); j++) {
                int z = s.charAt(j) - '0';
                if (count <= z) {
                    while (count < z) {
                        sNew += "(";
                        count++;
                    }
                } else {
                    while (count > z) {
                        sNew += ")";
                        count--;
                    }
                }
                sNew += s.charAt(j);
            }
            while (count > 0) {
                sNew += ")";
                count--;
            }
            System.out.println("Case #" + (i + 1) + ": " + sNew);
        }

    }
}
