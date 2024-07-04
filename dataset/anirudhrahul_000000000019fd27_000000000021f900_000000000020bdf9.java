/**
 * Created by user on 4/3/2020.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    static class Range implements Comparable<Range>{
        int l,r;
        int ogIndex;
        char p;
        public Range(int l, int r, int ogIndex){
            this.l=l;
            this.r=r;
            this.ogIndex=ogIndex;
        }

        @Override
        public int compareTo(Range o) {
            return l-o.l;
        }

        public String toString(){
            return "("+l+", "+r+")";
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int cases = Integer.parseInt(br.readLine());
        out:for(int c=1;c<=cases;c++){
            wr.write("Case #"+c+": ");
            int len = Integer.parseInt(br.readLine());
            ArrayList<Range> list = new ArrayList<>(len);
            for(int i=0;i<len;i++){
                StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                list.add(new Range(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),i));
            }
            Collections.sort(list);
            int cDone=0;
            int jDone=0;
            for(Range e: list){
                if(cDone<=e.l){
                    cDone=e.r;
                    e.p='C';
                }
                else if(jDone<=e.l){
                    jDone=e.r;
                    e.p='J';
                }
                else{
                    wr.write("IMPOSSIBLE\n");
                    continue out;
                }
            }
            char[] arr = new char[len];
            for(Range e:list){
                arr[e.ogIndex]=e.p;
            }
//            System.out.println(list);
            wr.write(new String(arr)+"\n");
        }
        wr.close();
    }
}
