import java.util.*;
import java.io.*;

public class Solution{
    
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int i=0; i<t; i++){
            System.out.print("Case #" + (i + 1) + ": ");
            solve(in);
        }
        in.close();
    }
    
    public static void solve(Scanner in){
        System.out.println("");
        int n = in.nextInt();
        int t = (n + 1)/2;
        for(int i=1; i<=t; i++){
            System.out.println(i + " " + 1);
        }
        if(n%2 == 0){
            t++;
        }
        System.out.println(t + " " + 2);
    }
    
}