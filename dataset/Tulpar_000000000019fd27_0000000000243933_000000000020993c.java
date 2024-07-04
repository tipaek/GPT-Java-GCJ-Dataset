import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Solution 
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=1; i<=t; i++){
            int n = in.nextInt();
            HashMap<Integer, HashSet<Integer>> columnMap = new HashMap<>();
            HashMap<Integer,Boolean> columnMapBool = new HashMap<>();

            for (int j=0;j<n; j++){
                columnMap.put(j,new HashSet<Integer>());
            }
            int[][] matrix = new int[n][n];
            int dupCol=0,dupRow=0,trace=0;

            for(int j=0; j<n; j++){
                HashSet<Integer> set= new HashSet<>();

                boolean found = false;
                for (int k=0; k<n; k++){
                    matrix[j][k] = in.nextInt();
                    if(j==k){
                        trace+=matrix[j][k];
                    }

                    //check rows
                    if(set.contains(matrix[j][k]) && !found){
                        dupRow++;
                        found=true;
                    }else{
                        set.add(matrix[j][k]);
                    }

                    //check column
                    if (columnMapBool.get(k)==null && columnMap.get(k).contains(matrix[j][k])){
                        columnMapBool.put(k,true);
                        dupCol++;
                    }else{
                        columnMap.get(k).add(matrix[j][k]);
                    }
                }
            }


            System.out.printf("Case #%d: %d %d %d\n",i,trace,dupRow,dupCol);
        }

    }
}
