import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        int caseNo = 0;

        while (testCase-- > 0) {
            int size = scanner.nextInt();
            int[][] m = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    m[i][j] = scanner.nextInt();
                }
            }
            int trace = getTrace(m, size);
            int repeatRows = getRowRepeat(m, size);
            int colRepeat = getColRepeat(m, size);

            System.out.println("Case #" + ++caseNo + ": " + trace + " " + repeatRows + " " + colRepeat);
        }
    }

    private static int getTrace(int[][] m, int size) {
        int trace=0;
        for(int i=0, j=0; i<size&&j<size;){
            trace += m[i][j];
            i++;j++;
        }
        return trace;
    }

    private static int getRowRepeat(int[][] m, int size){
        int r=0;
        List<Integer> rowList = new ArrayList<>();
        for(int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                if(rowList.contains(m[i][j])){
                    r++;
                    rowList.clear();
                    break;
                }
                else{
                    rowList.add(m[i][j]);
                }
            }
            rowList.clear();
        }
        return r;
    }

    private static int getColRepeat(int[][] m, int size){
        int c=0;
        List<Integer> colList = new ArrayList<>();
        for(int j=0; j<size; j++){
            for (int i=0; i<size; i++){
                if(colList.contains(m[i][j])){
                    c++;
                    colList.clear();
                    break;
                }
                else{
                    colList.add(m[i][j]);
                }
            }
            colList.clear();
        }
        return c;
    }


}
