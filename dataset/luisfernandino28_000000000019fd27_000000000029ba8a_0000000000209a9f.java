

import java.io.*;
import java.util.*;

public class Solution {

    public static StringBuilder res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();
        sc.nextLine();
        for (int k = 1; k <= T; k++) {
            res=new StringBuilder();
            String s= sc.nextLine();
            char[] digits= s.toCharArray();
            int cont1=0;
            for (int i = 0; i < s.length(); i++) {
                if(digits[i]=='0'){
                    if(cont1>0) {
                        addParenthesis(cont1);
                        cont1 = 0;
                    }
                    res.append('0');
                }else {
                    cont1++;
                }
            }
            if(cont1>0) {
                addParenthesis(cont1);

            }
            System.out.println("Case #"+ k + ": " +res );
        }
    }

    public static void addParenthesis(int n){
        for (int i = 0; i < n; i++) {
            res.append('(');
        }
        for (int i = 0; i < n; i++) {
            res.append('1');
        }
        for (int i = 0; i < n; i++) {
            res.append(')');
        }
    }
}
