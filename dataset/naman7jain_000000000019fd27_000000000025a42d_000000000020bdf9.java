/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

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
		    int n=s.nextInt();
            int start[]= new int[n];
            int end[]= new int[n];
            for(int i=0;i<n;i++)
            {
                start[i]=s.nextInt();
                end[i]=s.nextInt();
            }
            int a1=0;
            for(int i=0;i<n;i++)
            {
                int count=0;
                for(int j=i+1;j<n;j++)
                {
                    if(start[i]<=start[j] && start[j]<end[i])
                        count++;
                }
                if(count>1)
                {
                    a1=1;
                    break;
                }
            }
            if(a1==1){
                System.out.println("Case #"+(x+1)+": IMPOSSIBLE");
                break;
            }
            else{
                int initial=start[0];
                int finale=end[0];
                System.out.print("Case #"+(x+1)+": ");
                int a[]= new int[n];
                a[0]=0;
                // 0---'C' && 1---'J'
                for(int i=1;i<n;i++)
                {
                    for(int j=0;j<i;j++)
                    {
                        if((start[j]<=start[i] && start[i]<end[j]) || (start[j]<=end[i] && end[i]<end[j]))
                        {
                            if(a[j]==0)
                                a[i]=1;
                            if(a[j]==1)
                                a[i]=0;
                            break;
                        }
                    }
                }
                for(int i=0;i<n;i++)
                {
                    if(a[i]==0)
                        System.out.print("C");
                    else if(a[i]==1)
                        System.out.print("J");
                }
                System.out.println();
            }
		}
	}
}
