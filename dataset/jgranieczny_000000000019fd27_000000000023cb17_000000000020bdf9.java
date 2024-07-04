
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = scanner.nextInt();//test cases
        for (int i = 0; i < T; i++) {
            List<AbstractMap.SimpleEntry<Integer,Integer>> activities = new ArrayList();
            int N = scanner.nextInt();//string
            for(int j=0;j<N;j++){
                int S = scanner.nextInt(); //start time of activity
                int E = scanner.nextInt(); //end time of activity
                activities.add(new AbstractMap.SimpleEntry<Integer, Integer>(S,E));
            }
            System.out.print("Case #"+(i+1)+": ");
            print(activities);


        }
    }
    private static void print(List<AbstractMap.SimpleEntry<Integer,Integer>> s){
        List<Integer> indexesC = new ArrayList<>();
        List<Integer> indexesL = new ArrayList<>();
        Set<Integer>[] overlap = new HashSet[s.size()];
        for(int i=0;i<s.size();i++){
            overlap[i]=new HashSet<>();
        }
        for(int i=0;i<s.size()-1;i++){
            for(int j=i+1;j<s.size();j++){
                if(isOverlapping(s.get(i),s.get(j))){
                    overlap[i].add(j);
                    overlap[j].add(i);
                }


            }
        }
        if(getNumber(s,0,indexesC,indexesL,overlap)) {
            String[] res = new String[s.size()];
            String c= "C";
            String j = "J";
            for(Integer ind:indexesC){
                res[ind]=c;
            }
            for(Integer ind:indexesL){
                res[ind]=j;
            }
            for(int w=0;w<res.length;w++)
                System.out.print(res[w]);
            System.out.println();
        } else {
            System.out.println("IMPOSSIBLE");
        }

    }

    private static boolean getNumber(List<AbstractMap.SimpleEntry<Integer,Integer>> s, int index,List<Integer> indexesC,List<Integer> indexesL, Set<Integer>[] overlap) {
        if(index>=s.size()){
            return true;
        }

        if(Collections.disjoint(overlap[index], indexesC)){
            List<Integer> indstmp = new ArrayList<>(indexesC);
            indstmp.add(index);
            if(getNumber(s,index+1,indstmp,indexesL,overlap)) {
                indexesC.clear();
                indexesC.addAll(indstmp);

                return true;
            }

        }

        if(index==0)
            return false;

        if(Collections.disjoint(overlap[index], indexesL)) {
            List<Integer> indstmp = new ArrayList<>(indexesL);
            indstmp.add(index);
            if(getNumber(s,index+1,indexesC,indstmp,overlap)) {
                indexesL.clear();
                indexesL.addAll(indstmp);
                return true;
            }

        }


        return false;

    }
    private static boolean isOverlapping(AbstractMap.SimpleEntry<Integer,Integer> act1,AbstractMap.SimpleEntry<Integer,Integer> act2){
        int a0 = act1.getKey();
        int b0 = act2.getKey();
        int a1 = act1.getValue();
        int b1 = act2.getValue();
        int i0 = Math.max(a0, b0); // lower bound of intersection interval
        int i1 = Math.min(a1, b1); // upper bound of intersection interval
        return i0 < i1;  // interval non-empty?
    }


}