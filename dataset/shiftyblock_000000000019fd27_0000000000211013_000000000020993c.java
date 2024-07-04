import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int tcs= sc.nextInt();
        for (int x=1; x<=tcs; x++){
            int N=sc.nextInt();
            int matrixR[][]= new int[N][N];
            int matrixC[][]= new int[N][N];
            int rows=0;
            int cols=0;
            int K=0;
            for (int i=0; i<N; i++){
                for (int j=0; j<N; j++){
                    int num= sc.nextInt();
                    if (i==j) K+=num;
                    matrixR[i][j]=num;
                    matrixC[j][i]= num;
                }
            }

            for (int i=0; i<N; i++){
                ArrayList<Integer> row= new ArrayList<>();
                ArrayList<Integer> col= new ArrayList<>();
                for (int j=0; j<N; j++){
                    if (row.contains(matrixR[i][j])){
                        rows++;
                    }
                    else row.add(matrixR[i][j]);
                    if (col.contains(matrixC[i][j])){
                        cols++;
                    }
                    else col.add(matrixC[i][j]);
                }
            }
            System.out.println("Case #"+x+": "+K+" "+rows+" "+cols);
        }
    }
}