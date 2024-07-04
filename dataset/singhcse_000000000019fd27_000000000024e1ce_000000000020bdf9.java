import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = sc.nextInt();
    for(int t =1;t<=T;t++){
        int N=sc.nextInt();
        StringBuilder result = new StringBuilder("Case #"+t+": ");
        Map<String,Integer> map = new TreeMap<>();
        Map<String,Integer> request = new LinkedHashMap<>();
        Map<String,Character> resultMap = new HashMap<>();
        Map<Character,Integer> jobMap = new HashMap<>();
        for(int i=0;i<N;i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            request.put(s+"_"+e,e);
        }
        map.putAll(request);
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            String[] arr = entry.getKey().split("_");
            Character whoDoJob = jobMap.containsKey('C') ? 'J' : 'C';
            if(jobMap.size() < 2){
                jobMap.put(whoDoJob,entry.getValue());
                resultMap.put(entry.getKey(),whoDoJob);continue;
            }
            int num = Integer.parseInt(arr[0]);
            if(num >= jobMap.get('J')){
                jobMap.put('J',entry.getValue());
                resultMap.put(entry.getKey(),'J');
            }
            else if(num >= jobMap.get('C')){
                jobMap.put('C',entry.getValue());  
                resultMap.put(entry.getKey(),'C'); 
            }
            else{ break;
            }
        }
        for(Map.Entry<String,Integer> entry : request.entrySet()){
            if(resultMap.get(entry.getKey()) == null){
                result = new StringBuilder("Case #"+t+": ").append("IMPOSSIBLE");break;
            }
            else result.append(resultMap.get(entry.getKey()));
        }
        System.out.println(result);
    }
}
}
  