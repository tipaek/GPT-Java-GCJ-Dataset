
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]) + 1;
        List<String> ll = new ArrayList();
        for (int i = 1; i < h ; i++) {
             boolean parO = false;
             String p = "Case #"+i+": ";
            for (int j = 0; j < args[i].length(); j++) {
    
                if (!parO) {
                    if ( args[i].charAt(j) == '1') {
                        parO = true;
                        p += "(1";
                    } else {
                        p += args[i].charAt(j);
                    }
                } else {
                    if ( args[i].charAt(j) == '1') {
                        p += "1";
                    } else {
                        p += ")"+args[i].charAt(j);
                        parO = false;
                    }
                }
            }
            if(parO){
                p+=")";
            }
            ll.add(p);

        }
        
        ll.stream().forEach(l -> System.out.println(l));
    }

}

