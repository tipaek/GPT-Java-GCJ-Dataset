import java.util.*;
import java.io.*;
class Solution
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine());
        for(int g=1;g<=tc;g++)
        {
            String n=br.readLine();
            String b="";
            
            int p,q=0;
            for(int i=0;i<n.length()-1;i++)
            {
                b+=n.charAt(i);
                p=Integer.parseInt(Character.toString(n.charAt(i)));
                q=Integer.parseInt(Character.toString(n.charAt(i+1)));
                if(p-q>0)
                {
                    for(int j=1;j<=p-q;j++)
                    b+=")";
                }
                if(p-q<0)
                {
                     for(int j=1;j<=Math.abs(p-q);j++)
                    b+="(";
                }
            }
            b+=n.charAt(n.length()-1);
            p=Integer.parseInt(Character.toString(b.charAt(0)));
            q=Integer.parseInt(Character.toString(b.charAt(b.length()-1)));
             for(int j=1;j<=p;j++)
                    b="("+b;
            for(int j=1;j<=q;j++)
                    b+=")";
                    
            System.out.println("Case #"+g+": "+b);
        }
        
    }
}