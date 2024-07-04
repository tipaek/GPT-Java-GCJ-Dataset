import java.util.Scanner;
import java.util.ArrayList;
import java.lang.*;

public class Solution
{
    int t;
    String inputString, outputString;
    char openingBracket = '(';
    char closingBracket = ')';

    public static void main(String args[])
    {
        Solution sol = new Solution();
        sol.takeInputAndSolve();
    }

    void takeInputAndSolve()
    {
        Scanner s = new Scanner(System.in);
        t = s.nextInt();
        
        for (int a=0;a<t;a++)
        {
            inputString = s.next();
            outputString = "";
            
            if (inputString.length() == 1)
                {
                    int num = Integer.parseInt(String.valueOf(inputString.charAt(0)));
                    for (int l=0;l<num;l++)
                        {
                            outputString = outputString + openingBracket;
                        }
                        outputString = outputString + num;
                    for (int l=0;l<num;l++)
                        {
                            outputString = outputString + closingBracket;
                        }
                }
            else
            {
            for(int b=0; b<inputString.length();b++)
            {
                int num = Integer.parseInt(String.valueOf(inputString.charAt(b)));
                
                    if (b == 0)
                    {
                        int nextNum = Integer.parseInt(String.valueOf(inputString.charAt(b+1)));
                        int nextDiff = num-nextNum;
                        int nextAbsoluteDiff = Math.abs(nextDiff);
                        for (int l=0;l<num;l++)
                        {
                            outputString = outputString + openingBracket;
                        }
                        outputString = outputString + num;
                        
                        if (nextDiff < 0)
                        {
                            for (int l=0;l<nextAbsoluteDiff;l++)
                            {
                                outputString = outputString + openingBracket;
                            }
                            
                        }
                        else if (nextDiff > 0)
                        {
                            for (int l=0;l<nextAbsoluteDiff;l++)
                            {
                                outputString = outputString + closingBracket;
                            }
                        }
                    }
                    else if (b == inputString.length()-1)
                    {
                        outputString = outputString + num;
                        for (int l=0;l<num;l++)
                        {
                            outputString = outputString + closingBracket;
                        }
                    }
                    else 
                    {
                        int nextNum = Integer.parseInt(String.valueOf(inputString.charAt(b+1)));
                        int nextDiff = num-nextNum;
                        int nextAbsoluteDiff = Math.abs(nextDiff);
                        
                        if (nextDiff < 0)
                        {
                            outputString = outputString + num;
                            for (int l=0;l<nextAbsoluteDiff;l++)
                            {
                                outputString = outputString + openingBracket;
                            }
                        }
                        else if (nextDiff > 0)
                        {
                            outputString = outputString + num;
                            for (int l=0;l<nextAbsoluteDiff;l++)
                            {
                                outputString = outputString + closingBracket;
                            }
                        }
                        else
                        {
                            outputString = outputString + num;
                        }
                    }
                
                }
            }
            System.out.println("Case #"+(a+1)+": "+outputString);
        }
    }
}