import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    
    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine()); 
        try {
            for (int ks = 1; ks <= T; ks++) {
                int N = in.nextInt();
                String[] tab = new String[N];
                for (int i = 0; i < N; i++) {
                    tab[i] = in.next();
                }
                resolve(ks, tab);
            }

        } catch (NegativeArraySizeException ex) {
            System.out.println("ex: " + ex);
        }

    }
    
    public static void resolve(int ks, String[] tab)
    {
        String result="*";
        
        String resultTemp =tab[0].replace("*", "");
        
        for(int i = 1; i <tab.length;i++)
        {
            String chaineTemp = tab[i].replace("*", "");
            
            if(chaineTemp.contains(resultTemp))
            {
                resultTemp = chaineTemp;
            }
            else if(resultTemp.contains(chaineTemp))
            {
                
            }
            else
            {
                result = "*";
                break;
            }
            result = resultTemp;
            
        }
        
        System.out.println("Case #" + ks + ": " + result);
    }
}
