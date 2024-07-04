import java.io.*;
import java.util.*;

class Solution{
    private static boolean isSubstring(String s1, String s2) {
        int m = s1.length() - 1;
        int n = s2.length() - 1;
        for (int i = m, j = n; i >= 0; i--, j--) {
            if (s1.charAt(i) != s2.charAt(j))
                return false;
        }

        return true;
    }

    private static String getMaxVal(String[] arr) {
        int n = arr.length, maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (arr[maxIndex].length() < arr[i].length())
                maxIndex = i;
        }

        int flag = 0;
        for (int i = 0; i < n; i++) {
            if (!isSubstring(arr[i], arr[maxIndex]))
                flag = 1;
        }

        if (flag == 0)
            return arr[maxIndex];

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