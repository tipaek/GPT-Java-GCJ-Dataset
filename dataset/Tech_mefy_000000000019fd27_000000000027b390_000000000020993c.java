import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main
{
public static void main(String[] args) throws IOException {
        Scanner sc=  new Scanner(System.in);
        while (sc.hasNextInt()) {
            int t = sc.nextInt();
            for (int k=1;k<=t;k++){
                int n = sc.nextInt();
                int[][] matrix = new int[n][n];
                for (int i=0;i<n;i++){
                    //String[] s = br.readLine().split(" ");
                    for (int j=0;j<n;j++){
                        matrix[i][j] = sc.nextInt();
                    }
                }

                int trace =0;
                int rowCount = 0;
                int colVount =0;
                for (int i=0;i<n;i++){
                    Set<Integer> row = new HashSet<Integer>();
                    Set<Integer> col = new HashSet<Integer>();
                    for (int j=0;j<n;j++){
                       if(row.contains(matrix[i][j])){
                          rowCount++;
                       }else {
                           row.add(matrix[i][j]);
                       }
                        if(col.contains(matrix[j][i])){
                            colVount++;
                        }else{
                            col.add(matrix[j][i]);
                        }
                       if(i==j){
                           trace += matrix[i][j];
                       }
                    }
                }
                System.out.println("Case #"+k+": "+trace+" "+rowCount+" "+colVount);
            }
        }
    }
}
