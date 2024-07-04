package com.sanfoundry.setandstring;
 
import java.util.Scanner;
 
public class StringSearchUsingStrLib
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the main string: ");
        String text = sc.nextLine();
        System.out.println("Enter the pattern string: ");
        String pattern = sc.nextLine();
        for (int i = 0; i <= (text.length() - pattern.length()); i++)
        {
            if (text.substring(i, (i + pattern.length())).equalsIgnoreCase(
                    pattern))
            {
                System.out.println(pattern
                        + " is substring of main string, match found at: "
                        + ++i);
            }
        }
        sc.close();
    }
}    