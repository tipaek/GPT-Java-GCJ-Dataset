import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t > 0) {
            int n = sc.nextInt();
            String[] a = new String[n];
            
            for (int j = 0; j < n; j++) {
                a[j] = sc.next();
            }
            
            for (int j = 1; j < n; j++) {
                String m = match(a[j - 1], a[j]);
            }
            
            t--;
        }
    }

    static String match(String a, String b) {
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        int textLength = s1.length;
        int patternLength = s2.length;

        if (patternLength > textLength) {
            return "-1";
        }

        for (int i = 0; i <= textLength - patternLength; i++) {
            int position = i;
            int j;

            for (j = 0; j < patternLength; j++) {
                if (s2[j] != s1[position + j]) {
                    break;
                }
            }

            if (j == patternLength) {
                return Integer.toString(position);
            }
        }

        return "*";
    }
}