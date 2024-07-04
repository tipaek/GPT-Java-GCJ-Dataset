
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int inputCount = scanner.nextInt();

        for (int c = 0; c < inputCount; c++) {
            int N = scanner.nextInt();

            System.out.print("Case #" + (c + 1) + ":");

            long sum = 0;
            long dR = 0;
            long dC = 0;

            Map<Integer, Set<Integer>> columnTrack = new HashMap<>();
            Set<Integer> duplicateFoundInColumn = new HashSet<>();

            for (int i = 0; i < N; i++) {

                boolean foundInRow = false;
                Set<Integer> rowTrack = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    int M = scanner.nextInt();
                    if (i == j) {
                        sum += M;
                    }

                    if (columnTrack.containsKey(j)) {
                        if (columnTrack.get(j).contains(M)) {
                            if (!duplicateFoundInColumn.contains(j)) {
                                dC++;
                                duplicateFoundInColumn.add(j);
                            }
                        } else {
                            columnTrack.get(j).add(M);
                        }
                    }else {
                        Set<Integer> columnTrackMicro = new HashSet<>();
                        columnTrackMicro.add(M);
                        columnTrack.put(j,columnTrackMicro);
                    }

                    if (!foundInRow) {
                        if (rowTrack.contains(M)) {
                            foundInRow = true;
                            dR++;
                        } else {
                            rowTrack.add(M);
                        }
                    }
                }
            }
            System.out.print(" " + sum + " " + dR + " " + dC);
            System.out.println();
        }

    }
}
