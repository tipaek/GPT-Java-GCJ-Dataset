import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=T;t++) {
            int U = Integer.parseInt(br.readLine().trim());
            int cnt = (int) Math.pow(10, U) - 1;
            Map<Integer, HashSet<String>> numbToStrMap = new HashMap<>();
            // Map<String, Integer> map = new HashMap<>();
            for(int l=0;l<10000; l++) {
                String[] line = br.readLine().trim().split(" ");
                int Q = Integer.parseInt(line[0]);
                String s = line[1];
                if(!numbToStrMap.containsKey(Q)) {
                    HashSet<String> temp = new HashSet<>();
                    numbToStrMap.put(Q, temp);
                }
                numbToStrMap.get(Q).add(s);
                // Integer val = map.get(s);
                // if(val != null && val > Q) {
                //     val = Q;
                // }
                // map.put(s, val);
            }
            // for(int i=0;i<=10;i++) {
            //     System.out.println(i+": "+(numbToStrMap.get(i) == null ? "null" : numbToStrMap.get(i).toString()));
            // }
            String[] ar = new String[11];
            HashSet<String> prevSet = new HashSet<>();
            boolean isImp = false;
            for(int i=1;i<=10;i++) {
                if(numbToStrMap.containsKey(i)) {
                    for(String x : numbToStrMap.get(i)) {
                        if(!prevSet.contains(x)) {
                            ar[i] = x;
                        }
                    }
                    prevSet.addAll(numbToStrMap.get(i));
                } else {
                    //imp
                    isImp = true;
                    break;
                }
            }
            sb.append("Case #").append(t).append(": ");
            if(isImp) {
                sb.append("IMPOSSIBLE");
            } else  {
                ar[0] = ar[10].substring(1);
                for(int i=0;i<10;i++) {
                    sb.append(ar[i]);
                }
                // System.out.println("ar: "+Arrays.toString(ar));
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}