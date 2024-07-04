import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(scanner.nextLine());

        for(int a=0; a < T; a++) {
            char[] S = scanner.nextLine().toCharArray();
            String[] P = new String[S.length+1];

            int ballance = 0;

            P[0] = "(".repeat(Character.getNumericValue(S[0]));

            for(int i=1; i < S.length; i++) {
                ballance = Character.getNumericValue(S[i-1]) - Character.getNumericValue(S[i]);
                if(ballance<0) {
                    P[i] = "(".repeat(Math.abs(ballance));
                }
                else {
                    P[i] = ")".repeat(ballance);
                }
            }
            P[S.length] = ")".repeat(Character.getNumericValue(S[S.length-1]));

            StringBuilder stringBuilder = new StringBuilder();
            for(int j=0; j<S.length+P.length; j++) {
                if(j%2==0) {
                    stringBuilder.append(P[j/2]);
                }
                else {
                    stringBuilder.append(S[(j-1)/2]);
                }
            }

            System.out.println("Case #"+(a+1)+": "+stringBuilder.toString());

        }
    }
}
