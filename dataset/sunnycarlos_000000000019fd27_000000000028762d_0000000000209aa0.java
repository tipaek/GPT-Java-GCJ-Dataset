import java.util.*;
import java.io.*;
import java.awt.*;

public class Solution {
    static int n,k;
    static int arr[][];
    static boolean visitedA[][], visitedB[][];
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        int x=1;
        while(t-->0){
            n=sc.nextInt();k=sc.nextInt();arr=new int[n][n];visitedA =new boolean[n+1][n+1];visitedB =new boolean[n+1][n+1];
            System.out.print("Case #" + (x++) + ": ");
            if (dfs(0,0)){
                System.out.println("POSSIBLE");
                for (int i=0;i<n;i++){
                    for (int j=0;j<n;j++) System.out.print(arr[i][j]+" ");
                    System.out.println();
                }
            }else System.out.println("IMPOSSIBLE");

        }
    }
    static boolean foo(){
        int s=0;
        for (int i=0;i<n;i++){
            boolean check[]=new boolean[n+1];
            for (int j=0;j<n;j++){
                if (i==j)s+=arr[i][j];
                if (check[arr[i][j]])return false;
                check[arr[i][j]]=true;
            }
        }
        for (int i=0;i<n;i++){
            boolean check[]=new boolean[n+1];
            for (int j=0;j<n;j++){
                if (check[arr[j][i]])return false;
                check[arr[j][i]]=true;
            }
        }
        return s==k;
    }
    static boolean dfs(int i,int j){
        if (i==n-1 && j==n-1){
            for (int l=1;l<=n;l++){
                arr[i][j]=l;
                if (foo())return true;
            }
            return false;
        }
        for (int a=1;a<=n;a++){
            if (visitedA[i][a] || visitedB[j][a])continue;
            arr[i][j]=a;visitedB[j][a]=true;
            visitedA[i][a]=true;
            if (j==n-1){
                if (dfs(i+1,0))return true;
            }else if (dfs(i,j+1))return true;
            visitedA[i][a]=false;
            visitedB[j][a]=false;
        }
        return false;
    }
}