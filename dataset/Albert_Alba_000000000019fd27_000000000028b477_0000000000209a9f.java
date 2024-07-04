

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        for(int i = 0; i < count; i ++){
            String s = sc.nextLine();
            System.out.print("Case #" + (i + 1) + ": ");
            int open = 0;
            for (int a = 0; a < s.length(); a++){
                int num = s.charAt(a) - '0';
                for(int b = 0; b <= num; b++){
                    if(open < num){
                        System.out.print("(");
                        open++;
                    }
                    if(open > num){
                        System.out.print(")");
                        open--;
                    }
                }
                System.out.print(num);
            }
            for(int a = 0; a < open; a++){
                System.out.print(")");
            }
            System.out.println();
        }
    }
}
