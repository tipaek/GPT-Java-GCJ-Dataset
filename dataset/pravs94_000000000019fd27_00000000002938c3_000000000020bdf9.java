import java.util.Scanner;
import java.util.HashSet;
import java.util.TreeSet;

import javax.naming.ldap.StartTlsRequest;

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
            int[] startInd = new int[tasks];
            int[] endInd = new int[tasks];
            TreeMap<Integer, ArrayList<Integer>> size = new TreeMap<>();
            for(int j = 0; j< tasks; j++){
              int start = sc.nextInt();
              int end = sc.nextInt();
              startInd[j] = start;
              endInd[j] = end;
              ArrayList<Integer> current = new ArrayList<>();
              if(size.containsKey(start)){
                current = size.get(start);
              }
              current.add(j);
              size.put(start, current);
            }
            HashMap<Integer, Character> result = new HashMap<>();
            boolean possible = true;
            while(!size.isEmpty()){
              int smallest = size.firstKey();
              ArrayList<Integer> pos = size.get(smallest);
              size.remove(size.firstKey());
              Collections.sort(pos);
              while(!pos.isEmpty()){
                int index = pos.get(0);
                pos.remove(0);
                int start = startInd[index];
                int end = endInd[index];
                if(jamie[start]!=1 && jamie[end-1]!=1){
                  for(int k = start; k<end; k++){
                    jamie[k] = 1;
                  }
                  result.put(index, 'J');
                } else if(cameron[start]!=1 && cameron[end-1]!=1){
                    for(int k = start; k<end; k++){
                      cameron[k] = 1;
                    }
                    result.put(index, 'C');
                } else {
                  possible = false;
                }
              }
            }
            if(!possible){
              System.out.printf("Case #%d: IMPOSSIBLE", i+1);
              System.out.println();
            } else {
              System.out.printf("Case #%d: ", i+1);
                for(int j = 0; j<tasks; j++){
                    System.out.print(result.get(j));
                }
                System.out.println();
            }
        }
    }
}