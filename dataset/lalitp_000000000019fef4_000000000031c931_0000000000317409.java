import java.util.*;

public class Solution {

    public static void main(String[] args) {
        // write your code here
        int T, t, x, y, min = 0, i, cur, curX, curY, maxY, minY, saveCur;
        char ch;
        boolean found;
        Map<String, List<Integer>> pathMap = new HashMap<>();
        String path, key;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(t = 1; t <= T; t++) {
            x = sc.nextInt();
            y = sc.nextInt();
            path = sc.next();
            pathMap.clear();
            found = false;

            maxY = Integer.MIN_VALUE;
            minY = Integer.MAX_VALUE;
            min = 0;
            cur = 0;
            curX = x;
            curY = y;
            key = curX + ":" + curY;
            pathMap.put(key, new ArrayList<>());
            pathMap.get(key).add(cur);
            for(i = 0; i < path.length(); i++) {
                ch = path.charAt(i);
                cur++;
                switch (ch) {
                    case 'S':
                        curY--;
                        break;
                    case 'N':
                        curY++;
                        break;
                    case 'W':
                        curX--;
                        break;
                    case 'E':
                        curX++;
                        break;
                }
                if(curY > maxY) maxY = curY;
                if(curY < minY) minY = curY;

                key = curX + ":" + curY;
                if(!pathMap.containsKey(key)) {
                    pathMap.put(key, new ArrayList<>());
                }
                pathMap.get(key).add(cur);
            }

            // For first two cases
            cur = 0;
            curX = 0;
            curY = 0;
            for(i = 0; i <= x; i++) {
                key = curX + ":" + curY;
                if(pathMap.containsKey(key)) {
                    List<Integer> toa = pathMap.get(key);
                    for(Integer time: toa) {
                        if(time >= cur) {
                            found = true;
                            min = time;
                            break;
                        }
                    }
                }
                if(found) {
                    break;
                }
                curX++;
                cur++;
            }

            {
                saveCur = cur;
                for(i = 0; maxY >= 0 && i < maxY; i++) {
                    curY++;
                    cur++;
                    key = curX + ":" + curY;
                    if(pathMap.containsKey(key)) {
                        List<Integer> toa = pathMap.get(key);
                        for(Integer time: toa) {
                            if(time >= cur && time < min) {
                                found = true;
                                min = time;
                                break;
                            }
                        }
                    }
                }

                cur = saveCur;
                for(i = 0; maxY <= 0 && i >= maxY; i--) {
                    curY--;
                    cur++;
                    key = curX + ":" + curY;
                    if(pathMap.containsKey(key)) {
                        List<Integer> toa = pathMap.get(key);
                        for(Integer time: toa) {
                            if(time >= cur && time < min) {
                                found = true;
                                min = time;
                                break;
                            }
                        }
                    }
                }
            }

            if(found)
                System.out.println("Case #" + t + ": " + min);
            else
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
        }
    }
}