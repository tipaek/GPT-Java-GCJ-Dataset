import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t1 = in.nextInt();
        for (int t = 1; t <= t1; t++) {
            int n = in.nextInt();
            List<List<String>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = in.next();
                List<String> tmp = new ArrayList<>(Arrays.asList(str.split("\\*")));
                if (!tmp.isEmpty()) {
                    if (str.endsWith("*")) {
                        tmp.add("");
                    }
                    list.add(tmp);
                }
            }

            System.out.println("Case #" + t + ": " + calc(list));
        }
    }

    public static String calc(List<List<String>> list) {
        String start = "";
        String end = "";
        if (list.isEmpty()) {
            return "A";
        } else {
            for (List<String> i : list) {
                String tmp = i.get(0);
                if (tmp.length() > start.length()) {
                    if (tmp.startsWith(start)) {
                        start = tmp;
                    } else {
                        return "*";
                    }
                } else if (tmp.length() <= start.length()) {
                    if (!start.startsWith(tmp)) {
                        return "*";
                    }
                }
            }

            for (List<String> i : list) {
                String tmp = i.get(i.size() - 1);
                if (tmp.length() > end.length()) {
                    if (tmp.endsWith(end)) {
                        end = tmp;
                    } else {
                        return "*";
                    }
                } else if (tmp.length() <= end.length()) {
                    if (!end.endsWith(tmp)) {
                        return "*";
                    }
                }
            }

            int max = 0;
            for (int i = 0; i < list.size(); i++) {
                if (max < list.get(i).size()) {
                    max = list.get(i).size();
                }
            }

            StringBuilder mid = new StringBuilder();
            for (int i = 1; i < max - 1; i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (i < list.get(j).size() - 1) {
                        mid.append(list.get(j).get(i));
                    }
                }
            }
            return start + mid + end;
        }
    }
}