import java.util.*;
class solution
{
    public static void main(String args[])
    {  
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();
            int m[][]=new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    m[j][k]=sc.nextInt();
                }
                sc.nextLine();
            } 
            int sum=0;
            for(int j=0;j<n;j++)
            {
                sum+=m[j][j];
            }
            int count=0,count1=0;
            for(int j=0;j<n;j++)
            {
            HashSet<Integer> hs=new HashSet<>();
            for(int k=0;k<n;k++)
            {
                hs.add(m[j][k]);
            }
            if(hs.size()!=n)
                count++;
            } 
            for(int j=0;j<n;j++)
            {
            HashSet<Integer> hs=new HashSet<>();
            for(int k=0;k<n;k++)
            {
                hs.add(m[k][j]);
            }
            if(hs.size()!=n)
                count1++;
            } 
            
            
           
                   
                   System.out.println("Case #"+i+": "+sum+" "+count+" "+count1);
                   
        }
        
    }
}
