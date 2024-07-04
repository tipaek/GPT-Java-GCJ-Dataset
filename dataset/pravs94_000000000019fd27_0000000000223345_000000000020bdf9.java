import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Collections;


public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int i = 0; i<cases; i++){
            int tasks = sc.nextInt();
            HashSet<String> jamie = new HashSet<>();
            HashSet<String> cameron = new HashSet<>();
            for(int j = 0; j<1440; j++){
                String s = String.valueOf(j) + "," + String.valueOf(j+1);
                jamie.add(s);
                cameron.add(s);
            }
            boolean possible = true;
            TreeMap<Integer, ArrayList<Integer>> list = new TreeMap<>();
            HashMap<String, ArrayList<Integer>> order = new HashMap<>();
            ArrayList<Integer> sor = new ArrayList<>();
            for(int j = 0; j<tasks; j++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                String val = String.valueOf(start) + "," + String.valueOf(end);
                if(order.containsKey(val)){
                    ArrayList<Integer> a = order.get(val);
                    a.add(j);
                    order.put(val, a);
                }else {
                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(j);
                    order.put(val, a);
                }
                if(list.containsKey(start)){
                    ArrayList<Integer> a = list.get(start);
                    a.add(end);
                    list.put(start, a);
                }else {
                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(end);
                    list.put(start, a);
                }
                sor.add(start);
            }
            Collections.sort(sor);
            char[] result = new char[tasks];
            while(!sor.isEmpty()){
                int start = sor.get(0);
                ArrayList<Integer> r = list.get(start);
                int end = r.get(0);
                r.remove(0);
                sor.remove(0);
                String cur = String.valueOf(start) + "," + String.valueOf(end);
                String st = String.valueOf(start) + "," + String.valueOf(start+1);
                String en = String.valueOf(end-1) + "," + String.valueOf(end);
                if(jamie.contains(st)&&jamie.contains(en)){
                    for(int k = start; k<end; k++){
                        String s = String.valueOf(k) + "," + String.valueOf(k+1);
                        jamie.remove(s);
                    }
                    ArrayList<Integer> a = order.get(cur);
                    result[a.get(0)] = 'J';
                    a.remove(0);
                } else if(cameron.contains(st)&&cameron.contains(en)){
                    for(int k = start; k<end; k++){
                        String s = String.valueOf(k) + "," + String.valueOf(k+1);
                        cameron.remove(s);
                    }
                    ArrayList<Integer> a = order.get(cur);
                    result[a.get(0)] = 'C';
                    a.remove(0);
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