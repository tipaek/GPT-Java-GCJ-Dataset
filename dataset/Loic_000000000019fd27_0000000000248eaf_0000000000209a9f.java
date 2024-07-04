
public class Solution {

    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        for (int i = 1; i < h + 1; i++) {
             boolean parO = false;
             String line = args[i];
        String p = "";
        for (int j = 0; j < line.length(); j++) {

            if (!parO) {
                if (line.charAt(j) == '1') {
                    parO = true;
                    p += "(1";
                } else {
                    p += "0";
                }
            } else {
                if (line.charAt(j) == '1') {
                    p += "1";
                } else if (line.charAt(j) == '0') {
                    p += ")0";
                    parO = false;
                }
            }
        }
        if(parO){
            p+=")";
        }

        System.out.println("Case #"+i+": " +p);
        }
    }

}

