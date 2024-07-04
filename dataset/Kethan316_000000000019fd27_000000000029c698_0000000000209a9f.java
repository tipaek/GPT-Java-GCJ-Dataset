import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 n = new Solution2();
        n.first();
    }

    private void first() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int x = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= x; i++) {
            String y = sc.nextLine();
            String val = findSolution(y);
            String answer = "Case #" + i + ": " + val;
            System.out.println(answer);
        }
    }

    String findSolution(String y) {
        y += "0";
        String answer = "";
        int last = 0;
        int Cnt = 0;
        for (int i = 0; i < y.length(); i++) {
            int num = Integer.parseInt(y.substring(i, i + 1));
            if (num == last) {
                answer += num;
                continue;
            }
            if (cnt < num) {
                answer += go("(", num - cnt) + num;
            } else {
                answer += go(")", cnt - num) + num;
            }
            cnt = num;
            last = num;
        }

        return answer.substring(0, answer.length() - 1);
    }

    private String go(String str, int count) {
        String z = "";
        for (int i = 0; i < count; i++) {
            z += str;
        }
        return z;
    }

}