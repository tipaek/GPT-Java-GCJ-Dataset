import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static int caseNum = 0;

    public static void main(String[] arg) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for(int i=0; i < t; i++) {
            String s = in.next() + "0";
            solve(s);
        }
    }

    private static void solve(String s) {
        caseNum++;
        String ans = s;
        int[] depth = new int[s.length()];
        int[] possible = new int[s.length()];
        Pair[] brackets = new Pair[s.length()];
        for(int i=0;i<brackets.length;i++){
            brackets[i] = new Pair(0,0);
        }

        for(int i=0;i<ans.length();i++) {
            int amount = s.charAt(i)-48 - depth[i];
            if(amount == 0)
                continue;

//            ans = insert(ans, getString('(', amount), i);
            brackets[i].left += amount;
            possible[i] = amount;

            int min = amount;

            int j = i + 1;
            while(s.charAt(j)-48 - depth[j] > 0) {
                if(s.charAt(j)-48 - depth[j] < min)
                    min = s.charAt(j)-48 - depth[j];
                possible[j] = min;
                j++;
            }

            int added = 0;
            for(int k = j - 1; k>=i; k--) {
                if(possible[k] - added > 0) {
//                    insert(ans, getString(')',possible[k] - added),k + 1);
                    brackets[k].right += possible[k] - added;
                    added += possible[k] - added;
                }
                depth[k] += added;
            }
        }

        ans = ans.substring(0, ans.length() - 1);

        System.out.println("Case #" + caseNum +": " + formatPrint(ans, brackets));
    }

    private static String formatPrint(String ans, Pair[] brackets) {
        String result = "";
        for(int i=0;i<ans.length();i++) {
            result += getString('(',brackets[i].left) + ans.charAt(i) + getString(')',brackets[i].right);
        }
        return result;
    }

    private static String getString(char c, int amount) {
        String s = "";
        for(int i=0;i<amount;i++) {
            s += c;
        }

        return s;
    }

    private static String insert(String original, String in, int position) {
        return original.substring(0,position) + in +original.substring(position,original.length());
    }

    public static class Pair {
        public int left;
        public int right;
        public Pair(int x, int y) {
            this.left = x;
            this.right = y;
        }
    }
}
