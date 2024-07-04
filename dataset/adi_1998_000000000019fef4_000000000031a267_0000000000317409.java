/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.Scanner;
class Solution
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);int t=sc.nextInt();int x,y;String s;int l;int res;char c;int r1;
		for(int t1=1;t1<=t;t1++)
		{
		    res=-1;
		    x=sc.nextInt();y=sc.nextInt();s=sc.next();l=s.length();
		    if(x==0&&y==0) {System.out.println("Case #"+t1+": 0");continue;}
		    for(int i=0;i<l;i++)
		    {
		        c=s.charAt(i);
		        switch(c)
		        {
		            case 'N':y++;break;
		            case 'E':x++;break;
		            case 'W':x--;break;
		            case 'S':y--;break;
		        }
		        r1=0;
		        if(x>0) r1+=x;else r1-=x;if(y>0) r1+=y;else r1-=y;
		        if(r1<=(i+1)) {res=i+1;break;}
		    }
		    if(res>-1) System.out.println("Case #"+t1+": "+res);
		    else System.out.println("Case #"+t1+": IMPOSSIBLE");
		}
	}
}
