import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = in.nextInt();
            LinkedHashMap<String, Integer> map = new LinkedHashMap();
            for (int j = 0; j < N; j++) {
                String s = in.next();
                map.put(s, s.length());
            }
            printOutput(i, map);
        }
    }

    public static void printOutput(int T, LinkedHashMap<String,Integer> map) {
        StringBuilder res = new StringBuilder();
        LinkedHashMap<String,Integer> lastVMap = new LinkedHashMap<>();
        LinkedHashMap<String,Integer> firstVMap = new LinkedHashMap<>();
        for(String s: map.keySet()){
            String[] sarr=s.split("\\*");
//            System.out.println("------"+sarr[0]);
            if (sarr.length > 1) {
                firstVMap.put(sarr[0],sarr[0].length());
                lastVMap.put(sarr[sarr.length-1],sarr[sarr.length-1].length());
            } else {
                firstVMap.put(sarr[sarr.length-1],sarr[sarr.length-1].length());
            }
//            Arrays.stream(sarr).forEach(System.out::println);

        }
        String res1 = lastAsterik(lastVMap);
        if(!res1.equals("*")){
            String res2 = lastAsterik(firstVMap);
            if(!res2.equals("*") && !res1.equals(res2)){
                res.append(res2);
                res.append(res1);
                System.out.println("Case #" + T + ": " +res.toString());
            } else
                System.out.println("Case #" + T + ": " +res1);
        } else
            System.out.println("Case #" + T + ": " +"*");
    }
    public static String lastAsterik(LinkedHashMap<String,Integer> map){
        final LinkedHashMap<String,Integer> lmap=map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(e1-> e1.getKey(), e2->e2.getValue(),(e1, e2) -> e1,LinkedHashMap::new));

        String parent="";
        int i=1;
//        System.out.println("========");
        boolean flag=true;
        for(String s : lmap.keySet()){
//            System.out.println("--"+s+"--");
            if(i==1)
                parent=s;
            else {
                if(!parent.contains(s)){
                    flag=false;
                    break;
                }

            }
            i++;
        }
        if(!flag) {
//            System.out.println("*");
            return "*";
        } else {
//            System.out.println(parent);
            return parent;
        }
    }
}
