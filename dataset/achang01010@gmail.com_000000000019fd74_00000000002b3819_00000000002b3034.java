import java.util.Scanner;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cas = sc.nextInt();
        for (int i = 0; i<cas; i++) {
            int lines = sc.nextInt();
            String[] conds = new String[lines];
            for (int j = 0; j<lines; j++) {
                conds[j]=sc.next();
            }
            int maxInd = 0; 
            int max = conds[0].length();
            for (int k = 0; k<lines; k++) {
                if (conds[k].length()>max) {
                    maxInd=k;
                    max=conds[k].length();
                }
            }
            boolean b = true;
            for (String s: conds) {
                if (!conds[maxInd].contains(s.substring(1))) {
                    b=false;
                }
            }
            if (b) {
                System.out.println("Case #"+(i+1)+": "+conds[maxInd].substring(1));
            }
            else {
                System.out.println("Case #"+(i+1)+": *");
            }
        }
    }
}