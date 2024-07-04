import java.util.*;
import java.lang.*;

public class Solution{
     public static void main(String []args){
        Scanner sc= new Scanner(System.in);
        int T=0;
        int i=0,j=0,k=0,l=0;
        T=sc.nextInt();
        int N[]=new int[T];
        int M[][];
        int kt[]=new int[T];
        int r[]=new int[T];
        int c[]=new int[T];
        for(i=0;i<T;i++)
        {
            N[i]=sc.nextInt();
            M=new int[N[i]][N[i]];
            kt[i]=0;
            for(j=0;j<N[i];j++)
            {
                for(k=0;k<N[i];k++)
                {
                    M[j][k]=sc.nextInt();
                   if(k==j)
                   {
                       kt[i]=kt[i]+M[j][k];
                   }
                }
            }
            r[i]=0;
            c[i]=0;
            for(j=0;j<N[i];j++)
            {
                for(k=0;k<N[i];k++)
                {
                    for(l=k+1;l<N[i];l++)
                    {
                        if(M[j][k]==M[j][l])
                        {
                            r[i]++;
                            k=N[i];
                            break;
                        }
                    }
                }
            }
            for(j=0;j<N[i];j++)
            {
                for(k=0;k<N[i];k++)
                {
                    for(l=k+1;l<N[i];l++)
                    {
                        if(M[k][j]==M[l][j])
                        {
                            c[i]++;
                            k=N[i];
                            break;
                        }
                    }
                }
            }
        }
         for(i=0;i<T;i++)
        {
            System.out.println("Case #"+(i+1)+": "+kt[i]+" "+r[i]+" "+c[i]);   
        }
        
     }
}