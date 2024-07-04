import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());
            int D = Integer.parseInt(tokenizer.nextToken());

            tokenizer = new StringTokenizer(reader.readLine());
            if (D == 2) {
                processCaseD2(N, tokenizer, t);
            } else {
                processCaseDGreaterThan2(N, tokenizer, t);
            }
        }
    }

    private static void processCaseD2(int N, StringTokenizer tokenizer, int t) {
        boolean hasDuplicate = false;
        HashSet<Long> uniqueNumbers = new HashSet<>();

        for (int i = 0; i < N; i++) {
            long number = Long.parseLong(tokenizer.nextToken());
            if (uniqueNumbers.contains(number)) {
                hasDuplicate = true;
                break;
            }
            uniqueNumbers.add(number);
        }

        if (hasDuplicate) {
            System.out.println("Case #" + t + ": 0");
        } else {
            System.out.println("Case #" + t + ": 1");
        }
    }

    private static void processCaseDGreaterThan2(int N, StringTokenizer tokenizer, int t) {
        boolean zero = false;
        boolean one = false;
        long max = 0;
        long minOne = Long.MAX_VALUE;
        HashMap<Long, Integer> numberCounts = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long number = Long.parseLong(tokenizer.nextToken());

            if (numberCounts.getOrDefault(number, 0) == 2) {
                zero = true;
                break;
            }

            if (number % 2 == 0 && numberCounts.containsKey(number / 2)) {
                one = true;
            }

            if (numberCounts.containsKey(number * 2)) {
                one = true;
            }

            numberCounts.put(number, numberCounts.getOrDefault(number, 0) + 1);
            if (numberCounts.get(number) == 2) {
                minOne = Math.min(minOne, number);
            }

            max = Math.max(max, number);
        }

        if (zero) {
            System.out.println("Case #" + t + ": 0");
        } else if (one || minOne < max) {
            System.out.println("Case #" + t + ": 1");
        } else {
            System.out.println("Case #" + t + ": 2");
        }
    }
}