import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountCases = scanner.nextInt();

        for (int currentCase = 1; currentCase <= amountCases; currentCase++) {
            System.out.print("Case #" + currentCase + ": ");
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner) {

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        boolean xNeg = x < 0;
        boolean yNeg = y < 0;

        x = Math.abs(x);
        y = Math.abs(y);

        String[] bx = new String[2];
        String[] by = new String[2];

        bx[0] = new StringBuilder(Integer.toBinaryString(x)).toString().replace('1', 'E');
        by[0] = new StringBuilder(Integer.toBinaryString(y)).reverse().toString().replace('1', 'N');


        int x2 = pow2(bx[0].length()) - x;
        int y2 = pow2(by[0].length()) - y;

        bx[1] = new StringBuilder(Integer.toBinaryString(x2)).toString();
        bx[1] = "E" + String.format("%1$" + bx[0].length() + "s", bx[1]).replace(' ',  '0').replace('1', 'W');

        by[1] = new StringBuilder(Integer.toBinaryString(y2)).toString();
        by[1] = "N" + String.format("%1$" + by[0].length() + "s", by[1]).replace(' ',  '0').replace('1', 'S');


        boolean impossible = false;
        String output = "";
        outer:for (int xx = 0; xx < 2; xx++) {
            for (int yy = 0; yy < 2; yy++) {
                String currX = bx[xx];
                String currY = by[yy];
                if(currX.length() > currY.length()){
                    currY = String.format("%1$" + currX.length() + "s", currY).replace(' ',  '0');
                }else if(currY.length() > currX.length()){
                    currX = String.format("%1$" + currY.length() + "s", currX).replace(' ',  '0');
                }


                int l = currX.length();
                impossible = false;
                output = "";
                for (int i = l-1; i >= 0; i--) {
                    if(currX.charAt(i) == '0' && currY.charAt(i) == '0'){
                        impossible = true;
                    }else if(currX.charAt(i) != '0' && currY.charAt(i) != '0'){
                        impossible = true;
                    }else if(currX.charAt(i) != '0'){
                        output += currX.charAt(i);
                    }else{
                        output += currY.charAt(i);
                    }
                }
                if(!impossible){
                    break outer;
                }
            }
        }





        if (xNeg) {
            output = output.replace('E', 'P');
            output = output.replace('W', 'E');
            output = output.replace('P', 'W');
        }
        if (yNeg) {
            output = output.replace('N', 'P');
            output = output.replace('S', 'N');
            output = output.replace('P', 'S');
        }
        if (impossible) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(output);
        }
    }

    public static int pow2(int n) {
        int res = 1;
        while (n > 0) {
            res *= 2;
            n--;
        }
        return res;
    }
}