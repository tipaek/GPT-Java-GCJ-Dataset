import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<t; i++) {
            String s = sc.nextLine();
            int op = 0;
            String res = "";
            for(int j=0; j < s.length(); j++) {
                int cur = Character.getNumericValue(s.charAt(j));
                if(op > cur) 
                    for(int k=0; k < (op-cur); k++) {
                        res += ')';
                    }
                else {
                    for(int k=op; k < cur; k++) {
                        res += '(';
                    }
                }
                op = cur;
                res += cur;
            }
            for(int j=0; j<op; j++) res += ')';
            System.out.println("Case #" + (i+1) + ": " + res);
        }   
    }
}