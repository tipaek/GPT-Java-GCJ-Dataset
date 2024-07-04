import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[])
    {
        int test = 1,t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        int p_x,p_y;
        //int f_x = 0,f_y = 0;
        while(test <= t)
        {
            p_x = sc.nextInt();
            p_y = sc.nextInt();
           // sc.nextLine();
            String s;
            s = sc.next();
            helper(p_x,p_y,s,test);
            test++;
        }
    }
    public static void helper(int p_x,int p_y,String s,int test)
    {
        int f_x = 0,f_y = 0;
        for(int i =0;i<s.length();i++)
        {
            if(s.charAt(i) == 'S') p_y--;
            else if(s.charAt(i) == 'N') p_y++;
            else if(s.charAt(i) == 'E')p_x++;
            else p_x--;
            if(Math.abs(p_x) + Math.abs(p_y) <= i+1){
            System.out.println("Case #"+test+": "+(i+1));
            return;
            }
        }
        System.out.println("Case #"+test+": "+"IMPOSSIBLE");
    }
}