import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static boolean debug = false;

    private static int N, D;
    private static BigDecimal[] A;

    private static void solveProblem(InputStream instr) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(instr)));
        int testCount = sc.nextInt();
        for (int t = 1; t <= testCount; t++) {
            N = sc.nextInt();
            D = sc.nextInt();
            A = new BigDecimal[N];
            for(int i = 0; i < N; i++){
                A[i] = sc.nextBigDecimal();
            }
            Object result = solveTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static Object solveTestCase() {
        Map<BigDecimal, Integer> map = new HashMap<>();
        int maxCount = 1;
        for(BigDecimal cake: A){
            if(!map.containsKey(cake)){
                map.put(cake, 1);
            }else{
                int existing = map.get(cake);
                map.put(cake, existing + 1);
                maxCount = Math.max(maxCount, existing + 1);
            }
        }
        int answer = 0;
        if(maxCount >= D){
            return "0";
        }
        BigDecimal two = BigDecimal.valueOf(2);
        for(Map.Entry<BigDecimal, Integer> entry: map.entrySet()){
            BigDecimal half = entry.getKey().divide(two);
            Integer value = map.get(half);
            if(value != null){
                return "1";
            }
        }

        return "2";
    }

    private  static Long getMaxKey(Map<Long, Integer> map){
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static String joinValues(List<? extends Object> list, String delim) {
        return list.stream().map(Object::toString).collect(Collectors.joining(delim));
    }

    private static String joinValues(int[] arr, String delim) {
        List<Object> list = new ArrayList<>();
        for (Object value : arr) {
            list.add(value);
        }
        return list.stream().map(Object::toString).collect(Collectors.joining(delim));
    }

    private static int[] readInts(Scanner sc, int N) {
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void printDebug(Object str) {
        if (debug) {
            System.out.println("DEBUG: " + str);
        }
    }

    public static void main(String[] args) throws Exception {
        long currTime = System.currentTimeMillis();
        if (debug) {
            solveProblem(new FileInputStream(new File("input.in")));
            System.out.println("Time: " + (System.currentTimeMillis() - currTime));
        } else {
            solveProblem(System.in);
        }
    }

}
