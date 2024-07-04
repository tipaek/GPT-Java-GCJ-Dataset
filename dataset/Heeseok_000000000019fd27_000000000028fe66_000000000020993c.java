import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {

//        System.setIn(new FileInputStream("./input.txt"));
        
        Scanner scanner = new Scanner(System.in);
        
        int problemCount = scanner.nextInt();

        for (int i = 0; i < problemCount; i++) {
            int N = scanner.nextInt();

            int _k = 0;
            int _r = 0;
            int _c = 0;

            Set[] cols = new HashSet[N];
            boolean[] colDupls = new boolean[N];
            for (int j = 0; j < N; j++) {
                // col

                Set row = new HashSet();
                boolean rowDupl = false;
                for (int k = 0; k < N; k++) {

                    if(j == 0) cols[k] = new HashSet();

                    // row
                    int num = scanner.nextInt();

                    if(j == k) _k += num;

                    if(row.contains(num)) {
                        rowDupl = true;
                    } else {
                        row.add(num);
                    }

                    if(cols[k].contains(num)) {
                        colDupls[k] = true;
                    } else {
                        cols[k].add(num);
                    }
                }

                if(rowDupl) {
                    _r++;
                }
            }

            for (int j = 0; j < N; j++) {
                if(colDupls[j]) {
                    _c++;
                }
            }
            System.out.println("Case #" + (i+1) + ": " + _k + " " + _r + " " + _c);
        }
    }
}