import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
//        URL path = GCJR1c2.class.getResource("sample.in.txt");
        Scanner scan = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new FileReader("/sample.in.txt"));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        //log.write() //log.flush()
        int t = scan.nextInt();
        int count = 1;
        while(t-- >0){
            int len = scan.nextInt();
            HashMap<Character, Integer> counts = new HashMap<>();
            HashSet<Character> all = new HashSet<>();
            String s;
            while(scan.hasNext())
            {
                s = scan.next();
                System.out.println(s);
                String curr = scan.next();
                System.out.println(curr);
                char f = curr.charAt(0);
                int c = counts.getOrDefault(f, -1);
                c++;
                counts.put(f, c);
                for(int i = 0; i<curr.length();i++){
                    all.add(curr.charAt(i));
                }
            }
            String out = "";
            TreeMap<Integer, Character> sortedMap = new TreeMap<Integer, Character>();

            for(Character c: counts.keySet()){
                sortedMap.put(counts.get(c),c);
                all.remove(c);
            }
            char zero = ' ';
            for(char c: all){
                zero = c;
            }


            for(int i: sortedMap.keySet()){
                out = sortedMap.get(i) + out;
            }
            out =  zero+out;

            log.write("Case #" + (count) + ": "  + out + "\n");
            //System.out.println(colRep);
            count++;
        }
        log.flush();





    }
}