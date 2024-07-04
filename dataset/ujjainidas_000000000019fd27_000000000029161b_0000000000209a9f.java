import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc  = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(sc.nextLine());
        for(int i = 1; i<=testCases; i++)
        {
            System.out.println("Case #" + i + ": " + recur(sc.nextLine(), 0));
        }

    }

    public static String addParen(String string, int n)
    {
        for(int i = 0; i<n; i++)
        {
            string = "("+string+")";
        }
        return string;
    }

    public static int[] substring(String s, int n)
    {
        int a = 0;
        int b = 0;
        if(s.equals(""))
        {

        }
        else
        {
            String split[] = s.split("");
            for(a = 0; a<split.length; a++)
            {
                if(!split[a].equals("(") && !split[a].equals(")") && Integer.parseInt(split[a]) > n)
                {
                    for(b = a; b<=split.length; b++)
                    {
                        if(b == split.length)
                        {
                            break;
                        }
                        if(!split[b].equals("(") && !split[b].equals(")") && Integer.parseInt(split[b]) <= n)
                        {
                            break;
                        }
                    }
                    break;
                }
            }
        }

        int[] arr = {a, b};
        return arr;
    }

    public static int smallestNum(String s)
    {
        int smallest = 10;
        int num = -1;
        if(s.equals(""))
        {

        }
        else
        {
            String[] split = s.split("");
            for(int i = 0; i<split.length; i++)
            {
                if(!split[i].equals("(") && !split[i].equals(")"))
                {
                    num = Integer.parseInt(split[i]);
                    if(num < smallest)
                    {
                        smallest = num;
                    }
                }
            }
        }
        return smallest;
    }

    public static String recur(String string, int n)
    {
        int[] arr = substring(string, n);
        if(arr[0] >= arr[1])
        {
            return string;
        }
        String substring = string.substring(arr[0], arr[1]);
        String start = string.substring(0, arr[0]);
        String end = string.substring(arr[1]);
        int smallest = smallestNum(substring);
        int smallestStart = smallestNum(start);
        int smallestEnd = smallestNum(end);
        substring = addParen(substring, smallest-n);
        return recur(start, smallestStart) + recur(substring, smallest) + recur(end, smallestEnd);
    }
}
