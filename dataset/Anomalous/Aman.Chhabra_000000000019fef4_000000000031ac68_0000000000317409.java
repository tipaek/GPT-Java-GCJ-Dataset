import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<String> results = new ArrayList<>();
        
        for (int i = 0; i < testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();
            results.add(processMoves(x, y, moves));
        }
        
        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    private static String processMoves(int x, int y, String moves) {
        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            switch (move) {
                case 'S':
                    y--;
                    break;
                case 'N':
                    y++;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }
            if ((i + 1) >= (Math.abs(x) + Math.abs(y))) {
                return String.valueOf(i + 1);
            }
        }
        return "IMPOSSIBLE";
    }
}