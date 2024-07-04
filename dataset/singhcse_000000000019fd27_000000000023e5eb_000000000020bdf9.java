import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = sc.nextInt();
    for(int t =1;t<=T;t++){
        int N=sc.nextInt();
        StringBuilder result = new StringBuilder("Case #"+t+": ");
        Map<Integer,Integer> map = new TreeMap<>();
        Map<Character,Integer> jobMap = new HashMap<>();
        for(int i=0;i<N;i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            map.put(s,e);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            Character whoDoJob = jobMap.containsKey('J') ? 'C' : 'J';
            if(jobMap.size() < 2){
                jobMap.put(whoDoJob,entry.getValue());
                result.append(whoDoJob);
            }
            else if(key >= jobMap.get('J')){
                result.append('J');
                jobMap.put('J',entry.getValue());
            }
            else if(key >= jobMap.get('C')){
             result.append('C');
                jobMap.put('C',entry.getValue());   
            }
            else{
                result = new StringBuilder("Case #"+t+": ").append("IMPOSSIBLE");break;
            }
        }
        System.out.println(result);
    }
}
}

