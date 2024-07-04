import java.util.*;

public class Solution {
    public static Map<String, Integer[]> map;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();

        String []res = new String[cases];
        for (int i = 1; i <= cases; i++) {
            map = new HashMap<>();
            int ul = in.nextInt();

            for(int j = 0; j < 10000; j++) {
                String number = in.next();
                String rep = in.next();
                populate(number, rep);
            }

            StringBuilder rst = new StringBuilder("");
            for(int j = 0; j < 10; j++) {
                rst.append(getChar(map.get(String.valueOf(j))));
            }

            res[i-1] = "Case #"+i+": "+rst.toString();
        }
        in.close();
        for (String s: res) {
            System.out.println(s);
        }
    }

    public static void populate(String number, String representation){
        Random r = new Random();

        while (number.length()>representation.length()) {
            char c = (char)(r.nextInt(26) + 'A');
            representation = representation+c;
        }
        while (number.length()<representation.length()){
            number = number + r.nextInt(9) ;
        }
        for(int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if(map.containsKey(c)){
                Integer[] counts = map.get(c);
                counts[representation.charAt(i)-'A']++;
                map.put(String.valueOf(c), counts);
            } else {
                Integer[] counts = new Integer[26];
                Arrays.fill(counts, 0);
                counts[representation.charAt(i)-'A']++;
                map.put(String.valueOf(c), counts);
            }
        }
    }

    public static char getChar(Integer[] arr) {
        int max = Integer.MIN_VALUE;
        int maxInd = 0;
        if(arr != null) {
            for(int i = 0; i <arr.length; i++) {
                if(arr[i] > max) {
                    max = arr[i];
                    maxInd = i;
                }
            }

        }
        return (char) ('A'+maxInd);
    }
}
