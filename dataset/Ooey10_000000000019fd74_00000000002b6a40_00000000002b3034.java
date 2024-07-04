import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String [] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        input.nextLine();
        
        for(int x = 0; x < cases; x++)
        {
            int repeat = input.nextInt();
            input.nextLine();
            String[] list = new String[repeat];
            String str = "";
            for(int i = 0; i < repeat; i++)
            {
                list[i] = input.nextLine();
            }
            sort(list, repeat);
            for(int i = repeat-1; i >= 0; i--)
            {
                for(int y = i - 1; y >= 0; y--)
                {
                    if(!(list[i].length() > 1 && list[y].length() > 1 && list[i].substring(1, list[i].length()).contains(list[y].substring(1, list[y].length()))))
                    {
                        str = "*";
                    }
                }
            }
            if(str != "*")
            {
                int max = 0;
                for(int i = 0; i < repeat; i++)
                {
                    if(list[i].length() > max)
                    {
                        max = list[i].length();
                        str = list[i].substring(1);
                    }
                }
            }
            System.out.println("Case #" + (x + 1) + ": " + str);
        }
        
        input.close();
    }


    static void sort(String []s, int n) 
    { 
        for (int i=1 ;i<n; i++) 
        { 
            String temp = s[i]; 
    
            // Insert s[j] at its correct position 
            int j = i - 1; 
            while (j >= 0 && temp.length() < s[j].length()) 
            { 
                s[j+1] = s[j]; 
                j--; 
            } 
            s[j+1] = temp; 
        } 
    } 
}