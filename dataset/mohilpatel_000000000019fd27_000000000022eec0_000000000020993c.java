import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=in.nextInt();
        for(int l=0;l<t;l++){
            int n=in.nextInt();
            int arr[][]=new int[n][n];
            int k=0,r=0,c=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=in.nextInt();
                    if(i==j)
                        k+=arr[i][j];
                }
            }
            
            for(int i=0;i<n;i++){
                int mat[]=new int[n];
                for(int j=0;j<n;j++){
                    mat[arr[i][j]-1]++;
                }
                boolean uni=true;
                for(int j=0;j<n;j++)
                    if(mat[j]>1){
                        uni=false;
                        break;
                    }
                if(!uni)
                    r++;
            }
            
            for(int i=0;i<n;i++){
                int mat[]=new int[n];
                for(int j=0;j<n;j++){
                    mat[arr[j][i]-1]++;
                }
                boolean uni=true;
                for(int j=0;j<n;j++)
                    if(mat[j]>1){
                        uni=false;
                        break;
                    }
                if(!uni)
                    c++;
            }
            
            System.out.println("Case #"+(l+1)+": "+k+" "+r+" "+c);
        }
    }
}