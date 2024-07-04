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
            int totalQueries = 10000;
            List<Record> records = new ArrayList<>();
            
            for (int q = 0; q < totalQueries; q++) {
                String digit = scanner.next();
                if (!digit.equals("-1")) {
                    records.add(new Record(digit, scanner.next()));
                }
            }
            
            String distinctChars = records.stream()
                                          .map(record -> record.randomString)
                                          .reduce(Solution::combineDistinctChars)
                                          .orElse("");
                                          
            List<Record> validRecords = records.stream()
                                               .filter(record -> record.i.length() == 1 && Integer.parseInt(record.i) <= 9)
                                               .collect(Collectors.toList());
                                               
            List<RandomDigit> randomDigits = distinctChars.chars()
                                                          .mapToObj(c -> new RandomDigit((char) c))
                                                          .collect(Collectors.toList());
                                                          
            List<Character> nonZeroChars = validRecords.stream()
                                                       .map(record -> record.randomString)
                                                       .collect(Collectors.joining())
                                                       .chars()
                                                       .mapToObj(c -> (char) c)
                                                       .distinct()
                                                       .collect(Collectors.toList());
                                                       
            randomDigits.stream()
                        .filter(rd -> !nonZeroChars.contains(rd.digit))
                        .forEach(rd -> {
                            rd.isConfirmed = true;
                            rd.possible = Collections.singletonList(0);
                        });
                        
            randomDigits.forEach(rd -> rd.removePossibility(0));
            results.add(solve(randomDigits, records));
        }
        
        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    private static String solve(List<RandomDigit> randomDigits, List<Record> records) {
        records.stream()
               .filter(record -> record.i.length() == 1)
               .forEach(record -> {
                   char firstChar = record.randomString.charAt(0);
                   randomDigits.stream()
                               .filter(rd -> rd.digit.equals(firstChar))
                               .forEach(rd -> rd.checkAndRemovePossibilities(Integer.parseInt(record.i), randomDigits));
               });
               
        return randomDigits.stream()
                           .sorted(Comparator.comparingInt(rd -> rd.possible.get(0)))
                           .map(rd -> rd.digit.toString())
                           .collect(Collectors.joining());
    }

    private static String combineDistinctChars(String s1, String s2) {
        StringBuilder combined = new StringBuilder(s1);
        for (char c : s2.toCharArray()) {
            if (combined.indexOf(String.valueOf(c)) == -1) {
                combined.append(c);
            }
        }
        return combined.toString();
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

        public boolean checkAndRemovePossibilities(int number, List<RandomDigit> randomDigits) {
            if (number == 9) return false;
            IntStream.rangeClosed(number + 1, 9).forEach(this::removePossibility);
            if (isConfirmed) {
                randomDigits.forEach(rd -> rd.removePossibility(possible.get(0)));
            }
            return isConfirmed;
        }

        public boolean removePossibility(int number) {
            if (isConfirmed) return true;
            possible.remove((Integer) number);
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