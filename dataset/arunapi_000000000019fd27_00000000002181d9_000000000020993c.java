import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) { //each test case
            int n = in.nextInt(); //N
            int [][] latinSquare = new int[n][n];
            boolean [] repeatCols = new boolean[n];
            boolean [] repeatRows = new boolean[n];
            int trace = 0;
//            String  rowStr = in.next();
            for (int rowNum = 0; rowNum < n; ++rowNum) {
//                String[] rowArrStr = rowStr.split(" ");
                for(int colNum = 0; colNum< n; colNum++){
                    int element = in.nextInt();//iteration 2: 1
                    latinSquare[rowNum][colNum] = element;//2 1
                    if(colNum==rowNum)
                        trace=trace+element; //0+2 = 2
                    //check if exist in col
                    if(!repeatCols[colNum]){ //1 = false
                        for(int rowNumDash = 0; rowNumDash<rowNum;rowNumDash++){ //0<0

                            if(latinSquare[rowNumDash][colNum] == element){
                                repeatCols[colNum] = true;
                            }
                        }
                    }
                    //check if exist in row
                    if(!repeatRows[rowNum]){ //0 = false
                        for(int colNumDash = 0; colNumDash<colNum;colNumDash++){ //0<0
                            if(latinSquare[rowNum][colNumDash] == element){
                                repeatRows[rowNum] = true;
                            }
                        }
                    }

                }
            }
            int repeatColsNum = 0;
            for(boolean repeat : repeatCols){
                if(repeat)
                    repeatColsNum++;
            }
            int repeatRowsNum = 0;
            for(boolean repeat : repeatRows){
                if(repeat)
                    repeatRowsNum++;
            }
            System.out.println("Case #" + i + ": " + trace + " " + repeatRowsNum+ " " + repeatColsNum);
        }
    }
}
