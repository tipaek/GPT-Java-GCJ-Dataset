import java.util.*;

class Question{
    public String solve(int x, int y, int d1, int d2, String s, int n, HashSet<String> set){
        //System.out.println("x "+x+" y "+y+" s "+s+" n "+n+" set "+set);
        if(x == d1 && y == d2) return s;
        
        int low = -100;
        int up = 100;
        if(x < low || x > up || y < low || y > up) return "";
        
        /*StringBuffer sb1 = new StringBuffer("");
        StringBuffer sb2 = new StringBuffer("");
        StringBuffer sb3 = new StringBuffer("");
        StringBuffer sb4 = new StringBuffer("");*/
        //System.out.println(set);
        ArrayList<String> l = new ArrayList<String>();
        int north = y + (int)Math.pow(2,n-1);
        String k1 = x+"|"+north;
        //System.out.println("k1 "+k1);
        if(!set.contains(k1)){
            String ret = solve(x, north, d1, d2, s+"N", n+1, set);
            //System.out.println(ret);
            if(ret.length() > 0) l.add(ret);
            set.remove(k1);
        }
        
        int south = y - (int)Math.pow(2,n-1);
        String k2 = x+"|"+south;
        //System.out.println("k2 "+k2);
        if(!set.contains(k2)){
            String ret = solve(x, south, d1, d2, s+"S", n+1, set);
            //System.out.println(ret);
            if(ret.length() > 0) l.add(ret);
            set.remove(k2);
        }
        
        int east = x + (int)Math.pow(2,n-1);
        String k3 = east+"|"+y;
        //System.out.println("k3 "+k3);
        if(!set.contains(k3)){
            String ret = solve(east, y, d1, d2, s+"E", n+1, set);
            //System.out.println(ret);
            if(ret.length() > 0) l.add(ret);
            set.remove(k3);
        }
        
        int west = x - (int)Math.pow(2,n-1);
        String k4 = west+"|"+y;
        //System.out.println("k4 "+k4);
        if(!set.contains(k4)){
            String ret = solve(west, y, d1, d2, s+"W", n+1, set);
            //System.out.println(ret);
            if(ret.length() > 0) l.add(ret);
            set.remove(k4);
        }
        
        int minInd = 0;
        int minLen = Integer.MAX_VALUE;
        //System.out.println(l);
        if(l.size() == 0) return "";
        for(int i=0;i<l.size();i++){
            if(l.get(i).length() < minLen && l.get(i).length() != 0){
                minLen = l.get(i).length();
                minInd = i;
            }
        }
        
        return l.get(minInd);
    }
}


class Solution{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
        Question q = new Question();
        
        for(int i = 0 ; i < t ; i++){
            int x = s.nextInt();
            int y = s.nextInt();
            
            String res = q.solve(0, 0, x, y, "", 1, new HashSet<String>());
            if(res.length() > 0) System.out.println("Case #"+(i+1)+": "+res);
            else System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
        }
    }
}