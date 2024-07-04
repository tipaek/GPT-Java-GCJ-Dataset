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
            boolean edge = false;
            String mostRecent = "";
            HashSet<String> mostRecentSet = new HashSet<String>();
            HashSet<String> temp = new HashSet<>();
            TreeMap<String, String> outputMap = new TreeMap<>();
            for(Map.Entry<Integer, HashSet<String>> entry: map.entrySet()){
                HashSet<String> set = entry.getValue();
                //System.out.println(key);
                //System.out.println(set);
                for(String s: set){
                    System.out.println(s);
                    if(temp.contains(s)){
                        temp.remove(s);
                        if(p1Job.equals(s)){
                            p1Job = "";
                        }
                        else if(p2Job.equals(s)){
                            p2Job = "";
                        }
//
                    }
                    else{

                        if(p1Job.equals("")) {
                            temp.add(s);
                            p1Job = s;
                            //output+="C";
                            outputMap.put(s, "C");
                        }
                        else if(p2Job.equals("")){ //changed this //need to know who dropped job
                            temp.add(s);
                            p2Job = s;
                            //output+="J";
                            outputMap.put(s, "J");
                        }
                        else{
                            mostRecent = s;
                            mostRecentSet.add(s);
                            edge = true;
                        }

                    }

                }
                System.out.println(temp);
                if(temp.size() > 2){
                    impossible = true;
                    break;
                }
                else if(edge){
                    if(mostRecentSet.size() > 2){
                        impossible = true;
                    }
                    if(mostRecentSet.size() == 1) {
                        if (p1Job.equals("")) {
                            temp.add(mostRecent);
                            p1Job = mostRecent;
                            //output+="C";
                            outputMap.put(mostRecent, "C");
                        } else if (p2Job.equals("")) { //changed this //need to know who dropped job
                            temp.add(mostRecent);
                            p2Job = mostRecent;
                            //output+="J";
                            outputMap.put(mostRecent, "J");
                        }
                        else{
                            impossible = true;
                        }
                    }
                    if(mostRecentSet.size() == 2){
                        for(String asdf: mostRecentSet){
                            mostRecent = asdf;
                            if (p1Job.equals("")) {
                                temp.add(mostRecent);
                                p1Job = mostRecent;
                                //output+="C";
                                outputMap.put(mostRecent, "C");
                            } else if (p2Job.equals("")) { //changed this //need to know who dropped job
                                temp.add(mostRecent);
                                p2Job = mostRecent;
                                //output+="J";
                                outputMap.put(mostRecent, "J");
                            }
                            else{
                                impossible = true;
                            }
                        }

                    }
                    System.out.println(temp);
                    if(temp.size() > 2){
                        impossible = true;
                        break;
                    }
                    edge = false;
                    mostRecent="";
                    mostRecentSet = new HashSet<>();
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
                    //System.out.println(out.getKey());
                    //System.out.println(out.getValue());
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
