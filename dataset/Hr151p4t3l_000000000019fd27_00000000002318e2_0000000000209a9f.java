import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int T = 0;
        if(input.hasNextInt())
            T = input.nextInt();
            
        for(int i = 0; i < T; i++) {
            String S = "";
            String O = "";
            
            if(input.hasNext())
                S = input.next();
            
            char[] arrS = S.toCharArray();
            int len = arrS.length;
            
            int nPrev = 10;
            
            for(int j = 0; j < len; j++) {
                if(Character.isDigit(arrS[j])) {
                    int n = Integer.parseInt(String.valueOf(arrS[j]));
                    if(nPrev == n) {
                        O += Character.forDigit(n, 10);
                        continue;
                    }
                    else if(j > 0) {
                        for(int k = nPrev; k > 0; k--) {
                            O += ")";
                        }
                    }
                    for(int k = n; k > 0; k--) {
                        O += "(";
                    }
                    O += Character.forDigit(n, 10);
                    nPrev = n;
                }
            }
            for(int k = nPrev; k > 0; k--) {
                O += ")";
            }
            System.out.println(O);
        }
    }
}