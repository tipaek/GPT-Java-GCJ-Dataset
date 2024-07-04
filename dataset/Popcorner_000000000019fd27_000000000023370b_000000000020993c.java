import java.util.*;
import java.io.*;

public class Solution{

    public static String vest(int[][] mat, int size){
        int sum = 0;
        int repRows = 0;
        int repCols = 0;

        for(int i = 0; i < size; i++)
            sum += mat[i][i];

        for(int i = 0; i < size; i++){
            HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
            for(int j = 0; j < size; j++){
                if(map.containsKey(mat[i][j])){
                    repRows++;
                    break;
                }
                map.put(mat[i][j], false);
            }
        }

        for(int j = 0; j < size; j++){
            HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
            for(int i = 0; i < size; i++){
                if(map.containsKey(mat[i][j])){
                    repCols++;
                    break;
                }
                map.put(mat[i][j], false);
            }
        }

        return Integer.toString(sum) + " " + Integer.toString(repRows) + " " + Integer.toString(repCols);
    }
    public static void main(String[] args){
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int tc = 0;

        if(input.hasNextLine())
            tc = Integer.parseInt(input.nextLine());

        for(int i = 0; i < tc; i++){
            int size = Integer.parseInt(input.nextLine());
            int[][] mat = new int[size][size];

            for(int j = 0; j < size; j++){
                String[] line = input.nextLine().split(" ");
                for(int z = 0; z < size; z++){
                    mat[j][z] = Integer.parseInt(line[z]);
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + vest(mat, size));
        }
        input.close();
    }
}