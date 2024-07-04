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
            Map <Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
            for (int j = 0; j<N;j++){
                int a = in.nextInt();
                int b = in.nextInt();
                if (times.contains(a)){
                    ArrayList<Integer> use = new ArrayList<Integer>();
                    use = map.get(a);
                    use.add(b);
                    map.put(a,use);
                    times.add(a);
                    order.add(a);
                }else{
                ArrayList<Integer>value = new ArrayList<Integer>();
                value.add(b);
                times.add(a);
                order.add(a);
                map.put(a,value);}
            }
            Collections.sort(times);
            for (int k = 0; k<times.size();k++){
                if(k+2<times.size() && times.get(k+2)<map.get(times.get(k)).get(0) && times.get(k+2) < map.get(times.get(k+1)).get(0)){
                    sol = "";
                    break;
                    
                } else if (k+1<times.size() && times.get(k) == times.get(k+1)){
                    if (map.get(times.get(k)).get(0) < map.get(times.get(k)).get(1)){
                        if (val == 0) {
                            ans.put(times.get(k),"J");
                            val = 1;
                        }else{
                            ans.put(times.get(k),"C");
                            val = 0;
                        }
                    }
                }else if (k+1<times.size() && times.get(k+1)<map.get(times.get(k)).get(0)) {
                    if (val == 0) {
                        ans.put(times.get(k),"J");
                        val = 1;
                    }else{
                        ans.put(times.get(k),"C");
                        val = 0;
                    }
                } else {
                    if (map.get(times.get(k)).size()>1)
                    ans.put(times.get(k),"CJ");
                    else
                    ans.put(times.get(k),"C");
                }
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