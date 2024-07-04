import static java.lang.System.out;
import java.io.*;
import java.util.*;

class Solution {
public static void main(String [] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    
    int testCases = sc.nextInt();
    int matrix_size = 0;
    for (int i = 1; i <= testCases; i++) {
        matrix_size = sc.nextInt();
        //initializing the array
        int array[][] = new int[matrix_size][matrix_size];
        for(int r = 0; r < matrix_size; r++) {
            for(int c = 0; c < matrix_size; c++) {
                array[r][c] = sc.nextInt();
            }
        }
        
        //calculating the trace
        int t = trace(array, matrix_size);
        //finding repeated rows
        int row = repeatedRow(array, matrix_size);
        int col = repeatedCol(array, matrix_size);
        out.println("Case #"+i+": " + t +" "+ row +" "+ col);
    }
    
}

public static int trace(int[][] array, int size) {
    int trace = 0;
    for(int i = 0; i < size; i++) {
        trace += array[i][i];
    }
    return trace;
}

public static int repeatedRow(int[][] array, int n) {
    int count = 0;
    for(int r = 0; r < n; r++) {
        HashSet<Integer> table = createSet(n);
        for (int c = 0; c < n; c++) {
            int val = array[r][c];
            if(table.contains(val)) {
                table.remove(val);
            } else {
                count++;
                break;
            }
        }
    }
    return count;
}

public static int repeatedCol(int[][] array, int n) {
    int count = 0;
    for(int c = 0; c < n; c++) {
        HashSet<Integer> table = createSet(n);
        for (int r = 0; r < n; r++) {
            int val = array[r][c];
            if(table.contains(val)) {
                table.remove(val);
            } else {
                count++;
                break;
            }
        }
    }
    return count;
}

public static HashSet<Integer> createSet (int n) {
    HashSet<Integer> table = new HashSet<>();
    for(int i = 1; i <= n; i++) {
        table.add(i);
    }
    return table;
}
}