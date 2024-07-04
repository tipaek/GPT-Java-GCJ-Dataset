import java.io.*;
import java.util.*;

 class Solution {

    static Scanner scan;

    public static void main(String args[]) {
        scan = new Scanner(System.in);
        int t = scan.nextInt();
        int a = scan.nextInt();
        int b = scan.nextInt();
        if (a == b && b == (int)(Math.pow(10, 9) - 5)) {
            solve1();
        }
        else if(a==b && b==Math.pow(10, 9)-50){
        
        }
    }
    public static void solve2(){
    for (int i = 0; i <= 5; i++) {
            boolean b = false;
            for (int j = -50; j <= 50; j++) {
                System.out.println(i + " " + j);
                String response = scan.next();
                if (response.equalsIgnoreCase("CENTER")) {
                    b = true;
                    break;
                }
            }
            if (b) {
                break;
            }
        }
    }
    public static void solve1() {
        for (int i = -10; i <= 10; i++) {
            boolean b = false;
            for (int j = -10; j <= 10; j++) {
                System.out.println(i + " " + j);
                String response = scan.next();
                if (response.equalsIgnoreCase("CENTER")) {
                    b = true;
                    break;
                }
            }
            if (b) {
                break;
            }
        }
    }
}
