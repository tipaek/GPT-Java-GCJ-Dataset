import java.util.*;
class Solution{
    public static void main(String[]args){
        Scanner in = new Scanner (System.in);
        int T = in.nextInt();
        for (int i = 1; i<=T; i++){
            int x = i;
            int val = 0;
            String sol = "";
            String y = "IMPOSSIBLE";
            int N = in.nextInt();
            ArrayList<Integer> order = new ArrayList<Integer>();
            Map <Integer,String> ans = new HashMap<Integer,String>();
            ArrayList<Integer> times = new ArrayList<Integer>();
            Map <Integer,Integer> map = new HashMap<Integer,Integer>();
            for (int j = 0; j<N;j++){
                int a = in.nextInt();
                int b = in.nextInt();
                times.add(a);
                order.add(a);
                map.put(a,b);
            }
            Collections.sort(times);
            for (int k = 0; k<times.size();k++){
                if(k+2<times.size() && times.get(k+2)<map.get(times.get(k)) && times.get(k+2) < map.get(times.get(k+1))){
                    break;
                    
                } else if (k+1<times.size() && times.get(k) == times.get(k+1)){
                    if (map.get(times.get(k)) < map.get(times.get(k+1))){
                        if (val == 0) {
                            ans.put(times.get(k),"J");
                            val = 1;
                        }else{
                            ans.put(times.get(k),"C");
                            val = 0;
                        }
                    }
                }else if (k+1<times.size() && times.get(k+1)<map.get(times.get(k))) {
                    if (val == 0) {
                        ans.put(times.get(k),"J");
                        val = 1;
                    }else{
                        ans.put(times.get(k),"C");
                        val = 0;
                    }
                } else ans.put(times.get(k),"C");
            }if (ans.isEmpty()) System.out.println("Case #" + x + ": " + y);
            else {
                for (int item: order){
                    sol+= ans.get(item);
                }
                System.out.println("Case #" + x + ": " + sol);
            }
        }
    }
}