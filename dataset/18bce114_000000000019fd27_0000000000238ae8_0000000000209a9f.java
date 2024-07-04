import java.util.*;
import java.lang.*; 
public class Solution{

     public static void main(String []args){
        Scanner in=new Scanner(System.in);
        int t;
        String s;
        t=in.nextInt();
        in.nextLine();
        for(int i=0;i<t;i++)
        {
            s=in.nextLine();
            char ch[]=s.toCharArray();
            char ch1[]=new char[300];
            int c=0;
            for(int j=0;j<s.length();j++)
            {
                if(s.charAt(j)=='0')
                {
                    if(ch1[c]==')')
                    {
                        c++;
                    }
                    ch1[c]='0';
                    c++;
                }
                if(s.charAt(j)=='1')
                {
                    ch1[c]='(';
                    c++;
                    ch1[c]='1';
                    c++;
                    int mark=j+1;
                    while(mark<s.length()&&s.charAt(mark)=='1')
                    {
                        ch1[c]='1';
                        c++;
                        mark++;
                        j++;
                    }
                    ch1[c]=')';
                   // System.out.println("ch1["+c+"]="+ch1[c]);
                }
            }
            System.out.print("Case #"+(i+1)+": ");
            for(int j=0;j<=c;j++)
            {
                System.out.print(ch1[j]);
            }
            System.out.println();
        }
    }
} 