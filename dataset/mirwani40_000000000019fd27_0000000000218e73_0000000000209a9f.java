import java.util.Scanner;

public class Solution {

   
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            String s=sc.next();String s1="";
            int para=0;
            for(int j=0;j<s.length();j++)
            {
                int n= Integer.parseInt(String.valueOf(s.charAt(j)));
                if(n>=para)
                {
                    s1=addpara(s1,n-para,n);
                }
                else
                    s1=removepara(s1,para-n,n);
                para=n;
            }
            s1=closepara(s1,para);
            System.out.println("Case #"+(i+1)+": "+s1);
        }
        
    }
    static String addpara(String s, int para,int n)
    {
        for(int i=0;i<para;i++)
        {
            s=s+"(";
        }
        s=s+n;
        return s;
    }
    static String removepara(String s,int para,int n)
    {
        int l=s.length();
        s.substring(0,l-para+1);
        for(int i=0;i<para;i++)
        {s=s+")";
        }
        s=s+n;
        return s;
    }
    static String closepara(String s, int para)
    {
        for(int i=0;i<para;i++)
            s=s+")";
        return s;
    }
    
}
