import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String entriesString = sc.nextLine();
        int entries = Integer.parseInt(entriesString);


        int[] incorrectRow = new int[entries];
        int[] incorrectCol = new int[entries];
        int[] trace = new int[entries];

        for (int z = 0; z < entries; z++) {

            String NString = sc.nextLine();
            int N = Integer.parseInt(NString);

            boolean duplicateRow = false;
            boolean[] duplicateColumn = new boolean[N];
            HashSet[] columnSet = new HashSet[N];
            HashSet rowSet;
            int i,j;

            for (i = 0; i < N; i++){
                String row = sc.nextLine();
                String[] element = row.split(" ");
                duplicateRow = false;
                rowSet = new HashSet();
                for (j = 0; j < element.length; j++){
                    int elementValue = Integer.parseInt(element[j]);
                    if (i == 0){
                        columnSet[j] = new HashSet();
                    }
                    if (rowSet.contains(elementValue)){
                        duplicateRow = true;
                    } else {
                        rowSet.add(elementValue);
                    }
                    if (columnSet[j].contains(elementValue)){
                        duplicateColumn[j] = true;
                    } else {
                        columnSet[j].add(elementValue);
                    }

                    if (i == N - 1){
                        if(duplicateColumn[j]){
                            incorrectCol[z] += 1;
                        }
                    }
                    if (i == j){
                        trace[z] += elementValue;
                    }
                }
                if (duplicateRow){
                    incorrectRow[z] += 1;
                }
            }

        }
        sc.close();
        for (int i = 1; i <= entries; i++){
            System.out.println("Case #" + i + ": " + trace[i-1] + " " + incorrectRow[i-1] + " " + incorrectCol[i-1]);
        }
    }
}
