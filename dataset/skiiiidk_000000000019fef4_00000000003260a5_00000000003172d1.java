import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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

            int slice = scan.nextInt();
            int din = scan.nextInt();
            HashMap<Long, Integer> sizes = new HashMap<>();
            for(int i = 0; i<slice; i++){
                long num = scan.nextLong();
                int c = sizes.getOrDefault(num, 0);
                c++;
                sizes.put(num, c);
            }
            //System.out.println(sizes);
            int out = 2;
            if(din == 2){
                out = 1;
                for(long key: sizes.keySet()){
                    if(sizes.get(key) >=2){
                        out = 0;
                    }
                }
            }
            else if(din == 3){
                out = 2;
                for(long key: sizes.keySet()){
                    if(sizes.get(key) >=3){
                        out = 0;
                        break;
                    }
                    if(sizes.get(key) >=2){
                        for(long key2: sizes.keySet()){
                            if(key2 > key){
                                out = 1;
                            }
                        }
                    }
                    if(sizes.containsKey(key*2)){
                        out = 1;
                    }
                }

            }

            log.write("Case #" + (count) + ": "  + out +  "\n");
            //System.out.println(colRep);
            count++;
        }
        log.flush();





    }
}