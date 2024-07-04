import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int merp = s.nextInt();

        for(int i=0; i<merp; i++) {
            System.out.println("Case #" + (i+1) + ": ");

            int N = s.nextInt();
            System.out.println("1 1");
            System.out.println("1 1");
            System.out.println("2 2");

            N-=4;

            for(int j=0; j<N; j++) {
                System.out.println((3+j) + " " + 0);
            }
        }

        s.close();
    }

}
