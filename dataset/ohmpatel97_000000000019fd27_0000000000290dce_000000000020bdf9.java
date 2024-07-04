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
            }
            
            String ansnew = minMeetingRooms(arr);
            System.out.println("Case #"+(c+1) + ": " + ansnew);
            c++;
        }
    }
    public static String minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));
    String ans = "";
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int count = 0;
    Stack st = new Stack();
    st.push("C");
    st.push("J");
    HashMap map = new HashMap();
    for (int[] itv : intervals) {
        if (heap.isEmpty()) {
            count++;
            if(!st.isEmpty()){
                ans += (String)st.peek();
            }else{
                return "IMPOSSIBLE";
            }
            if(count > 2){
                    return "IMPOSSIBLE";
            }
            heap.offer(itv[1]);
            map.put(itv[1],st.pop());
        } else {
            if (itv[0] >= heap.peek()) {
                int temp = heap.poll();
                st.push((String)map.get(temp));
                ans += (String)map.get(temp);
                map.remove(temp);
            } else {
                count++;
                if(!st.isEmpty()){
                    ans += (String)st.peek();
                }else{
                    return "IMPOSSIBLE";
                }
                
                if(count > 2){
                    return "IMPOSSIBLE";
                }
            }
            map.put(itv[1],st.pop());
            heap.offer(itv[1]);
        }
    }
 
    return ans;
}

}