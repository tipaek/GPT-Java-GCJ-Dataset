import com.sun.source.tree.Tree;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        //log.write() //log.flush()
        int t = scan.nextInt();
        int count = 1;
        while (t-- > 0) {
            int acts = scan.nextInt();
            TreeMap<Integer, HashSet<String>> map = new TreeMap<>();

            for(int i = 0; i<acts; i++){
                int start = scan.nextInt();

                if(!map.containsKey(start)){
                    HashSet<String> temp = new HashSet<>();
                    map.put(start, temp );
                }
                String startStr = "S" + i;
                map.get(start).add(startStr );


                int end = scan.nextInt();
                if(!map.containsKey(end)){
                    HashSet<String> temp = new HashSet<>();
                    map.put(end, temp);
                }
                String endStr = "S" + i;
                map.get(end).add(endStr );
            }
            String output = "";
            String p1Job = "";
            String p2Job = "";
            boolean impossible = false;
            HashSet<String> temp = new HashSet<>();
            TreeMap<String, String> outputMap = new TreeMap<>();
            for(Map.Entry<Integer, HashSet<String>> entry: map.entrySet()){
                int key = entry.getKey();
                HashSet<String> set = entry.getValue();
                //System.out.println(key);
                //System.out.println(set);
                for(String s: set){
                    if(temp.contains(s)){
                        temp.remove(s);
                        if(p1Job.equals(s)){

                            p1Job = "";
                        }
                        else if(p2Job.equals(s)){

                            p2Job = "";
                        }
//                        else{
//                            impossible = true;
//                            break;
//                        }
                    }
                    else{
                        temp.add(s);
                        if(p1Job.length() == 0) {
                            p1Job = s;
                            output+="C";
                            char num = p1Job.charAt(1);
                            int numi = Character.getNumericValue(num);
                            outputMap.put(s, "C");
                        }
                        else{
                            p2Job = s;
                            output+="J";
                            char num = p1Job.charAt(1);
                            int numi = Character.getNumericValue(num);
                            outputMap.put(s, "J");
                        }

                    }

                }
                if(temp.size() > 2){
                    impossible = true;
                    break;
                }
                if(impossible){
                    break;
                }
            }
            //System.out.println(count);
            //System.out.println(output);
            if(impossible){
                output = "IMPOSSIBLE";
            }
            else{
                output = "";
                for(Map.Entry<String, String> out: outputMap.entrySet()){
                    System.out.println(out.getKey());
                    System.out.println(out.getValue());
                    String person = out.getValue();
                    output += person;
                }
            }
            log.write("Case #" + (count) + ": " + output + "\n");
            //System.out.println(colRep);
            count++;
        }
        log.flush();

    }
}
