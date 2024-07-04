
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = sc.nextInt();
        String[] ans = new String[cases];
        for (int z = 0; z < cases; z++) {
            String in = sc.next();

            String answer = getAns(in, 0);
            int counter = 0;
            for (int i = 0; i < answer.length(); i++) {
                if (answer.charAt(i) == '0') {
                    answer = answer.substring(0, i) + in.charAt(counter) + answer.substring(i + 1);
                    counter++;
                }
            }
            ans[z] = answer;
        }

        for (int i = 0; i < cases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + ans[i]);
        }
    }

    public static String getAns(String in, int add) {
        if (getCorrect(in)) {
            return in;
        }
        if (in.length() == 0) return in;

        char[] charArr = in.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] != '0' && charArr[i] != '(' && charArr[i] != ')') {
                charArr[i] -= add;
            }
        }
        in = String.valueOf(charArr);

        String a = "", b = "";
        for (int i = 0; i < add; i++) {
            a += "(";
            b += ")";
        }
        in = a + in + b;

        ArrayList<Integer> zeroPos = new ArrayList<Integer>();

        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '0') {
                zeroPos.add(i);
            }
        }
        zeroPos.add(0, -1);
        zeroPos.add(in.length());

        int[] toAdd = new int[zeroPos.size() - 1];
        for (int i = 0; i < zeroPos.size() - 1; i++) {
            int s = zeroPos.get(i);
            int e = zeroPos.get(i + 1);
            for (int j = 1; j < 10; j++) {
                if (in.substring(s + 1, e).contains(Integer.toString(j))) {
                    toAdd[i] = j;
                    break;
                }
            }
        }

        String[] ansStr = new String[zeroPos.size() - 1];
        ansStr[0] = getAns(in.substring(0, zeroPos.get(1)), toAdd[0]);
        for (int i = 1; i < zeroPos.size() - 1; i++) {
            int s = zeroPos.get(i);
            int e = zeroPos.get(i + 1);
            ansStr[i] = in.charAt(s) + getAns(in.substring(s + 1, e), toAdd[i]);
        }

        String ans = "";
        for (String s : ansStr) {
            ans += s;
        }

        return ans;
    }

    public static boolean getCorrect(String in) {
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) != '(' && in.charAt(i) != ')' && in.charAt(i) != '0')
                return false;
        }
        return true;
    }

}
