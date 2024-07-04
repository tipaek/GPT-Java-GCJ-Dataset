import java.io.*;
import java.util.*;
class Solution{
    public static void main(String args[])throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            StringTokenizer str=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(str.nextToken());
            int y=Integer.parseInt(str.nextToken());
            String s=str.nextToken();int time=-1;
            for(int j=0;j<s.length();j++){
                switch(s.charAt(j)){
                    case 'N':y++;break;
                    case 'S':y--;break;
                    case 'E':x++;break;
                    case 'W':x--;break;
                }
                if(Math.abs(x)+Math.abs(y)<=j+1){time=j;break;}
            }
            if(time==-1)System.out.println("Case "+i+": IMPOSSIBLE");
            else System.out.println("Case "+i+": "+time);
        }
    }
}