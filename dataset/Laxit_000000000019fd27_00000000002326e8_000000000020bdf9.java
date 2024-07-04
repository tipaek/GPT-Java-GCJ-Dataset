
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static int check(int []st, int []end, int i,int n)
    {
        double en = end[i] - 0.5, start = st[i] + 0.5;
        int count=0, pos=-1;
        for(double k=start;k<=en;k++)
        {
            count=0;
            for(int j=0;j<n;j++)
            {
                if(i==j)
                   continue;
                if(k>st[j] && k<end[j]) {
                   count++;
                   pos=j;
                }  
            }
            if(count > 1) {
                return -1;
            }
        }
        if(pos == -1){
            return i;
        }
        else {
            return pos;
        }
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
		    int val=0;
		    for(int i=0; i<n; i++)
		    {
		        val = check(st, end, i, n);
		        if(val == -1){
		            break;
		        }
		        else if(val == i) {
		            if(ch[val]!='C' && ch[val]!='J')
		               ch[i] = 'J';
		        }
		        else {
		            if((ch[val]!='C' && ch[val]!='J') && (ch[i]!='C' && ch[i]!='J')) {
		                ch[i] = 'C';
		                ch[val] = 'J';
		            }
		            else {
		                if(ch[i] == 'C') {
		                    if(ch[val] == 'J'){	 }
		                    else {
		                        ch[val] = 'J';
		                    }
		                }
		                else if(ch[i] == 'J') {
		                    if(ch[val] == 'C'){  }
		                    else {
		                        ch[val] = 'C';
		                    }
		                }
		                else {
		                    if(ch[val] == 'J'){
		                        ch[i] = 'C';
		                    }
		                    else {
		                        ch[i] = 'J';
		                    }
		                }
		            }
		        }
		    }
		    StringBuffer ans = new StringBuffer();
		    if(val == -1) {
		        ans.append("IMPOSSIBLE");
		    }
		    else {
		        ans.append(ch);
		    }
		    
		    System.out.println("Case #"+temp+": "+ans);
		    temp++;
		}
	}
}





















