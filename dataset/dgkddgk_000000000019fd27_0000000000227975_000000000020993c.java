package test;


import java.util.Scanner;
import java.util.TreeSet;
class Vestigium
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        String op="";
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            int ip=sc.nextInt();
            int[][] a=new int[ip][ip];
            int[][] b=new int[ip][ip];
            for(int j=0;j<ip;j++)
            for(int k=0;k<ip;k++)
            {
            a[j][k]=sc.nextInt();
            b[k][j]=a[j][k];
            }
            
            /*for(int j=0;j<ip;j++)
            {
                for(int k=0;k<ip;k++)
                System.out.println(b[j][k]);
                System.out.println();
            }
            //System.out.println(a.toString());
            //System.out.println(b);
            */
            boolean dup = false;
            int count=0,sum=0,rcount=0,ccount=0;
            int temp=a[0][0];
            
            
            //System.out.println(temp);
            TreeSet<Integer> s1=new TreeSet<Integer>();
            TreeSet<Integer> s2=new TreeSet<Integer>();
            for(int j=0;j<ip;j++)
            {
            	for(int k=0;k<ip;k++)
            	{
            		if(j==k)
            			if(temp==a[j][k])
            			{
            				count++;
            				sum+=a[j][k];
            				//System.out.println(count);
            			}
            			else
            				sum+=a[j][k];
            		s1.add(a[j][k]);
            		s2.add(b[j][k]);
            	}
            	//System.out.println("col size "+s2.size());
            	//System.out.println("row"+s1.toString());
            	//System.out.println("col"+s2.toString());
            	if(s1.size()!=ip)
            	rcount+=1;
            	if(s2.size()!=ip)
                	ccount+=1;
            	
            	s2.clear();
            	s1.clear();
            }
            /*if(count==ip)
            {
            	System.out.println("diag");
            	System.out.println(sum);
            }
            else
            	System.out.println(sum);
            */
            if(i!=ip-1)
            {
            op+=("Case #"+(i+1)+": "+sum+" "+rcount+" "+ccount);
            op+="\n";
            }
            else
            op+=("Case #"+(i+1)+": "+sum+" "+rcount+" "+ccount);
           // System.out.println("Case #"+(i+1)+": "+sum+" "+rcount+" "+ccount);
            //System.out.println("no of duplicate rows "+rcount);
            //System.out.println("no of duplicate colss "+ccount);
            
        }
        System.out.println(op);
    }
    
    
    
}