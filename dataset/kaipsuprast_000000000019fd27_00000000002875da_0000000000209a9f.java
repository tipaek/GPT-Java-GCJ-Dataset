import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int test = Integer.parseInt(input.nextLine());

        for (int i = 0; i<test; i++){
            char lastChar = '*';
            String S = input.nextLine();
            List <String> nS = new ArrayList<>();
            for(int j = 0; j<S.length(); j++) {
                char ch = S.charAt(j);
                int n = Character.getNumericValue(ch);
                String pL = "";
                String pR = "";

                if(lastChar=='*'){
                    for(int k = 0; k<n; k++){
                        pL = pL + "(";
                    }
                    nS.add(pL);
                    nS.add(Character.toString(ch));
                }
                else if(lastChar<ch){
                    int diff = ch-lastChar;
                    for(int k = 0; k<diff; k++){
                        pL = pL + "(";
                    }
                    nS.add(pL);
                    nS.add(Character.toString(ch));
                }
                else if(lastChar==ch){
                    nS.add(Character.toString(ch));
                }
                else if(lastChar!=ch){
                    int val = Character.getNumericValue(lastChar);
                    for(int k = 0; k<val; k++){
                        pR = pR + ")";
                    }
                    nS.add(pR);
                    nS.add(Character.toString(ch));
                }
                lastChar = ch;
            }
            String pR = "";
            int val = Character.getNumericValue(lastChar);
            for(int k = 0; k<val; k++){
                pR = pR + ")";
            }
            nS.add(pR);
            String ans = String.join("", nS);
            int t = i+1;
            System.out.println("Case #" + t + ": " + ans);
        }
    }
}
