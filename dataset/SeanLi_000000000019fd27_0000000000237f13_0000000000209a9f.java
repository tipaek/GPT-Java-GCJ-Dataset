import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
/*
        Scanner sc = null;
        try {
            sc = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
*/
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= t; i++) {
            solve(sc, i);
        }
    }

    private static void solve(Scanner sc, int c) {
        int current = 0;
        StringBuffer sb = new StringBuffer();
        for (char value : sc.nextLine().toCharArray()) {
            int num = value - '0';
            if(num == current) {
                sb.append(num);
            } else if (num<current){
                for(int i=0;i<current-num;i++){
                    sb.append(')');
                }
                sb.append(num);
                current = num;
            } else {
                for(int i=0;i<num-current;i++){
                    sb.append('(');
                }
                sb.append(num);
                current = num;
            }
        }
        for (int i = 0; i <current ; i++) {
            sb.append(')');
        }

        System.out.printf("Case #%d: %s\n", c, sb.toString());
    }
}
