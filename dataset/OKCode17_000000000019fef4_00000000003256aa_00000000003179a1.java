import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class Solution {

    Scanner             sc       = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    PrintStream         out      = System.out;

    private void solve() {
        int U = sc.nextInt();
        int bound = getBound(U);
        Map<Integer, Map<String, Integer>> map = new TreeMap<>();
        Map<Integer, Map<Character, Integer>> resultMap = new HashMap<>();
        for(int i=0;i<10;i++){
            resultMap.put(i, new HashMap<>());
            for(int j=0;j<26;j++) {
                resultMap.get(i).put((char) ('a' + j), 0);
            }
        }
        for(int i=0;i<10000;i++){
            int num = sc.nextInt();
            String s = sc.next();
            map.putIfAbsent(num, new HashMap());
            Map<String, Integer> counterMap = map.get(num);
            counterMap.put(s, counterMap.getOrDefault(s, 0) + 1);
        }
        for(int key : map.keySet()){
            Map<String, Integer> val = map.get(key);
            sortByValue(val);
            for(String s : val.keySet()){
                int len = findBase(key);
                if(s.length()<len){
                    continue;
                };
                int d = key;
                int position = 0;
                while(d>0){
                    int digit = d%10;
                    char c = s.charAt(s.length() - 1 - (position++));
                    int start = 0;
                    if(d/10==0){
                        start = 1;
                    }
                    for(int i=start;i<=digit;i++) {
                        Map<Character, Integer> resultM = resultMap.get(i);
                        resultM.put(c, resultM.getOrDefault(c, 0) + 1);
                    }
                    d = d/10;
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for(int i=0;i<10;i++){
            Map<Character, Integer> m = resultMap.get(i);
            char rst = ' ';
            int max = Integer.MIN_VALUE;
            for(char c : m.keySet()){
                if(set.contains(c)){
                    continue;
                }
                if(m.get(c)>max){
                    max = m.get(c);
                    rst = c;
                }
            }
            set.add(rst);
            sb.append(rst);
        }
        out.println(sb.toString());
    }

    public static int findBase(int num){
        int base = 1;
        for(int i=1;i<16;i++){
            base *= 10;
            if(num/base==0){
                return i;
            }
        }
        return 1;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> unsortMap) {

        List<Map.Entry<K, V>> list =
                new LinkedList<Map.Entry<K, V>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;

    }

    class ValueComparator implements Comparator {
        Map map;

        public ValueComparator(Map map) {
            this.map = map;
        }

        public int compare(Object keyA, Object keyB) {
            Comparable valueA = (Comparable) map.get(keyA);
            Comparable valueB = (Comparable) map.get(keyB);
            return valueB.compareTo(valueA);
        }
    }

    private int getBound(int U) {
        int base = 1;
        for(int i=0;i<U;i++){
            base *= 10;
        }
        return base;
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            solve();
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }


}
