import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<String> resultList = new ArrayList<>();
        while (testCases-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();
            resultList.add(solveProblem(x, y, moves));
        }
        int count = 0;
        for (String result : resultList) {
            System.out.println("Case #" + ++count + ": " + result);
        }
    }

    private static String solveProblem(int x, int y, String moves) {
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
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
            if ((i+1) >= (Math.abs(x) + Math.abs(y)))
                return Integer.toString(++i);
        }
        return "IMPOSSIBLE";
    }

}
