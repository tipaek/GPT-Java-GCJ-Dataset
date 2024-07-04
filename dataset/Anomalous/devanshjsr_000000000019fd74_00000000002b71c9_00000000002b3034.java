import java.util.*;

public class Solution {
    
    static void sort(String[] s, int n) {
        for (int i = 1; i < n; i++) {
            String temp = s[i];
            int j = i - 1;
            while (j >= 0 && temp.length() < s[j].length()) {
                s[j + 1] = s[j];
                j--;
            }
            s[j + 1] = temp;
        }
    }
    
    public static String docat(String f, String s) {
        if (!f.contains(s.substring(0, 1))) {
            return f + s;
        }
        int idx = s.length();
        try {
            while (!f.endsWith(s.substring(0, idx--)));
        } catch (Exception e) {
            // Do nothing
        }
        return f + s.substring(idx + 1);
    }
    
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        int st = 1;
        
        while (t > 0) {
            int n = sc.nextInt();
            String[] a = new String[n];
            String[] b = new String[n];
            
            int k = 0;
            
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                
                if (s.charAt(0) == '*') {
                    a[i] = "";
                    b[i] = s.substring(1);
                } else {
                    String[] sa = s.split("\\*", 2);
                    a[i] = sa[0];
                    b[i] = sa[1];
                    k = 1;
                }
            }
            
            sort(a, n);
            sort(b, n);
            
            if (k == 0) {
                boolean g = true;
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < b[i].length(); j++) {
                        if (b[i].charAt(b[i].length() - 1 - j) != b[n - 1].charAt(b[n - 1].length() - 1 - j)) {
                            g = false;
                            break;
                        }
                    }
                    if (!g) break;
                }
                
                if (!g) {
                    System.out.println("Case #" + st + ": *");
                } else {
                    System.out.println("Case #" + st + ": " + b[n - 1]);
                }
                
                t--;
                st++;
                continue;
            }
            
            boolean f = true;
            
            for (int i = 0; i < n - 1; i++) {
                if (!a[n - 1].contains(a[i])) {
                    f = false;
                    break;
                }
            }
            
            for (int i = 0; i < n - 1; i++) {
                if (!b[n - 1].contains(b[i])) {
                    f = false;
                    break;
                }
            }
            
            if (!f) {
                System.out.println("Case #" + st + ": *");
            } else {
                System.out.println("Case #" + st + ": " + docat(a[n - 1], b[n - 1]));
            }
            
            st++;
            t--;
        }
    }
}