import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    
    private static String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out);
        
        int T;
        T = input.nextInt();
        int x,y;
        
        
        for (int i = 0; i < T; i++) {
            x = input.nextInt();
            y = input.nextInt();
            String movment = input.next();
            String res = solution(x, y, movment);
            output.println(String.format("Case #%d: %s",(i+1), res));
            output.flush();
        }

    }
    
    public static int[] getMovment(char c) {
        
        int[] move;
        
        switch(c) {
            case 'E':
                move = new int[] { 1, 0};
                break;
            case 'W':
                move = new int[] { -1, 0};
                break;
            case 'S':
                move = new int[] { 0, -1};
                break;
            case 'N':
                move = new int[] { 0, 1};
                break;
            default:
                move = null;
                break;
        }
        
        return move;
    }
    
    public static int getDist(int[] pos) {
        return Math.abs(pos[0]) + Math.abs(pos[1]);
    }
    
    public static String solution(int x, int y, String movement) {
        int[] catPos = new int[] {x, y};
        int[] myPos = new int[] {0, 0};
        
        boolean catToWest = x < 0;
        boolean catToSouth = y < 0;
                
        
        int move = 0;
        int dist = -1;
        int i = 0;
        char[] moveVec = movement.toCharArray();        
        
        
        while (i <= moveVec.length) {
            dist = getDist(catPos);
            //System.out.format("dist: %d, pos: %s, i: %d\n", dist, Arrays.toString(catPos), i);
            if (dist <= i) {
                break;
            }
            
            if (i == moveVec.length) {
                break;
            }
            
            char catMove = moveVec[i];
            int[] catMoveVec = getMovment(catMove);            
            
            
            catPos[0] += catMoveVec[0];
            catPos[1] += catMoveVec[1];
            
            i++;
        }                
       
        if (dist <= i) {
            return Integer.toString(i); 
        }
        
        return IMPOSSIBLE;
    }
}
