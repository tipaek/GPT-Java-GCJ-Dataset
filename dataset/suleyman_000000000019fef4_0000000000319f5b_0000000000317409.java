import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int caseNo=1; caseNo<= T; caseNo++) {  // each case

            int x = Integer.parseInt(scanner.next());
            int y = Integer.parseInt(scanner.next());
            String d = scanner.next();

            String res = "IMPOSSIBLE";

            if(Math.abs(x) + Math.abs(y) <= 0) {

                res = "0";
            }
            else {
                for (int i = 0; i < d.length(); i++) {

                    //System.out.println("before x:" + x + " y:" + y + " i:" + i);

                    switch (d.charAt(i)) {
                        case 'N':
                            y++;
                            break;
                        case 'S':
                            y--;
                            break;
                        case 'E':
                            x++;
                            break;
                        case 'W':
                            x--;
                            break;
                    }

                    //System.out.println("after x:" + x + " y:" + y + " i:" + i);

                    if (Math.abs(x) + Math.abs(y) <= i+1) {

                        res = String.valueOf(i+1);
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNo + ": " + res);
        }
    }
}
