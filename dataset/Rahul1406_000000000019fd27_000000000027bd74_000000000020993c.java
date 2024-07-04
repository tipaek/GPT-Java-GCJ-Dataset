
import java.util.*;
import java.io.*;
 class ves1 {
  public static void main(String[] args) {
    Scanner inp=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=inp.nextInt();  
        for(int i=0;i<t;i++)
        {
            int N=inp.nextInt();   
            int arr[][]=new int[N][N];
            int trace=0;  
            int rowrep=0;  
            int colrep=0;  
            for(int j=0;j<N;j++)
            {
                for(int k=0;k<N;k++)
                {
                    arr[j][k]=inp.nextInt();
                }
            }
          
            for(int x=0;x<N;x++)
                {
                    trace+=arr[x][x];
                }

          
            for(int j=0;j<N;j++)
            {
                int count=0;
                for(int k=0;k<N;k++)
                {
                    if(count==1)
                        break;
                    else
                    {
                        int key=arr[j][k];
                        for(int l=0;l<N;l++)
                        {
                            if(l==k)
                            { }
                            else
                            {
                                if(arr[j][l]==key)
                                {   count++;
                                    rowrep++;
                                    break;
                                }
                            }
                        }
                    }
                }
            }



           for(int k=0;k<N;k++)
           {
               int count=0;
               for(int j=0;j<N;j++)
               {
                   if(count==1)
                       break;
                   else
                   {
                       int key=arr[j][k];  
                       for(int l=0;l<N;l++)
                       {
                           if(j==l)
                           { }
                           else
                           {
                               if(arr[l][k]==key)
                               {
                                   count++;
                                   colrep++;
                                   break;
                               }
                           }
                       }
                   }
               }
           }
            System.out.println("Case #" + (i+1) + ": " + trace + " " + rowrep+" "+colrep);
    }
  }
}