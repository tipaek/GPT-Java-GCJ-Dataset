import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner myScanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(myScanner.nextLine());
        for(int i=1; i<=cases; i++) {
            int errands = myScanner.nextInt();
            //String[] matrix = new String[errands];
            boolean[][] matrix = new boolean[errands][errands];
            ArrayList<Integer> start = new ArrayList<Integer>();
            ArrayList<Integer> end = new ArrayList<Integer>();
            for(int j=0; j<errands; j++){
                int nextStart = myScanner.nextInt();
                int nextEnd = myScanner.nextInt();
                start.add(nextStart);
                end.add(nextEnd);
            }
            for(int j=0; j<start.size(); j++){
                for(int z=j+1; z<start.size(); z++){
                    if(compareErrands(start.get(j), end.get(j), start.get(z), end.get(z))){
                        matrix[j][z] = true;
                        matrix[z][j] = true;
                    }
                    else {
                        matrix[j][z] = false;
                        matrix[z][j] = false;
                    }
                }
            }

            if(i==cases){
                System.out.print("Case #"+i+": "+checkBipartite(matrix, errands));
            }
            else{
                System.out.println("Case #"+i+": "+checkBipartite(matrix, errands));
            }
        }
        myScanner.close();
    }
    private static boolean compareErrands(int nextStart, int nextEnd, int start, int end) {
        boolean s = (nextStart >= end);
        boolean t = (nextEnd <= start);
        return  !(s || t);
    }
    private static String checkBipartite(boolean[][] matrix, int errands) {
        int[] colors = new int[errands];
        for(int p=0; p<errands; p++){
            colors[p] = 0;
        }
        colors[0] = 1;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        while(queue.size() != 0){
            int check = queue.poll();
            for(int vertex=0; vertex<errands; vertex++){
                if(check==vertex){
                    continue;
                }
                if(matrix[check][vertex] && colors[vertex] == 0){
                    colors[vertex] = -colors[check];
                    queue.add(vertex);
                }
                else if(matrix[check][vertex] && colors[vertex]==colors[check]){
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