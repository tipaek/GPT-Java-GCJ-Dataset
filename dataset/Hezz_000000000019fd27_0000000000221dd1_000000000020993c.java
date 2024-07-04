package Gooogle.CodeJam;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String [] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testNumber = scan.nextInt();
        for(int i = 1; i <= testNumber; i ++) {
            int size = scan.nextInt();
            List<int[]> matrix = new ArrayList<>();
//            scan.nextLine();

            for(int j = 0; j < size; j ++) {
                String numbers = scan.next();
                matrix.add(parseToIntArray(numbers));
            }
            calculate(matrix, i, size);
        }
    }

    private static void calculate(List<int[]> m, int testNum, int size) {
        List<Set<Integer>> repeatedRows = new ArrayList<>();
        List<Set<Integer>> repeatedCols = new ArrayList<>();
        boolean [] rowsFlag = new boolean[size];
        boolean [] colsFlag = new boolean[size];

        for(int i = 0; i < size; i ++) {
            repeatedRows.add(new HashSet<>());
        }

        for(int i = 0; i < size; i ++) {
            repeatedCols.add(new HashSet<>());
        }

        int repeatedRowCnt = 0;
        int repeatedColCnt = 0;
        int trace = 0;


//        Map<Integer, Integer> rowCounter = new HashMap<>();
//        Map<Integer, Integer> colCounter = new HashMap<>();

        for(int i = 0; i < size; i ++) {
            for(int j = 0; j < size; j ++) {
                int val = m.get(i)[j];
                if(i == j) {
                    trace += val;
                }
                if(repeatFound(val, i, repeatedRows.get(i)) && !rowsFlag[i]) {
                    rowsFlag[i] = true;
                    repeatedRowCnt ++;
                }

                if(repeatFound(val, j, repeatedCols.get(j)) && !colsFlag[j]) {
                    colsFlag[j] = true;
                    repeatedColCnt ++;
                }
            }
        }
        System.out.println(String.format("Case #%d: %d %d %d", testNum, trace, repeatedRowCnt, repeatedColCnt));
    }

    private static boolean repeatFound(int val, int metric, Set<Integer> repeat){
        if(!repeat.add(val)){
            return true;
        }
        return false;
    }

    private static int[] parseToIntArray(String s){
        if(s == null || s.length() == 0) return null;
        String [] ele = s.split("\\s+");

        int [] res = new int [ele.length];

        for(int i = 0; i < ele.length; i ++) {
            res[i] = Integer.parseInt(ele[i]);
        }
        return res;
    }
}
