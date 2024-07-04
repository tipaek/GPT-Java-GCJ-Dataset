
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        List<String> ll = new ArrayList();
        for (int i = 1; i < h ; i++) {
             boolean parO = false;
             String p = "Case #"+i+": ";
            for (int j = 0; j < args[i].length(); j++) {
                String cc = args[i].charAt(j) +"";
                if (!parO) {
                    if ( "1".equals(cc)) {
                        parO = true;
                        p += "(1";
                    } else {
                        p += cc;
                    }
                } else {
                    if ( "1".equals(cc)) {
                        p += "1";
                    } else {
                        p += ")"+cc;
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

