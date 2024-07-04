import java.util.*;

public class Solution {
    public static String solve(Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        // Set<Integer> numsToUse = new HashSet<>();
        List<Integer> stack = new ArrayList<>();
        boolean flipX = x < 0;
        boolean flipY = y < 0;
        x = Math.abs(x);
        y = Math.abs(y);
        int totalDist = x + y;
        int i = 1;
        int totalSoFar = 0;
        String ans = "";
        
        while (totalSoFar < totalDist) {
            int num = (int) Math.pow(2, i-1);
            totalSoFar += num;
            stack.add(num);
            i++;
        }
        
        Map<String, String> directions = new HashMap<>();
        if (flipY) { 
            directions.put("N", "S");
            directions.put("S", "N");
        } else {
            directions.put("N", "N");
            directions.put("S", "S");
        }
        if (flipX) { 
            directions.put("E", "W");
            directions.put("W", "E");
        } else {
            directions.put("E", "E");
            directions.put("W", "W");
        }

        while (!stack.isEmpty()) {
            int largestNum = stack.remove(stack.size() - 1);
            if (Math.abs(x) > Math.abs(y)) {
                if (x > 0) {
                    x = x - largestNum;
                    ans = directions.get("E") + ans;
                } else {
                    x = x + largestNum;
                    ans = directions.get("W") + ans;
                }
            } else {
                if (y > 0) {
                    y = y - largestNum;
                    ans = directions.get("N") + ans;
                } else {
                    y = y + largestNum;
                    ans = directions.get("S") + ans;
                }
            }
        }
        if (x != 0 || y != 0) return "IMPOSSIBLE";
        return ans;
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int caseNum = input.nextInt();
        for (int ks = 1; ks <= caseNum; ks++) {
            System.out.println(String.format("Case #%d: %s", ks, solve(input)));
        }
    }
}