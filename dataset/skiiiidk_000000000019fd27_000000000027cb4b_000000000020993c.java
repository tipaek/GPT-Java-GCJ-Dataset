import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        //log.write() //log.flush()
        int t = scan.nextInt();
        int count = 1;
        while(t-- >0){
            HashMap<Integer, HashSet<Integer>> rowMap = new HashMap<>();
            HashMap<Integer, HashSet<Integer>> colMap = new HashMap<>();
            HashSet<Integer> rowRep = new HashSet<>();
            HashSet<Integer> colRep = new HashSet<>();
            int trace = 0;
            
            int size = scan.nextInt();
            for(int i = 0; i < size; i++){
                HashSet<Integer> temp = new HashSet<>();
                rowMap.put(i, temp);
                HashSet<Integer> temp1 = new HashSet<>();
                colMap.put(i, temp1);
            }
            for(int i = 0; i< size; i++){
                for(int o = 0; o<size; o++){
                    int curr = scan.nextInt();
                    int row = i;
                    //int col = (i+o)%size;
                    int col = o;
                    if(i == o){
                        trace += curr;
                        //System.out.println(curr);
                    }
                    if(rowMap.get(row).contains(curr)){
                        rowRep.add(row);
                    }
                    else{
                        rowMap.get(row).add(curr);
                    }
                    if(colMap.get(col).contains(curr)){
                        colRep.add(col);
                    }
                    else{
                        colMap.get(col).add(curr);
                    }
                }
            }
            log.write("Case #" + (count) + ": " + trace + " " + rowRep.size() + " " + colRep.size() + "\n");
            //System.out.println(colRep);
            count++;
        }
        log.flush();





    }
}