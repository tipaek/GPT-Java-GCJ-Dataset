import java.util.*;

class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();

        int B = in.nextInt();
        
        for (int testCase = 1; testCase <= T; testCase++)
        {
            StringBuilder out = new StringBuilder();

            for (int i = 1; i <= B; i++)
            {
                out.append("x");
            }

            //first 10 is a gift, just grab it!
            for (int a = 1; a <= 5; a++)
            {
                System.out.println(a);
                char input = in.next().charAt(0); 
                out.setCharAt(a - 1, input);
            }
            for (int a = B; a >= B-4; a--)
            {
                System.out.println(a);
                char input = in.next().charAt(0); 
                out.setCharAt(a - 1, input);
            }

            //check for potential checker
            int indexToReverse = -1, indexToFlip = -1;
            for (int i = 0; i <= 4; i++)
            {
                if (out.charAt(i) != out.charAt(B - i - 1)) indexToReverse = i;
                else    indexToFlip = i;
            }

            //REAL THING HERE
            int attempt = 1;
            int lastX = 0;
            boolean isFront = true;

            while (out.indexOf("x") != -1 && attempt <= 140)
            {
                if (attempt % 10 == 1)
                {
                    boolean isFlipped = false, isReversed = false;
                    //something might happen
                    //first, check if we are ready
                    if (indexToFlip != -1)
                    {
                        System.out.println((indexToFlip+1));
                        attempt++;
                        char checkFlip = in.next().charAt(0);
                        if (out.charAt(indexToFlip) != checkFlip)
                        {
                            //WE ARE FLIPPED!
                            //adjust to the current situation
                            isFlipped = true;
                            for (int i = 0; i < B; i++)
                            {
                                if (out.charAt(i) == '0')
                                {
                                    out.setCharAt(i, '1');
                                }
                                else if (out.charAt(i) == '1')
                                {
                                    out.setCharAt(i, '0');
                                }
                            }
                        }
                    }

                    //next, reversed?
                    if (indexToReverse != -1)
                    {
                        System.out.println((indexToReverse+1));
                        attempt++;
                        char checkReverse = in.next().charAt(0);
                        if ((!isFlipped && out.charAt(indexToReverse) != checkReverse) || 
                            (isFlipped && out.charAt(indexToReverse) != checkReverse))
                        {
                            //WE ARE REVERSED!
                            //adjust to the current situation
                            isReversed = true;
                            out.reverse();
                        }
                    }
                    
                    //if one of two was not checked, the attempt number will be shifted. 
                    //We must fix that by wasting 1 attempt
                    if (attempt % 10 != 3)
                    {
                        System.out.println(1);
                        in.nextInt();
                        attempt++;
                    }
                }


                //ok, let's do our business next
                if (isFront)
                {
                    int currentIndex = out.indexOf("x");
                    System.out.println((currentIndex+1));                    
                    char input = in.next().charAt(0); 
                    out.setCharAt(currentIndex, input);
                    attempt++;
                    isFront = false;
                    lastX = currentIndex;
                }
                else
                {
                    System.out.println((B-lastX));
                    char input = in.next().charAt(0); 
                    out.setCharAt(B-lastX-1, input);
                    attempt++;
                    //check if we still need checker
                    if (indexToFlip == -1)
                    {
                        if (out.charAt(lastX) == out.charAt(B-lastX-1)) indexToFlip = lastX;
                    }
                    else if (indexToReverse == -1)
                    {
                        if (out.charAt(lastX) != out.charAt(B-lastX-1)) indexToReverse = lastX;
                    }
                    isFront = true;
                }
            }

            //print output
            System.out.println(out.toString());
            in.next();
        }
    }
}