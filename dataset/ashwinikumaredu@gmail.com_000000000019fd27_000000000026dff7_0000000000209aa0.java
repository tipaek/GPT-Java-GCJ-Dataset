import java.util.*;

import sun.security.util.Length;

public class Solution{
    static void printLatin(int[][] mat,int n) 
    { 
        for (int i = 0; i <n; i++) 
        { 
            int k=i+1;
            int temp=1;
            for(int j=0;j<n;j++){
                if(k<=n){
                    mat[i][j]=k;
                    k++;
                }else{
                    mat[i][j]=temp;
                    temp++;
                }
            }
        } 
    } 
    static int findTrace(int mat[][], int n) 
    { 
        int sum = 0; 
        for (int i=0; i<n; i++) 
            sum += mat[i][i]; 
        return sum; 
    } 
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int m=0;m<T;m++){
            int N=sc.nextInt();
            int K=sc.nextInt();
            int[][] mat=new int[N][N];
            printLatin(mat,N);
            int trace=findTrace(mat,N);
            if(K==T){
                System.out.println("Case #"+
                (m+1)+": POSSIBLE");
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        System.out.print(mat[i][j]+" ");
                    }
                    System.out.println();
                }
            }else{
                System.out.println("Case #"+(m+1)+": IMPOSSIBLE");
            }
        }
    }
}