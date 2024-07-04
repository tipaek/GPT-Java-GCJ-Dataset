import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
        Map<Integer, Position> positions = new HashMap<>(); 
        Position position = new Position(-x, -y);
        positions.put(0, position);

        int minutes = 0;
        for(char c : path.toCharArray()) {
            minutes++;

            if(c == 'W') {
                position = new Position(position.x-1, position.y);
            } else if(c == 'E') {
                position = new Position(position.x+1, position.y);
            } else if(c == 'N') {
                position = new Position(position.x, position.y-1);
            } else if(c == 'S') {
                position = new Position(position.x, position.y+1);
            } else {
                System.out.println("Should not occur...");
            }

            positions.put(minutes, position);
        }

        LinkedList<Position> myPositions = new LinkedList<>();
        myPositions.add(new Position(0, 0));
        int minute = 0;
        while(minute <= minutes) {
            Position targetPosition = positions.get(minute);
            LinkedList<Position> nextPositions = new LinkedList<>();
            for(Position myPosition : myPositions) {
                if(targetPosition.equals(myPosition)) {
                    System.out.println("Case #" + nth + ": " + minute);
                    return;
                }

                nextPositions.add(new Position(myPosition.x-1, myPosition.y));
                nextPositions.add(new Position(myPosition.x+1, myPosition.y));
                nextPositions.add(new Position(myPosition.x, myPosition.y-1));
                nextPositions.add(new Position(myPosition.x, myPosition.y+1));
                nextPositions.add(myPosition);
            }
            myPositions = nextPositions;
            minute++;
        }
        
        System.out.println("Case #" + nth + ": IMPOSSIBLE");
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            Position other = (Position) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "Position [x=" + x + ", y=" + y + "]";
        }
    }
}