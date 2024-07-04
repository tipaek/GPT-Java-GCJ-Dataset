import java.util.Scanner;
import java.util.Arrays;

class Solution{
    public static void main(String a[])
    {
        Scanner in=new Scanner(System.in);
        int t,n,s=0,f1=0,f2=0,c1=0,c2=0;
		int[] t1 = new int[101];
		int[] t2 = new int[101];
		int[] t3 = new int[101];
		int[] z = new int[101];
		int[] y = new int[101];
		int[][] m = new int[101][101];
        t=in.nextInt();
        for(int i=1;i<=t;i++)
        {  s=0;c1=0;c2=0;
	      
            n=in.nextInt();
            for(int j=0;j<n;j++)
              for(int k=0;k<n;k++)
                 m[j][k]=in.nextInt();
            for(int l=0;l<n;l++)
            {f1=0;f2=0; Arrays.fill(z,0);
		   Arrays.fill(y,0);
              for(int o=0;o<n;o++)
                {
                    z[m[l][o]]=1;
                    y[m[o][l]]=1;
                }
              for(int p=1;p<=n;p++)
                {
                  if(z[p]==0 && f1==0) {          
                    c1++;f1=1;}
                  if(y[p]==0 && f2==0){
                    c2++;f2=1;}
                  if(f1==1 && f2==1)
                    break;
                }
               s=s+m[l][l]; 
            } 
           t1[i]=s;
           t2[i]=c1;
           t3[i]=c2;
        }
        for(int i=1;i<=t;i++)
          System.out.println("Case #"+i+" :  "+t1[i]+"  "+t2[i]+"  "+t3[i]);
	  
    }
}