import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static int arrayLength;

    public static void main(String[] args) {
        String firstLine = scanner.nextLine();
        int testCases = Integer.parseInt(firstLine.split(" ")[0]);
        arrayLength = Integer.parseInt(firstLine.split(" ")[1]);

        for (int i = 0; i < testCases; i++) {
            String result = startProcessing();
            System.out.println(result);

            String response = scanner.next();
            if (response.equals("N")) {
                throw new RuntimeException();
            }
        }
    }

    public static String startProcessing() {
        List<Integer> result = new ArrayList<>(arrayLength);
        for (int i = 0; i < arrayLength; i++) {
            result.add(null);
        }

        int equalPairId = -1;
        int diffPairId = -1;
        int requestCount = 1;

        for (int i = 0; i < arrayLength / 2; i++) {
            if (requestCount > 10 && requestCount % 10 == 1) {
                updateArray(result, equalPairId, diffPairId);
                if (equalPairId != -1) {
                    requestCount++;
                }
                if (diffPairId != -1) {
                    requestCount++;
                }
            }

            int firstId = i;
            int secondId = (arrayLength - i - 1);
            int firstValue = getValueAt(firstId);
            requestCount++;
            int secondValue = getValueAt(secondId);
            requestCount++;

            if (firstValue == secondValue && equalPairId == -1) {
                equalPairId = firstId;
            }
            if (firstValue != secondValue && diffPairId == -1) {
                diffPairId = firstId;
            }

            result.set(firstId, firstValue);
            result.set(secondId, secondValue);

            if (!result.contains(null)) {
                String output = "";
                for (Integer item : result) {
                    output += item;
                }

                return output;
            }
        }

        return "";
    }
    public static void updateArray(List<Integer> list, int equalPairId, int diffPairId) {
        if (equalPairId != -1) {
            Integer newValue = getValueAt(equalPairId);
            Integer oldValue = list.get(equalPairId);

            if (!newValue.equals(oldValue)) {
                changeEqualPairs(list);
            }
        }

        if (diffPairId != -1) {
            Integer newValue = getValueAt(diffPairId);
            Integer oldValue = list.get(diffPairId);

            if (!newValue.equals(oldValue)) {
                changeDifferentPairs(list);
            }
        }
    }

    public static void changeEqualPairs(List<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            Integer firstValue = list.get(i);
            Integer secondValue = list.get(list.size() - 1 - i);
            if (firstValue != null && secondValue != null && firstValue.equals(secondValue)) {
                list.set(i, Math.abs(firstValue - 1));
                list.set(list.size() - 1 - i, Math.abs(secondValue - 1));
            }
        }
    }

    public static void changeDifferentPairs(List<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            Integer firstValue = list.get(i);
            Integer secondValue = list.get(list.size() - 1 - i);
            if (firstValue != null && secondValue != null && !firstValue.equals(secondValue)) {
                list.set(i, Math.abs(firstValue - 1));
                list.set(list.size() - 1 - i, Math.abs(secondValue - 1));
            }
        }
    }

    public static int getValueAt(int index) {
        System.out.println(index + 1);
        String response = scanner.next();
        if (response.equals("N")) {
            throw new RuntimeException();
        }
        return Integer.parseInt(response);
    }
}
