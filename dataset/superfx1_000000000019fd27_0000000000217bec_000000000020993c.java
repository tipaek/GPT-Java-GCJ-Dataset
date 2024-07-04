import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T=input.nextInt();
        for(int t=0;t<T;t++){
            int N=input.nextInt();
            int[][] matrix=new int[N][N];
            int r=0;
            int c=0;
            int k=0;
            for(int i=0;i<N;i++){
                int[] pos=new int[N];
                for(int j=0;j<N;j++){
                    matrix[i][j]=input.nextInt();
                    pos[matrix[i][j]-1]++;
                }
                for(int j :pos){
                if(j > 1){
                    r++;
                    break;
                }
                }
            }
            for(int i=0;i<N;i++){
                k+=matrix[i][i];
                int[] pos=new int[N];
                for(int j=0;j<N;j++){
                    pos[matrix[j][i]-1]++;
                }
                for(int j :pos){
                if(j > 1){
                    c++;
                    break;
                }
                }
            }
            System.out.println("Case #"+(t+1)+": "+k+" "+r+" "+" "+c);
            
            
        
        
        
        
        
        
        
        }
    }
}