import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
            int U = sc.nextInt();
            Map<Character, Integer> map = new HashMap<>();

            for (int i=0; i<Math.pow(10, 4); i++) {
                String M = sc.next();
                String R = sc.next().trim();

                if (M.length() != R.length()) {
                    continue;
                }
                
                char x = R.charAt(0);
                int y = M.charAt(0)-'0';
                if (map.containsKey(x)) {
                    if (map.get(x)>y){
                        map.put(x, y);
                    }
                }else {
                    map.put(x, y);
                }
            }
        }
    }
    
    private static String formAns(Map<Character, Integer> map) {
        Map<Integer, Character> map1 = new HashMap<>();
        
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            map1.put(entry.getValue(), entry.getKey());
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        
        for (int i=0; i<=9; i++){
            stringBuilder.append(map1.get(i));
        }
        return stringBuilder.toString();
    }
}
