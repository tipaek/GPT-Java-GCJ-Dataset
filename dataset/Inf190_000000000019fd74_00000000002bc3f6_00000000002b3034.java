import java.io.*;
import java.util.*;

class Solution{
    private static boolean isSubstring(String s1, String s2) {
        int M = s1.length();
        int N = s2.length();
        for (int i = 0; i <= N - M; i++) {
            int j;

            for (j = 0; j < M; j++)
                if (s2.charAt(i + j) != s1.charAt(j))
                    break;
            if (j == M)
                return true;
        }

        return false;
    }

    private static String getMaxVal(String[] arr) {
        int n = arr.length, maxLen = 0;
        List<String> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (arr[maxLen].length() < arr[i].length()) {
                list.clear();
                list.add(arr[i]);
                maxLen = i;
            }
            if (arr[maxLen].length() == arr[i].length())
                list.add(arr[i]);
        }

        for (String str : list) {
            int flag = 0;
            for (int i = 0; i < n; i++) {
                if (!isSubstring(arr[i], str))
                    flag = 1;
            }
            if (flag == 0)
                return str;
        }
        return "*";
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tItr = 1; tItr <= t; tItr++) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] arr = new String[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextLine().substring(1);

            System.out.println("Case #" + tItr + ": " + getMaxVal(arr));
        }
        sc.close();
    }
}