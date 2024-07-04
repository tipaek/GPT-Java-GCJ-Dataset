import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    static ArrayList<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int caseNum = input.nextInt();
        String[][] answer = new String[caseNum][2];

        for (int n = 0; n < caseNum; n++) {
            String N = input.next();
            answer[n][0] = Integer.toString(n);
            answer[n][1] = brack(N);
            ans.clear();
        }

        for (int n = 0; n < caseNum; n++) {
            System.out.println("Case #" + (Integer.parseInt(answer[n][0]) + 1) + ": " + answer[n][1]);
        }
    }

    public static String brack(String n) {
        int br = 0;

        for (int i = 0; i < n.length(); i++) {
            char currentChar = n.charAt(i);
            int currentNum = Character.getNumericValue(currentChar);

            if (br > currentNum) {
                close(br - currentNum);
            } else if (br < currentNum) {
                open(currentNum - br);
            }
            br = currentNum;
            ans.add(String.valueOf(currentChar));
        }
        close(br);
        return String.join("", ans);
    }

    public static void open(int t) {
        for (int i = 0; i < t; i++) {
            ans.add("(");
        }
    }

    public static void close(int t) {
        for (int i = 0; i < t; i++) {
            ans.add(")");
        }
    }
}