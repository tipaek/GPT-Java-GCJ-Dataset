import java.util.*;

class pair{
    int x;
    int y;
    pair(int a,int b){
        x = a;
        y = b;
    }
}
class Solution{
    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int c = 0;
        
        while(c < t){
            int ca = -1;
            int ja = -1;

            TreeMap tm = new TreeMap();
            
            //HashMap index = new HashMap();
            int n = s.nextInt();
            int [][]arr = new int[n][2];
            ArrayList ans = new ArrayList(Collections.nCopies(n, 0));
            for(int i = 0;i<n;i++){
                int start = s.nextInt();
                int end = s.nextInt();
                arr[i][0] = start;
                arr[i][1] = end;
                tm.put(start, new pair(end,i));
            }
            
            ArrayList ansnew = minMeetingRooms(tm,n);
            System.out.print("Case #"+(c+1) + ": ");
                for(int k = 0;k<ansnew.size();k++){
                    System.out.print(ansnew.get(k));
                }
                System.out.print("\n");
           
            c++;
        }
    }
    public static ArrayList minMeetingRooms(TreeMap tm, int n) {
   
   
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int count = 0;
    Stack st = new Stack();
    st.push("J");
    st.push("C");
    HashMap map = new HashMap();
    Iterator it = tm.entrySet().iterator(); 
    ArrayList ans = new ArrayList(Collections.nCopies(n, 0));
     while(it.hasNext()){
         Map.Entry me = (Map.Entry)it.next();
        int start = (int)me.getKey();
        pair p = (pair)me.getValue();
        int end = p.x;
        int index = p.y;
        if (heap.isEmpty()) {
            count++;
            if(!st.isEmpty()){
                ans.set(index,(String)st.peek());
            }else{
                return new ArrayList(Arrays.asList(("IMPOSSIBLE").split("")));
            }
            if(count > 2){
                    return  new ArrayList(Arrays.asList(("IMPOSSIBLE").split("")));
            }
            map.put(end,st.pop());
            heap.offer(end);
        } else {
            if (start >= heap.peek()) {
                int temp = heap.poll();
                st.push((String)map.get(temp));
                ans.set(index,(String)map.get(temp));
                map.remove(temp);
            } else {
                count++;
                if(!st.isEmpty()){
                    ans.set(index,(String)st.peek());
                }else{
                    return new ArrayList(Arrays.asList(("IMPOSSIBLE").split("")));
                }
                
                if(count > 2){
                    return  new ArrayList(Arrays.asList(("IMPOSSIBLE").split("")));
                }
            }
            map.put(end,st.pop());
            heap.offer(end);
        }
    }

    return ans;
}

}