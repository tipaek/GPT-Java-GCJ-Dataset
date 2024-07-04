
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static Map<Integer, BigInteger> rowAndSum = new HashMap<>();

    public static Map<Integer, List<BigInteger>> getPascalTri() {
        Map<Integer, List<BigInteger>> ret = new HashMap<>();
        for (int i = 1; i <= 500; i++) {
            List<BigInteger> row = new ArrayList<>();
            BigInteger lastSum = new BigInteger("0");
            BigInteger sum = new BigInteger("0");
            if (i > 2) {
                row.add(new BigInteger("1"));
                List<BigInteger> lastRow = ret.get(i - 1);
                for (int j = 0; j < lastRow.size() - 1; j++) {
                    BigInteger newValue = lastRow.get(j).add(lastRow.get(j + 1));
                    row.add(newValue);
                }
                row.add(new BigInteger("1"));

                sum.add(new BigInteger("2"));
            } else {
                if (i == 1) {
                    row.add(new BigInteger("1"));
                    sum = new BigInteger("1");
                } else if (i == 2) {
                    row.add(new BigInteger("1"));
                    row.add(new BigInteger("1"));
                    sum = new BigInteger("2");
                }
            }
            if (i > 1) {
                lastSum = rowAndSum.get(i - 1);
            }
            sum= row.stream() .reduce(BigInteger::add) .get();
            rowAndSum.put(i, lastSum.add(sum));
            ret.put(i, row);
        }
        return ret;
    }

    public static String writeStepMatrix(Map<Integer, List<BigInteger>> pascalTri, int rowNumber) {
        String ret = "1 1";
        for (int i = 2; i <= rowNumber; i++) {
            List<BigInteger> row = pascalTri.get(i);
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
        Map<Integer, List<BigInteger>> pascalTri = getPascalTri();

        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int N = in.nextInt();

            BigInteger nBig = new BigInteger(N + "");

            String res = "Case #" + t + ":\n";
            int lastOnRow = -1;
            String addStep = "";
            for (int rowNumber = 1; rowNumber <= 500; rowNumber++) {
                if (nBig.compareTo(rowAndSum.get(rowNumber)) < 0) {
                    lastOnRow = rowNumber - 1;
                    BigInteger leftN = nBig.subtract(rowAndSum.get(rowNumber - 1));
                    BigInteger leftTemp = nBig.subtract(rowAndSum.get(rowNumber - 1));
                    List<BigInteger> row = pascalTri.get(rowNumber);
                    int stop = -1;
                    for (int i = 0; i < row.size(); i++) {
                        leftTemp.subtract(row.get(i));
                        if (leftTemp.compareTo(new BigInteger("0")) < 0) {
                            stop = i;
                            break;
                        }
                    }

                    if (leftTemp.compareTo(new BigInteger("0")) < 0) {
                        while (leftN.compareTo(new BigInteger("0")) > 0) {
                            if (lastOnRow % 2 != 0) {
                                addStep += "\n" + rowNumber + " " + 1;
                            } else {
                                addStep += "\n" + rowNumber + " " + pascalTri.get(rowNumber).size();
                            }
                            leftN.subtract(new BigInteger("1"));
                            rowNumber++;
                        }
                    } else {
                        for (int j = 0; j < row.size(); j++) {
                            if (lastOnRow % 2 != 0) {
                                addStep += "\n" + rowNumber + " " + (j + 1);
                            } else {
                                addStep += "\n" + rowNumber + " " + (row.size() - j);
                            }
                            if (stop == j) {
                                break;
                            }
                        }
                    }
                    break;
                } else if (nBig.compareTo(rowAndSum.get(rowNumber)) == 0) {
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
