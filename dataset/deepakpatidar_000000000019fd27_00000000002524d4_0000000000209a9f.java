/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
	import java.util.*;
import java.math.*;

public class Main
{
	public static void main(String[] args) {
	
    Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int a=0;a<t;a++)
        {   int flag=0;
        String ans="";
            String str=sc.next();
            char ch[]=str.toCharArray();
            for(int j=0;j<ch.length;j++)
            {
                if(flag==0)
                {
                    if(ch[j]=='0')
                    {
                        ans=ans+'0';
                    }
                    else
                    {
                        ans=ans+'('+'1';
                        flag=1;
                    }
                }
                else
                {
                    if(ch[j]=='0')
                    {
                        ans=ans+')'+'0';
                        flag=0;
                    }
                    else
                    {
                        ans=ans+'1';
                    }
                }
            }
            if(ch[ch.length-1]=='1')
            {
                ans=ans+')';
            }
            System.out.println(ans);
        }

}
}

