
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static int checkC(int []gpC1, int []gpC2, int countC,int n, int st, int end)
    {
        double en = end - 0.5, start = st + 0.5;
        int count=0;
        for(double k=start;k<=en;k++)
        {
            for(int j=0;j<countC;j++)
            {
                if(k>gpC1[j] && k<gpC2[j]) {
                   count++;
                }  
            }
            if(count >= 1) {
                return -1;
            }
        }
        return 1;
    }
    public static int checkJ(int []gpJ1, int []gpJ2, int countJ,int n, int st, int end)
    {
        double en = end - 0.5, start = st + 0.5;
        int count=0;
        for(double k=start;k<=en;k++)
        {
            for(int j=0;j<countJ;j++)
            {
                if(k>gpJ1[j] && k<gpJ2[j]) {
                   count++;
                }  
            }
            if(count >= 1) {
                return -1;
            }
        }
        return 1;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc= new Scanner(System.in);
		int test = sc.nextInt();
		int temp=1;
		while(temp<=test)
		{
		    int n = sc.nextInt();
		    int []st = new int[n];
		    int []end = new int[n];
		    for(int i=0; i<n; i++) {
		        st[i] = sc.nextInt();
		        end[i] = sc.nextInt();
		    }
		    char []ch = new char[n];
		    int []groupC1 = new int[n];
		    int []groupC2 = new int[n];
		    int []groupJ1 = new int[n];
		    int []groupJ2 = new int[n];
		    int countC=0, countJ=0, go=0;
		    int val=0;
		    for(int i=0; i<n; i++)
		    {
		        val = checkC(groupC1, groupC2, countC, n, st[i], end[i]);
		        if(val != -1){
		            groupC1[countC] = st[i];
		            groupC2[countC++] = end[i];
		            ch[go++] = 'C';
		            continue;
		        }
		        val = checkJ(groupJ1, groupJ2, countJ, n, st[i], end[i]);
		        if(val == -1) {
		            break;
		        }
		        groupJ1[countJ] = st[i];
		        groupJ2[countJ++] = end[i];
		        ch[go++] = 'J';
		    }
		    String ans = "";
		    if(val == -1) {
		        ans = "IMPOSSIBLE";
		    }
		    else {
		        for(int i=0; i<n; i++)
		           ans+=ch[i];
		    }
		    System.out.println("Case #"+temp+": "+ans);
		    temp++;
		}
	}
}





















