import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scanner.nextInt();
        for (int cases = 1; cases <= tests; cases++){
            StringBuilder ret = new StringBuilder();
            int n = scanner.nextInt();
            int maxI = 0;
            TreeMap<Integer, List<String>> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                String curr = scanner.next();
                String[] arr = curr.split("\\*");
                for (int j = 0; j < arr.length; j++) {
                    if (map.containsKey(j)) {
                        map.get(j).add(arr[j]);
                    } else {
                        List<String> temp = new ArrayList<>();
                        temp.add(arr[j]);
                        map.put(j, temp);
                    }
                    maxI = Math.max(j, maxI);
                }
            }

            boolean check = true;
            for (Integer index : map.keySet()){
                List<String> list = map.get(index);
                String appender = "";
                for (int s = 0; s < list.size(); s++){
                    String temp = list.get(s);
                    int a = 0;
                    int t = 0;
                    if(index == maxI){
                        StringBuilder realTemp = new StringBuilder(temp);
                        temp = realTemp.reverse().toString();
                    }
                    boolean putTemp = true;
                    while (a < appender.length() && t < temp.length()){
                        if(appender.charAt(a) != temp.charAt(t)){
                            if (index < maxI){
                                map.get(index + 1).add(temp);
                            } else {
                                check = false;
                            }
                            putTemp = false;
                        }
                        a++;
                        t++;
                    }
                    if (putTemp) {
                        appender = appender.length() > temp.length() ? appender : temp;
                    }
                }
                if (index == maxI){
                    StringBuilder nvm = new StringBuilder(appender);
                    ret.append(nvm.reverse().toString());
                } else {
                    ret.append(appender);
                }
            }

            if (check) {
                System.out.println("Case #" + cases + ":" + " " + ret.toString());
            } else {
                System.out.println("Case #" + cases + ":" + " " + "*");

            }
        }
    }
}
