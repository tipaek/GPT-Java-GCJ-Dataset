import java.util.*;
import java.io.*;
    
class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer testCount = Integer.parseInt(in.nextLine());
    
        for(int test = 1; test <= testCount; test++){
            int n = Integer.parseInt(in.nextLine());
        
            String[] times = new String[n];
            
            for(int i = 0; i < n; i++){
                times[i] = in.nextLine();
            }
            
            String result = createSchedule(times, n);
            

            System.out.println("Case #"+test+": "+result);
        }
    }
    
    private static String createSchedule(String[] times, int n){
        int[][] timesDigits = new int[n][2];
        
        for(int i = 0; i < n; i++){
            String[] data = times[i].split(" ");
            timesDigits[i][0] = Integer.parseInt(data[0]);
            timesDigits[i][1] = Integer.parseInt(data[1]);
        }
        
        Arrays.sort(timesDigits, Comparator.comparingInt(a -> a[0]));
        Map<String, Character> map = new HashMap<>();
        
        int endC = 0;
        int endJ = 0;
        
        for(int i = 0; i < n; i++){
            int start = timesDigits[i][0];
            int end = timesDigits[i][1];
            String key = Integer.toString(start) + " " + Integer.toString(end); 

            if(endC <= start){
                map.put(key, 'C');
                endC = end;
            }else if(endJ <= start){
                map.put(key, 'J');
                endJ = end;
            }else{
                return "IMPOSSIBLE";
            }
        }
        
        StringBuffer str= new StringBuffer();
        for(String st: times){
            str.append(map.get(st));
        }
        
        return str.toString();
    }
}