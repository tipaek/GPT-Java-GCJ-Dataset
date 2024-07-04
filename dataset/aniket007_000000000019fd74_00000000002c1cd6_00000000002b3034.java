import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner (System.in);
        int t=sc.nextInt();
        
        for(int y=1;y<=t;y++)
        {
            int n=sc.nextInt();
            String s10=sc.nextLine();
            String s[]=new String[n];int max=0,p=0;
            for(int i=0;i<n;i++)
            {
                s[i]=sc.nextLine();
                if(max<s[i].length())
                {
                    max=s[i].length();
                    p=i;
                }
            }
            String st="";
            for(int i=0;i<max;i++)
            {
                if(s[p].charAt(i)!='*')
                st=st+s[p].charAt(i);
            }int l=st.length()-1;
            outer:
            {
            for(int i=0;i<n;i++)
            {
                for(int j=s[i].length()-1;j>=0;j--)
                {
                    if(s[i].charAt(j)!='*')
                    {
                        if(st.charAt(l)!=s[i].charAt(j))
                        {System.out.println("Case #"+y+": *");
                         break outer;
                        }
                        l--;
                        
                        
                    }
                    
                }l=st.length()-1;
            }
            
            System.out.println("Case #"+y+": "+st);
            }
            
        }
    }
}