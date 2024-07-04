import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

class Solution
{

    public static void main(String[] args) throws NumberFormatException, IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int k = 1; k < t + 1; k++)
        {
            String s = br.readLine();
            int n = s.length();
            int cur=0;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++)
            {
                int val = s.charAt(i)-48;
                if(val==cur)
                {
                    sb.append(s.charAt(i));
                }
                else if(val>cur)
                {
                    int diff = val-cur;
                    sb.append(generateOpencures(diff)).append(s.charAt(i));
                    cur = cur+diff;
                }
                else
                {
                    int diff = cur-val;
                    sb.append(generateClosecures(diff)).append(s.charAt(i));
                    cur=cur-diff;
                }
            }

            if(cur>0) 
            {
                sb.append(generateClosecures(cur));
            }
            
            System.out.println("Case #" + k + ": " + sb.toString());

        }
        System.exit(0);
    }

    public static String generateOpencures(int n)
    {
        String res = "";
        for(int i = 0; i < n; i++) {
            res += "(";
        }
        
        return res;
    }
    public static String generateClosecures(int n)
    {
        String res = "";
        for(int i = 0; i < n; i++) {
            res += ")";
        }
        
        return res;
    }


}