import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.HashMap;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int i = 0; i<cases; i++){
            ArrayList<Character> record = new ArrayList<>();
            int tasks = sc.nextInt();
            HashSet<Integer> jamie = new HashSet<>();
            HashSet<Integer> cameron = new HashSet<>();
            for(int j = 0; j<=1440; j++){
                jamie.add(j);
                cameron.add(j);
            }
            boolean possible = true;
            TreeMap<Integer, Integer> list = new TreeMap<>();
            HashMap<String, Integer> order = new HashMap<>();
            for(int j = 0; j<tasks; j++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                list.put(start, end);
                String val = String.valueOf(start) + String.valueOf(end);
                order.put(val, j);
            }
            char[] result = new char[tasks];
            while(!list.isEmpty()){
                int start = list.firstKey();
                int end = list.get(list.firstKey());
                list.remove(list.firstKey());
                String val = String.valueOf(start) + String.valueOf(end);
                if(jamie.contains(start)&&jamie.contains(end)){
                    for(int k = start+1; k<=end-1; k++){
                        jamie.remove(k);
                    }
                    result[order.get(val)] = 'J';
                } else if(cameron.contains(start)&&cameron.contains(end)){
                    for(int k = start+1; k<=end-1; k++){
                        cameron.remove(k);
                    }
                    result[order.get(val)] = 'C';
                } else {
                    System.out.printf("Case #%d: IMPOSSIBLE", i+1);
                    System.out.println();
                    possible = false;
                }
            }
            if(possible) {
                System.out.printf("Case #%d: ", i+1);
                for(int j = 0; j<tasks; j++){
                    System.out.print(result[j]);
                }
                System.out.println();
            }
        }
    }
}