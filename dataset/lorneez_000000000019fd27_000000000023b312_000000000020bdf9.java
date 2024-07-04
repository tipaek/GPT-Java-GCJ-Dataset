import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner myScanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(myScanner.nextLine());
        for(int i=1; i<=cases; i++){
            boolean J = false;
            String ret = "";
            int errands = myScanner.nextInt();
            //System.out.println("# Errands " + errands);
            boolean possible = true;
            ArrayList<Integer> start = new ArrayList<Integer>();
            ArrayList<Integer> end = new ArrayList<Integer>();
            for(int j=0; j<errands; j++){
                int nextStart = myScanner.nextInt();
                //System.out.println("start "+nextStart);
                int nextEnd = myScanner.nextInt();
                //System.out.println("end "+nextEnd);

                int overlapStart = 0;
                int overlapEnd = 0;

                int indexoverlap = 0;
                int overlap = 0;
                for(int z=0; z<start.size(); z++){
                    //System.out.println("Comparing " + nextStart + " " + nextEnd + " "+ start.get(z) + " " + end.get(z));
                    if(compareErrands(nextStart,nextEnd,start.get(z),end.get(z))){
                        //System.out.println("overlap");
                        overlap ++;
                        overlapStart = start.get(z);
                        overlapEnd = end.get(z);
                        indexoverlap = z;
                    }
                }
                if(overlap == 0){
                    // original
                    if(J){
                        ret += "J";
                    }
                    else{
                        ret+= "C";
                    }
                }
                if(overlap == 1){
                    // next
                    if(Character.toString(ret.charAt(indexoverlap)).equals("J")){
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