import java.io.*;
import java.util.*;

public class Solution {
    
    private HashMap<Character, Character> confirmedMaps;
    private HashMap<Character, HashSet<Character>> digitMapping;
    
    class Query implements Comparable<Query> {
        String M, R;
        
        public Query(String M, String R) {
            this.M = M;
            this.R = R;
            
            for (int i = 0; i < R.length(); i++) {
                digitMapping.put(R.charAt(i), new HashSet<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9')));
            }
        }
        
        @Override
        public int compareTo(Query q) {
            return M.compareTo(q.M);
        }
    }
    
    public void run() throws Exception {
        Scanner file = new Scanner(new File("input.txt"));
        
        int T = file.nextInt();
        
        for (int test = 1; test <= T; test++) {
            int U = file.nextInt();
            
            confirmedMaps = new HashMap<>();
            digitMapping = new HashMap<>();
            
            ArrayList<Query> queries = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                queries.add(new Query(file.next(), file.next()));
            }
            
            Collections.sort(queries);
            
            boolean ok = false;
            
            for (Query q : queries) {
                if (q.M.equals("-1")) {
                    ok = true;
                    break;
                }
                
                if (q.M.length() == q.R.length()) {
                    int idx = 0;
                    
                    while (idx < q.M.length() && confirmedMaps.containsKey(q.R.charAt(idx)) 
                            && confirmedMaps.get(q.R.charAt(idx)) == q.M.charAt(idx)) {
                        idx++;
                    }
                    
                    if (idx != q.M.length() && !confirmedMaps.containsKey(q.R.charAt(idx))) {
                        HashSet<Character> toRemove = new HashSet<>();
                        for (char c : digitMapping.get(q.R.charAt(idx))) {
                            if (c >= q.M.charAt(idx)) {
                                toRemove.add(c);
                            }
                        }
                        digitMapping.get(q.R.charAt(idx)).removeAll(toRemove);
                        
                        if (digitMapping.get(q.R.charAt(idx)).size() == 1) {
                            char ans = 1;
                            for (char c : digitMapping.get(q.R.charAt(idx))) {
                                ans = c;
                            }
                            
                            confirmedMaps.put(q.R.charAt(idx), ans);
                            
                            for (char c : digitMapping.keySet()) {
                                digitMapping.get(c).remove(ans);
                            }
                        }
                    }
                }
            }
            
            if (!ok) {
                for (char c : digitMapping.keySet()) {
                    if (digitMapping.get(c).size() == 1) {
                        char ans = 1;
                        for (char cc : digitMapping.get(c)) {
                            ans = cc;
                        }
                        confirmedMaps.put(c, ans);
                    }
                }
                
                char[] mapping = new char[11];
                for (char c : confirmedMaps.keySet()) {
                    mapping[confirmedMaps.get(c) - '0' + 1] = c;
                }
                mapping[0] = mapping[10];
                
                System.out.print("Case #" + test + ": ");
                for (int i = 0; i < 10; i++) {
                    System.out.print(mapping[i]);
                }
                System.out.println();
            } else {
                HashMap<Character, Long> digitFrequency = new HashMap<>();
                
                for (Query q : queries) {
                    for (int j = 0; j < q.R.length(); j++) {
                        digitFrequency.put(q.R.charAt(j), digitFrequency.getOrDefault(q.R.charAt(j), 0L) + 1L);
                    }
                }
                
                ArrayList<Pair> arr = new ArrayList<>();
                for (char c : digitFrequency.keySet()) {
                    arr.add(new Pair(digitFrequency.get(c), c));
                }
                
                Collections.sort(arr);
                
                char[] mapping = new char[11];
                for (int i = 1; i < 11; i++) {
                    mapping[i] = arr.get(i - 1).let;
                }
                mapping[0] = mapping[10];
                
                System.out.print("Case #" + test + ": ");
                for (int i = 0; i < 10; i++) {
                    System.out.print(mapping[i]);
                }
                System.out.println();
            }
        }
    }
    
    class Pair implements Comparable<Pair> {
        long frq;
        char let;
        
        public Pair(long frq, char let) {
            this.frq = frq;
            this.let = let;
        }
        
        @Override
        public int compareTo(Pair p) {
            return Long.compare(p.frq, frq);
        }
    }
    
    public static void main(String[] args) throws Exception {
        new Solution().run();
    }
}