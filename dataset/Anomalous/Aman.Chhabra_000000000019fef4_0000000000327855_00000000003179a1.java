import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<String> results = new ArrayList<>();

        for (int t = 0; t < testCases; t++) {
            int u = scanner.nextInt();
            int totalRecords = 10000;
            List<Record> records = new ArrayList<>();

            for (int j = 0; j < totalRecords; j++) {
                records.add(new Record(scanner.next(), scanner.next()));
            }

            String distinctDigits = records.stream()
                    .map(record -> record.randomString)
                    .reduce(Solution::combineUniqueCharacters)
                    .orElse("");

            List<Record> filteredRecords = records.stream()
                    .filter(record -> record.i.length() == 1 && Integer.parseInt(record.i) <= 9)
                    .collect(Collectors.toList());

            List<RandomDigit> randomDigits = distinctDigits.chars()
                    .mapToObj(c -> new RandomDigit((char) c))
                    .collect(Collectors.toList());

            List<Character> nonZeroDigits = filteredRecords.stream()
                    .map(record -> record.randomString)
                    .reduce(String::concat)
                    .orElse("")
                    .chars()
                    .mapToObj(c -> (char) c)
                    .distinct()
                    .collect(Collectors.toList());

            randomDigits.stream()
                    .filter(randomDigit -> !nonZeroDigits.contains(randomDigit.digit))
                    .forEach(randomDigit -> {
                        randomDigit.confirmDigit(0);
                    });

            randomDigits.forEach(randomDigit -> randomDigit.removePossibility(0));

            results.add(solve(randomDigits, filteredRecords));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    private static String solve(List<RandomDigit> randomDigits, List<Record> records) {
        records.forEach(record -> {
            randomDigits.stream()
                    .filter(randomDigit -> randomDigit.digit.equals(record.randomString.charAt(0)))
                    .forEach(randomDigit -> randomDigit.checkAndUpdatePossibility(Integer.parseInt(record.i), randomDigits));
        });

        return randomDigits.stream()
                .sorted(Comparator.comparingInt(o -> o.possible.get(0)))
                .map(randomDigit -> randomDigit.digit.toString())
                .collect(Collectors.joining());
    }

    private static String combineUniqueCharacters(String s1, String s2) {
        StringBuilder sb = new StringBuilder(s1);

        for (char c : s2.toCharArray()) {
            if (sb.indexOf(String.valueOf(c)) == -1) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    static class RandomDigit {
        Character digit;
        boolean isConfirmed;
        List<Integer> possible;

        public RandomDigit(Character digit) {
            this.digit = digit;
            this.isConfirmed = false;
            this.possible = IntStream.rangeClosed(0, 9).boxed().collect(Collectors.toList());
        }

        public void confirmDigit(int value) {
            this.isConfirmed = true;
            this.possible = Collections.singletonList(value);
        }

        public boolean checkAndUpdatePossibility(int value, List<RandomDigit> randomDigits) {
            if (value == 9) return false;

            IntStream.rangeClosed(value + 1, 9).forEach(this::removePossibility);

            if (isConfirmed) {
                randomDigits.forEach(randomDigit -> randomDigit.removePossibility(this.possible.get(0)));
            }

            return isConfirmed;
        }

        public boolean removePossibility(int value) {
            if (isConfirmed) return true;

            possible.remove(Integer.valueOf(value));

            if (possible.size() == 1) {
                isConfirmed = true;
                return true;
            }

            return false;
        }

        @Override
        public String toString() {
            return "RandomDigit{" +
                    "digit=" + digit +
                    ", isConfirmed=" + isConfirmed +
                    ", possible=" + possible +
                    '}';
        }
    }

    static class Record {
        String i;
        String randomString;

        public Record(String i, String randomString) {
            this.i = i;
            this.randomString = randomString;
        }
    }
}