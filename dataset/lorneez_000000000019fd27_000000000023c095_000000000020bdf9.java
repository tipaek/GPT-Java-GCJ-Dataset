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
                for(int z=0; z<start.size(); z++){
                    if(compareErrands(nextStart,nextEnd,start.get(z),end.get(z))){
                        overlap ++;
                        indexOverlap= z;
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
                    if(Character.toString(ret.charAt(indexOverlap)).equals("J")){
                        J = false;
                    }
                    else{
                        J = true;
                    }
                    if(J){
                        ret += "J";
                    }
                    else{
                        ret+= "C";
                    }
                }
                if(overlap >= 2){
                    possible = false;
                    break;
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
        return(((start < nextStart)&&(nextStart < end)) || ((nextEnd > start)&&(nextEnd < end)));
    }
}