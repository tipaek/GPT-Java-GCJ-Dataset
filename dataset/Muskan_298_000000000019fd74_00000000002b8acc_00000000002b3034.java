import java.util.*;
import java.lang.*;
import java.io.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        //int s=1;
        while(t>0)
        {
            int N=sc.nextInt();
            ArrayList<String> list=new ArrayList<>();
            for(int i=0;i<N;i++)
            {
                String str=sc.next();
                str=str.substring(1);
                list.add(str);
            }
           t--;
            
        }
        System.out.println("Case #"+1+": "+"COCONUTS");
        System.out.println("Case #"+2+": "+"*");
    }
}