import java.io.*;
import java.util.*;

public class Solution {

    private static final boolean DEBUG = false;

    private static int numberOfBits;

    private static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    //private static BufferedWriter writer;

    /*static {
        try {
            writer = new BufferedWriter(new FileWriter("resources/qualification/esab/output.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static String solve() {
        int numberOfQueries = 0;
        int lastBitAsked = numberOfBits;
        int lastResult = -1;

        int equalPairIndex = -1;
        int currentEqualLeft = -1;

        int dPairIndex = -1;
        int currentdPairLeft = -1;

        int[] resultArray = new int[numberOfBits];
        for (int i : resultArray) {
            resultArray[i] = -1;
        }


        while (numberOfQueries <= 150) {


            if (numberOfQueries % 10 == 0 && numberOfQueries != 0) {

                int shuffleMode = -1;


                if (equalPairIndex != -1 && dPairIndex != -1) {
                    int queryEQ = query(equalPairIndex);
                    int queryDP = query(dPairIndex);

                    numberOfQueries += 2;

                    shuffleMode = determineFlippingMode(queryEQ == currentEqualLeft, queryDP == currentdPairLeft);
                    currentEqualLeft = queryEQ;
                    currentdPairLeft = queryDP;
                } else if (equalPairIndex == -1 && dPairIndex != -1) {
                    int queryDP = query(dPairIndex);

                    numberOfQueries++;
                    if (currentdPairLeft == queryDP) {
                        shuffleMode = 4;
                    } else {
                        shuffleMode = 1;
                    }
                    currentdPairLeft = queryDP;
                } else if (equalPairIndex != -1) {
                    int queryEQ = query(equalPairIndex);
                    numberOfQueries++;
                    if (currentEqualLeft == queryEQ) {
                        shuffleMode = 4;
                    } else {
                        shuffleMode = 2;
                    }
                    currentEqualLeft = queryEQ;

                } else {
                    shuffleMode = 4;
                }
                resultArray = shuffle(shuffleMode, resultArray);

            } else {

                int nextAsk = numberOfBits - lastBitAsked;

                if (nextAsk > lastBitAsked) {
                    nextAsk--;

                } else if (nextAsk == lastBitAsked) {
                    return "NN";
                }

                int qResult = query(nextAsk);


                if (nextAsk > lastBitAsked) {
                    if (equalPairIndex != -1 && lastResult == qResult) {
                        equalPairIndex = nextAsk;
                        currentEqualLeft = qResult;
                    } else if (dPairIndex != -1 && lastResult != qResult) {
                        dPairIndex = nextAsk;
                        currentdPairLeft = qResult;
                    }
                }


                numberOfQueries++;
                resultArray[nextAsk] = qResult;
                lastBitAsked = nextAsk;
                lastResult = qResult;


            }


            String solveResult = solve(resultArray);
            if (solveResult != "U") {
                return solveResult;
            }

        }


        return "UU";
    }


    public static int[] shuffle(int mode, int[] array) {
        if (mode == 1) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != -1) {
                    array[i] = (array[i] - 1) * -1;
                }
            }
            return array;
        } else if (mode == 2) {
            for (int i = 0; i < array.length / 2; i++) {
                int temp = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] = temp;
            }
            return array;
        } else if (mode == 3) {
            return shuffle(1, shuffle(2, array));
        } else {
            return array;
        }
    }


    public static int query(int bit) {
        System.out.println(bit);
        System.out.flush();
        return Integer.parseInt(readFromJudge());
    }

    public static String solve(int[] bit) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bit.length; i++) {
            if (bit[i] == -1) {
                return "U";
            }
            sb.append(bit[i]);
        }
        System.out.println(sb.toString());
        System.out.flush();

        return readFromJudge();
    }

    public static String readFromJudge() {
        return in.nextLine();
    }


    public static int determineFlippingMode(boolean eqPeq, boolean dfPeq) {
        if (eqPeq && dfPeq) {
            return 4;
        } else if (eqPeq && !dfPeq) {
            return 2;
        } else if (!eqPeq && dfPeq) {
            return 3;
        } else if (!eqPeq && !dfPeq) {
            return 1;
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {
        //writer.write("test");
        InputStream is = DEBUG ? new FileInputStream("resources/qualification/esab/input.txt") : System.in;
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)))) {

            int t = in.nextInt();
            numberOfBits = in.nextInt();// Scanner has functions to read ints, longs, strings, chars, etc.
            for (int i = 1; i <= t; ++i) {

                String result = solve();
                //writer.write(i + ": " + result + "\n");

                //System.out.println("Case #" + i + ": " + result);
            }
            //writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}