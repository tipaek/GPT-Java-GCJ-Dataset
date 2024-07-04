import java.util.*;
public class Vestigium
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int g=0;g<t;g++)
        {
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            int r=0,r1=0,sum=0,c=0;
            HashSet<Integer>hs=new HashSet<>();
            for(int i=0;i<n;i++)
            {	
		        r1=0;
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                    if(i==j)
                    sum+=a[i][j];
                    if(hs.contains(a[i][j]))
                    r1++;
                    else
                    {
                        hs.add(a[i][j]);
                    }
                }
		    if(r1>0)
		    {
		        r++;
	        }
	        hs.clear();
        }
            for(int i=0;i<n;i++)
            {
                HashSet<Integer>hs1=new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    if(hs.contains(a[j][i]))
                    {
                        c++;
			break;
                    }
                    else
                    {
                        hs.add(a[j][i]);
                    }
                }
		hs.clear();
            }
            System.out.println("Case #"+(g+1)+": "+sum+" "+r+" "+c);
        }
    }
}