
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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
            List<AbstractMap.SimpleEntry<Integer,Integer>> originalActivities = new ArrayList(activities);

            Collections.sort(activities, Comparator.comparing(integerIntegerSimpleEntry -> integerIntegerSimpleEntry.getKey()));
            System.out.print("Case #"+(i+1)+": ");
            print(activities,originalActivities);


        }
    }
    private static void print(List<AbstractMap.SimpleEntry<Integer,Integer>> s,List<AbstractMap.SimpleEntry<Integer,Integer>> os){
        List<Integer> indexesC = new ArrayList<>();
        List<Integer> indexesL = new ArrayList<>();

        if(getNumber(s,0,indexesC,indexesL)) {
            List<AbstractMap.SimpleEntry<Integer,Integer>> Cs = new ArrayList<>(indexesC.size());
            List<AbstractMap.SimpleEntry<Integer,Integer>> Ls = new ArrayList<>(indexesL.size());
            for(Integer indexC:indexesC){
                Cs.add(s.get(indexC));
            }
            for(Integer indexL:indexesL){
                Ls.add(s.get(indexL));
            }



            for(AbstractMap.SimpleEntry<Integer,Integer> se:os){
                if(Cs.remove(se))
                    System.out.print("C");
                else
                    System.out.print("J");
            }

            System.out.println();
        } else {
            System.out.println("IMPOSSIBLE");
        }

    }





    private static boolean getNumber(List<AbstractMap.SimpleEntry<Integer,Integer>> s, int index,List<Integer> indexesC,List<Integer> indexesL) {
        if(index>=s.size()){
            return true;
        }
        boolean goFurther;
        if(indexesC.size()==0)
            goFurther = true;
        else
            goFurther = s.get(index).getKey()>=s.get(indexesC.get(indexesC.size()-1)).getValue();

        if(goFurther) {

            indexesC.add(index);
            if (!getNumber2(s, index + 1, indexesC, indexesL)) {
                indexesC.remove(new Integer(index));
            }
            else
                return true;

        }



        if(index==0)
            return false;
        if(indexesL.size()==0)
            goFurther = true;
        else
            goFurther = s.get(index).getKey()>=s.get(indexesL.get(indexesL.size()-1)).getValue();

        if(goFurther) {
            indexesL.add(index);
            if (!getNumber(s, index + 1, indexesC, indexesL)) {
                indexesL.remove(new Integer(index));
            }else{
                return true;
            }
        }




        return false;

    }
    private static boolean getNumber2(List<AbstractMap.SimpleEntry<Integer,Integer>> s, int index,List<Integer> indexesC,List<Integer> indexesL) {
        if(index>=s.size()){
            return true;
        }
        boolean goFurther;


        if(indexesL.size()==0)
            goFurther = true;
        else
            goFurther = s.get(index).getKey()>=s.get(indexesL.get(indexesL.size()-1)).getValue();

        if(goFurther) {
            indexesL.add(index);
            if (!getNumber(s, index + 1, indexesC, indexesL)) {
                indexesL.remove(new Integer(index));
            }else{
                return true;
            }
        }




        if(index==0)
            return false;



        if(indexesC.size()==0)
            goFurther = true;
        else
            goFurther = s.get(index).getKey()>=s.get(indexesC.get(indexesC.size()-1)).getValue();

        if(goFurther) {

            indexesC.add(index);
            if (!getNumber2(s, index + 1, indexesC, indexesL)) {
                indexesC.remove(new Integer(index));
            }
            else
                return true;

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