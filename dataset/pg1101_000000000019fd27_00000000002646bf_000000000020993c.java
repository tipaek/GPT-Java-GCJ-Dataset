import java.util.*;
class Hello{
     static int rows(int[] arr)
    {  int count = 0;  
        first:
        for(int ic = 0; ic < arr.length; ic++){  
            
            for(int jf = ic+1; jf < arr.length; jf++){  
                if(arr[ic] == arr[jf]){  
                    count++;  
                    break first;
                }
            }
        }
            return count;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext())
        {
            int T = sc.nextInt();
            for(int x=0;x<T;x++)
            {
                int M = sc.nextInt();
                int[][] a = new int[M][M];
                for(int i =0;i<M;i++)
                {
                    for(int j=0;j<M;j++)
                    {
                        a[i][j]= sc.nextInt();
                    }
                }
                int s=0,p=0,t=0;
                for(int ip=0;ip<M;ip++)
                {
                    int[] arr = a[ip];
                    int c = rows(arr);
                    s=s+c;
                    
                }
                 for(int iii =0;iii<M;iii++)
                { int[] col = new int[M];
                    for(int jjj=0;jjj<M;jjj++)
                    {
                        col[jjj] = a[jjj][iii];

                    }
                    int r = rows(col);
                    p=p+r;
                }
                for(int i =0;i<M;i++)
                {
                    t=t+a[i][i];
                }
                
                System.out.println("Case #"+(x+1)+":"+ " "+t+" "+s+" "+p);
            }
        }
    }
}