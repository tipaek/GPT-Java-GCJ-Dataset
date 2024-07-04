import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Solution {
    static class Pair<K, V>{
        private K key;
        private V value;
        
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K getKey() {
            return key;
        }
        
        public V getValue() {
            return value;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            
            Pair<?, ?> that = (Pair<?, ?>) o;
    
            return Objects.equals(getKey(), that.getKey())
                   && Objects.equals(getValue(), that.getValue());
        }
        
        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }
    }
    
    public static List<Pair<Integer, Integer>> readHours(final Scanner in, int N) {
        List<Pair<Integer, Integer>> hours = new ArrayList();
        for (int i = 0; i < N; ++i) {
            hours.add(new Pair(in.nextInt(), in.nextInt()));
        }
        return hours;
    }
    
    public static List<Pair<Integer, Integer>> sortHours(List<Pair<Integer, Integer>> hours) {
        List<Pair<Integer, Integer>> sortedHours = new ArrayList();
        for (int i = 0; i < hours.size(); ++i) {
            sortedHours.add(hours.get(i));
        }
        
        Collections.sort(sortedHours, new Comparator<Pair<Integer, Integer>>() {
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                return p1.getValue().compareTo(p2.getValue());
            }
        });
        
        return sortedHours;
    }
    
    public static Map<Pair<Integer, Integer>, Character> schedule(List<Pair<Integer, Integer>> sortedHours) {
        Map<Pair<Integer, Integer>, Character> m = new HashMap();
        
        Pair<Integer, Integer> C = sortedHours.get(0);
        Pair<Integer, Integer> J = null;
        
        m.put(sortedHours.get(0), 'C');
        
        for (int i = 1; i < sortedHours.size(); ++i) {
            if (sortedHours.get(i).getKey() >= C.getValue() ) {
                m.put(sortedHours.get(i), 'C');
                C = sortedHours.get(i);
            } else if (J == null || sortedHours.get(i).getKey() >= J.getValue() ) {
                m.put(sortedHours.get(i), 'J');
                J = sortedHours.get(i);
            } else {
                break;
            }
        }
        
        return m;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; ++i) {
            List<Pair<Integer, Integer>> hours = readHours(in, in.nextInt());
            List<Pair<Integer, Integer>> sortedHours = sortHours(hours);
            Map<Pair<Integer, Integer>, Character> m = schedule(sortedHours);
            
            System.out.printf("Case #%d: ", i + 1);
            if (m.size() != hours.size()) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int j = 0; j < hours.size(); ++j) {
                    System.out.print(m.get(hours.get(j)));
                }
                System.out.println();
            }
        }
    }
}