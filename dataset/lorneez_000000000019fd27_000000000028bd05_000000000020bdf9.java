import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner myScanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(myScanner.nextLine());
        for(int i=1; i<=cases; i++) {
            int errands = myScanner.nextInt();
            String[] matrix = new String[errands];
            ArrayList<Integer> start = new ArrayList<Integer>();
            ArrayList<Integer> end = new ArrayList<Integer>();
            for(int j=0; j<errands; j++){
                int nextStart = myScanner.nextInt();
                int nextEnd = myScanner.nextInt();
                start.add(nextStart);
                end.add(nextEnd);
            }
            for(int j=0; j<start.size(); j++){
                matrix[j] = "";
                for(int z=0; z<start.size(); z++){
                    if(j==z){
                        matrix[j] += "0";
                    }
                    else if(compareErrands(start.get(j), end.get(j), start.get(z), end.get(z))){
                        matrix[j] += "1";
                    }
                    else {
                        matrix[j] += "0";
                    }
                }
            }
            // check bipartite
            System.out.println("Case #"+i+": "+checkBipartite(matrix, errands));
        }

        myScanner.close();
    }
    
    private static boolean compareErrands(int nextStart, int nextEnd, int start, int end) {
        boolean overlap = (nextStart>start)&&(nextStart<end) || (nextEnd>start)&&(nextEnd<end); //1
        boolean outeredge = (nextStart == start)&&(nextEnd>end) || (nextEnd==end)&&(nextStart<start); //2
        boolean inneredge = (nextStart>start)&&(nextEnd<end) || (nextStart<start)&&(nextEnd>end); //3
        boolean middle = (nextStart==start)&&(nextEnd<end) || (nextStart>start)&&(nextEnd==end);
        boolean equal = (nextEnd==end)&&(nextStart==start); //4
        return  (overlap || outeredge || inneredge || equal || middle);
    }

    private static String checkBipartite(String[] matrix, int errands) {
        int[] colors = new int[errands];
        for(int p=0; p<errands; p++){
            colors[p] = 0;
        }
        colors[0] = 1;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        while(queue.size() != 0){
            int check = queue.poll();
            // loop through all vertex
            for(int vertex=0; vertex<errands; vertex++){
                // find vertices that are uncolored
                if(matrix[check].substring(vertex,vertex+1).equals("1") && colors[vertex] == 0){
                    colors[vertex] = -colors[check];
                    queue.add(vertex);
                }
                // if vertex is adjacent and colored and not the same color
                else if(matrix[check].substring(vertex,vertex+1).equals("1") && colors[vertex]==colors[check]){
                    return "IMPOSSIBLE";
                }
            }
        }

        String ret = "";
        for(int x : colors){
            if(x == 1){
                ret += "J";
            }
            else{
                ret += "C";
            }
        }
        return ret;
    }
}
