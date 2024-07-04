
import java.io.*;
import java.util.Scanner;

class Solution {
    public static void main(String args[])
    {int c,t,o=0;
        Scanner s=new Scanner(System.in);
        int T=s.nextInt();
        for(int i=0;i<T;i++)
        {
            String s1=s.nextLine();
            String s2="";
            for(int j=0;j<s1.length();j++)
            {
                c=Integer.parseInt(Character.toString(s1.charAt(j)));
                t=c;
                if(o<t)
                {
                    while(o<t)
                    {
                        s2+="(";
                        o++;
                 }
                }
                else if(o>t)
                {
                    while(o>t)
                    {
                        s2+=")";
                        o--;
                    }
                }
                s2+=c;
            }
            while(o!=0)
                    {
                        s2+=")";
                        o--;
                    }
            System.out.println("case #"+(i+1)+": "+s2);
        }
    }
}
