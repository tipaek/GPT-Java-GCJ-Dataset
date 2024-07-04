/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Solution
{
	public static void main(String[] args) {
		//System.out.println("Hello World");
		Scanner s = new Scanner(System.in);
		int t=s.nextInt();
		for(int x=0;x<t;x++)
		{
		    String str=s.next();
		    int len=str.length();
		    int count=0;
		    System.out.print("Case #"+(x+1)+": ");
		    for(int i=0;i<len;i++)
		    {
		        int num=((int)str.charAt(i))-48;
		        //System.out.println(num);
		        if(num==count)
		            System.out.print(num);
		        else if(num>count)
		        {
		            for(int j=count;j<num;j++)
		                System.out.print("(");
		            System.out.print(num);
		        }
		        else if(num<count)
		        {
		            for(int j=0;j<(count-num);j++)
		                System.out.print(")");
		            System.out.print(num);
		        }
		        count=num;
		    }
		    while(count>0){
		        System.out.print(")");
		        count--;
		    }
		    System.out.println();
		}
	}
}