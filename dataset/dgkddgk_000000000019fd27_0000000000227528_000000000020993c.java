import java.util.Scanner;
import java.util.TreeSet;
class Vestigium
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
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
            
            boolean dup = false;
            int count=0,sum=0,rcount=0,ccount=0;
            int temp=a[0][0];
            
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
            			}
            			else
            				sum+=a[j][k];
            		s1.add(a[j][k]);
            		s2.add(b[j][k]);
            	}
            	if(s1.size()!=ip)
            	rcount+=1;
            	if(s2.size()!=ip)
                	ccount+=1;
            	
            	s2.clear();
            	s1.clear();
            }
            System.out.println("Case #"+(i+1)+": "+sum+" "+rcount+" "+ccount);
        }
        
    }
    
    
    
}