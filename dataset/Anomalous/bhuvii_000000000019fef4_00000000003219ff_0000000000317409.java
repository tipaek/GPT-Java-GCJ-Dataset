import java.util.*;

class Solution {
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int k = 1; k <= testCase; k++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String path = sc.next();
            
            ArrayList<Pair> pathTrack = new ArrayList<>();
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            
            for (int i = 0; i < path.length(); i++) {
                int lastX = (a.isEmpty()) ? x : a.get(a.size() - 1);
                int lastY = (b.isEmpty()) ? y : b.get(b.size() - 1);

                switch (path.charAt(i)) {
                    case 'N':
                        a.add(lastX);
                        b.add(lastY + 1);
                        break;
                    case 'S':
                        a.add(lastX);
                        b.add(lastY - 1);
                        break;
                    case 'E':
                        a.add(lastX + 1);
                        b.add(lastY);
                        break;
                    case 'W':
                        a.add(lastX - 1);
                        b.add(lastY);
                        break;
                }
            }

            Integer ans = Integer.MAX_VALUE;
            for (int i = 0; i < a.size(); i++) {
                int currX = a.get(i);
                int currY = b.get(i);
                int currDist = Math.abs(currX) + Math.abs(currY);
                if (currDist <= i + 1) {
                    ans = i + 1;
                    break;
                }
            }

            if (ans == Integer.MAX_VALUE)
                System.out.println("Case #" + k + ": IMPOSSIBLE");
            else
                System.out.println("Case #" + k + ": " + ans);
        }
    }
}