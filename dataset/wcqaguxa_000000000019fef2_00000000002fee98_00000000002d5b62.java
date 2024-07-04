import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int i = 1; i <= cases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if ((Math.abs(x)%2)  == (Math.abs(y)%2)){
                System.out.println("Case #"+i+": IMPOSSIBLE");
            } else {
                Aim aim = new Aim(x, y);
                Candidate can = aim.solve();
                if (aim == null) {
                    System.out.println("Case #"+i+": IMPOSSIBLE");
                } else {
                    System.out.println("Case #"+i+": "+ can.print());
                }
            }
        }
    }
}

class Aim {
    int xGoal;
    int yGoal;

    Aim(int x, int y) {
        this.xGoal = x;
        this.yGoal = y;
    }

    Candidate solve() {
        LinkedList<Candidate> iterate = new LinkedList<>();
        if (this.xGoal % 2 != 0) {
            iterate.add(new Candidate(Direction.EAST));
            iterate.add(new Candidate(Direction.WEST));
        } else {
            iterate.add(new Candidate(Direction.SOUTH));
            iterate.add(new Candidate(Direction.NORTH));
        }
        //here check if solution in already in iterate! TODO

        while (!iterate.isEmpty()) {
            Candidate candidate = iterate.removeFirst();
            Candidate can;
            candidate.power++;
            long value = (long) Math.pow(2, candidate.power);
            for (Direction direction : Direction.values()) {
                can = candidate.addDirection(direction, value);
                if (can.xCurrent == this.xGoal && can.yCurrent == this.yGoal) {
                    return can;
                }
                if (can.power <31 /*&& Math.abs(can.xCurrent - this.xGoal) > 2*value && Math.abs(can.yCurrent - this.yGoal) > 2*value*/) {
                    iterate.addLast(can);
                }
            }
        }
        return null;
    }


}

class Candidate {
    ArrayList<Direction> path;
    long xCurrent;
    long yCurrent;
    int power;

    Candidate(Candidate other) {
        this.path = new ArrayList<>();
        for (Direction dir: other.path) {
             this.path.add(dir);
        }
        this.xCurrent = other.xCurrent;
        this.yCurrent = other.yCurrent;
        this.power = other.power;
    }

    Candidate(Direction direction) {
        path = new ArrayList<>();
        path.add(direction);
        if (direction == Direction.SOUTH) {
           xCurrent =  0;
           yCurrent = -1;
        } else if (direction == Direction.NORTH) {
            xCurrent = 0;
            yCurrent = 1;
        } else if (direction == Direction.EAST) {
            xCurrent = 1;
            yCurrent = 0;
        } else {
            xCurrent = -1;
            yCurrent = 0;
        }
        this.power = 0;
    }

    Candidate addDirection(Direction direction, long value) {
        Candidate other = new Candidate(this);
        other.path.add(direction);
        if (direction == Direction.EAST) {
            other.xCurrent +=value;
        } else if (direction == Direction.WEST) {
            other.xCurrent-=value;
        } else if (direction == Direction.SOUTH) {
            other.yCurrent-=value;
        } else {
            other.yCurrent+=value;
        }
        return other;
    }

    String print() {
        StringBuilder result = new StringBuilder();
        for (Direction dir: path) {
            if (dir == Direction.EAST) { result.append('E'); }
            else if (dir == Direction.NORTH) { result.append('N'); }
            else if (dir == Direction.WEST) {result.append('W'); }
            else { result.append('S'); }
        }
        return result.toString();
    }

}

enum Direction {
    SOUTH,
    NORTH,
    EAST,
    WEST,
}