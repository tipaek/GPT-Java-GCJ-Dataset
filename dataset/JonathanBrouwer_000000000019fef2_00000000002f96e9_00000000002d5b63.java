import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        in.nextLine();
        for(int id = 1; id <= t; id++) {
            solution(in, id, a, b);
        }
    }

    private static void solution(Scanner in, int id, int a, int b) {
        //(0, 0) is always included
        //Try to find left boundary
        int left;
        int right;
        int bottom;
        int top;
        {
            int min = -1000000000;
            int max = 0;

            while(min < max) {
                int center = (min + max) / 2;
                if(min + 1 == max) center = min;
                System.out.println(center + " 0");
                String response = in.nextLine();
                if(response.equals("CENTER")) return;
                if(response.equals("WRONG")) throw new IllegalStateException("Wrong");
                if(response.equals("HIT")) {
                    max = center;
                }else{
                    min = center + 1;
                }
            }
            left = min;
        }
        {
            int min = 0;
            int max = 1000000000;

            while(min < max) {
                int center = (min + max) / 2;
                if(min + 1 == max) center = max;
                System.out.println(center + " 0");
                String response = in.nextLine();
                if(response.equals("CENTER")) return;
                if(response.equals("WRONG")) throw new IllegalStateException("Wrong");
                if(response.equals("HIT")) {
                    min = center;
                }else{
                    max = center - 1;
                }
            }
            right = min;
        }
        {
            int min = -1000000000;
            int max = 0;

            while(min < max) {
                int center = (min + max) / 2;
                if(min + 1 == max) center = min;
                System.out.println("0 " + center);
                String response = in.nextLine();
                if(response.equals("CENTER")) return;
                if(response.equals("WRONG")) throw new IllegalStateException("Wrong");
                if(response.equals("HIT")) {
                    max = center;
                }else{
                    min = center + 1;
                }
            }
            bottom = min;
        }
        {
            int min = 0;
            int max = 1000000000;

            while(min < max) {
                int center = (min + max) / 2;
                if(min + 1 == max) center = max;
                System.out.println("0 " + center);
                String response = in.nextLine();
                if(response.equals("CENTER")) return;
                if(response.equals("WRONG")) throw new IllegalStateException("Wrong");
                if(response.equals("HIT")) {
                    min = center;
                }else{
                    max = center - 1;
                }
            }
            top = min;
        }

        int avg_x = (left + right) / 2;
        int avg_y = (top + bottom) / 2;
        System.out.println(avg_x + " " + avg_y);
        String response = in.nextLine();
        if(!response.equals("CENTER")) throw new IllegalStateException();
    }


}