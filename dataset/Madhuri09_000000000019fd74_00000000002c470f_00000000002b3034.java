import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static String makestr(String str) {
        String s = "";
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) != '*') {
                s += str.charAt(j);
            }
        }
        return s;
    }
    
    public static int countlen(String str) {
        int c = 0;
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) != '*') {
                c++;
            }
        }
        return c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            String s[] = new String[n];
            for (int j = 0; j < n; j++) {
                s[j] = br.readLine();
            }
            String str = makestr(s[0]);
            int flag = 0;
            for (int j = 1; j < n; j++) {
                int slen = str.length();
                int plen = countlen(s[j]);
                if (plen > slen) {
                    str = makestr(s[j]);
                    flag = 0;
                    int l = str.length() - 1;
                    for (int k = s[j - 1].length() - 1; k > 0; k--) {
                        if (s[j - 1].charAt(k) != str.charAt(l)) {
                            flag = 1;
                            break;
                        }
                        l--;
                    }
                    if (flag == 1) {
                        break;
                    } 
                } else {
                    int l = str.length() - 1;
                    for (int k = s[j].length() - 1; k > 0; k--) {
                        if (s[j].charAt(k) != str.charAt(l)) {
                            flag = 1;
                            break;
                        }
                        l--;
                    }
                    if (flag == 1) {
                        break;
                    } 
                }
            }
            bw.write("Case #" + i + ": ");
            if (flag == 1) {
                bw.write("" + "*\n");
            } else {
                bw.write("" + str + "\n");
            }
        }
        bw.flush();
    }
}