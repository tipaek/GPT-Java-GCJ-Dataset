import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().solve();
    }

    public void solve() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        
        for (int caseNo = 1; caseNo <= T; caseNo++) {
            int U = scanner.nextInt();
            Map<Long, Set<Character>> digitToCharsMap = new HashMap<>();
            Set<Character> allCharacters = new HashSet<>();
            
            for (int i = 0; i < 10000; i++) {
                long m = scanner.nextLong();
                String S = scanner.next();
                char firstChar = S.charAt(0);
                
                if (1 <= m && m <= 9) {
                    digitToCharsMap.computeIfAbsent(m, k -> new HashSet<>()).add(firstChar);
                }
                
                if (allCharacters.size() < 10) {
                    for (char c : S.toCharArray()) {
                        allCharacters.add(c);
                    }
                }
            }
            
            char[] result = new char[10];
            Set<Character> usedCharacters = new HashSet<>();
            
            for (int i = 1; i <= 9; i++) {
                for (char c : digitToCharsMap.getOrDefault((long) i, Collections.emptySet())) {
                    if (!usedCharacters.contains(c)) {
                        result[i] = c;
                        usedCharacters.add(c);
                        allCharacters.remove(c);
                        break;
                    }
                }
            }
            
            for (char c : allCharacters) {
                result[0] = c;
                break;
            }
            
            System.out.printf("Case #%d: %s%n", caseNo, String.valueOf(result));
        }
    }
}