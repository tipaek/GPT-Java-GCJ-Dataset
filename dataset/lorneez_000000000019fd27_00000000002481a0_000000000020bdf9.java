import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner myScanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(myScanner.nextLine());
        for(int i=1; i<=cases; i++){
            boolean J = true;
            String ret = "";
            int errands = myScanner.nextInt();
            boolean possible = true;
            ArrayList<Integer> start = new ArrayList<Integer>();
            ArrayList<Integer> end = new ArrayList<Integer>();
            for(int j=0; j<errands; j++){
                int nextStart = myScanner.nextInt();
                int nextEnd = myScanner.nextInt();
                int indexOverlap=0;
                int overlap = 0;
                if(start.size() != 0){
                    for(int z=0; z<start.size(); z++){
                        if(compareErrands(nextStart,nextEnd,start.get(z),end.get(z))){
                            overlap ++;
                            indexOverlap = z;
                        }
                    }
                }
                if(overlap == 0){
                    if(J){
                        ret += "J";
                    }
                    else{
                        ret+= "C";
                    }
                }
                if(overlap == 1){
                    J = !ret.substring(indexOverlap,indexOverlap+1).equals("J");

                    if(J){
                        ret += "J";
                    }
                    else{
                        ret+= "C";
                    }
                }
                if(overlap > 1){
                    possible = false;
                }
                start.add(nextStart);
                end.add(nextEnd);
            }
            if(possible){
                System.out.println("Case #"+i+": "+ret);
            }
            else{
                System.out.println("Case #"+i+": IMPOSSIBLE");
            }
        }
        myScanner.close();
    }

    private static boolean compareErrands(int nextStart, int nextEnd, int start, int end) {
        boolean overlap = (nextStart>start)&&(nextStart<end) || (end>start)&&(end<nextEnd); //1
        boolean outeredge = (nextStart == start)&&(nextEnd>end) || (nextEnd==end)&&(nextStart<start); //2
        boolean inneredge = (nextStart>start)&&(nextEnd<end) || (nextStart<start)&&(nextEnd>end); //3
        boolean middle = (nextStart==start)&&(nextEnd<end) || (nextStart>start)&&(nextEnd==end);
        boolean equal = (nextEnd==end)&&(nextStart==start); //4
        return  (overlap || outeredge || inneredge || equal || middle);
    }
}
