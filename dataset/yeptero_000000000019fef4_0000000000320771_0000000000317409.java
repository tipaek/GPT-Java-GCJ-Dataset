import java.util.Scanner;

public class Solution {
    static public int T;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        T = Integer.parseInt(input.next());

        for(int t = 1; t <= T; t ++){
            int east = Integer.parseInt(input.next());
            int north  = Integer.parseInt(input.next());

            String dir = input.next();

            if(east == 0 && north == 0){
                System.out.println("Case #" + t + ": " + 0);
            }
            else {

                int minTime = -1;

                for (int i = 0; i < dir.length(); i++) {
                    if (dir.substring(i, i + 1).equals("S")) {
                        north = north - 1;
                    }
                    if (dir.substring(i, i + 1).equals("N")) {
                        north = north + 1;
                    }
                    if (dir.substring(i, i + 1).equals("E")) {
                        east = east + 1;
                    }
                    if (dir.substring(i, i + 1).equals("W")) {
                        east = east - 1;
                    }

                    int total = Math.abs(east) + Math.abs(north);

                    if (total <= i + 1) {
                        minTime = i + 1;
                        i = dir.length();
                    }
                }

                if (minTime == -1) {
                    System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + t + ": " + minTime);
                }
            }



        }



    }
}
