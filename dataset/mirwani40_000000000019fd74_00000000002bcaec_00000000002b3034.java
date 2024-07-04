
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();
            String p[]=new String[n];
            for(int j=0;j<n;j++)
            {
                p[j]=sc.next();
            }
            String s="";String s1[]=new String[n];
            for(int j=0;j<n;j++)
            {
            for(int k=0;k<p[j].length();k++)
            {if(p[j].charAt(0)=='*')
                p[j]="."+p[j];
                if((p[j].charAt(k))=='*'|| p[j].charAt(k)=='.')
                { s=s+"";
                }
                else
                    s=s+p[j].charAt(k);
            }s1[j]=s;
                s="";
            }
            int flag=0;String max="";String temp="";
            try{
                for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {if(!Pattern.matches(p[j], s1[k]))
                {   flag=1; break;}
                else
                { flag=0;temp=s1[k];}}
            }
                if(flag==0)
                max=temp;
            }catch(Exception e)
            {System.out.println(e);}
            if(flag==0)
                System.out.println("Case #"+(i+1)+": "+max);
            else
                System.out.println("Case #"+(i+1)+": "+"*");
        }
    }
    
}
