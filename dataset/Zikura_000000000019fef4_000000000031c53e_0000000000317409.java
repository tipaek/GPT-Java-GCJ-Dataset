import java.util.Optional;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int numCases = s.nextInt();
        for(int caseNum=1;caseNum<=numCases;caseNum++) {
            int x = s.nextInt();
            int y = s.nextInt();
            String route = s.next();

            Optional<Integer> solution = solve(x, y, route);

            if(solution.isPresent()) {
                System.out.printf("Case #%d: %d\n", caseNum, solution.get());
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", caseNum);
            }
        }
    }

    private static Optional<Integer> solve(int x, int y, String route) {
        int currentX = x;
        int currentY = y;
        for(int i=0;i<route.length();i++) {
            System.err.printf("Pepe is at (%d, %d) at time %d\n", currentX, currentY, i);

            if(Math.abs(currentX)+Math.abs(currentY) <= i) {
                return Optional.of(i);
            }
            switch (route.charAt(i)) {
                case 'N': currentY++; break;
                case 'S': currentY--; break;
                case 'E': currentX++; break;
                case 'W': currentX--; break;
            }

        }
        System.err.printf("Pepe is at (%d, %d) at time %d\n", currentX, currentY, route.length());
        if(Math.abs(currentX)+Math.abs(currentY) <= route.length()) {
            return Optional.of(route.length());
        }

        return Optional.empty();
    }
}
