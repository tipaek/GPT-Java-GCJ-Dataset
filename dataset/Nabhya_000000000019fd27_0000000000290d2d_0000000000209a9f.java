import java.util.*;
import java.util.Scanner;

public class Solution {
    public static void main(String [] args)
    {
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        String result[]=new String[t];
        for(int i=0;i<t;i++)
        {
            String s = sc.nextLine();
            for(int j=0;j<s.length();j++)
            {
                result[i]="";
            }
            for(int j=0;j<s.length();j++)
            {
                int x= Integer.parseInt(String.valueOf(s.charAt(j)));
                int y;
                if(j+2>s.length())
                    y= 0;
                else
                    y=Integer.parseInt(String.valueOf(s.charAt(j+1)));;
                for(int k=0;k<x;k++)
                {
                    result[i]+="(";
                }
                result[i]+=x;
                for(int k=0;k<x-y;k++)
                {
                    result[i]+=")";
                }
            }
        }
        for(int i=0;i<t;i++)
        {
            System.out.println(result[i]);
        }
    }

}
