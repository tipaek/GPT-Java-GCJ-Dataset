import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Solution {



    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String result = solve(in);

            System.out.println(String.format("Case #%d: %s", i, result));
        }

    }

    private static String solve(Scanner in) {
        int U = Integer.parseInt(in.nextLine());
        Set<Character> letters = new HashSet<>();
        Map<String, String> input = new HashMap<>();


        for (int i = 0; i < 10000; i++) {
            String[] line = in.nextLine().split(" ");
            String R = line[1];
            input.put(line[0], R);
            for (char c : R.toCharArray()) {
                letters.add(c);
            }
        }

        Set<Character> potZero = new HashSet<>(letters);

        for (String s : input.values()) {
            potZero.remove(s.charAt(0));
        }

        if(potZero.size() != 1) throw new RuntimeException();

        Map<Character, Integer> highest = new HashMap<>();
        for (Character letter : letters) {
            highest.put(letter, 9);
        }

        highest.put(potZero.iterator().next(), 0);

        for (Map.Entry<String, String> entry : input.entrySet()) {
            String M = entry.getKey();
            String s = entry.getValue();

            if(M.length() == s.length()){
                char firstR = s.charAt(0);
                int h = highest.get(firstR);
                int firstDigit = Character.getNumericValue(M.charAt(0));
                if(firstDigit < h){
                    highest.put(firstR, firstDigit);
                }

            }
        }

        Map<Character, Integer> freq = new HashMap<>();
        for (String s : input.values()) {
            char firstR = s.charAt(0);
            if(s.length() == U){
                freq.compute(firstR, (k, v) -> (v==null) ? 1 : v+1);
            }
        }

        LinkedHashMap<Character, Integer> sortedFreq = sortByValue(freq, false);
        List<Character> order = new ArrayList<>(sortedFreq.keySet());

        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(highest.entrySet());
        list.sort(new MyComparator(order, potZero));





        return list.stream().map(e -> "" + e.getKey()).collect(Collectors.joining());





    }

    private static class MyComparator implements Comparator<Map.Entry<Character, Integer>>{
        private final Set<Character> potZero;
        List<Character> order;


        public MyComparator(List<Character> order, Set<Character> potZero){
            this.order = order;
            this.potZero = potZero;
        }


        @Override
        public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
            if(!o1.getValue().equals(o2.getValue())){
                return o1.getValue() - o2.getValue();

            }
            Character l1 = o1.getKey();
            Character l2 = o2.getKey();
            if(potZero.contains(l1)) return 1;
            if(potZero.contains(l2)) return 2;
            if(order.indexOf(l1) < order.indexOf(l2)) return l1; else return l2;
        }
    }

    public static <K, V extends Comparable<? super V>> LinkedHashMap<K, V> sortByValue(Map<K, V> map, boolean ascending) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<K, V>> comparator = ascending ? Map.Entry.comparingByValue() : Collections.reverseOrder(Map.Entry.comparingByValue());
        list.sort(comparator);

        LinkedHashMap<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public static int[] lineToInt(String line, String regex) {
        return Stream.of(line.split(regex)).mapToInt(Integer::parseInt).toArray();
    }

    public static int[] lineToInt(String line) {
        return lineToInt(line, " ");
    }
}