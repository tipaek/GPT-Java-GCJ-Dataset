import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static int nbQueries = 0;
    private static int b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        b = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            Integer[] storedData = new Integer[b];
            for (int j = 0; j < 5; j++) {
                query(j + 1, storedData, scanner);
                query(b - j, storedData, scanner);
            }

            boolean isCompleted = false;
            while (!isCompleted) {
                int fluctuationType = determineFluctuation(storedData, scanner);
                storedData = applyFluctuation(storedData, fluctuationType);

                int k = 0;
                while (nbQueries % 10 != 0 && !isCompleted) {
                    while (k < b && storedData[k] != null) {
                        k++;
                    }

                    if (k == b) {
                        isCompleted = true;
                        System.out.println(Arrays.toString(storedData).replace("[", "").replace(", ", "").replace("]", ""));
                        String verdict = scanner.next();
                        if (verdict.equals("N")) {
                            return;
                        }
                    } else {
                        query(k + 1, storedData, scanner);
                        if (nbQueries % 10 != 0 && storedData[b - 1 - k] == null) {
                            query(b - k, storedData, scanner);
                        }
                    }
                }
            }
        }
        scanner.close();
    }

    private static void query(int index, Integer[] storedData, Scanner scanner) {
        System.out.println(index);
        storedData[index - 1] = scanner.nextInt();
        nbQueries++;
    }

    private static int determineFluctuation(Integer[] storedData, Scanner scanner) {
        System.out.println(1);
        int newValueOne = scanner.nextInt();
        nbQueries++;

        int newValueTwo = -1;
        int indexTwo = -1;

        if (storedData[0] == storedData[b - 1]) {
            for (int j = 1; j < b / 2; j++) {
                if (storedData[j] != null && storedData[j] != storedData[b - 1 - j]) {
                    System.out.println(j + 1);
                    newValueTwo = scanner.nextInt();
                    nbQueries++;
                    indexTwo = j;
                    break;
                }
            }

            if (newValueOne == storedData[0]) {
                return (indexTwo == -1 || newValueTwo == storedData[indexTwo]) ? 4 : 2;
            } else {
                return (indexTwo != -1 && newValueTwo == storedData[indexTwo]) ? 3 : 1;
            }
        } else {
            for (int j = 1; j < b / 2; j++) {
                if (storedData[j] != null && storedData[j] == storedData[b - 1 - j]) {
                    System.out.println(j + 1);
                    newValueTwo = scanner.nextInt();
                    nbQueries++;
                    indexTwo = j;
                    break;
                }
            }

            if (newValueOne == storedData[0]) {
                return (indexTwo != -1 && newValueTwo == storedData[indexTwo]) ? 4 : 3;
            } else {
                return (indexTwo == -1 || newValueTwo == storedData[indexTwo]) ? 2 : 1;
            }
        }
    }

    private static Integer[] applyFluctuation(Integer[] storedData, int fluctuation) {
        switch (fluctuation) {
            case 1:
                for (int j = 0; j < b; j++) {
                    storedData[j] = (storedData[j] == 0) ? 1 : 0;
                }
                break;
            case 2:
                for (int j = 0; j < b / 2; j++) {
                    int temp = storedData[b - 1 - j];
                    storedData[b - 1 - j] = storedData[j];
                    storedData[j] = temp;
                }
                break;
            case 3:
                for (int j = 0; j < b / 2; j++) {
                    int temp = storedData[b - 1 - j];
                    storedData[b - 1 - j] = storedData[j];
                    storedData[j] = temp;
                }
                for (int j = 0; j < b; j++) {
                    storedData[j] = (storedData[j] == 0) ? 1 : 0;
                }
                break;
            case 4:
                break;
        }
        return storedData;
    }
}