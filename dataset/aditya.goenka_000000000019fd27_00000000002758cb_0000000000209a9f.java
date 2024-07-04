import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int q = 1; q <= t; ++q) {

            String text = in.nextLine();
            int num[] = new int[text.length()];
            for(int i=0; i<text.length(); i++) {
                num[i] = Character.getNumericValue(text.charAt(i));
            }
            String res = "";
            for(int i=0; i<num[0]; i++) {
                res += "(";
            }

            res += num[0];
            for(int i=1; i<num.length; i++) {
                if(num[i] == num[i-1]) {
                }
                else if(num[i] < num[i-1]) {
                    for(int j=(num[i-1] - num[i]); j>0; j--) {
                        res += ")";
                    }
                }
                else {
                    for(int j=(num[i] - num[i-1]); j>0; j--) {
                        res += "(";
                    }
                }
                res += num[i];
            }

            for(int i=num[num.length-1]; i>0; i--) {
                res += ")";
            }

            System.out.println("Case #" + q + ": " + res);
        }
    }
}