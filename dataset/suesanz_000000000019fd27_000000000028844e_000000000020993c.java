import java.util.*;
import java.io.*;

class Solution{
    public static void main(String args[]){
        Scanner scn=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T=scn.nextInt();
        for(int i=0;i<T;i++){
            int N=scn.nextInt();
            int arr[][]=new int[N][N];
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    arr[j][k]=scn.nextInt();
                }
            }
            solve(arr, i+1);
        }
    }       
    public static void solve(int [][]arr, int T){
        int n=arr.length;
        int diagSum=0;
        for(int i=0;i<n;i++){
            diagSum+=arr[i][i];
        }
        int row=0;
        HashSet<Integer> hs=new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (hs.size()>0 && hs.contains(arr[i][j]))
                {
                    row++;
                    break;
                }
                else
                hs.add(arr[i][j]);
        }
        hs.clear();
    }
    int col=0;
          for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (hs.size()>0 && hs.contains(arr[j][i]))
                {
                    col++;
                    break;
                }
                else
                hs.add(arr[j][i]);
        }
        hs.clear();
    } 
    System.out.println("Case #" + T + ": "+ diagSum + " " + row + " " + col);
    }
}