
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
            String s="";String max="";
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
            }
                if(s.length()>=max.length())
                    max=s;
                s="";
            }
            int flag=0;
            try{
                for(int j=0;j<n;j++)
            {
                if(!Pattern.matches(p[j], max))
                {   flag=1;
                    break;}
            }}catch(Exception e)
            {System.out.println(e);}
            if(flag==0)
                System.out.println("Case #"+(i+1)+": "+max);
            else
                System.out.println("Case #"+(i+1)+": "+"*");
        }
    }
    
}
