import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
       // int[][] arr = { {600,660},{ 360,480},{420,540}};
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int[][] arr=new int[n][2];
          for(int r=0;r<n;r++){
                arr[r][0]= in.nextInt(); 
                arr[r][1]=in.nextInt();
          }
          String result=merge(arr);
          System.out.println("Case #" + i + ": " + result);  
      }  
        
    }
    public static String merge(int[][] intervals){
        Arrays.sort(intervals,((a,b)->a[0]-b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        HashMap<Integer, Character> map=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        int c=0,j=0;
        //System.out.println()
        System.out.println(Arrays.deepToString(intervals).replace("], ", "]\n"));
        for(int[] nums:intervals){
            while(!pq.isEmpty() && nums[0]>=pq.peek()){
                int k=pq.poll();
                if(map.get(k)=='c') c--;
                if(map.get(k)=='j') j--;
                map.remove(k);
            }
            pq.offer(nums[1]);
            if(c==0){
                sb.append("c");
                map.put(nums[1],'c');
                c++;
            }
            else if(j==0){
                sb.append("j");
                map.put(nums[1],'j');
                j++;
            }
            else {
                return "IMPOSSIBLE";
            }
        }
        return sb.toString();
        
                
        
        
    }
}