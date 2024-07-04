import java.util.*;

class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();
        long A = in.nextLong();
        long B = in.nextLong();
        long range = (1000000000 - (B - A)) * 2;
        
        for (int testCase = 1; testCase <= T; testCase++)
        {
            boolean isFound = false;

            long borderLeft, borderRight, borderTop, borderBottom;
            long top, bottom, left, right;
            long targetX, targetY;
            long tempX, tempY;

            String read;

            //check Y testing line
            tempY = -1000000000;

            do
            {
                tempY += 200000000;
                System.out.println("0 " + tempY);
                read = in.next();
                if (read.equals("CENTER"))
                {
                    isFound = true;
                    break;
                }
            }while (!read.equals("HIT"));

            if (isFound)    continue;

            //check left

            left = -1000000000;
            right = 0;
            
            targetX = (left + right) / 2;

            while (left < right)
            {
                targetX = (left + right) / 2;
                System.out.println(targetX + " " + tempY);
                read = in.next();

                if (read.equals("CENTER"))
                {
                    isFound = true;
                    break;
                }
                else if (read.equals("HIT"))
                {
                    right = targetX;
                }
                else if (read.equals("MISS"))
                {
                    left = targetX;
                }
                else if (read.equals("WRONG"))
                {
                    System.exit(0);
                }
            }

            if (isFound)    continue;

            borderLeft = targetX;

            //check right

            left = 0;
            right = 1000000000;
            
            targetX = (left + right) / 2;

            while (left < right)
            {
                targetX = (left + right) / 2;
                System.out.println(targetX + " " + tempY);
                read = in.next();

                if (read.equals("CENTER"))
                {
                    isFound = true;
                    break;
                }
                else if (read.equals("HIT"))
                {
                    left = targetX;
                }
                else if (read.equals("MISS"))
                {
                    right = targetX;
                }
                else if (read.equals("WRONG"))
                {
                    System.exit(0);
                }
            }

            if (isFound)    continue;
            borderRight = targetX;

            //check X testing line
            tempX = -1000000000;

            do
            {
                tempX += 200000000;
                System.out.println(tempX + " 0");
                read = in.next();
                if (read.equals("CENTER"))
                {
                    isFound = true;
                    break;
                }
            }while (!read.equals("HIT"));

            if (isFound)    continue;

            //check top

            top = 1000000000;
            bottom = 0;
            
            targetY = (top + bottom) / 2;

            while (bottom < top)
            {
                targetY = (top + bottom) / 2;
                System.out.println(tempX + " " + targetY);
                read = in.next();

                if (read.equals("CENTER"))
                {
                    isFound = true;
                    break;
                }
                else if (read.equals("HIT"))
                {
                    bottom = targetY;
                }
                else if (read.equals("MISS"))
                {
                    top = targetY;
                }
                else if (read.equals("WRONG"))
                {
                    System.out.println("WRONG");
                    System.exit(0);
                }
            }

            if (isFound)    continue;

            borderTop = targetY;

            //check bottom

            top = 0;
            bottom = -1000000000;
            
            targetY = (top + bottom) / 2;

            while (bottom < top)
            {
                targetY = (top + bottom) / 2;
                System.out.println(tempX + " " + targetY);
                read = in.next();

                if (read.equals("CENTER"))
                {
                    isFound = true;
                    break;
                }
                else if (read.equals("HIT"))
                {
                    top = targetY;
                }
                else if (read.equals("MISS"))
                {
                    bottom = targetY;
                }
                else if (read.equals("WRONG"))
                {
                    System.out.println("WRONG");
                    System.exit(0);
                }
            }

            if (isFound)    continue;

            borderBottom = targetY;

            targetX = (borderLeft + borderRight) / 2;
            targetY = (borderTop + borderBottom) / 2;
            
            System.out.println(targetX + " " + targetY);

            in.next();
        }
    }
}