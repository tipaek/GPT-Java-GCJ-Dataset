import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int times = scanner.nextInt();
        for (int t = 1; t <= times; t++) {
            int n = scanner.nextInt();
            List<List<Integer>> list = new ArrayList<>();
            boolean valid = true;
            for (int i = 0; i < n; i++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(scanner.nextInt());
                temp.add(scanner.nextInt());
                list.add(temp);
            }
            Collections.sort(list, Comparator.comparing(o -> o.get(1)));

            int C_end = 0, J_end = 0;
            for (int i = 0; i < list.size(); i++) {
                if (C_end >= J_end) {
                    if (C_end <= list.get(i).get(1)) {
                        C_end = list.get(i).get(2);
                        list.get(i).add(0);
                    } else if (J_end <= list.get(i).get(1)) {
                        J_end = list.get(i).get(2);
                        list.get(i).add(1);
                    } else {
                        valid = false;
                        break;
                    }
                } else {
                    if (J_end <= list.get(i).get(1)) {
                        J_end = list.get(i).get(2);
                        list.get(i).add(1);
                    } else if (C_end <= list.get(i).get(1)) {
                        C_end = list.get(i).get(2);
                        list.get(i).add(0);
                    } else {
                        valid = false;
                        break;
                    }
                }
            }

            String ans;
            if (valid) {
                StringBuffer sb = new StringBuffer();
                Collections.sort(list, Comparator.comparing(o -> o.get(0)));
                for (List<Integer> l: list) {
                    if (l.get(3) == 0) {
                        sb.append("C");
                    } else if (l.get(3) == 1) {
                        sb.append("J");
                    }
                }
                ans = sb.toString();
            } else {
                ans = "IMPOSSIBLE";
            }

            System.out.println(String.format("Case #%d: %s", t, ans));
        }
    }

}