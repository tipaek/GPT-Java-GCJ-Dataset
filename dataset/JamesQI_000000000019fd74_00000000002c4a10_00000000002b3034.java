package round1A;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int i = 1; i <= t; ++i) {
                int c = scanner.nextInt();
                ArrayList<String> inputs = new ArrayList<>();
                for (int ii = 0; ii < c; ii++) {
                    inputs.add(scanner.next());
                }
                System.out.println("Case #" + i + ": " + getAns(inputs));
            }
        } catch (Exception e) {
        }
    }

    public static String getAns(List<String> inputs) {
        String ans = "*";
        boolean flag = true;
        int curIdx = 1;
        while (flag) {
            if (curIdx >= inputs.get(0).length()) break;
            char ch = inputs.get(0).charAt(curIdx);
            for (int i = 1; i < inputs.size(); i++) {
                if (ch != inputs.get(i).charAt(curIdx)) {
                    flag = false;
                }
            }
            ans += ch;
            curIdx++;
        }
        return ans;
    }

}
