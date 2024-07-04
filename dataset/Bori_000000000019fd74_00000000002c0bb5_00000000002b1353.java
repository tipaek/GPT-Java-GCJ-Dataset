import java.util.Scanner;

public class Solution {

    static Scanner scanner;


    public static void main(String[] args){
        scanner = new Scanner(System.in);
        int noTests = scanner.nextInt();
        int n;
        int x, y;
        for(int t=1; t<=noTests; t++){
            n = scanner.nextInt();
            x=1;
            y=1;
            if(n<=500){
                System.out.println("Case #" + t + ":");
                for(int i=1; i<=n; i++){
                    System.out.println(x + " " + y);
                    x++;
                }
            }
            else if(n==501){
                System.out.println("Case #" + t + ":");
                System.out.println("1 1");
                System.out.println("2 1");
                System.out.println("3 1");
                System.out.println("3 2");
                System.out.println("3 3"); //sum = 6
                x=4;
                y=4;
                for(int i=1; i<=n-6; i++){
                    System.out.println(x + " " + y);
                    x++;
                    y++;
                }
            }
            else{
                if(n>521){
                    System.out.println("Case #" + t + ":");
                    for(int i=1; i<=9; i++){
                        System.out.println(x + " " + y);
                        x++;
                    }
                    //x=10, y=1
                    //go to 10th row
                    for(int i=1; i<=10; i++){
                        System.out.println(x + " " + y);
                        y++;
                    }
                    x++;
                    //now sum = 512 + 9 = 521
                    //I have taken 19 steps
                    for(int i=1; i<=n-521; i++){ //max 479 more steps
                        System.out.println(x + " " + y);
                        x++;
                        y++;
                    }
                }
                else{
                    System.out.println("Case #" + t + ":");
                    for(int i=1; i<=8; i++){
                        System.out.println(x + " " + y);
                        x++;
                    }
                    //x=9, y=1
                    //go throughh 9th row
                    for(int i=1; i<=9; i++){
                        System.out.println(x + " " + y);
                        y++;
                    }
                    //now sum = 256 + 8 = 264
                    //I have taken 17 steps
                    x++;
                    for(int i=1; i<=n-264; i++){ //max 521-264 more steps
                        System.out.println(x + " " + y);
                        x++;
                        y++;
                    }
                }
            }
        }
    }
}
