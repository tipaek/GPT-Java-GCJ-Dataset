import java.io.*;
class vestigium
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input");
        int T=Integer.parseInt(br.readLine());
        int a=0;
        if(T>=1&&T<=100)
        {
        for(int k=0;k<T;k++)
        {
           
         int N=Integer.parseInt(br.readLine());
          int trace=0,r=0,c=0;
            
         if(N>=2&&N<=100)
         {
         int arr[][]=new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                int M=Integer.parseInt(br.readLine());
                if(M>=1&&M<=N)
                arr[i][j]=M;
            }
        }
        a++;
         for(int i=0;i<N;i++)
         {
               for(int j=0;j<N;j++)
            {
                  System.out.print(arr[i][j]+"\t");
                }
                System.out.println();
            }
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(i==j)
                trace=trace+arr[i][j];
        }
      }
     for(int i=0;i<N;i++)
        {
            
            for(int j=0;j<N;j++)
            {
              int x=arr[i][j];
              for(int z=0;z<N;z++)
              {
                  if(j!=z)
                  {
                  int q=arr[i][z];
                  if(q==x)
                  r=i+1;
                  else
                  continue;
              }
              }
            }
        }
        for(int i=0;i<N;i++)
        {
            
            for(int j=0;j<N;j++)
            {
              int x=arr[j][i];
              for(int z=0;z<N;z++)
              {
                  if(j!=z)
                  {
                  int q=arr[z][i];
                  if(q==x)
                  c=i+1;
                  else
                  continue;
              }
              }
            }
        }
    System.out.println("Output");
   
         System.out.println("Case #"+a+": "+trace+" "+r+" "+c);
  
       
   }
  }
  }
    
 }
}
