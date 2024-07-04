import java.util.*;
class Vestigium
{
    public static void main(String arh[])
    {
        Scanner kb=new Scanner(System.in);
        int tcase=kb.nextInt();
        int rcount=0;
        int ccount=0;
        int sum=0;
        for(int i=1;i<=tcase;i++)
        {   
            int num=kb.nextInt();
            int arr[][]=new int [num][num]; 
            for(int j=0;j<num;j++ )
               {    int rc=0,cc=0;
                   for(int m=0;m<num;m++)
                   {
                       arr[j][m]=kb.nextInt();
                       if(j==m)
                       {
                       sum=sum+arr[j][m];
                       }
                   }
                  for(int n=0;n<num;n++)
                   {
                    for(int w=n;w<num;w++)
                       { 
                         if(arr[j][n]==arr[n][w])
                           {
                            ++rc;
                           }
                        }
                        if(rc>num)
                          ++rcount;
                    }
                    }
               for(int i=0;i<num;i++)
                   {  
                   
                     for( j=0;j<num;j++)
                        { 
                            
                          int y=arr[j][i];
                          
                          if(y==arr[j][i])
                           {
                           ++cc;
                           }
                        }
                        
                        if(cc>num)
                          ++ccount;
                           
                   }
               System.out.println("Case #"+i+":"+" "+sum+" "+rcount+" "+ccount);
        }
       
    }
}