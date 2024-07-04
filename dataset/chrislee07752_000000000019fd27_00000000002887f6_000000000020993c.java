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
            HashSet<Integer> rows = new HashSet<>();
            HashSet<Integer> cols = new HashSet<>();
            for (int j = 0; j < n; j++) {
                for (int j1 = 0; j1 < n; j1++) {
                    int check = scan.nextInt();
                    if (j == j1) {
                        trace += check;
                    }

                    if (map.containsKey(check)) {
                        // System.out.println("when duplicate: " + j + " " + j1);
                        for (int i1 = 0; i1 < ((map.get(check).length() / 2) - 1); i1++) {

                            if (!rows.contains(Integer.parseInt(map.get(check).split(" ")[i1]))
                                    && Integer.parseInt(map.get(check).split(" ")[i1]) == j) {
                                // System.out.println("added r");
                                // System.out.println(map.get(check).split(" ")[i1] + "==" + j);
                                rows.add(Integer.parseInt(map.get(check).split(" ")[i1]));
                                r++;
                            }

                            if (!cols.contains(Integer.parseInt(map.get(check).split(" ")[i1 + 1]))
                                    && Integer.parseInt(map.get(check).split(" ")[i1 + 1]) == j1) {
                                // System.out.println("added c");
                                // System.out.println(map.get(check).split(" ")[i1 + 1] + "==" + j1);
                                cols.add(Integer.parseInt(map.get(check).split(" ")[i1 + 1]));
                                c++;
                            }
                            i1++;
                        }
                    }
                    // map.put(check, "" + j + " " + j1 + " ");
                    map.put(check, map.getOrDefault(check, "") + j + " " + j1 + " ");

                }
            }
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + r + " " + c);
            // System.out.println(map);
        }
    }
}