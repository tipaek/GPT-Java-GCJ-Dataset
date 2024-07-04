import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= testCases; i++)
        {
            runTestCase(i, in);
        }
    }

    private static void runTestCase(int testCaseNumber, Scanner in)
    {
        int deltaX = in.nextInt();
        int deltaY = in.nextInt();
        String directions = in.next();

        Coordinates[] coords = getCatCoordinates(deltaX, deltaY, directions);

        int intercept = getClosestIntercept(coords);

        if(intercept == -1)
        {
            String testCaseString = "IMPOSSIBLE";
            outputTestCase(testCaseNumber, testCaseString);
        }
        else
        {
            outputTestCase(testCaseNumber, String.valueOf(intercept));
        }
    }

    private static int getClosestIntercept(Coordinates[] coords)
    {
        for(int i = 0; i < coords.length; i++)
        {
            //System.out.println(String.valueOf(coords[i].x) + String.valueOf(coords[i].y));
            int distance = Math.abs(coords[i].x) + Math.abs(coords[i].y);

            if(i + 1 >= distance)
            {
                return i + 1;
            }
        }
        return -1;
    }


    private static Coordinates[] getCatCoordinates(int deltaX, int deltaY, String directions)
    {
        Coordinates[] coords = new  Coordinates[directions.length()];

        int x = deltaX;
        int y = deltaY;

        for(int i = 0; i < directions.length(); i++)
        {
            char direction = directions.charAt(i);

            if(direction == 'N')
            {
                y++;
            }
            else if(direction == 'S')
            {
                y--;
            }
            else if(direction == 'W')
            {
                x--;
            }
            else if(direction == 'E')
            {
                x++;
            }
            coords[i] = new Coordinates(x, y);
        }

        return coords;
    }



    private static class Coordinates
    {
        public int x;
        public int y;

        public Coordinates(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    private static void outputTestCase(int testCaseNumber, String outString)
    {
        System.out.println("Case #" + testCaseNumber + ": " + outString);
    }
}