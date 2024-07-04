import java.util.*;
import java.util.regex.Pattern;

class Solution {

    public static void main(String args[]) {

        int t, i, j, xp, yp, time = 0;

        Scanner in = new Scanner(System.in);

        t = in.nextInt();

        String str = new String();

        Pattern p = Pattern.compile("[NSEW]+");
        for (i = 1; i <= t; i++) {

            xp = in.nextInt();

            yp = in.nextInt();

            
            str = in.next(p);
            time = 0;
            boolean solutionFound = false;
            for (j = 0; j < str.length(); j++) {
                time += 1;

                if (str.charAt(j) == 'N') {

                    yp += 1;
                } else if (str.charAt(j) == 'S') {

                    yp -= 1;
                } else if (str.charAt(j) == 'E') {

                    xp += 1;
                } else {

                    xp -= 1;
                }


                if (Math.abs(xp) + Math.abs(yp) <= time) {

                    System.out.println("Case #" + i + ": " + time);
                    solutionFound = true;
                    break;

                }

            }
            if(!solutionFound) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }

        }

    }

}
