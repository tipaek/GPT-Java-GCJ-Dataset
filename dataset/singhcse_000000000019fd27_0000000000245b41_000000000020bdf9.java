import java.util.*;
import java.io.*;
import java.lang.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = sc.nextInt();
    for(int t =1;t<=T;t++){
        int N=sc.nextInt();
        StringBuilder result = new StringBuilder("Case #"+t+": ");
        Map<Integer,Integer> map = new TreeMap<>();
        Map<Integer,Integer> request = new LinkedHashMap<>();
        Map<String,Character> resultMap = new HashMap<>();
        Map<Character,Integer> jobMap = new HashMap<>();
        for(int i=0;i<N;i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            request.put(s,e);
        }
        map.putAll(request);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            Character whoDoJob = jobMap.containsKey('C') ? 'J' : 'C';
            if(jobMap.size() < 2){
                jobMap.put(whoDoJob,entry.getValue());
                resultMap.put((entry.getKey()+""+entry.getValue()),whoDoJob);
            }
            else if(key >= jobMap.get('J') && jobMap.get('J') < jobMap.get('C')){
                jobMap.put('J',entry.getValue());
                resultMap.put((entry.getKey()+""+entry.getValue()),'J');
            }
            else if(key >= jobMap.get('C') && jobMap.get('C') < jobMap.get('J')){
                jobMap.put('C',entry.getValue());  
                resultMap.put((entry.getKey()+""+entry.getValue()),'C'); 
            }
            else{
                break;
            }
        }
        for(Map.Entry<Integer,Integer> entry : request.entrySet()){
            if(resultMap.get(entry.getKey()+""+entry.getValue()) == null){
                result = new StringBuilder("Case #"+t+": ").append("IMPOSSIBLE");break;
            }
            else result.append(resultMap.get(entry.getKey()+""+entry.getValue()));
        }
        System.out.println(result);
    }
}
}

