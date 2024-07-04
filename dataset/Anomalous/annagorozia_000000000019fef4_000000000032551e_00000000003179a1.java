import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {

    static class Pair {
        Long num;
        String val;

        public Pair(Long num, String val) {
            this.num = num;
            this.val = val;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input.txt");
        Scanner scanner = new Scanner(inputFile);

        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < testCases; i++) {
            int u = scanner.nextInt();
            PriorityQueue<Pair> priorityQueue = initializePriorityQueue(scanner);
            Character[] result = new Character[10];
            Set<Character> charSet = new HashSet<>();

            processQueue(priorityQueue, result, charSet);
            printResult(i, result);
        }

        scanner.close();
    }

    private static PriorityQueue<Pair> initializePriorityQueue(Scanner scanner) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Comparator.comparing(o -> o.num));
        for (int j = 0; j < 10000; j++) {
            priorityQueue.add(new Pair(scanner.nextLong(), scanner.nextLine().trim()));
        }
        return priorityQueue;
    }

    private static void processQueue(PriorityQueue<Pair> priorityQueue, Character[] result, Set<Character> charSet) {
        while (!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.poll();
            if (pair.num / 10 == 0 && result[Math.toIntExact(pair.num)] != null) continue;

            if (pair.num == 1) {
                result[1] = pair.val.charAt(0);
                charSet.add(pair.val.charAt(0));
                continue;
            }

            if (pair.num / 10 == 0 && notEqualToOthers(result, pair.val, pair.num)) {
                charSet.add(pair.val.charAt(0));
                result[Math.toIntExact(pair.num)] = pair.val.charAt(0);
                continue;
            }

            assignFirstUnusedCharacter(pair, result, charSet);
        }
    }

    private static void assignFirstUnusedCharacter(Pair pair, Character[] result, Set<Character> charSet) {
        for (char c : pair.val.toCharArray()) {
            if (!charSet.contains(c)) {
                result[0] = c;
                break;
            }
        }
    }

    private static boolean notEqualToOthers(Character[] result, String val, Long num) {
        for (int i = 0; i < num; i++) {
            if (result[i] != null && val.charAt(0) == result[i]) {
                return false;
            }
        }
        return true;
    }

    private static void printResult(int testCaseIndex, Character[] result) {
        StringBuilder resultString = new StringBuilder();
        for (Character c : result) {
            resultString.append(c);
        }
        System.out.println("Case #" + (testCaseIndex + 1) + ": " + resultString);
    }
}