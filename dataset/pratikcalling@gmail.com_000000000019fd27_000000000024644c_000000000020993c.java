
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int caseNo = 1; caseNo <= cases; ++caseNo) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];

            in.nextLine();

            for(int row=0;row<n;row++) {
                String line=in.nextLine();
                String[] lineNumbers=line.split(" ");

                for(int character=0;character<lineNumbers.length;character++) {
                    matrix[row][character]=Integer.parseInt(lineNumbers[character]);
                }
            }

            int traceIndex=0;
            int traceValue=0;

            for(int row=0;row<n;row++) {
                for(int col=0;col<n;col++) {
                    int val=matrix[row][col];
                }
                traceValue+=matrix[row][traceIndex];
                traceIndex++;
            }

            int duplicateInRow=0;

            for(int row=0;row<n;row++) {
                Set<Integer> visited=new HashSet<>();
                for(int col=0;col<n;col++) {
                    int val=matrix[row][col];
                    if(visited.contains(val)) {
                        duplicateInRow++;
                        break;
                    }
                    visited.add(val);
                }
            }

            int duplicateInCol=0;

            for(int col=0;col<n;col++) {

                Set<Integer> visited=new HashSet<>();
                for(int row=0;row<n;row++) {
                    int val=matrix[row][col];
                    if(visited.contains(val)) {
                        duplicateInCol++;
                        break;
                    }
                    visited.add(val);
                }
            }

            System.out.println("Case #" + caseNo + ": " + traceValue + " " + duplicateInRow+" "+duplicateInCol);
        }
    }
}