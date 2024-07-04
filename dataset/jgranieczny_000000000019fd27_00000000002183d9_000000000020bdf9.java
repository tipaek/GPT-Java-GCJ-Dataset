
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = scanner.nextInt();//test cases
        for (int i = 0; i < T; i++) {
            List<Point> activities = new ArrayList();
            int N = scanner.nextInt();//string
            for(int j=0;j<N;j++){
                int S = scanner.nextInt(); //start time of activity
                int E = scanner.nextInt(); //end time of activity
                activities.add(new Point(S,E));
            }
            System.out.print("Case #"+(i+1)+": ");
            List<Integer> indexesC = new ArrayList<>();
            List<Integer> indexesL = new ArrayList<>();
            if(getNumber(activities,0,indexesC,indexesL)) {
                String[] res = new String[N];
                for(Integer ind:indexesC){
                    res[ind]="C";
                }
                for(Integer ind:indexesL){
                    res[ind]="J";
                }
                for(int w=0;w<res.length;w++)
                System.out.print(res[w]);
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }

        }
    }

    private static boolean getNumber(List<Point> s, int index,List<Integer> indexesC,List<Integer> indexesL) {
        if(index>=s.size()){
            return true;
        }
        boolean add = true;
        for(int i=0;i<indexesC.size();i++) {
            if (isOverlapping(s.get(indexesC.get(i)),s.get(index))){
                add=false;
            }
        }
        if(add){
            indexesC.add(index);
            if(getNumber(s,index+1,indexesC,indexesL))
                return true;
            else{
                indexesC.remove(indexesC.size()-1);
            }
        }

        if(index==0)
            return false;
         add = true;
        for(int i=0;i<indexesL.size();i++) {
            if (isOverlapping(s.get(indexesL.get(i)),s.get(index))){
                add=false;
            }
        }
        if(add) {
            indexesL.add(index);

            if(getNumber(s,index+1,indexesC,indexesL))
                return true;
            else {
                indexesL.remove(indexesL.size()-1);
            }
        }
       

        return false;

    }
    private static boolean isOverlapping(Point act1,Point act2){
        int a0 = (int)act1.getX();
        int b0 = (int)act2.getX();
        int a1 = (int)act1.getY();
        int b1 = (int)act2.getY();
        int i0 = Math.max(a0, b0); // lower bound of intersection interval
        int i1 = Math.min(a1, b1); // upper bound of intersection interval
        return i0 < i1;  // interval non-empty?
    }


}