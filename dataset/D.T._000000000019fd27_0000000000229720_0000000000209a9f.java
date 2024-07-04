import java.util.Scanner;

public class Solution {

    public static void solve(int ks, String s) {
        int[] original = new int[s.length()];
        int len = s.length();
        int total = 0;
        for (int i = 0; i < len; i++) {
            original[i] = Integer.parseInt(s.substring(i, i + 1));
            total = total + original[i];
        }

        char[] whole = new char[total * 2 + len];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < original[i]; j++) {
                whole[idx] = '(';
                idx++;
            }
            whole[idx] = (char)(original[i] + '0');
            idx++;
            for (int j = 0; j < original[i]; j++) {
                whole[idx] = ')';
                idx++;
            }
        }

        // reduce
        boolean reduce = true;
        while (whole.length > 0 && reduce) {
            reduce = false;
            for (int i = 0; i < whole.length - 1; i++) {
                if (whole[i] == ')' && whole[i + 1] == '(') {
                    whole[i] = '-';
                    whole[i + 1] = '-';
                    reduce = true;
                }
            }
            whole = new String(whole).replaceAll("-","").toCharArray();
        }

        System.out.println("Case #" + ks + ": " + new String(whole));
    }


    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            String s = input.next();
            solve(ks, s);
        }
    }
}
