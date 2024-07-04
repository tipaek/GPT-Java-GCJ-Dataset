import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long T = input.nextLong();
        input.nextLine();

        for (long i = 0; i < T; i++) {
            String s = input.nextLine();
            for (int j = 1; j <= 9; j++) {
                String newString = "";
                if(j==1){
                    newString = "(1)";
                }else if(j==2){
                    newString = "((2))";
                }else if(j==3){
                    newString = "(((3)))";
                }else if(j==4){
                    newString = "((((4))))";
                }else if(j==5){
                    newString = "(((((5)))))";
                }else if(j==6){
                    newString = "((((((6))))))";
                }else if(j==7){
                    newString = "(((((((7)))))))";
                }else if(j==8){
                    newString = "((((((((8))))))))";
                }else if(j==9){
                    newString = "(((((((((9)))))))))";
                }
                s = s.replace(j + "", newString);
            }

            for (int j = 1; j <= 9; j++) {
                s = s.replace(")(", "");
            }

            System.out.println("Case #" + (i + 1) + ": " + s);
        }
    }
}
