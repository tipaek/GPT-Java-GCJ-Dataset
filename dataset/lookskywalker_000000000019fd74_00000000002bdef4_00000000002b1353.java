
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static Map<Integer, Long> rowAndSum = new HashMap<>();

    public static Map<Integer, List<Integer>> getPascalTri() {
        Map<Integer, List<Integer>> ret = new HashMap<>();
        for (int i = 1; i <= 500; i++) {
            List<Integer> row = new ArrayList<>();
            long lastSum = 0;
            if (i > 2) {
                row.add(1);
                List<Integer> lastRow = ret.get(i - 1);
                for (int j = 0; j < lastRow.size() - 1; j++) {
                    row.add(lastRow.get(j) + lastRow.get(j + 1));
                }
                row.add(1);
            } else {
                if (i == 1) {
                    row.add(1);
                } else if (i == 2) {
                    row.add(1);
                    row.add(1);
                }
            }
            int sum = row.stream().mapToInt(Integer::intValue).sum();
            if (i > 1) {
                lastSum = rowAndSum.get(i - 1);
            }
            rowAndSum.put(i, lastSum + sum);
            ret.put(i, row);
        }
        return ret;
    }

    public static String writeStepMatrix(Map<Integer, List<Integer>> pascalTri, int rowNumber) {
        String ret = "1 1";
        for (int i = 2; i <= rowNumber; i++) {
            List<Integer> row = pascalTri.get(i);
            for (int j = 0; j < row.size(); j++) {
                if (i % 2 == 0) {
                    ret += "\n" + i + " " + (j + 1);
                } else {
                    ret += "\n" + i + " " + (row.size() - j);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> pascalTri = getPascalTri();

        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int N = in.nextInt();

            String res = "Case #" + t + ":\n";
            int lastOnRow = -1;
            String addStep = "";
            for (int rowNumber = 1; rowNumber <= 500; rowNumber++) {
                if (N < rowAndSum.get(rowNumber)) {
                    lastOnRow = rowNumber - 1;
                    long leftN = N - rowAndSum.get(rowNumber - 1);
                    long leftTemp = N - rowAndSum.get(rowNumber - 1);
                    List<Integer> row = pascalTri.get(rowNumber);
                    int stop = -1;
                    for (int i = 0; i < row.size(); i++) {
                        leftTemp -= row.get(i);
                        if (leftTemp <= 0) {
                            stop = i;
                            break;
                        }
                    }

                    if (leftTemp < 0) {
                        while (leftN > 0) {
                            if (lastOnRow % 2 != 0) {
                                addStep += "\n" + rowNumber + " " + 1;
                            } else {
                                addStep += "\n" + rowNumber + " " + pascalTri.get(rowNumber).size();
                            }
                            leftN--;
                            rowNumber++;
                        }
                    } else {
                        for (int j = 0; j < row.size(); j++) {
                            if (lastOnRow % 2 != 0) {
                                addStep += "\n" + rowNumber + " " + (j + 1);
                            } else {
                                addStep += "\n" + rowNumber + " " + (row.size() - j);
                            }
                            if (stop==j){
                                break;
                            }
                        }
                    }
                    break;
                } else if (N == rowAndSum.get(rowNumber)) {
                    lastOnRow = rowNumber;
                    break;
                } else {
                    continue;
                }
            }

            res += writeStepMatrix(pascalTri, lastOnRow) + addStep;

            System.out.println(res);
        }
    }
}
