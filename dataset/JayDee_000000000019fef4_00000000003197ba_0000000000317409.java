import java.util.*;

public class Solution {
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in); 

    int numT = in.nextInt(); 
    for(int t=0; t<numT; t++) {
      int x = in.nextInt(); 
      int y = in.nextInt();

      char[] moves = in.next().toCharArray(); 

      HashMap<Character, Integer> getDir = new HashMap<>();
      getDir.put('N', 0);
      getDir.put('E', 1); 
      getDir.put('S', 2);
      getDir.put('W', 3);

      int minTime = Integer.MAX_VALUE;
      if (x == 0 && y == 0) {
        minTime = 0;
      }
      for(int time=0; time<moves.length; time++) {
        char dirChar = moves[time];
        int dir = getDir.get(dirChar);
        x += dx[dir]; 
        y += dy[dir]; 
        int curDist = Math.abs(x) + Math.abs(y); 
        if(curDist <= time+1) {
          if(minTime > time+1) {
            minTime = time+1;
          } 
        }
      }

      // System.out.printf("%d %d\n", x, y);

      // int dist = Math.abs(x) + Math.abs(y);
      if(minTime <= moves.length) {
        // possible
        System.out.printf("Case #%d: %d\n", (t+1), minTime);
      } else {
        System.out.printf("Case #%d: IMPOSSIBLE\n", (t+1));
      }

    }
  }
}
/* 

Tests

5
4 4 SSSS
3 0 SNSS
2 10 NSNNSN
0 1 S
2 7 SSSSSSS

Case #1: 4
Case 2: IMPOSSIBLE
Case 3: IMPOSSIBLE
Case #4: 1
Case #5: 5

*/