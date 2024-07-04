import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb =new StringBuilder();
        int t = in.nextInt();
        for(int i=1;i<=t;i++){
            int n = in.nextInt();
            HashMap<Integer,Integer> c = new HashMap();
            HashMap<Integer,Integer> j = new HashMap();
            String res = "";
            boolean all = false;
            for(int a=0;a<n;a++){
                int s = in.nextInt();
                int e = in.nextInt();
                if(a == 0) {
                    c.put(s,e);
                    res+="C";
                }
                else {
                    boolean check = false;
                    for (Map.Entry v : c.entrySet()) {
                        check = (s >=(int)v.getValue() && e > (int)v.getValue()) || ((s <=(int)v.getKey() && e <= (int)v.getKey()));
                    }
                    if(check) {
                        res+="C";
                        c.put(s, e);
                    }
                    else{
                        if(j.isEmpty()){
                            j.put(s, e);
                            check = true;
                        }
                        else {
                            for (Map.Entry v : j.entrySet()) {
                                check = (s >=(int)v.getValue() && e > (int)v.getValue()) || ((s <=(int)v.getKey() && e <= (int)v.getKey()));
                            }
                        }
                        if(check) {
                            res+="J";
                            j.put(s, e);
                        }
                    }
                    if(check == false) {
                        all = true;
                    }
                }
            }
            if(all) res = "IMPOSSIBLE";
            sb.append("Case #").append(i).append(": ").append(res).append("\n");
        }
        System.out.println(sb);
    }     
}