import java.util.*;

class Solution {


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for(int k = 1; k <= t; k++){
            int n = scan.nextInt();
            String ans = "";
            HashMap<Integer,Integer> c = new HashMap<>();
            HashMap<Integer,Integer> j = new HashMap<>();

            for(int i = 0; i < n; i++){
                boolean flag = false;
                boolean flagg = false;
                int s = scan.nextInt();
                int e = scan.nextInt();
                if(i == 0){
                    c.put(s,e);
                    ans += "C";
                    continue;
                }
                if(i == 1){
                    j.put(s,e);
                    ans += "J";
                    continue;
                }
                int m_set = 0;
                int match = 0;
                for (Map.Entry<Integer,Integer> entry : c.entrySet()) {
                    m_set++;
                    if(!(s>entry.getKey() && s<entry.getValue()) && !(e>entry.getKey() && e<entry.getValue())){
                        if((s<entry.getKey() && e<=entry.getKey()) || (s>=entry.getValue() && e>entry.getValue())){
                            match++;
                        }
                    }
                }
                if(m_set == match){
                    ans += "C";
                    c.put(s,e);
                    continue;
                }

                m_set = 0;
                match = 0;
                for (Map.Entry<Integer,Integer> entry : j.entrySet()) {
                    m_set++;
                    if(!(s>entry.getKey() && s<entry.getValue()) && !(e>entry.getKey() && e<entry.getValue())){
                        if((s<entry.getKey() && e<=entry.getKey()) || (s>=entry.getValue() && e>entry.getValue())){
                            match++;
                        }
                    }
                }
                if(m_set == match){
                    ans += "J";
                    j.put(s,e);
                    continue;
                }

                ans += "N";

            }
            if(ans.contains("N")){
                ans = "IMPOSSIBLE";
            }
            System.out.println("Case #" + k + ": " + ans);
        }
    }

}
