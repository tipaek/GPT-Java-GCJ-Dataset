import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Solution {
    public static void main (String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int u = in.nextInt();
            HashMap<Integer, HashSet<String>> list = new HashMap<>();
            for (int i2 = 0; i2 < 10; i2++) {
                list.put(i2, new HashSet<String>());
            }
            for (int i2 = 0; i2 < 10000; i2++) {
                int q = in.nextInt();
                if (q != -1) {
                    String r = in.next();
                    if (q < 10) {
                        list.get(q).add(r);
                    } else if (r.length() == 1) {
                        list.get(9).add(r);
                    } else {
                        String[] s = r.split("");
                        list.get(9).add(s[0]);
                        for (int i3 = 1; i3 < s.length; i3++) {
                            list.get(0).add(s[i3]);
                        }
                    }
                }
            }
            int ind = 10;
            while (list.get(0).size() > 1) {
                ind--;
                for (String s : list.get(ind)) {
                    list.get(0).remove(s);
                }
            }
            for (int i2 = 9; i2 > 1; i2--) {
                for (String s : list.get(i2 - 1)) {
                    list.get(i2).remove(s);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < 10; i2++) {
                sb.append(getString(list.get(i2)));
            }
            System.out.println("Case #" + i + ": " + sb.toString());
        }
        in.close();
    }

    private static String getString(HashSet<String> set) {
        for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
            return it.next();
        }
        return null;
    }
}
