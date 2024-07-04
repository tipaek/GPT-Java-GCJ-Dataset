import java.util.*;
 class Solution{
     static int rows(int[] arr)
    {  int count = 0;  
        first:
        for(int i = 0; i < arr.length; i++){  
            
            for(int j = i+1; j < arr.length; j++){  
                if(arr[i] == arr[j]){  
                    count++;  
                    break first;
                }
            }
        }
            return count;
    }
    public static void main(String[] args)
    { try {
        
    
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
                for(int i=0;i<M;i++)
                {
                    int[] arr = a[i];
                    int c = rows(arr);
                    s=s+c;
                    
                }
                 for(int i =0;i<M;i++)
                { int[] col = new int[M];
                    for(int j=0;j<M;j++)
                    {
                        col[j] = a[j][i];

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
    } catch(Exception e) {
    } finally {
    }
    }
}