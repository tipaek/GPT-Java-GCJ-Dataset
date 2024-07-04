import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution n = new Solution();
        n.start();
    }

    private void start() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            String s = in.nextLine();
            String val = findSolution(s);
            String answer = "Case #" + i + ": " + val;
            System.out.println(answer);
        }
    }

    String findSolution(String s) {
        s += "0";
        String answer = "";
        int last = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = Integer.parseInt(s.substring(i, i + 1));
            if (num == last) {
                answer += num;
                continue;
            }
            if (cnt < num) {
                answer += repeat("(", num - cnt) + num;
            } else {
                answer += repeat(")", cnt - num) + num;
            }
            cnt = num;
            last = num;
        }

        return answer.substring(0, answer.length() - 1);
    }

    private String repeat(String str, int count) {
        String r = "";
        for (int i = 0; i < count; i++) {
            r += str;
        }
        return r;
    }

}