
public class Solution {

    public static void main(String[] args) {
        Solver solver = new Solver(args);

    }

}


class Solver {

    public Solver(String agrs[]) {
        int h = Integer.parseInt(agrs[0]);
        for (int i = 1; i < h + 1; i++) {
            each(agrs[i], i );
        }
    }

    public void each(String line, int w) {
        boolean parO = false;
        String p = "";
        for (int i = 0; i < line.length(); i++) {

            if (!parO) {
                if (line.charAt(i) == '1') {
                    parO = true;
                    p += "(1";
                } else {
                    p += "0";
                }
            } else {
                if (line.charAt(i) == '1') {
                    p += "1";
                } else if (line.charAt(i) == '0') {
                    p += ")0";
                    parO = false;
                }
            }
        }
        if(parO){
            p+=")";
        }

        System.out.println("Case #"+w+": " +p);
    }
}
