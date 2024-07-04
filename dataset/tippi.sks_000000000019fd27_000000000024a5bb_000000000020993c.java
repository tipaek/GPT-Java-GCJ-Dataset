import java.util.Scanner;
class Main
{
public static int count=0;
   
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        if(T<=0 && T>100)
        return;
        
        int []sum=new int[T];
       
        
        for(int t=0;t<T;t++){
            
        int N=sc.nextInt();
        if(N<2 && N>100)
        return;
        else
        {
        int [][]matrix=new int[N][N];
        boolean result=true, isduplicate=false;
            
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                matrix[i][j]=sc.nextInt();
                if(matrix[i][j]<1 || matrix[i][j]>N)
                result=false;
                
                for(int k=0;k<j;k++)
                {
                    if(matrix[i][j]==matrix[i][k]|| matrix[i][j]==matrix[k][i])
                    isduplicate=true;
                }
            }
        }
       
        if(result==false)
        {
            continue;
        }
        else
        {
            //  boolean res=duplicates(matrix,N);
            //  System.out.println(res);
         if(isduplicate==true)
         continue;
            else
            {
            for(int i=0,j=0;i<N;i++)
            {
            j=i;
            sum[t]=sum[t]+matrix[i][j];
            }
            count++;
            }
        }
        }
        }
        
        for(int i=0;i<count;i++)
        {
        System.out.println(sum[i]);
        }
    
    }
}
