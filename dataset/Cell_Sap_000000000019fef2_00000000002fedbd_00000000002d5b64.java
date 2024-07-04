import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String args[]) throws Exception{
        Scanner xy = new Scanner(System.in);
        int t = xy.nextInt();
        int r,s,k;
        for(k=0;k<t;k++){
            r = xy.nextInt();
            s = xy.nextInt();
            int p = ((r*s)/2) - 1;
            if(r == 2 && s == 2)
            {
                System.out.println("Case #"+(k+1)+": "+p);
                System.out.println("2 1");
                continue;
            }
            System.out.println("Case #"+(k+1)+": "+p);
            for(int i = 1;i<=p;i++){
                System.out.println(r + " " + s);
                if(r!=2)
                    r--;
                s--;
            }
        }
    }
}