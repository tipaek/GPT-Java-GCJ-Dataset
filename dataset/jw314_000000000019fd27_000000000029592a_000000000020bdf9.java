import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String args[]){
        //Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scan.nextInt();
        for(int testNum = 0; testNum < tests; testNum++){
            int n = scan.nextInt();
            List<Integer> start = new ArrayList<Integer>();
            List<Integer> end = new ArrayList<Integer>();
            List<Integer> align = new ArrayList<Integer>();
            for(int i = 0; i < n; i++){
                start.add(scan.nextInt());
                end.add(scan.nextInt());
                align.add(i);
            }
            //BUBBLE SORT THE START TIMES
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n-1; j++){
                    if(start.get(j) > start.get(j+1)){
                        int temp = start.get(j);
                        start.set(j, start.get(j+1));
                        start.set(j+1, temp);
                        temp = end.get(j);
                        end.set(j, end.get(j+1));
                        end.set(j+1, temp);
                        temp = align.get(j);
                        align.set(j, align.get(j+1));
                        align.set(j+1, temp);
                    }
                }
            }
            
            List<Integer> people = new ArrayList<Integer>();
            //-1 = no task, other num = task num working on
            people.add(-1);
            people.add(-1);
            boolean success = true;
            List<String> output = new ArrayList<String>();
            for(int i = 0; i < n; i++){
                output.add("");
            }
            for(int i = 0; i < n; i++){
                int startTime = start.get(i);
                String aval = "";
                for(int j = 0; j < 2; j++){
                    if(people.get(j) == -1 || end.get(people.get(j)) <= startTime){
                        if(j == 0){
                            aval = "C";
                            people.set(0, i);
                        }else{
                            aval = "J";
                            people.set(1, i);
                        }
                        break;
                    }
                }
                if(aval == ""){
                    success = false;
                    break;
                }
                output.set(align.get(i), aval);
            }
            if(success){
                String out = "";
                for(int i = 0; i < n; i++){
                    out = out.concat(output.get(i));
                }
                System.out.println("Case #"+(testNum+1)+": "+out);
            }else{
                System.out.println("Case #"+(testNum+1)+": "+"IMPOSSIBLE");
            }
        }
        
    }
    
}