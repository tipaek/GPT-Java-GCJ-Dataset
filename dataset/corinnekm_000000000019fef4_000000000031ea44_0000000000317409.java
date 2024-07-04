import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;



public class Solution {

    public class Position {
        private int X;
        private int Y;

        public Position(int x, int y) {
            X = x;
            Y = y;
        }
    }

    static boolean canReachPosition (Position myPos, Position catPos, int nbMoves){
        return Math.abs(myPos.X - catPos.X) + Math.abs(myPos.Y - catPos.Y) <= nbMoves;
    }




    static Position move(Solution sol, Position start, char direction){
        switch (direction){
            case 'S':
                return sol.new Position(start.X, start.Y -1);
            case 'N':
                return sol.new Position(start.X , start.Y+1);
            case 'E':
                return sol.new Position(start.X+1, start.Y);
            case 'O':
                return sol.new Position(start.X-1 , start.Y);
            default:
                return sol.new Position(start.X, start.Y);

        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Solution sol = new Solution();
        //Scanner sc = new Scanner(new File("resources/input1.txt"));
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String line;
        /****************************************************************************/
        int T = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < T; t++) {
            //System.out.println("TEST " + t);
            //System.out.println("***************");
            String input = sc.nextLine();
            int X = Integer.parseInt(input.split(" ")[0]);
            int Y = Integer.parseInt(input.split(" ")[1]);
            String strMoves = input.split(" ")[2];
            char[] moves = strMoves.toCharArray();
            int nbMoved = moves.length;
            Position[] catPositions = new Position[nbMoved + 1];
            catPositions[0] = sol.new Position(X,Y);
            //System.out.printf("Cat position start : %d,%d", X, Y);
            Position positionZero = sol.new Position(0,0);
            // fill array of cat positions
            boolean found = false;
            for (int i = 1; i < catPositions.length && !found; i++) {
                Position actualCatPosition = move(sol,catPositions[i-1], moves[i-1]);
                catPositions[i]= actualCatPosition;
                if (canReachPosition(positionZero, actualCatPosition, i)){
                    found = true;
                    System.out.println("Case #" + (t+1) + ": "+ i);
                }

            }
            if (!found){
                System.out.println("Case #" + (t+1) + ": IMPOSSIBLE");
            }

        }
    }
}

