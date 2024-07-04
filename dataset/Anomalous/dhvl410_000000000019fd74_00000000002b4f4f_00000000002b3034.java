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
            
            String m = "";
            for (int i = 1; i < n; i++) {
                m = match(a[i - 1], a[i]);
            }
            
            t--;
        }
        
        sc.close();
    }

    static String match(String a, String b) {
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        int textLength = s1.length;
        int patternLength = s2.length;

        if (patternLength > textLength) {
            return "-1";
        }

        for (int c = 0; c <= textLength - patternLength; c++) {
            int position = c;
            int d;
            
            for (d = 0; d < patternLength; d++) {
                if (s2[d] != s1[position + d]) {
                    break;
                }
            }
            
            if (d == patternLength) {
                return Integer.toString(position);
            }
        }

        return "-1";
    }
}