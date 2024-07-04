import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static int solve2(int catX, int catY, int myX, int myY, int index, char[] route) {
        int diffN = catY - myY;
        int diffE = catX - myX;

        if (diffN == 0 && diffE == 0) return index;
        if (index >= route.length) return -1;

        char c = route[index];
        boolean goToMe = false;

        switch (c) {
            case 'N':
                goToMe = diffN < -1;
                break;
            case 'S':
                goToMe = diffN > 1;
                break;
            case 'E':
                goToMe = diffE < -1;
                break;
            case 'W':
                goToMe = diffE > 1;
                break;
        }

        return solve(catX, catY, myX, myY, ++index, route);
    }

    public static int solve(int catX, int catY, int myX, int myY, int index, char[] route) {
        int diffN = catY - myY;
        int diffW = catX - myX;

        if (diffN == 0 && diffW == 0) return index;
        if (index >= route.length) return -1;

        char c = route[index];

        switch (c) {
            case 'N':
                catY++;
                if (diffN >= 0) myY++;
                else if (diffN < -1) myY--;
                break;
            case 'S':
                catY--;
                if (diffN <= 0) myY--;
                else if (diffN > 1) myY++;
                break;
        }

        return solve(catX, catY, myX, myY, ++index, route);
    }

    public static int roll(int catX, int catY, int myX, int myY, int index, char[] route) {
        int diffW = catX - myX;

        while (diffW != 0 && index < route.length) {
            char c = route[index];
            switch (c) {
                case 'N':
                    catY++;
                    break;
                case 'S':
                    catY--;
                    break;
            }

            diffW += (diffW > 0) ? -1 : 1;
            index++;
        }

        if (diffW == 0)
            return solve(catX, catY, catX, 0, index, route);

        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        in.nextLine();

        for (int c = 1; c <= t; ++c) {
            String[] tokens = in.nextLine().split(" ");
            int catX = Integer.parseInt(tokens[0]);
            int catY = Integer.parseInt(tokens[1]);
            char[] route = tokens[2].toCharArray();

            int len = roll(catX, catY, 0, 0, 0, route);
            if (len > 0)
                System.out.println("Case #" + c + ": " + len);
            else
                System.out.println("Case #" + c + ": IMPOSSIBLE");
        }
    }
}