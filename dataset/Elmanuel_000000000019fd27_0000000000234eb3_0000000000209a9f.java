import java.util.Scanner;

public class Solution {
    public static void main(String args[]){
        Scanner read = new Scanner(System.in);
        int cases = read.nextInt();
        int act = 1;
        while(act <= cases){
            String line = read.next();
            System.out.println("Case #"+(act)+": "+solve(line));
            act++;
        }
    }
    public static String solve(String line){
        String sol = "";
        int actDepth = 0;
        for(int i = 0; i < line.length(); i++){
            int actVal = line.charAt(i)-'0';
            while(actDepth < actVal){
                sol += "(";
                actDepth++;
            }
            while(actDepth > actVal){
                sol += ")";
                actDepth--;
            }
            sol+=actVal;
        }
        while(actDepth > 0){
            sol += ")";
            actDepth--;
        }
        return sol;
    }
}