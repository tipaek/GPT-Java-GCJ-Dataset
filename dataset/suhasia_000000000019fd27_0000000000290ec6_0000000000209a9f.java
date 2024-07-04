import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();

        for(int x = 0; x < t; x++){
            int n = in.nextInt();
            int[] digits = new int[String.valueOf(n).length()];
            for(int i = digits.length-1; i >= 0; i--){
                digits[i] = n%10;
                n = n/10;
            }
            String ans = "";
            if(digits[0]==1) ans += "(";
            ans+=digits[0];
            for(int i = 1; i < digits.length; i++){
                if(digits[i-1]==1 && digits[i]==0)
                    ans+=")";
                if(digits[i-1]==0 && digits[i]==1)
                    ans+="(";
                ans+=digits[i];
            }
            if(digits[digits.length-1]==1) ans += ")";

            System.out.println(ans);
        }

    }
}