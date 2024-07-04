import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        String str="", res;
        int in, digit;
        for (int i = 1; i <= t; i++) {
            res = "";
            str = "";
            while (str.length() == 0)
                str = sc.nextLine();
            in = 0;
            for(int j=0; j<str.length(); j++) {
                digit = str.charAt(j) - '0';
                while(in > digit) {
                    in--;
                    res += ")";
                }
                while ((in < digit)) {
                    in++;
                    res += "(";
                }
                res += str.charAt(j);
            }
            while(in-- > 0)
                res += ")";
            System.out.println("Case #" + i + ": " + res);
        }
    }
}