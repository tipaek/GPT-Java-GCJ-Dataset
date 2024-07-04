import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int i = 1; i <= cases; i++) {
            Coord cat = new Coord (scanner.nextInt(), scanner.nextInt());
            String movement = scanner.nextLine();
            int res = Solution.solve(movement, cat);
            if (res < 0) {
                System.out.println("Case #"+i+": IMPOSSIBLE");
            } else {
                System.out.println("Case #"+1+": "+res);
            }
        }
    }

    static int solve(String movement, Coord cat) {
        for (int j = 0; j < movement.length(); j++) {
            if(cat.getDistance() <= cat.time) {
                return cat.time;
            }
            cat.move(movement.charAt(j));
        }
        if(cat.getDistance() <= cat.time) {
            return cat.time;
        }
        return -1;
    }
}

class Coord{
    int xCoord;
    int yCoord;
    int time;

    public Coord(int x, int y) {
        this.xCoord = x;
        this.yCoord = y;
        this.time = -1;
    }

    void move(char c) {
        if (c == 'S') {
            yCoord-=1;
        } else if (c == 'N') {
            yCoord+=1;
        } else if (c== 'E') {
            xCoord +=1;
        } else {
            xCoord -=1;
        }
        time++;
    }

    int getDistance() {
        return Math.abs(xCoord)+Math.abs(yCoord);
    }
}