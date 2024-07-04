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
            str = list[list.length - 1].substring(1);
            for(int i = 0; i < list.length - 1; i++)
            {
                if(!(list[i].substring(1).equals(list[list.length - 1].substring(list[list.length - 1].length() - list[i].length() + 1))))
                {
                    str = "*";
                }
            }
            System.out.println("Case #" + (x + 1) + ": " + str);
        }
        
        input.close();
    }

    //"S".equals("COCONUTS")
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