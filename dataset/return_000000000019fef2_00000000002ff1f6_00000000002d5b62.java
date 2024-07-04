import java.util.Scanner;

public class Solution {
    public static String solver(long x, long y, long fx, long fy, long d, String str) {
//        System.out.println(x + " " + y + " " + fx + " " + fy + " " + d + " " + str);
        if(Math.abs(x) > Math.abs(fx) || Math.abs(y) > Math.abs(fy))
            return "";

        long nx = fx < 0 ? x - d : x + d;
        long ny = fy < 0 ? y - d : y + d;


        if(nx == fx && y == fy)
            return str + (fx < 0 ? "W" : "E");
        else if(x == fx && ny == fy)
            return str + (fy < 0 ? "S" : "N");

        String ans1 = solver(nx, y, fx, fy, d*2, fx < 0 ? "W" : "E");
        String ans2 = solver(x, ny, fx, fy, d*2, fx < 0 ? "S" : "N");


        if(ans1.length() == 0 && ans2.length() == 0)
            return "";
        if (ans2.length() == 0)
            return str + ans1;
        if (ans1.length() == 0)
            return str + ans2;
        return ans1.length() < ans2.length() ? str + ans1 : str + ans2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        long x, y;
        for(long i=1; i<=t; i++) {
            x = sc.nextLong();
            y = sc.nextLong();

            String finalAns="";
            String ans1 = solver(1, 0, x, y, 2, "E");
            if(ans1.length() > 0)
                finalAns = ans1;
            String ans2 = solver(0, 1, x, y, 2, "N");
            if(ans2.length() > 0)
                finalAns = ans2;
            String ans3 = solver(-1, 0, x, y, 2, "W");
            if(ans3.length() > 0)
                finalAns = ans3;
            String ans4 = solver(0, -1, x, y, 2, "S");
            if(ans4.length() > 0)
                finalAns = ans4;

            if(ans1.length()>0 && ans1.length() <= finalAns.length())
                finalAns = ans1;
            if(ans2.length()>0 && ans2.length() <= finalAns.length())
                finalAns = ans2;
            if(ans3.length()>0 && ans3.length() <= finalAns.length())
                finalAns = ans3;
            if(ans4.length()>0 && ans4.length() <= finalAns.length())
                finalAns = ans4;

            if(finalAns.length() == 0)
                System.out.println("CASE #"+ i + ": IMPOSSIBLE");
            else
                System.out.println("CASE #"+ i + ": " + finalAns);
        }

    }
}
