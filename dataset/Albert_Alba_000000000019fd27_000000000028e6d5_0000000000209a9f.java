
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < count; i ++){
            System.out.print("Case #" + (i + 1) + ": ");
            String s = sc.nextLine();
            int open = 0;
            for (int a = 0; a < s.length(); a++){
                int num = s.charAt(a) - '0';
                while (open > num){
                    System.out.print(")");
                    open--;
                }
                while (open < num){
                    System.out.print("(");
                    open++;
                }
                System.out.print(num);
            }
            while (open!=0){
                System.out.print(")");
                open--;
            }
            System.out.println();
        }
    }
}