import java.util.*;


    public class Program
    {
        public static void rotate (int[][]a,int num,int n)
        {
            for(int i=0;i<n;i++)
            {
                int t=0;
                for(int j=0;j<n;j++)
                {
                    if(num<=n)
                    {
                    a[i][j]=num;
                    num++;
                    }
                    else
                    {
                        t=j;
                        break;
                    }
                }
                num=1;
                for(int j=t;j<n;j++)
                {
                    a[i][j]=num;
                    num++;
                }
                num--;
            }
            
           
        }
       public static void main(String[] args)
        {
           
            Scanner sc=new Scanner(System.in);
             int t = sc.nextInt();
            while(t--!=0)
            {
                
                int cas=1;
                 int num=0;
                int n = sc.nextInt();
                int rtrace = sc.nextInt();
                int f = 1;
               for (int i = 1; i <= n; i++)
                {
                    if (rtrace == n*i)
                    {
                        f = 0;
                        num=i;
                        break;
                    }
                }
              
                
                if (f == 0)
                  { 
                      int a[][]=new int[n][n];
                     
                         rotate(a,num,n);
                      
                      System.out.println("Case #"+cas +": POSSIBLE");
                      for(int i=0;i<n;i++)
                      {
                       for(int j=0;j<n;j++)
                       {
                          System.out.print(a[i][j]);
                       }
                       System.out.println();
                      }
                      
                  }
                else
                    System.out.println("Case #"+cas +": IMPOSSIBLE");

                cas++;
            }
            
        }
    }

