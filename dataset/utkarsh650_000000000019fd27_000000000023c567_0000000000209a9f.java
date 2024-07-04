import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner x = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = x.nextInt();
        String s = x.nextLine();
        for(int p=1; p<=t; p++)
        {
            s = x.nextLine();
            String sdash = ""; int l = s.length();
            
            int depth = 0;
            for(int i=0; i<l; i++)
            {
                int n = s.charAt(i)-48;
                while(n>depth) {sdash+="("; depth++;}
                while(n<depth) {sdash+=")"; depth--;}
                sdash+=n;
            }
            while(depth>0) {sdash+=")"; depth--;}
            
            System.out.println("Case #"+p+": "+sdash);
        }
    }
}