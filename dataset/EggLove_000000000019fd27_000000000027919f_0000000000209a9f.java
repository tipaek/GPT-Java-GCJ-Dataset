import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for(int i = 0; i < T; i++){
            solve(in, i + 1);
        }
    }
    
    public static void solve(Scanner in, int num){
        String s = in.next();
        int a = 0;
        int b = Integer.parseInt(s.substring(0, 1));
        System.out.println(b);
        int counter = 0;
        
        System.out.print("Case #" + num + ": ");
        for(int i = 1; i < s.length(); i++){
            counter = a - b;
            if(counter < 0){
                print(counter);
            } else if(counter > 0){
                print(counter);
            }
            System.out.print(b);
            a = b;
            b = Integer.parseInt(s.substring(i, i + 1));
        }
        counter = a - b;
        print(counter);
        System.out.print(b);
        print(b);
        System.out.println();
    }
    
    public static void print(int n) {
    	if(n < 0) {
    		for(int i = 0; i < Math.abs(n); i++) System.out.print("(");
    	} else if(n > 0) {
    		for(int i = 0; i < n; i++) System.out.print(")");
    	}
    }
}
