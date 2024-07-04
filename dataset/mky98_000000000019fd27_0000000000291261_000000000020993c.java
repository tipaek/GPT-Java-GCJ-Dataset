import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution{
    
     public static void rc(int [][] matrix,int N,int k){
        int r=0,c=0,t=0;

        for(int i=0;i<N;i++){
            Set<Integer> row=new HashSet<>();
            Set<Integer> col=new HashSet<>();
            for(int j=0;j<N;j++){
                if(i==j)
                    t+=matrix[i][j];
                row.add(matrix[i][j]);
                col.add(matrix[j][i]);
            }
            if(row.size()<N)
                r++;
            if(col.size()<N)
                c++;
        }
        System.out.println("Case #"+k+": "+t+" "+r+" "+c);

    }
    public static void main(String []args){

        Scanner s=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=s.nextInt();
        for(int i=1;i<=t;i++){
            int N=s.nextInt();
            int matrix[][] = new int[N][N];
            for(int j=0;j<N;j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = s.nextInt();
                }
            }
            rc(matrix,N,i);
        }

    }
}