import java.util.*;

public class Solution {
    public static String solve(Scanner scanner) {
        int u = scanner.nextInt();
        Map<Integer, String> test = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int m_i = scanner.nextInt();
            String q_i = scanner.next();
            if (!test.containsKey(m_i)) {
                test.put(m_i, q_i);
            } else {
                for (int j = 0; j < q_i.length(); j++) {
                    String res = test.get(m_i);
                    String letter = String.valueOf(q_i.charAt(j));
                    if (!res.contains(letter)) {
                        res = res + letter;
                    }
                    test.put(m_i, res);
                }
            }
        }

        String key = "";
        for (int i = 1; i < 10; i++) {
            String res = test.get(i);
            for (int j = 0; j < res.length(); j++) {
                String letter = String.valueOf(res.charAt(j));
                if (!key.contains(letter)) {
                    key = key + letter;
                }
            }
        }
        String res = test.get(11);
        for (int j = 0; j < res.length(); j++) {
            String letter = String.valueOf(res.charAt(j));
            if (!key.contains(letter)) {
                key = letter + key;
            }
        }
        
        return key;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int caseNum = input.nextInt();
        for (int ks = 1; ks <= caseNum; ks++) {
            System.out.println(String.format("Case #%d: %s", ks, solve(input)));
        }
    }
}