import java.util.Scanner;



    public class Solution {
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int t = Integer.parseInt(s.nextLine());
            for (int ii = 1; ii <= t; ii++) {
                 String[] d = s.nextLine().split(" ");
                 int X = Integer.parseInt(d[0]);
                int Y = Integer.parseInt(d[1]);
                String M = d[2];
                int xc = X;
                int yc = Y;
                int time = M.length();
                int time1 = M.length();
                for(int i=0; i < M.length(); i++){
                    if (M.charAt(i) == 'W'){

                        if (xc > 0) {

                            xc = xc - 1;
                            time1--;
                        }
                    }
                    if (M.charAt(i) == 'E'){
                        xc = xc + 1;

                        time1--;
                    }
                    if (M.charAt(i) == 'N'){
                        yc = yc + 1;

                        time1--;
                    }
                    if (M.charAt(i) == 'S'){

                        if (yc > 0) {

                            yc = yc - 1;
                            time1--;
                        }
                    }
                    if (xc <= 0) {

                        xc = 0;
                        break;
                    }
                    if (yc <= 0) {
                        yc = 0;
                        break;
                    }
                   time++;
                }
                //System.out.println("time = " + time1 + "xc = " + xc + "yc = " + yc);
                if (Math.max((time1+Math.abs(xc) + Math.abs(yc))
                            ,M.length()-(time1+Math.abs(xc) + Math.abs(yc))) <=  M.length() ){
                    System.out.println("Case #" + ii + ": " + Math.max((time1+Math.abs(xc) + Math.abs(yc))
                            ,M.length()-(time1+Math.abs(xc) + Math.abs(yc))));
                }
                else{
                    System.out.println("Case #" + ii + ": " + "IMPOSSIBLE");
                }
            }
        }
    }

