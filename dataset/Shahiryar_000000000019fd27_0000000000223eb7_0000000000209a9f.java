
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int l = in.nextInt();
        Integer[] inT;
        String[] chT;
        in.nextLine();
        for (int ln = 0; ln < l; ln++) {
            String S = in.nextLine();
            inT = new Integer[S.length()];
            chT = new String[S.length()];
            
            for (int i = 0; i < S.length(); i++) {
                inT[i] = Integer.parseInt(S.charAt(i) + "");
            }
            Arrays.sort(inT, Collections.reverseOrder());
            for (int i = 0; i < S.length(); i++) {
                chT[i] = inT[i] + "";
            }
            for (int i = 0; i < S.length(); i++) {
                int cur = inT[i];
                for (int j = 0; j < S.length(); j++) {
                    if (cur == inT[j] && (i != j)) {
                        inT[j] = -1;
                        chT[i] = chT[i] + chT[j];
                        chT[j] = "";}
                }
            }
            for (int i = 0; i < S.length(); i++)
            {
                int minLar = 0;
                for(int n = 0; n <S.length(); n++)
                {if(inT[n] < inT[i] ){if(inT[n] > minLar){minLar = inT[n];}}}
                for (int p = 0; p < (inT[i]-minLar); p++) 
                {
                    chT[i] = chT[i] + ")";
                }
            }
            int larI = 0, larN = 0;for(int n = 0; n < S.length(); n++){if (inT[n] > larN){larI = n;larN = inT[n];}}
            for(int p = 0; p < larN; p++){chT[larI] = "(" + chT[larI];}
            S = "";
            for (String s: chT){S = S+ s;}
            System.out.println("Case #" + (ln+1) +": "+ S);

        }

    }
}
