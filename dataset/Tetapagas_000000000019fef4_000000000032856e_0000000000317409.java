import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int cases = in.nextInt();

		for(int n=0; n<cases; n++) {
			solveCase(n+1);
		}
    }

    private static void solveCase(int nth) {
        int x = in.nextInt();
        int y = in.nextInt();

        String path = in.next();
        int[][] positions = new int[path.length()+1][2]; 
        positions[0][0] = -x;
        positions[0][1] = -y;
        
        int minutes = 0;
        for(char c : path.toCharArray()) {
            int prevx = positions[minutes][0];
            int prevy = positions[minutes][1];
            minutes++;

            if(c == 'W') {
                positions[minutes][0] = prevx-1;
                positions[minutes][1] = prevy; 
            } else if(c == 'E') {
                positions[minutes][0] = prevx+1;
                positions[minutes][1] = prevy;
            } else if(c == 'N') {
                positions[minutes][0] = prevx;
                positions[minutes][1] = prevy-1;
            } else if(c == 'S') {
                positions[minutes][0] = prevx;
                positions[minutes][1] = prevy+1;
            } else {
                System.out.println("Should not occur...");
            }
        }

        int minute = 0;
        LinkedList<int[]> myPositions = new LinkedList<>();
        myPositions.add(new int[]{0, 0});
        while(minute <= minutes && !myPositions.isEmpty()) {
            LinkedList<int[]> nextPositions = new LinkedList<>();
            for(int[] position : myPositions) {
                int distance = Math.abs(positions[minute][0] - position[0]) + Math.abs(positions[minute][1] - position[1]);
                if(distance > (minutes - minute)*2) {
                    continue;
                }

                if(distance == 0) {
                    System.out.println("Case #" + nth + ": " + minute);
                    return;
                }
                
                nextPositions.add(new int[]{position[0]-1, position[1]});
                nextPositions.add(new int[]{position[0]+1, position[1]});
                nextPositions.add(new int[]{position[0], position[1]-1});
                nextPositions.add(new int[]{position[0], position[1]+1});
                nextPositions.add(new int[]{position[0], position[1]});
            }

            myPositions = nextPositions;
            minute++;
        }
        
        System.out.println("Case #" + nth + ": IMPOSSIBLE");
    }
}