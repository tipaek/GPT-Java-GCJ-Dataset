import java.util.Scanner;

class Solution{
    public static void main(String[] args){

        Scanner stdScanner = new Scanner(System.in);
        String stream = "";
        int testCases = Integer.parseInt(stdScanner.nextLine().trim());
        int id = 0;
        while(id < testCases){

            int matrixSize = Integer.parseInt(stdScanner.nextLine().trim());
            int n = 0;
            int[][] matrix = new int[matrixSize][matrixSize];
            while(n < matrixSize){

                stream = stdScanner.nextLine().trim();
                //System.out.println(stream);
                String[] row = stream.split(" ");
                for(int i = 0 ;i < matrixSize ; i++){

                    matrix[n][i] = Integer.parseInt(row[i]);
                }
                n++;
            }
            Vestigium vestigium = new Vestigium(id, matrix);
            String out = vestigium.process();
            System.out.println(out);
            id++;
        }
    }
}

class Vestigium{

    int[][] matrix;
    int testId;
    public Vestigium(int testId, int[][] matrix){

        this.matrix = matrix;
        this.testId = testId;
    }

    public String process(){

        int trace = getTrace();
        String mismatches = computeRowsAndColumnsWithRepeatedNumbers();
        return formatOutput(trace, mismatches);
    }

    public String formatOutput(int trace, String mismatches){

        String ret = "";
        ret += "Case #" + String.valueOf(testId+1) + ": ";
        ret += String.valueOf(trace) + " ";
        ret += mismatches;
        return ret;
    }

    public int getTrace(){

        int trace = 0;
        for(int i = 0 ; i< matrix.length ; i++){

            trace += matrix[i][i];
        }
        return trace;
    }

    public String computeRowsAndColumnsWithRepeatedNumbers(){

        int r = 0;
        int c = 0;
        boolean[][] columnTracking = new boolean[matrix.length][matrix.length];
        boolean[] isColumnInvalid = new boolean[matrix.length];
        for(int i = 0 ; i< matrix.length; i++){

            boolean isRowInvalid = false;
            boolean[] rowTracking = new boolean[matrix.length];
            for(int j = 0 ; j< matrix.length ; j++){

                int value = matrix[i][j];
                if(!columnTracking[j][value-1]){
                    columnTracking[j][value-1] = true;
                }
                else{
                    isColumnInvalid[j] = true;
                }

                if(!rowTracking[value-1]){
                    rowTracking[value-1] = true;
                }
                else{
                    isRowInvalid = true;
                }
            }
            if(isRowInvalid) r++;
        }

        for(int i = 0 ; i< matrix.length; i++){
            if(isColumnInvalid[i]) c++;
        }
        return r + " " + c;
    }
}