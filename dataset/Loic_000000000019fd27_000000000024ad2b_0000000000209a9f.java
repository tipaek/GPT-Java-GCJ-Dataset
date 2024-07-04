
public class Solution {

    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]) + 1;
        for (int i = 1; i < h ; i++) {
             boolean parO = false;
             String p = "Case #"+i+": ";
            for (int j = 0; j < args[i].length(); j++) {
    
                if (!parO) {
                    if ( args[i].charAt(j) == '1') {
                        parO = true;
                        p += "(1";
                    } else {
                        p += "0";
                    }
                } else {
                    if ( args[i].charAt(j) == '1') {
                        p += "1";
                    } else {
                        p += ")0";
                        parO = false;
                    }
                }
            }
            if(parO){
                p+=")";
            }
            
            System.out.println(p);

        }
    }

}

