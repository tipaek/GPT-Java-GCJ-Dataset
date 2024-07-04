import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;
import java.util.Comparator;
class pair{
    int s;
    int e;
    public pair(int start,int end){
        this.s = start;
        this.e = end;
    }
}

class sortByStart implements Comparator<pair>{
    
    public int compare(pair p1,pair p2) {
    	return p1.s-p2.s;
    }
    
}
class Solution{
    public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    
    for(int i=0;i<T;i++){
    	ArrayList<pair> interval = new ArrayList<>();
        HashMap<pair,Integer> map = new HashMap<>();
        int N = in.nextInt();
        
        for(int j=0;j<N;j++){
            int start  = in.nextInt();
            int end = in.nextInt();
            pair p = new pair(start,end);
            interval.add(p);
            map.put(p,j);
        }
        Collections.sort(interval, new sortByStart());
        Stack<pair> C = new Stack<>();
        Stack<pair> J = new Stack<>();
        String out="";
        for(int j=0;j<N;j++){
            out+=0;
        }
        for(int j=0;j<interval.size();j++){
            pair curr = interval.get(j);
            
            if(C.isEmpty() || C.peek().e<=curr.s ){
                if(!C.isEmpty()){
                    C.pop();
                }
                C.push(curr);
                int index = map.get(curr);
                out = out.substring(0,index)+'C'+out.substring(index+1);
                    
            }else if(J.isEmpty() || J.peek().e<=curr.s){
                if(!J.isEmpty()){
                    J.pop();
                }
                J.push(curr);
                int index = map.get(curr);
                out = out.substring(0,index)+'J'+out.substring(index+1);
            }
            else{
                out = "IMPOSSIBLE";
                break;
            }
        }
        System.out.println("Case #"+(i+1)+": "+out);
    }
  }
}
