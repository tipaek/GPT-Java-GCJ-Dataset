import java.util.Scanner;
import java.util.HashSet;
import java.util.TreeSet;
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
            int[] jamie = new int[1440];
            int[] cameron = new int[1440];
            boolean possible = true;
            int[][] taskArray = new int[tasks][1440];
            HashMap<Integer, Integer> size = new HashMap<>();
            for(int j = 0; j<tasks; j++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                taskArray[j][start] = 1;
                size.put(j, end-start);
            }
            int taskAcc = 0;
            HashMap<Integer, Character> rec = new HashMap<>();
            HashMap<Integer, TreeSet<Integer>> ord = new HashMap<>();
            for(int j = 0; j<1440; j++){
                if(taskAcc<tasks){
                    ArrayList<Integer> selected = new ArrayList<>();
                    for(int k = 0; k<tasks; k++){
                        if(taskArray[k][j]==1){
                            selected.add(size.get(k));
                            taskAcc++;
                            if(ord.containsKey(size.get(k))){
                                TreeSet<Integer> a = ord.get(size.get(k));
                                a.add(k);
                                ord.put(size.get(k), a);
                            }else {
                                TreeSet<Integer> a = new TreeSet<>();
                                a.add(k);
                                ord.put(size.get(k), a);
                            }
                        }
                    }
                    Collections.sort(selected);
                   while(!selected.isEmpty()){
                       int shortest = selected.get(0);
                       selected.remove(0);
                       if(jamie[j]!=1 && jamie[j+shortest-1]!=1){
                            for(int k = j; k<j+shortest; k++){
                                jamie[k]=1;
                            }
                            rec.put(ord.get(shortest).pollFirst(), 'J');
                        } else if(cameron[j]!=1 && cameron[j+shortest-1]!=1){
                            for(int k = j; k<j+shortest; k++){
                                cameron[k]=1;
                            }
                            rec.put(ord.get(shortest).pollFirst(), 'C');
                        } else {
                            System.out.printf("Case #%d: IMPOSSIBLE", i+1);
                            System.out.println();
                            possible = false;
                        }
                   }
                }
            }
            if(possible) {
                System.out.printf("Case #%d: ", i+1);
                for(int j = 0; j<tasks; j++){
                    System.out.print(rec.get(j));
                }
                System.out.println();
            }
        }
    }
}