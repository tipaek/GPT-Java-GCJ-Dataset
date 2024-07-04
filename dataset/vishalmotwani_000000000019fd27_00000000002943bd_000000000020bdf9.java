import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Key {
    int start;
    int end;
    Key(int start,int end){
        this.start = start;
        this.end = end;
    }
}

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(b.readLine().trim());
        for(int i=0;i<tc;i++) {
            Map<Key,Integer> map = new TreeMap<>(Comparator.comparingInt(k -> k.start));
            Solution bp = new Solution();
            int n = Integer.parseInt(b.readLine().trim());
            for(int j=0;j<n;j++){
                String[] pair = b.readLine().trim().split("\\s+");
                map.put(new Key(Integer.parseInt(pair[0]),Integer.parseInt(pair[1])),j);
            }
            System.out.println("Case #"+(i+1)+": "+bp.balanceParent(map,n));
        }
    }



    public String balanceParent(Map<Key,Integer> map,int n){
        // available[0] for J and available[1] for K
        int[] available = new int[]{0,0};
        char[] result = new char[n];

        for( Map.Entry<Key,Integer> entry: map.entrySet()){
            int start = entry.getKey().start;
            int end = entry.getKey().end;
            int index = entry.getValue();
            if(available[0] <= start){
                available[0] = end;
                result[index] = 'J';
            }
            else if(available[1] <= start){
                available[1] = end;
                result[index] = 'C';
            }
            else
                return "IMPOSSIBLE";
        }
        return new String(result);
    }
}
