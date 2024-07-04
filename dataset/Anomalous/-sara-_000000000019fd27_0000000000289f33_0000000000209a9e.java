import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static int nbQueries = 0;
    private static int b;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        b = in.nextInt();

        for (int i = 0; i < t; i++) {
            nbQueries = 0;
            Integer[] storedData = new Integer[b];
            for (int j = 0; j < 5; j++) {
                query(j + 1, storedData, in);
                query(b - j, storedData, in);
            }

            boolean finished = false;
            while (!finished) {
                int fluctuation = determineFluctuation(storedData, in);
                storedData = applyFluctuation(storedData, fluctuation);

                int k = 0;
                while (nbQueries % 10 != 0 && !finished) {
                    while (k < b && storedData[k] != null) {
                        k++;
                    }

                    if (k == b) {
                        finished = true;
                        System.out.println(Arrays.toString(storedData).replace("[", "").replace(", ", "").replace("]", ""));
                        String verdict = in.next();
                        if (verdict.equals("N")) {
                            return;
                        }
                    } else {
                        query(k + 1, storedData, in);
                        if (nbQueries % 10 != 0 && storedData[b - 1 - k] == null) {
                            query(b - k, storedData, in);
                        }
                    }
                }
            }
        }
        in.close();
    }

    private static void query(int j, Integer[] storedData, Scanner in) {
        System.out.println(j);
        storedData[j - 1] = in.nextInt();
        nbQueries++;
    }

    private static int determineFluctuation(Integer[] storedData, Scanner in) {
        System.out.println(1);
        int newValueOne = in.nextInt();
        nbQueries++;

        int indexTwo = -1;
        int newValueTwo = -1;

        if (storedData[0].equals(storedData[b - 1])) {
            for (int j = 1; j < b / 2; j++) {
                if (storedData[j] == null || storedData[j].equals(storedData[b - 1 - j])) {
                    continue;
                } else {
                    System.out.println(j + 1);
                    newValueTwo = in.nextInt();
                    nbQueries++;
                    indexTwo = j;
                    break;
                }
            }

            if (newValueOne == storedData[0]) {
                if (indexTwo == -1 || newValueTwo == storedData[indexTwo]) {
                    return 4; // unchanged
                } else {
                    return 2; // reversed
                }
            } else {
                if (indexTwo != -1 && newValueTwo == storedData[indexTwo]) {
                    return 3; // reversed and complemented
                } else {
                    return 1; // complemented
                }
            }
        } else {
            for (int j = 1; j < b / 2; j++) {
                if (storedData[j] == null || !storedData[j].equals(storedData[b - 1 - j])) {
                    continue;
                } else {
                    System.out.println(j + 1);
                    newValueTwo = in.nextInt();
                    nbQueries++;
                    indexTwo = j;
                    break;
                }
            }

            if (newValueOne == storedData[0]) {
                if (indexTwo != -1 && newValueTwo == storedData[indexTwo]) {
                    return 4; // unchanged
                } else {
                    return 3; // reversed and complemented
                }
            } else {
                if (indexTwo == -1 || newValueTwo == storedData[indexTwo]) {
                    return 2; // reversed
                } else {
                    return 1; // complemented
                }
            }
        }
    }

    private static Integer[] applyFluctuation(Integer[] storedData, int fluctuation) {
        switch (fluctuation) {
            case 1:
                for (int j = 0; j < b; j++) {
                    storedData[j] = storedData[j] == 0 ? 1 : 0;
                }
                break;
            case 2:
                for (int j = 0; j < b / 2; j++) {
                    Integer temp = storedData[b - 1 - j];
                    storedData[b - 1 - j] = storedData[j];
                    storedData[j] = temp;
                }
                break;
            case 3:
                for (int j = 0; j < b / 2; j++) {
                    Integer temp = storedData[b - 1 - j];
                    storedData[b - 1 - j] = storedData[j];
                    storedData[j] = temp;
                }
                for (int j = 0; j < b; j++) {
                    storedData[j] = storedData[j] == 0 ? 1 : 0;
                }
                break;
            case 4:
                break;
        }
        return storedData;
    }
}