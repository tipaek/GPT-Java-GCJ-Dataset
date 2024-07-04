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
                boolean rowAdded=false;
                boolean colAdded=false;
                for (int j=0; j<N; j++){
                    if (!rowAdded && row.contains(matrixR[i][j])){
                        rows++;
                        rowAdded=true;
                    }
                    else row.add(matrixR[i][j]);
                    if (!colAdded && col.contains(matrixC[i][j])){
                        cols++;
                        colAdded=true;
                    }
                    else col.add(matrixC[i][j]);
                }
            }
            System.out.println("Case #"+x+": "+K+" "+rows+" "+cols);
        }
    }
}
/*
4
2 2 2 2
2 3 2 3
2 2 2 3
2 2 2 2
 */