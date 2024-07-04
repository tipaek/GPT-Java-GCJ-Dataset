import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = Integer.parseInt(in.nextLine());
        

        for(int nooftestcase=1 ;nooftestcase<=testcases;++nooftestcase) {
            int noofrows = Integer.parseInt(in.nextLine());
            int [][]array = new int[noofrows][noofrows];
            for (int i = 0; i < noofrows; i++) {
                array = storeinarray(in.nextLine(), i, array);
            }
            //Diagonal sum to find trace
            int diagonalsum = 0;
            for (int i = 0; i < array.length; i++) {
                diagonalsum += array[i][i];
            }
            int noof_dupli_col = 0;
            int noof_dupli_row = 0;
            for (int i = 0; i < array.length; i++) {
                noof_dupli_row = (checkrowduplicates(array, i)) ? ++noof_dupli_row : noof_dupli_row;
                noof_dupli_col = (checkcolumnduplicates(array, i)) ? ++noof_dupli_col : noof_dupli_col;
            }
            System.out.println("Case #" + nooftestcase + ": " + diagonalsum+" "+noof_dupli_row+" "+noof_dupli_col);
        }





    }
    public static int[][] storeinarray(String row,int rowno,int[][]array){
        String []split = row.split(" ");
        for(int i =0;i<split.length;i++){
            array[rowno][i]= Integer.parseInt(split[i]);
        }
        return array;
    }
    public static boolean checkrowduplicates(int[][]array,int rowno){
        int []array1d= new int[array[rowno].length];
        for(int i=0;i<array[rowno].length;i++) {
                array1d[i]= array[rowno][i];
        }
        Arrays.sort(array1d);
        return array1d[0]==array1d[1];
    }
    public static boolean checkcolumnduplicates(int [][]array, int colno){
        int []array1d= new int[array.length];
        for(int i=0;i<array.length;i++) {
            array1d[i]= array[i][colno];
        }
        Arrays.sort(array1d);
        return array1d[0]==array1d[1];
    }
}