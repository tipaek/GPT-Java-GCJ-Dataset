import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
  
public class Solution
{ 
    public static void main(String[] args) throws IOException 
    { 
  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 
        int i,j;
        for(i=1;i<=t;i++)
        {
            String s = br.readLine();
            int n = s.length();
            String res = "";
            int d=0,newd=0;
            for(j=0;j<n;j++)
            {
                int c = s.charAt(j);
                int num = c-48;
                newd = num;
                while(d < newd)
                {
                    res = res+'(';
                    d++;
                }
                while(d>newd)
                {
                res = res+')';
                d++;
                }
                res = res+(char)c;
            }
            while(d>0)
            {
            res = res+')';
            d--;
            }
            System.out.println("Case #"+i+": "+res);
        }
    }
}    
                
                
                
                
            
                
                
                
                
                
            