import java.io.*;
import java.math.*;
import java.util.Scanner;


public class Main {
    static String sol = "";
    static Boolean valid = false;

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);


        String fullAnswer = "";

        int totalCases = Integer.parseInt(in.nextLine());
        for (int caseId = 1; caseId <= totalCases; caseId++)
        {

            String[] cord  =in.nextLine().split(" ");
            long goalX = Long.parseLong(cord[0]);
            long goalY = Long.parseLong(cord[1]);
            if((goalX + goalY)%2!=0)
            {
                possible(1, 'N', "", 0, 0 + 1, goalX, goalY);
                possible(1, 'E', "", 0 + 1, 0, goalX, goalY);
                possible(1, 'W', "", 0 - 1, 0 , goalX, goalY);
                possible(1, 'S', "", 0, 0 - 1, goalX, goalY);
            }

            fullAnswer+=("Case #"+caseId+": ");
            if (valid)
            {
                fullAnswer += (sol);
            }
            else
            {
                fullAnswer += ("IMPOSSIBLE");
            }
            if (caseId != totalCases)
                fullAnswer += "\n";
            sol = "";
            valid = false;
            // Console.WriteLine(fullAnswer);
        }
        System.out.println(fullAnswer);
        //  Console.ReadLine();


    }

    public static void possible(long i, char dir, String path, long curX, long curY, long goalX, long goalY)
    {
        path += dir;


        if ((curX == goalX)&&(curY == goalY))
        {
            valid = true;
            if(sol.length()==0)
            {
                sol = path;
            }
            else if(path.length()<sol.length())
            {
                sol = path;
            }
            return;
        }
        if (Math.pow(2,i) > Math.abs(goalX) + Math.abs(goalY))
        {
            return;
        }
            /* 
             long tmpCur = 0;
             long tmpGoal = 0;
             if(curX!=0)
             {
                 tmpCur+= Math.Abs(curX);
             }
             if (curY != 0)
             {
                 tmpCur += Math.Abs(curY);
             }
             if (goalX != 0)
             {
                 tmpGoal += Math.Abs(goalX);
             }
             if (goalY != 0)
             {
                 tmpGoal += Math.Abs(goalY);
             }
             if (tmpCur > tmpGoal)
                 return;
    */


        i++;
        long newI = (long)Math.pow(2, i - 1);
        possible(i, 'N', path, curX, curY + newI, goalX, goalY);
        possible(i, 'E', path, curX + newI, curY , goalX, goalY);
        possible(i, 'W', path, curX - newI, curY , goalX, goalY);
        possible(i, 'S', path, curX, curY - newI, goalX, goalY);

        return;

    }

}



