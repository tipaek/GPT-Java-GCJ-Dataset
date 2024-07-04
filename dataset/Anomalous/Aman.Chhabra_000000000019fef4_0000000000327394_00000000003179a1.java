import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<String> results = new ArrayList<>();
        
        while (testCases-- > 0) {
            int u = scanner.nextInt();
            int totalRecords = 10000;
            List<Record> records = new ArrayList<>();
            
            for (int i = 0; i < totalRecords; i++) {
                records.add(new Record(scanner.next(), scanner.next()));
            }
            
            String distinctDigits = records.stream()
                                           .map(record -> record.randomString)
                                           .reduce(Solution::mergeDistinctChars)
                                           .orElse("");
                                           
            records = records.stream()
                             .filter(record -> record.i.length() == 1 && Integer.valueOf(record.i) <= 9)
                             .collect(Collectors.toList());
                             
            List<RandomDigit> randomDigits = distinctDigits.chars()
                                                           .mapToObj(c -> new RandomDigit((char) c))
                                                           .collect(Collectors.toList());
                                                           
            List<Character> nonZeroDigits = records.stream()
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
                            randomDigit.isConfirmed = true;
                            randomDigit.possible = List.of(0);
                        });
                        
            randomDigits.forEach(randomDigit -> randomDigit.removePossibility(0));
            results.add(solveProblem(randomDigits, records));
        }
        
        int caseNumber = 1;
        for (String result : results) {
            System.out.println("Case #" + caseNumber++ + ": " + result);
        }
    }

    private static String solveProblem(List<RandomDigit> randomDigits, List<Record> records) {
        records.forEach(record -> {
            char firstChar = record.randomString.charAt(0);
            randomDigits.stream()
                        .filter(randomDigit -> randomDigit.digit.equals(firstChar))
                        .forEach(randomDigit -> randomDigit.checkPossibility(Integer.valueOf(record.i), randomDigits));
        });
        
        return randomDigits.stream()
                           .sorted(Comparator.comparingInt(rd -> rd.possible.get(0)))
                           .map(rd -> rd.digit.toString())
                           .collect(Collectors.joining());
    }

    private static String mergeDistinctChars(String s1, String s2) {
        StringBuilder result = new StringBuilder(s1);
        for (char c : s2.toCharArray()) {
            if (result.indexOf(String.valueOf(c)) == -1) {
                result.append(c);
            }
        }
        return result.toString();
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

        public boolean checkPossibility(int i, List<RandomDigit> randomDigits) {
            if (i == 9) return false;
            IntStream.rangeClosed(i + 1, 9).boxed().forEach(this::removePossibility);
            if (isConfirmed) {
                randomDigits.forEach(rd -> rd.removePossibility(possible.get(0)));
            }
            return isConfirmed;
        }

        public boolean removePossibility(Integer i) {
            if (isConfirmed) return true;
            possible.remove(i);
            if (possible.size() == 1) {
                isConfirmed = true;
            }
            return isConfirmed;
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