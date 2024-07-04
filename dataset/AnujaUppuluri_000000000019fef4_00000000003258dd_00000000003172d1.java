import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

class Solution
{
    static Scanner sc = new Scanner (System.in);
    public static void main(String args[])
    {
        int T=sc.nextInt();
        for(int z=1;z<=T;z++)
        
        {
            int k = getRandomNumInRange(0, 3);

            System.out.println("Case #" +z+ ":"+" " +k); //Case #1: 4 0 0


        }
    }
    private static int getRandomNumInRange(int min, int max)
    {
        if (min>=max)
        {
            throw new IllegalArgumentException("max must be greater than the minimum");
        }
        return (int)(Math.random() * ((max-min) + 1)) + min;
    }
    
    
}