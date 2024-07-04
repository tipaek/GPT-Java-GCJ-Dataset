import java.lang.*;
import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = new Integer(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int z=1;z<=t;z++){
            sb.append("Case #"+z+": ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = new Integer(st.nextToken());
            int y = new Integer(st.nextToken());
            String path = st.nextToken();
            int time = 0;
            if(Math.abs(x)+Math.abs(y)==time){
                sb.append(time).append("\n");
                continue;
            }
            time++;
            boolean flag = false;
            for(int i=0;i<path.length();i++){
                if(path.charAt(i)=='N'){
                    y++;
                }
                else if(path.charAt(i)=='S'){
                    y--;
                }
                else if(path.charAt(i)=='E'){
                    x++;
                }
                else if(path.charAt(i)=='W'){
                    x--;
                }
                if(time >= Math.abs(x)+Math.abs(y)){
                    sb.append(time).append("\n");
                    flag = true;
                }
                else{
                    time++;
                }
            }
            if(!flag){
                sb.append("IMPOSSIBLE\n");
            }
        }
        br.close();
        System.out.println(sb);
    }
}