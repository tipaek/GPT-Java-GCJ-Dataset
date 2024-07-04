import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {

    static int trace = 0;
    static int dupRow = 0;
    static int dupCol = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); sc.nextLine();

        IntStream.range(0,t).forEach(i-> {
            int n = sc.nextInt(); sc.nextLine();
            int [] [] intMatrix = new int[n][n];
            trace = 0;
            dupRow = 0;
            dupCol = 0;
            IntStream.range(0,n).forEach(j -> {
                String row = sc.nextLine();
                String [] rowElem = row.split(" ");
                int colIndex = 0;
                Set<Integer> rowSet = new HashSet<Integer>();

                for(String elem: rowElem){
                    int intElemValue = Integer.parseInt(elem);
                    if(j == colIndex) trace = trace +  intElemValue;
                    rowSet.add(intElemValue);
                    intMatrix [j][colIndex] = intElemValue;
                    colIndex++;
                }
                if(rowSet.size() < n)
                    dupRow++;

                rowSet = new HashSet<Integer>();
            });


            Set<Integer> colSet = new HashSet<Integer>();

            for(int a = 0; a < n ; a++){
                for(int b= 0; b < n ; b++){
                    colSet.add(intMatrix[b][a]);
                }
                if (colSet.size() < n){
                    dupCol++;
                }
                colSet = new HashSet<Integer>();
            }

            int k = trace;
            int r = dupRow;
            int c = dupCol;

            System.out.println("Case #"+(i+1)+ ": " + k + " " + r + " " + c);
        });
    }

}
