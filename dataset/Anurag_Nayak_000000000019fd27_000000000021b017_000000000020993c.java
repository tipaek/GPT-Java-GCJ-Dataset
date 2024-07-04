import java.util.*;
class vestigium
{
   public static void main(String[] args)
   {try{
       Scanner sc=new Scanner(System.in);
       int t=sc.nextInt();
       int s1[]=new int[t]; 
       int r1[]=new int[t];  
       int c2[]=new int[t];

       int c=0,d=0,c1=0,d1=0,s=0;
       for(int i=1;i<=t;i++)
       {d=0;d1=0;s=0;c=0;c1=0;
           int n=sc.nextInt();
           int[][] m=new int[n][n];
           for(int j=0;j<n;j++)
           {
               for(int k=0;k<n;k++)
               {
                   m[j][k]=sc.nextInt();
                   if(j==k)
                   s=s+m[j][k];
               }
           }
           for(int j=0;j<n;j++)
           {//c=0;
               for(int k=0;k<n;k++)
               {c=0;
                   for(int l=k;l<n;l++)
                   {if(m[j][k]==m[j][l])
                   c++;

                   }
                   if(c>1)
                   {d++;
                       break;
                   }

               }


              /* else
               d=0;*/
           }
           for(int j=0;j<n;j++)
           {//c1=0;
               for(int k=0;k<n;k++)
               {c1=0;
                   for(int l=k;l<n;l++)
                   {
                   if(m[k][j]==m[l][j])
                   c1++;

                   }
                   if(c1>1)
                   {
                   d1++;
                   break;
               }

               }


           }




             s1[i-1]=s;
             r1[i-1]=d;
             c2[i-1]=d1;

       }
       for(int j=0;j<t;j++)
       System.out.println("Case #"+(j+1)+": "+s1[j]+" "+r1[j]+" "+c2[j]);
   }catch(Exception e){}
   }
}