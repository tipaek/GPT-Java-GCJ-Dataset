import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution { 
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // input 
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(); // number of values read
            int[][] matrix = new int[n][n];
            for(int r = 0; r < n; r++){
                for(int c = 0; c < n; c++){
                    matrix[r][c] = in.nextInt();
                }
            }
            int[] ans = latinSquare(n, matrix);
            System.out.println(print(i, ans));
          }
    }


    public static String print(int input, int[] nums){
        StringBuilder sb = new StringBuilder("Case #" + input + ": ");
        for(int i = 0; i < nums.length; i++){
            sb.append(nums[i] + " ");
        }
       return sb.toString().trim();
    }

    public static int[] latinSquare(int num, int[][] matrix){
        HashMap<Integer, HashSet<Integer>> row = new HashMap<Integer, HashSet<Integer>>();
        HashMap<Integer, HashSet<Integer>> col = new HashMap<Integer, HashSet<Integer>>();
        boolean[] rowChecked = new boolean[num];
        boolean[] colChecked = new boolean[num];

        int[] values = new int[3];
        for(int i = 0; i < matrix.length; i++){
            if(!row.containsKey(i)){
                row.put(i, new HashSet<Integer>());
            }
            for(int j = 0; j < matrix[0].length; j++){
                int value = matrix[i][j];

                if(!col.containsKey(j)){
                    col.put(j, new HashSet<Integer>());
                }

                if(row.get(i).contains(value) && rowChecked[i] == false){
                    values[1] ++;
                    rowChecked[i] = true;;
                } else {
                    row.get(i).add(value);
                }

                if(col.get(j).contains(value) && colChecked[j] == false){
                        values[2] ++;
                        colChecked[j] = true;
                } else {
                    col.get(j).add(value);
                }

                if(i == j){
                    values[0] += value;
                }
            }
        }
        return values;
    }
}

