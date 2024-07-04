import java.util.*;
class jam
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int tt[]=new int[t];
        int rr[]=new int[t];
        int cc[]=new int[t];
        for(int a=0;a<t;a++)
        {
            int n=sc.nextInt();
            int ar[][]=new int[n][n];
            int tr=0,r=0,c=0,z;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    ar[i][j]=sc.nextInt();
                    if(i==j)
                        tr=tr+ar[i][j];
                }
                
            }
	tt[a]=tr;
	rr[a]=0;
	cc[a]=0;
            
        }
        
        for(int a=0;a<t;a++)
        {
            System.out.println("Case #"+(a+1)+": "+tt[a]+" "+rr[a]+" "+cc[a]);
        }
        
    }
}
