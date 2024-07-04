import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Vestigium{
    public static void main(String [] args){
        Scanner read = new Scanner(System.in);
        int cases = read.nextInt();
        int act = 1;
        while(act <= cases){
            int N = read.nextInt();
            System.out.println("Case #"+(act)+": "+solveVestigium(N,read));
            act++;
        }
    }

    public static String solveVestigium(int N,Scanner read){
        int k = 0,r = 0, c = 0;
        Map<Integer,Set<Integer>> rows = new HashMap<>();
        Map<Integer,Map<Integer,Integer>> cols = new HashMap<>();
        for(int i = 0; i < N;i++){
            boolean repeated = false, repeatedc = false;
            for(int j = 0; j < N;j++){
                int val = read.nextInt();
                if(j == i)k+=val;
                //Analizing rows
                if(rows.containsKey(i) && rows.get(i).contains(val)){
                    repeated = true;
                }
                else if(rows.containsKey(i)){
                    rows.get(i).add(val);
                }else{
                    Set<Integer> s = new HashSet<>();
                    s.add(val);
                    rows.put(i,s);
                }

                //Analizing cols
                if(cols.containsKey(j) && cols.get(j).containsKey(val)){
                    if(cols.get(j).get(val) == 0 && c < N)c++;
                    repeatedc = true;
                }
                else if(cols.containsKey(j)){
                    cols.get(j).put(val,i);
                }else{
                    Map<Integer,Integer> s = new HashMap<>();
                    s.put(val,i);
                    cols.put(j,s);
                }
            }
            if(repeated && r < N)r++;
            if(repeatedc && c < N)c++;
        }
        return k+" "+r+" "+c;
    }
}