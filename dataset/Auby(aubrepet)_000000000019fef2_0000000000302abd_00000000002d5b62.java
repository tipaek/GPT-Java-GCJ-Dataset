import static java.lang.Math.abs;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author peta
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0; i < tests; i++) {
            int width = in.nextInt();
            int height = in.nextInt();
            int sum = Math.abs(width) + Math.abs(height);
            Queue<Integer> signFoldsOfTwo = fillFolds(sum);
            String result = calculateMoves(signFoldsOfTwo,width, height);
            System.out.println("Case #" + (i+1) + ": " + result);
        }
    
    }

    private Queue<Integer> fillFolds(int sum) {
        Queue<Integer> signFoldsOfTwo = new ArrayDeque<>();
        int max = 1;
        int tempSum = max;
        while (tempSum < sum) {            
            max *= 2;
            tempSum += max;
        }
        while (max >= 1) {   
            int sign = 1;
            if (sum < 0) {
                sign = -1;
            }
            signFoldsOfTwo.add(sign * max);
            sum -= sign * max;
            max /= 2;
        }
        return signFoldsOfTwo;
    }

    private String calculateMoves(Queue<Integer> signFoldsOfTwo, int width, int height) {
        StringBuilder sb = new StringBuilder();
        int correctionW = 1;
        int correctionH = 1;
        if (width < 0) {
            correctionW = -1;
        }
        if (height < 0) {
            correctionH = -1;
        }
        while (!signFoldsOfTwo.isEmpty()) {            
            int lastMove = signFoldsOfTwo.poll();
            if (abs(height - correctionH * lastMove) < abs(width - correctionW * lastMove)){
            //if ((lastMove > 0 && width < height) || (lastMove < 0 && width > height)) {
                lastMove *= correctionH;
                height -= lastMove;
                if (lastMove > 0) {
                    sb.append('N');
                } else {
                    sb.append('S');
                }
            } else{
                lastMove *= correctionW;
                width -= lastMove;
                if (lastMove > 0) {
                    sb.append('E');
                } else {
                    sb.append('W');
                }
            }
        }
        sb = sb.reverse();
        if (width != 0 || height != 0) {
            return "IMPOSSIBLE";
        }
        return sb.toString();

    }
}
