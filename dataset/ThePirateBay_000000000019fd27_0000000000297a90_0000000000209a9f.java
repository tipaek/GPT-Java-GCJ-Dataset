import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

class Solution{
    
    public static void main(String[] args) throws NumberFormatException, IOExpection{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tt = 0;tt <t ; tt++){
            String s = br.readLine();
            int n = s.length();
            int braq= 0;
            StringBuilder sb = new StringBuilder();
            for(int i =0; i<n; i++){
                int val = s.charAt(i)-48;
                if(val==braq)
                {
                    sb.append(s.charAt(i));
                }
                else if(val>braq)
                {
                    int diff = val-braq;
                    sb.append(generateOpenBraces(diff)).append(s.charAt(i));
                    braq = braq+diff;
                }
                else
                {
                    int diff = braq-val;
                    sb.append(generateCloseBraces(diff)).append(s.charAt(i));
                    braq=braq-diff;
                }
            }
            if(braq > 0){
                sb.append(generateCloseBraces(braq));
            }
            System.out.println(sb.toString());
        }
        System.exit(0);
    }
    
      public static String generateOpenBraces(int n)
    {
         return String.join("", Collections.nCopies(n, "("));
    }
    public static String generateCloseBraces(int n)
    {
         return String.join("", Collections.nCopies(n, ")"));
    }
}


