import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;



public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = in.nextInt();
        ArrayList<String> output = new ArrayList<>();
        for (int i = 0; i < testcases; i++) {
            int rowDupes = 0;
            int colDupes = 0;
            int matLen = in.nextInt();
            int[][] elem = new int[matLen][matLen];

            for (int j = 0; j < matLen; j++) {
                HashSet<Integer> setR = new HashSet<>();
                boolean found = false;
                for (int k = 0; k < matLen; k++) {
                    elem[j][k] = in.nextInt();
                    if (setR.contains(elem[j][k]) && !found) {
                        rowDupes++;
                        found= true;
                    }
                    setR.add(elem[j][k]);
                }
            }

            for (int j = 0; j < matLen; j++) {
                HashSet<Integer> setC = new HashSet<>();
                boolean found= false;
                for (int k = 0; k < matLen; k++) {
                    if (setC.contains(elem[k][j]) && !found) {
                        colDupes++;
                        found= true;
                    }
                    setC.add(elem[k][j]);
                }
            }
            output.add("Case #" +(i+1)+": "+findTrace(elem, matLen)+" "+rowDupes+" "+colDupes);
        }
        for (String outLine:output) {
            System.out.println(outLine);

        }
    }


    static int findTrace(int[][] mat, int n)
    {
        int sum = 0;
        for (int i=0; i<n; i++)
            sum += mat[i][i];
        return sum;
    }
}
