import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();
        for (int i = 1; i <= numTests; i++) {
            int numWord = sc.nextInt();
            sc.nextLine();
            String[] arr = new String[numWord];
            for (int j = 0; j < numWord; j++) {
                arr[j] = sc.nextLine();
            }
            List<Character> start = new ArrayList<>();
            List<Character> end = new ArrayList<>();
            if (foo(numWord, arr, start, end)) {
                String ret = "";
                for (int k = 0; k < start.size(); k++) {
                    if (start.get(k) != '*') {
                        ret += start.get(k);
                    }
                }
                for (int k = end.size() - 1; k >= 0; k--) {
                    if (end.get(k) != '*') {
                        ret += end.get(k);
                    }
                }
                System.out.println("Case #" + i + ": " + ret);
            } else {
                System.out.println("Case #" + i + ": *");
            }
        }
    }

    public static boolean foo(int num, String[] arr, List<Character> start, List<Character> end) {
        char curStartChar = '*';
        char curEndChar = '*';
        int[] beginIdx = new int[num];
        int[] endIdx = new int[num];
        int maxLength = 0;
        for (int i = 0; i < num; i++) {
            String curStr = arr[i];
            beginIdx[i] = 0;
            endIdx[i] = curStr.length() - 1;
            if (curStr.length() > maxLength) {
                maxLength = curStr.length();
            }
            if (curStr.charAt(0) != curStartChar) {
                if (curStartChar == '*') {
                    curStartChar = curStr.charAt(0);
                    beginIdx[i] = 1;
                } else if (curStr.charAt(0) != '*') {
                    return false;
                }
            } else {
                if (curStartChar != '*') {
                    beginIdx[i] = 1;
                }
            }

            if (curStr.charAt(curStr.length() - 1) != curEndChar) {
                if (curEndChar == '*') {
                    curEndChar = curStr.charAt(curStr.length() - 1);
                    endIdx[i] = endIdx[i] - 1;
                } else if (curStr.charAt(curStr.length() - 1) != '*'){
                    return false;
                }
            } else {
                if (curEndChar != '*') {
                    endIdx[i] = endIdx[i] - 1;
                }
            }
            arr[i] = arr[i].substring(beginIdx[i], endIdx[i] + 1);
        }
        if (maxLength == 1) {
            return true;
        }
        start.add(curStartChar);
        end.add(curEndChar);
        return foo(num, arr, start, end);
    }
}
