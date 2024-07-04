import java.util.Scanner;

public class Solution{

    public static void main(String []args){
        int amount;

        Scanner in = new Scanner(System.in);
        amount = Integer.parseInt(in.nextLine());

        for (int i = 0; i<amount; i++){

            String input = in.nextLine();

            int X = Integer.parseInt(input.split(" ")[0]);
            int Y = Integer.parseInt(input.split(" ")[1]);
            String path = input.split(" ")[2];

            int xCurr = X, yCurr= Y;
            int j;
            for ( j = 0; j < path.length(); j++ ){

                if ('N'==path.charAt(j)) {
                    yCurr++;
                } else if ('S'==path.charAt(j)) {
                    yCurr--;
                } else if ('E'==path.charAt(j)) {
                    xCurr++;
                } else if ('W'==path.charAt(j)) {
                    xCurr--;
                }

                if (Math.abs(yCurr)+Math.abs(xCurr)<=j+1) {
                    System.out.println("Case #" + (i + 1) + ": " + (j+1));
                    break;
                }
            }
            if (j==path.length()) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}
