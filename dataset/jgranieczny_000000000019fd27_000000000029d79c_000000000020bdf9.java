
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = scanner.nextInt();//test cases
        for (int i = 0; i < T; i++) {
            List<AbstractMap.SimpleEntry<Integer,AbstractMap.SimpleEntry<Integer,Integer>>> activities = new ArrayList();
            int N = scanner.nextInt();//string
            for(int j=0;j<N;j++){
                int S = scanner.nextInt(); //start time of activity
                int E = scanner.nextInt(); //end time of activity
                activities.add(new AbstractMap.SimpleEntry<>(j, new AbstractMap.SimpleEntry<>(S, E)));
            }
            activities.sort(Comparator.comparing(integerSimpleEntrySimpleEntry -> integerSimpleEntrySimpleEntry.getValue().getKey()));
            System.out.print("Case #"+(i+1)+": ");
            print(activities);


        }
    }
    private static void print(List<AbstractMap.SimpleEntry<Integer,AbstractMap.SimpleEntry<Integer,Integer>>> s){
        List<Integer> indexesC = new ArrayList<>();
        List<Integer> indexesL = new ArrayList<>();

        if(getNumber(s,0,indexesC,indexesL)) {
            String[] results=new String[s.size()];
            for(Integer c:indexesC){
                results[s.get(c).getKey()]="C";
            }
            for(Integer j:indexesL){
                results[s.get(j).getKey()]="J";
            }
           for(int i=0;i<results.length;i++)
               System.out.print(results[i]);
            System.out.println();

        } else {
            System.out.println("IMPOSSIBLE");
        }

    }





    private static boolean getNumber(List<AbstractMap.SimpleEntry<Integer,AbstractMap.SimpleEntry<Integer,Integer>>> s,
                                     int index,
                                     List<Integer> indexesC,List<Integer> indexesL) {
        if(index>=s.size()){
            return true;
        }
        boolean goFurther;
        if(indexesC.size()==0)
            goFurther = true;
        else
            goFurther = s.get(index).getValue().getKey()>=s.get(indexesC.get(indexesC.size()-1)).getValue().getValue();

        if(goFurther) {

            List tmpind = new ArrayList(indexesC);
            tmpind.add(index);
            if (!getNumber2(s, index + 1, tmpind, indexesL)) {
                if(!getNumber(s, index + 1, tmpind, indexesL)) {
                    return false;
                }else{
                    indexesC.clear();
                    indexesC.addAll(tmpind);
                    return true;
                }
            }
            else {
                indexesC.clear();
                indexesC.addAll(tmpind);
                return true;
            }

        }
        return false;

    }
    private static boolean getNumber2(List<AbstractMap.SimpleEntry<Integer,AbstractMap.SimpleEntry<Integer,Integer>>> s,
                                     int index,
                                     List<Integer> indexesC,List<Integer> indexesL) {
        if(index>=s.size()){
            return true;
        }
        boolean goFurther;
        if(indexesL.size()==0)
            goFurther = true;
        else
            goFurther = s.get(index).getValue().getKey()>=s.get(indexesL.get(indexesL.size()-1)).getValue().getValue();

        if(goFurther) {

            List tmpind = new ArrayList(indexesL);
            tmpind.add(index);
            if (!getNumber(s, index + 1, indexesC, tmpind)) {
                if(!getNumber2(s, index + 1, indexesC, tmpind)) {
                    return false;
                }else{
                    indexesL.clear();
                    indexesL.addAll(tmpind);
                    return true;
                }
            }
            else {
                indexesL.clear();
                indexesL.addAll(tmpind);
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