import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int recursive = scanner.nextInt();
        for (int r = 0; r < recursive; r++) {
            int U = scanner.nextInt();
            Map<Character, Integer> charMap = new HashMap<>();
            int flagged = 0;
            StringBuilder sb = new StringBuilder("          ");
            scanner.nextLine();
            
            while (flagged < 9) {
                String line = scanner.nextLine();
                String[] list = line.split(" ");
                if (!list[0].equals("-1")) {
                    String N = list[0];
                    int ni = Integer.parseInt(N);
                    String ri = list[1];
                    if (ni <= (flagged + 1) * 10 + 9) {
                        if (ri.length() == 2 && !charMap.containsKey(ri.charAt(0))) {
                            charMap.put(ri.charAt(0), flagged + 1);
                            flagged++;
                        }
                    }
                }
            }
            
            while (flagged < 10) {
                String line = scanner.nextLine();
                String[] list = line.split(" ");
                if (!list[0].equals("-1")) {
                    String ri = list[1];
                    if (ri.length() == 2 && !charMap.containsKey(ri.charAt(1))) {
                        charMap.put(ri.charAt(1), 0);
                        flagged++;
                    }
                }
            }
            
            for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                char currentChar = entry.getKey();
                int index = entry.getValue();
                sb.setCharAt(index, currentChar);
            }
            System.out.println("Case #" + (r + 1) + ": " + sb);
        }
        scanner.close();
    }
}