import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nam =sc.nextInt();
        for(int tr = 0; tr < nam; tr++){
            sc.nextLine();

            int amountLeft = sc.nextInt();
            System.out.println("Case #" + (tr+1) + ":");

            while(amountLeft > 0){
                if(amountLeft >= 5){
                    System.out.println("1 1");
                    System.out.println("2 2");
                    System.out.println("3 2");
                    System.out.println("2 1");
                    amountLeft -=5;
                }else if(amountLeft == 4){
                    System.out.println("1 1");
                    System.out.println("2 2");
                    System.out.println("3 2");
                    amountLeft -=4;
                }else if(amountLeft == 3){
                    System.out.println("1 1");
                    System.out.println("2 2");
                    System.out.println("2 1");
                    amountLeft -=3;
                }else if(amountLeft == 2){
                    System.out.println("1 1");
                    System.out.println("2 2");
                    amountLeft -=2;
                }else{
                    System.out.println("1 1");                    amountLeft -=1;
                }
            }
        }
    }
}
