import java.util.*;
class Solution {
    
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int noOfTestCases = scr.nextInt();
        
        for (int x = 1; x<= noOfTestCases; x++) {
            int N = scr.nextInt();
            int[][] m = new int[N][N];
            int k = 0;
            int c = 0;
            int r = 0;
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                Set<Integer> s = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    int temp = scr.nextInt();
                    s.add(temp);
                    if (!map.containsKey(j)){
                        map.put(j, new HashSet<>());
                    }
                    map.get(j).add(temp);
                    if (i == j) {
                        k += temp;
                    }
                }
                if (s.size() != N) {
                    r++;
                }
            }
            
            for (Integer n : map.keySet()){
                if (map.get(n).size() != N) {
                    c++;
                }
            }
            
            System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
        }
        
    }
}