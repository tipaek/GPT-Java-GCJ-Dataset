import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
        for(int i = 0; i < numCases; i++){
            int matrixSize = sc.nextInt();
            sc.nextLine();
            HashMap<Integer, HashSet<String>> columnMap = new HashMap<Integer, HashSet<String>>();
            int diagonalCount = 0;
            int repeatRow = 0;
            int repeatColumn = 0;
            HashSet<Integer> repeatColumnVals = new HashSet<Integer>();
            for(int s = 0; s < matrixSize; s++){
                HashSet<Integer> repeatRowVals = new HashSet<Integer>();
                String[] currRow = sc.nextLine().split(" ");
                HashSet<String> rowVals = new HashSet<String>();
                for(int c = 0; c < currRow.length; c++){
                    if(rowVals.contains(currRow[c]) && !(repeatRowVals.size() > 0)){
                        repeatRow += 1;
                        repeatRowVals.add(0);
                    }
                    else{
                        rowVals.add(currRow[c]);
                    }
                    if(columnMap.containsKey(c)) {
                        if (columnMap.get(c).contains(currRow[c]) && !repeatColumnVals.contains(c)) {
                            repeatColumn += 1;
                            repeatColumnVals.add(c);
                        } else {
                            columnMap.get(c).add(currRow[c]);
                        }
                    }
                    else{
                        HashSet<String> intList = new HashSet<String>();
                        intList.add(currRow[c]);
                        columnMap.put(c, intList);
                    }
                    if(c == s){
                        diagonalCount += Integer.parseInt(String.valueOf(currRow[c]));
                    }
                }
            }
            System.out.println("Case #" + (i+1) + ": " + diagonalCount + " " + repeatRow + " " + repeatColumn);
        }
    sc.close();
    }
}
