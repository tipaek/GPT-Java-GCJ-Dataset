import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static int nbQueries = 0;
    private static int b;

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt(); 
            b = in.nextInt();
            for (int i = 1; i <= t; ++i) {
                nbQueries = 0;
                Integer[] storedData = new Integer[b];
                initializeStoredData(storedData, in);
                boolean finished = false;
                while (!finished) {
                    int fluctuation = determineFluctuation(storedData, in);
                    storedData = applyFluctuation(storedData, fluctuation);
                    finished = processStoredData(storedData, in);
                }
            }
        }
    }

    private static void initializeStoredData(Integer[] storedData, Scanner in) {
        for (int j = 1; j <= 5; j++) {
            query(j, storedData, in);
            query(b + 1 - j, storedData, in);
        }
    }

    private static boolean processStoredData(Integer[] storedData, Scanner in) {
        boolean finished = false;
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
                    return true;
                }
            } else {
                query(k + 1, storedData, in);
                if (nbQueries % 10 != 0 && storedData[b - 1 - k] == null) {
                    query(b - k, storedData, in);
                }
            }
        }
        return finished;
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
        int newValueTwo = -1;
        int indexTwo = -1;

        if (storedData[0].equals(storedData[b - 1])) {
            indexTwo = findIndexForComparison(storedData, in, newValueOne, true);
            newValueTwo = indexTwo != -1 ? in.nextInt() : -1;
            nbQueries += indexTwo != -1 ? 1 : 0;
            return getFluctuationType(storedData, newValueOne, newValueTwo, indexTwo, true);
        } else {
            indexTwo = findIndexForComparison(storedData, in, newValueOne, false);
            newValueTwo = indexTwo != -1 ? in.nextInt() : -1;
            nbQueries += indexTwo != -1 ? 1 : 0;
            return getFluctuationType(storedData, newValueOne, newValueTwo, indexTwo, false);
        }
    }

    private static int findIndexForComparison(Integer[] storedData, Scanner in, int newValueOne, boolean isEqual) {
        for (int j = 1; j < b / 2; j++) {
            if (storedData[j] != null && (isEqual ? storedData[j].equals(storedData[b - 1 - j]) : !storedData[j].equals(storedData[b - 1 - j]))) {
                System.out.println(j + 1);
                return j;
            }
        }
        return -1;
    }

    private static int getFluctuationType(Integer[] storedData, int newValueOne, int newValueTwo, int indexTwo, boolean isEqual) {
        if (newValueOne == storedData[0]) {
            if (indexTwo == -1 || newValueTwo == storedData[indexTwo]) {
                return isEqual ? 4 : 3;
            } else {
                return isEqual ? 2 : 1;
            }
        } else {
            if (indexTwo == -1 || newValueTwo == storedData[indexTwo]) {
                return isEqual ? 1 : 2;
            } else {
                return isEqual ? 3 : 4;
            }
        }
    }

    private static Integer[] applyFluctuation(Integer[] storedData, int fluctuation) {
        switch (fluctuation) {
            case 1:
                complementData(storedData);
                break;
            case 2:
                reverseData(storedData);
                break;
            case 3:
                reverseData(storedData);
                complementData(storedData);
                break;
            case 4:
                break;
        }
        return storedData;
    }

    private static void complementData(Integer[] storedData) {
        for (int j = 0; j < b; j++) {
            if (storedData[j] != null) {
                storedData[j] = storedData[j] == 0 ? 1 : 0;
            }
        }
    }

    private static void reverseData(Integer[] storedData) {
        for (int j = 0; j < b / 2; j++) {
            Integer temp = storedData[b - 1 - j];
            storedData[b - 1 - j] = storedData[j];
            storedData[j] = temp;
        }
    }
}