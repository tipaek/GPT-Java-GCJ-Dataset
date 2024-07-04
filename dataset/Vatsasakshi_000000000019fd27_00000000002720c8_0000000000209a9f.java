import java.io.*; 
import java.util.*; 
  
public class Solution { 
    public static void main(String[] args) throws IOException 
    { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 
        int tst=1;
        while(t-->0)
        {
            String str=br.readLine();
            int open=0;
            int n=str.length();
            String ans="";
            for(int i=0;i<n;i++)
            {
                int val=(int)str.charAt(i)-48;
               // System.out.println(val+" val");
                if(open<val)
                {
                    while(open<val)
                    {
                        ans+='(';
                        open++;
                    }
                }
                else if(open>val)
                {
                    while(open>val)
                    {
                        ans+=')';
                        open--;
                    }
                }
                ans+=str.charAt(i);
              //  System.out.println(ans+" ans");
            }
            while(open>0)
            {
                ans+=')';
                open--;
            }
            //System.out.println(ans);
            System.out.println("Case #"+tst+": "+ans);
            tst++;
        }
        br.close();
    } 
}
