import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int x = 1;x <= t;x ++) {
            String s = scanner.next();
            char[] sArray = ("0" + s + "0").toCharArray();
            String sPrime = "";
            for(int i = 1;i < sArray.length;i ++) {
                int dif = sArray[i] - sArray[i - 1];
                if(dif < 0) {
                    do {
                        sPrime += ")";
                        dif ++;
                    } while (dif < 0);
                }
                else if(dif > 0) {
                    do {
                        sPrime += "(";
                        dif --;
                    } while (dif > 0);
                }
                sPrime += sArray[i];
            }
            System.out.println("Case #" + x + ": " + sPrime.substring(0, sPrime.length() - 1));
        }
    }
}