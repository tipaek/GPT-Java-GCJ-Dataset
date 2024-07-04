import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.lang.*;
public class Solution
{
    private static Scanner scan = new Scanner(System.in);
    static int tn = 1;
    public static void main(String args[])
    {

        int t = scan.nextInt();
        scan.nextLine();
        while(t-- > 0)
        {
            solution();
        }
    }

private static void solution()
    {
        String str = scan.nextLine();
        StringBuilder builtString = new StringBuilder();
        char[] characters = str.toCharArray();
    
        int first = Character.getNumericValue(characters[0]);
        int num = first;
        int brackets = first;

        for(int i = 0; i < first;i++)
        {
            builtString.append('(');
        }
        builtString.append(first);

        for(int i = 1;i < characters.length; i++)
        {
            int numValue = Character.getNumericValue(characters[i]);
            if(numValue== num)
            {
            builtString.append(numValue);
            }
            else if(numValue> num)
            {
            int diff = numValue - num;
            for(int j = 0;j < diff;j++)
            {
                builtString.append('(');
                brackets++;
            }
            builtString.append(numValue);
            }
            else{
                int difference = num -numValue;
                for(int j = 0; j <difference;j++)
                {
                    builtString.append(')');
                    brackets--;
                }
                    builtString.append(numValue);              
            }
            num = Character.getNumericValue(characters[i]);
        }
        while(brackets-- > 0)
        {
            builtString.append(')');
        }        System.out.println("Case #" + (tn++) + ": " + builtString.toString());

        }
       
    
    }
