import java.util.*;
import java.lang.*;
import java.io.*;
class Solution
 {
	public static void main (String[] args)
	 {
	    Scanner sc=new Scanner(System.in);
	    int test=sc.nextInt();
        sc.nextLine();
	    for(int x=0;x<test;x++)
	    {
            String str=sc.nextLine();
            int o=0,c=0;
            String ans="";
            for(int i=0;i<str.length();i++)
            {                
                int k=Integer.valueOf(str.charAt(i)-'0');
            //    System.out.println(k);
                if(k>o)
                {
                    
                    while(o<k)
                    {
                //        System.out.println(o+" "+k);
                        ans=ans+'(';
             //           System.out.println(ans);
                        o++;
                    }
                }
                else if(k<o)
               {     while(k<o)
                    {
                        ans=ans+')';
                   o--;
                    }
               }
                ans=ans+str.charAt(i);
            }
            while(o>0){
                ans=ans+')';
                o--;
                }
            System.out.println("Case #"+(x+1)+": "+ans);
	    
	    }
	 }
}