import java.util.*;
  
public class Solution 
{ 
    public static void main(String[] args) 
    { 

        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        for(int i=1 ; i<= testCases ; i++)
        {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            for(int j = 0 ; j < N ; j++)
            {
                for(int k = 0 ; k < N ; k++)
                {
                    arr[j][k] = sc.nextInt();
                }
            }
            int[] res = latinSq(arr);
            System.out.println("Case #"+i+": "+res[0]+" "+res[1]+" "+res[2]);
         } 
    }

    public static int[] latinSq(int[][] arr){
        int N = arr.length;
        int[] res = new int[3];
        int trace = 0;
        int r = 0,c = 0 ; 
        for(int j = 0 ; j < N ; j++)
            {
                HashSet<Integer> hsr = new HashSet<Integer>();
                HashSet<Integer> hsc = new HashSet<Integer>();
                for(int k = 0 ; k < N ; k++)
                {
                    hsr.add(arr[j][k]);
                    hsc.add(arr[k][j]);
                    if(j==k){
                        trace += arr[j][k];
                    }
                }
                if(hsr.size()!=N){
                    r++;
                }
                if(hsc.size()!=N){
                    c++;
                }
            }
            res[0]=trace;
            res[1]=r;
            res[2]=c;
            
            return res;
    }

}