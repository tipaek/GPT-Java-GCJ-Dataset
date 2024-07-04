import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int c = 1; c <= t; c++) {
            int n = sc.nextInt();
            String[] arr = new String[n];
            Map<Integer, Integer> map = new HashMap<>();
            int maxLength = -1;
            
            for (int i = 0; i < n; i++) {
                arr[i] = sc.next();
                int len = arr[i].length() - 1;
                map.put(i, len);
                if (arr[i].length() > maxLength) {
                    maxLength = arr[i].length();
                }
            }
            
            StringBuilder result = new StringBuilder();
            boolean isMismatch = false;
            
            for (int i = maxLength - 1; i >= 0; i--) {
                boolean done = false;
                
                for (int j = 1; j < n; j++) {
                    char c1 = arr[j - 1].charAt(map.get(j - 1));
                    char c2 = arr[j].charAt(map.get(j));
                    
                    if (c1 != c2 && c1 != '*' && c2 != '*') {
                        isMismatch = true;
                        break;
                    }
                    
                    if (c2 != '*' && c1 == '*') {
                        if (map.get(j - 1) != 0 && arr[j - 1].charAt(map.get(j - 1) - 1) == c1) {
                            map.put(j - 1, map.get(j - 1) - 1);
                        }
                        if (!done) {
                            done = true;
                            result.insert(0, c2);
                        }
                    }
                    
                    if (c1 != '*' && c2 == '*') {
                        if (map.get(j) != 0 && arr[j].charAt(map.get(j) - 1) == c1) {
                            map.put(j, map.get(j) - 1);
                        }
                        if (!done) {
                            done = true;
                            result.insert(0, c1);
                        }
                        if (map.get(j - 1) != 0) {
                            map.put(j - 1, map.get(j - 1) - 1);
                        }
                    }
                    
                    if (c1 == c2) {
                        if (!done && c1 != '*') {
                            done = true;
                            result.insert(0, c1);
                        }
                        if (map.get(j - 1) != 0) {
                            map.put(j - 1, map.get(j - 1) - 1);
                        }
                        if (j == n - 1 && c2 != '*') {
                            map.put(j, map.get(j) - 1);
                        }
                    }
                }
                
                if (isMismatch) {
                    break;
                }
            }
            
            if (isMismatch) {
                System.out.println("Case #" + c + ": *");
            } else {
                System.out.println("Case #" + c + ": " + result.toString());
            }
        }
    }
}