
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            String pattern = sc.next();
            char[] cPattern = pattern.toCharArray();
            char prev = '0';
            StringBuilder output = new StringBuilder("");
            for(char c : cPattern){
                if(c > prev){
                    for(int j = 0; j < c-prev; j++){
                        output.append('(');
                    }
                } else if(c < prev){
                    for(int j = 0; j < prev - c; j++){
                        output.append(')');
                    }
                }
                output.append(c);
                prev = c;
            }
            for(int j = 0; j < prev-'0'; j++){
                output.append(')');
            }

            System.out.println("Case #"+ (i+1) + ": " + output.toString() );
        }
    }
}
