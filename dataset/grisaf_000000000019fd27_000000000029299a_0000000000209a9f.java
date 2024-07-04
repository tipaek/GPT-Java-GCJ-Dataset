import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            String s = sc.next();
            List<String> l = new LinkedList<>();
            List<Integer> v = new LinkedList<>();
            String base = "";
            int val = -1;
            for (char c : s.toCharArray()) {
                if (base.length() == 0) {
                    base = c + "";
                    val = c - '0';
                } else if (base.charAt(base.length() - 1) == c) {
                    base = base + c;
                } else {
                    l.add(base);
                    v.add(val);
                    base = c + "";
                    val = c - '0';
                }
            }
            if (base.length() != 0) {
                l.add(base);
                v.add(val);
            }
            for (int i = 9; i > 0; i--) {
                for (int j = 0; j < l.size(); j++) {
                    if (v.get(j) == i) {
                        l.set(j, "(" + l.get(j) + ")");
                        v.set(j, v.get(j) - 1);
                    }
                }
                int size = l.size();
                for (int j = 0; j < size - 1; j++) {
                    if (v.get(j) == v.get(j + 1)) {
                        l.set(j, l.get(j) + l.get(j + 1));
                        l.remove(j + 1);
                        v.remove(j + 1);
                        size--;
                        j--;
                    }
                }
            }
            String res = String.join("", l);
            System.out.println("Case #" + t + ": " + res);
        }
    }
}
