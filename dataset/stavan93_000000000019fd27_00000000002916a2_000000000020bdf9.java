import java.util.*;

class Solution {

    static HashMap<Integer,Integer> c = null;
    static HashMap<Integer,Integer> j = null;

    static boolean o_j(HashMap<Integer,Integer> j, int s, int  e){

        int m_set = 0;
        int match = 0;
        for (Map.Entry<Integer,Integer> entry : j.entrySet()) {
            m_set++;
            if((s<entry.getKey() && e<=entry.getKey()) || (s>=entry.getValue() && e>entry.getValue())){
                match++;
            }
        }
        //System.out.println("J"+m_set + " " + match);
        if(m_set == match){

            return false;
        }
        return true;

    }

    static boolean o_c(HashMap<Integer,Integer> c, int s, int e){
        int m_set = 0;
        int match = 0;
        for (Map.Entry<Integer,Integer> entry : c.entrySet()) {
            m_set++;
            if((s<entry.getKey() && e<=entry.getKey()) || (s>=entry.getValue() && e>entry.getValue())){
                match++;
            }
        }
        //System.out.println("C"+m_set + " " + match);
        if(m_set == match){

            return false;
        }
        return true;
    }


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for(int k = 1; k <= t; k++){
            int n = scan.nextInt();
            String ans = "";
            c = new HashMap<>();
            j = new HashMap<>();

            for(int i = 0; i < n; i++){

                int s = scan.nextInt();
                int e = scan.nextInt();
                if(i == 0){
                    j.put(s,e);
                    ans += "J";
                    continue;
                }
                if(i == 1){
                    c.put(s,e);
                    ans += "C";
                    continue;
                }

                if(!o_c(c,s,e)){
                    c.put(s,e);
                    ans+="C";

                }

                else if(!o_j(j,s,e)){
                    j.put(s,e);
                    ans+="J";
                }

                else{
                    ans = "IMPOSSIBLE";
                    break;
                }



            }

            System.out.println("Case #" + k + ": " + ans);
        }
    }

}