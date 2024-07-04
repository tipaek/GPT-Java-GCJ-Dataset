import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 1; i <= T; i++) {
            char[] arr = in.next().toCharArray();
            StringBuilder sb = computeNewString(arr, '0');
            System.out.printf("Case #%d: %s\n", i, sb);
        }
    }

    public static StringBuilder computeNewString(char[] arr, char level) {
        StringBuilder result = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == level) {
                if(tmp.length() > 0) {
                    if(tmp.length() == 1) {
                        int diff = tmp.toString().toCharArray()[0] - level;
                        for(int j = 0; j < diff; j++) result.append("(");
                        result.append(tmp);
                        for(int j = 0; j < diff; j++) result.append(")");
                    } else {
                        result.append("(");
                        result.append(computeNewString(tmp.toString().toCharArray(), (char)(level + 1)));
                        result.append(")");
                    }
                    tmp = new StringBuilder();
                }
                result.append(arr[i]);
            } else {
                tmp.append(arr[i]);
            }
        }
        if(tmp.length() > 0) {
            result.append("(");
            result.append(computeNewString(tmp.toString().toCharArray(), (char)(level + 1)));
            result.append(")");
            tmp = new StringBuilder();
        }
        return result;
    }
}
