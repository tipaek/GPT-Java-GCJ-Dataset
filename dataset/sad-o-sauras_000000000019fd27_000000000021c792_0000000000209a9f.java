import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	public static void main (String[] args) throws java.lang.Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for(int test = 1;test<=t;test++){
            String s = sc.nextLine();
            
            s = s.replaceAll("1", "(1)");
            s = s.replaceAll("2", "((2))");
            s = s.replaceAll("3", "(((3)))");
            s = s.replaceAll("4", "((((4))))");
            s = s.replaceAll("5", "(((((5)))))");
            s = s.replaceAll("6", "((((((6))))))");
            s = s.replaceAll("7", "(((((((7)))))))");
            s = s.replaceAll("8", "((((((((8))))))))");
            s = s.replaceAll("9", "(((((((((9)))))))))");
            
            int ref = s.indexOf(")(");
            while(ref>=0){
                s = s.replaceAll("\\)\\(", "");
                ref = s.indexOf(")(");
            }
            System.out.println("Case #"+test+": "+s);
        }
        
	}
}
        