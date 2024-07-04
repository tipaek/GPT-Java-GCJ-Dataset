import java.util.Scanner;
class Main
{
  public static void main(String args[])
  {
     Scanner sc=new Scanner(System.in);
     int n=sc.nextInt(),i,j,k,res1,res2,res3,a,l,m,v,z,ap;
     for(i=0;i<n;i++)
     {
       res1=0;res2=0;res3=0;
       a=sc.nextInt();
       int[][] arr=new int[a][a];
       int[] r=new int[a];
       int[] c=new int[a];
       for(j=0;j<a;j++)
       {
         for(k=0;k<a;k++)
         {
            arr[j][k]=sc.nextInt();
            if(j==k)
            {
              res1=res1+arr[j][k];
            }
            l=j;m=k;
            z=0;ap=0;
            for(l=0;l<j;l++)
            {
              if(arr[l][k]==arr[j][k])
              {
                z=1;ap=1;
                for(v=0;v<res3;v++)
                {
                  if(k==c[v])
                  {
                    z=1;ap=0;
                    break;
                   }
                }
                if(z==1 && ap==1)
                {
                      c[res3]=k;
                      res3++;
                     break;
                }
              }
            }
            z=0;ap=0;
            for(m=0;m<k;m++)
            {
              if(arr[j][k]==arr[j][m])
              {
               z=1;
               ap=1;
               for(v=0;v<res2;v++)
                {
                  if(j==r[v])
                  {
                    z=1;
                    ap=0;
                    break;
                  }
                }
                if(z==1 && ap==1)
                {
                  r[res2]=j;
                  res2++;
                  break;
                }
              }
            }
        }
       }
      System.out.println("Case #"+i+": "+res1+" "+res2+" "+res3);
     }
    }
   }
            
            