import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Solution {

    private static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws FileNotFoundException {
        //in = new Scanner(NestingDepth.class.getResourceAsStream("file.in"));
        int T = Integer.parseInt(in.nextLine());
        
        for (int t = 1; t <= T; t++) {
            String S = in.nextLine();
            
            int n = Integer.parseInt(S.charAt(0) + "");
            String S1 = repeat("(", n) + n;
            
            for(int i=1; i< S.length(); i++){
                int c = Integer.parseInt(S.charAt(i) + "");
                if(n > c){
                    S1 += repeat(")", n-c) + c;
                    n = c;
                }else if(n < c){
                    S1 += repeat("(", c-n) + c;
                    n = c;
                }else{
                    S1 += c;
                }
            }
            n = Integer.parseInt(S.charAt(S.length()-1) + "");
            S1 += repeat(")", n);

            System.out.println("Case #" + t + ": " + S1);
        }
    }
    
    private static String repeat(String s, int c){
        String r = "";
        for(int i=0; i< c; i++){
            r += s;
        }
        return r;
    }

}
