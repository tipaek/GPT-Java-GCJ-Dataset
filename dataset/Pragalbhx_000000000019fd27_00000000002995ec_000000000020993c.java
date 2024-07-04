import java.io.*;
import java.util.*;
import java.lang.*;
public class Solution {


public static void main(String[] args) throws NumberFormatException, IOException {

    // TODO Auto-generated method stub
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int testcases = Integer.parseInt(read.readLine());
    StringBuilder answer = new StringBuilder();
    for(int i  = 0; i< testcases; i++) {
        int N = Integer.parseInt(read.readLine());
        String matrix = "";
        String [] vals;;
        for(int j = 0; j< N; j++) {
                matrix+=read.readLine();
        }

        vals = matrix.split(" ");
        String m = "";
        for( String s: vals) {
            m+=s;
        }
        if(i < testcases -1) {
            answer.append(calcRowsandColumns(m,N,(i+1))).append("\n");
        }
        else answer.append(calcRowsandColumns(m,N,(i+1)));
    }
    System.out.println(answer);


}


public static  String calcRowsandColumns(String matrixs, int N, int caseNumber) {
    HashSet<Integer> seen = new HashSet<Integer>();
    int [][] matrix = new int [N][N];

    for(int i = 0; i< N; i++) {

        for(int j = 0; j < N; j++) {

            matrix[i][j] = (matrixs.charAt(N*i +j) - '0');
        }

    }

    int numColr = 0,numRowr = 0, trace = 0;

    for(int i = 0; i< N; i++) {//first check everyrow
        for(int j = 0; j < N; j++ ) {

            if(seen.contains(matrix[i][j])) {
                numRowr++;

                break;//you break since you already counted that row
            }
            else seen.add(matrix[i][j]);

        }
        seen.removeAll(seen);//we restart(we only care about rows here)
    }

    for(int i = 0; i < N; i++) {//now calculates the repeated columns

        for(int j = 0; j < N; j++) {

            if(seen.contains(matrix[j][i])) {
                numColr ++;
                break;
            }
            else seen.add(matrix[j][i]);


        }
        seen.removeAll(seen);
    }

    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            if(i==j) {
                trace+=matrix[i][j];
            }
        }
    }

    return "Case #"+caseNumber+": "+trace+" "+numRowr+" "+numColr;

}
}