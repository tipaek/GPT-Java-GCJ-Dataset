import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {


        int t;

        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            String m = sc.next();
            int px = x;
            int py = y;


            int mx = 0;
            int my = 0;
            boolean reached = false;

            int time = 0;

            if(y > m.length()) {
                time = -1;
                reached = false;
            }

            else {
                while(time < m.length()) {

                    //time++;

                    switch(m.charAt(time)) {
                        case 'N':
                            py++;
                            break;
                        case 'S':
                            py--;
                            break;
                        case 'E':
                            px++;
                            break;
                        case 'W':
                            px--;
                            break;
                        default:
                            System.out.println("Default reached!!");
                    }


                    if(mx != px) {
                        if(px > mx) {
                            mx++;
                        }
                        else {
                            mx--;
                        }
                    }
                    else {
                        if(py > my + 1) {
                            my++;
                        }
                        else if(px < my - 1) {
                            my--;
                        }
                        else {
                            //stay
                        }
                    }
                    if(mx == px && my == py) {
                        reached = true;
                        break;
                    }
                    time++;

                }



            }





            System.out.println("Case #" + (i+1) + ": " + (!reached? "IMPOSSIBLE": time+1));


        }

    }
}
