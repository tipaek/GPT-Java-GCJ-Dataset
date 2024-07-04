import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<String> resultList = new ArrayList<>();
        while (testCases-- > 0) {
            int u = scanner.nextInt();
            int total = 10000;
            List<Record> records = new ArrayList<>();
            while(total-->0){
                records.add(new Record(scanner.next(), scanner.next()));
            }
            String dDigit = records.stream().map(record -> record.randomString).reduce(Solution::reduceString).get();
            records = records.stream().filter(record -> record.i.length() == 1).filter(record -> Integer.valueOf(record.i) <= 9).collect(Collectors.toList());
            List<RandomDigit> randomDigits = dDigit.chars().mapToObj(c -> (char) c).map(character -> new RandomDigit(character)).collect(Collectors.toList());
            //records.stream().map(record -> record.i +" "+record.randomString).forEach(System.out::println);
            List<Character> nonZeroDigits = records.stream().map(record -> record.randomString).reduce((a,b)-> a.concat(b)).get().chars().mapToObj(c->(char)c).distinct().collect(Collectors.toList());
            randomDigits.stream().filter(randomDigit -> !nonZeroDigits.contains(randomDigit.digit)).forEach(randomDigit -> {
                randomDigit.isConfirmed = true;
                randomDigit.possible = List.of(0);
            });
            randomDigits.forEach(randomDigit1 -> randomDigit1.removePossibility(0));

            resultList.add(solveProblem(randomDigits,records));
        }
        int count = 0;
        for (String result : resultList) {
            System.out.println("Case #" + ++count + ": " + result);
        }
    }

    private static String solveProblem(List<RandomDigit> randomDigits, List<Record> records) {
        records.stream().forEach(record -> randomDigits.stream().filter(randomDigit -> randomDigit.digit.equals(record.randomString.charAt(0))).forEach(randomDigit -> {
            //System.out.println(record.i +" "+record.randomString);
            if(randomDigit.checkPossibility(Integer.valueOf(record.i), randomDigits));
//                randomDigits.forEach(randomDigit1 -> randomDigit1.removePossibility(Integer.valueOf(record.i)));

        }));
        //randomDigits.forEach(System.out::println);
        
        return randomDigits.stream().sorted((o1, o2) -> o1.possible.get(0).compareTo(o2.possible.get(0))).map(randomDigit -> randomDigit.digit).map(character -> character.toString()).reduce((character, character2) -> character.concat(character2)).get();
    }

    private static String reduceString(String s, String s1) {
        if (s.length() == 10) return s;
        for (int i=0;i<s1.length();i++) {
            if(!s.contains(Character.toString(s1.charAt(i))))
                s = s.concat(Character.toString(s1.charAt(i)));
        }
        return s;
    }

//    private static String solveProblem(List<Record> records) {
//
//    }

    static class RandomDigit{
        Character digit;
        boolean isConfirmed;
        List<Integer> possible;

        public RandomDigit(Character digit) {
            this.digit = digit;
            this.isConfirmed = false;
            this.possible = IntStream.rangeClosed(0,9).boxed().collect(Collectors.toList());;
        }

        public boolean checkPossibility(int i, List<RandomDigit> randomDigits){
            if(i==9) return false;
            IntStream.rangeClosed(i+1, 9).boxed().forEach(no -> removePossibility(no));
            if(isConfirmed){
                randomDigits.forEach(randomDigit1 -> randomDigit1.removePossibility(possible.get(0)));
            }
            return isConfirmed;
        }
        public boolean removePossibility(Integer i){
            if(isConfirmed)return isConfirmed;
            possible.remove(i);
            if(possible.size() == 1){
                isConfirmed = true;
               // System.out.println("Confirming" + this.toString());
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
