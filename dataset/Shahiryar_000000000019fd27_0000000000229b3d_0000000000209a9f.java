
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int l = in.nextInt();
        int[] inT;
        String[] chT;
        in.nextLine();
        for (int ln = 0; ln < l; ln++) {
            String S = in.nextLine();
            inT = new int[S.length()];
            chT = new String[S.length()];

            for (int i = 0; i < S.length(); i++) {
                inT[i] = Integer.parseInt(S.charAt(i) + "");
                chT[i] = S.charAt(i) + "";
            }


            for (int i = 0; i < S.length(); i++) {
                for (int p = 0; p < inT[i] && p >= 0; p++) {
                    chT[i] = "(" + chT[i] + ")";
                }
            }
            S = "";
            for (String s: chT)
            {
                S = S + s;
            }
            do{
               S = S.replace(")(", "");
            }while(S.contains(")("));
                        System.out.println("Case #" + (ln+1) +": "+ S);

        }

    }
}
