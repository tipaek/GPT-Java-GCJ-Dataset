import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Mattia D'ambrosio
 * Created on 02/05/2020.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++){
            String[] s = scanner.nextLine().split("\\s+");

            System.out.println("Case #"+i+": "+picture(s[0], s[1], s[2]));
        }
    }

    private static String picture(String pX, String pY, String directions){
        int pCX = Integer.parseInt(pX);
        int pCY = Integer.parseInt(pY);
        int x = 0, y = 0;

        for (int i = 0; i < directions.length(); i++) {
            switch (directions.charAt(i)){
                case 'N':
                    pCY++;
                    y = getY(directions, pCX, pCY, y, i);
                    break;
                case 'E':
                    pCX++;
                    x = getX(directions, pCX, pCY, x, i);
                    break;
                case 'S':
                    pCY--;
                    y = getY(directions, pCX, pCY, y, i);
                    break;
                case 'W':
                    pCX--;
                    x = getX(directions, pCX, pCY, x, i);
                    break;
            }

            if(x == pCX && y == pCY)
                return Integer.toString(i+1);
        }

        return "IMPOSSIBLE";
    }

    private static int getX(String directions, int pCX, int pCY, int x, int i) {
        if(i+1 < directions.length()){
            int nX = nextMove(directions.charAt(i+1), pCX, pCY, true);
            if(nX != x)
                if(nX-x > 0)
                    x++;
                else
                    x--;
        }else{
            if(pCX != x)
                if(pCY-x > 0)
                    x++;
                else
                    x--;
        }
        return x;
    }

    private static int getY(String directions, int pCX, int pCY, int y, int i) {
        if(i+1 < directions.length()){
            int nY = nextMove(directions.charAt(i+1), pCX, pCY, false);
            if(nY != y)
                if(nY-y > 0)
                    y++;
                else
                    y--;
        }else{
            if(pCY != y)
                if(pCY-y > 0)
                    y++;
                else
                    y--;
        }
        return y;
    }

    private static int nextMove(char nC, int pCX, int pCY, boolean x){
        switch (nC){
            case 'N':
                pCY++;
                break;
            case 'E':
                pCX++;
                break;
            case 'S':
                pCY--;
                break;
            case 'W':
                pCX--;
                break;
        }

        if(x)
            return pCX;
        else
            return pCY;
    }
}
