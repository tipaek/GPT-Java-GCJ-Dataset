import java.util.*;
import java.io.*;

class Solution {
    
    static ArrayList<Integer> start = new ArrayList<Integer>();
    static ArrayList<Integer> end = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String one = br.readLine();
        int test = Integer.parseInt(one);
        int caseno = 1;
        char current = 'a';
        while(test-->0){
            String two = br.readLine();
            int tasks = Integer.parseInt(two);
            StringBuilder sb = new StringBuilder();
            while(tasks>0){
                String[] time = br.readLine().split(" ");
                int st = Integer.parseInt(time[0]);
                int en = Integer.parseInt(time[1]);
                start.add(st);
                end.add(en);
            }
            Collections.sort(start);
            Collections.sort(end);
            
            int itr = 0;
            int jtr = 0;
            int count = 0;
            int max = Integer.MIN_VALUE;
            while(itr < start.size() && jtr < end.size()){
                if(start.get(itr) < end.get(jtr)){
                    count++;
                    if(current != 'J'){
                        sb.append('J');
                        current = 'J';
                    }
                    itr++;
                } else {
                    count--;
                    if(current != 'C'){
                        sb.append('C');
                        current = 'C';
                    }
                    jtr++;
                }
                
                if(count > max){
                    max = count;
                }
            }
            
            if(max <= 2){
                System.out.println("Case #" + caseno++ + ": " + sb);
            } else {
                System.out.println("Case #" + caseno++ + ": IMPOSSIBLE");
            }
            
            current = 'A';
                
        }
    }
}