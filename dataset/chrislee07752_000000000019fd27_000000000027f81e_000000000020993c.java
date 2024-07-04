//vestigium q1

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int r = 0;
            int c = 0;
            int trace = 0;
            HashMap<Integer, String> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                for (int j1 = 0; j1 < n; j1++) {
                    int check = scan.nextInt();
                    if (j == j1) {
                        trace += check;
                    }
                    if (map.containsKey(check)) {
                        if (map.get(check).split(" ")[0].equals(j)) {
                            r++;
                        }
                        if (map.get(check).split(" ")[1].equals(j1)) {
                            c++;
                        }
                        continue;
                    }
                    map.put(check, "" + j + " " + j1 + "");

                }
            }
            System.out.println("Case #" + i +": " + trace + " " + r + " " + c);
        }
    }
}