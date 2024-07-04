import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int ct = 1;
        int x, y, time, dist, l;
        String path;
        boolean found;
        int[] dir;
        Map<Character, int[]> map = new HashMap();
        map.put('N', new int[] {0,1});
        map.put('S', new int[] {0,-1});
        map.put('E', new int[] {1,0});
        map.put('W', new int[] {-1,0});

        while (ct <= t) {
            time = 0;
            dist = 0;
            found = false;
            x = sc.nextInt();
            y = sc.nextInt();
            path = sc.next();
            l = path.length();
            for (int i = 0; i < l; i++, time++) {
                dist = distFromOrigin(x,y);
                if (dist <= time) {
                    System.out.println("Case #" + ct + ": " + time);
                    found = true;
                    break;
                }
                dir = map.get(path.charAt(i));
                x += dir[0];
                y += dir[1];
//                System.out.println(x + " " + y);
            }
            if (!found) {
                if (distFromOrigin(x,y) <= time) {
                    System.out.println("Case #" + ct + ": " + time);
                } else {
                    System.out.println("Case #" + ct + ": IMPOSSIBLE");
                }
            }
            ct++;
        }
    }

    private static int distFromOrigin(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }
}