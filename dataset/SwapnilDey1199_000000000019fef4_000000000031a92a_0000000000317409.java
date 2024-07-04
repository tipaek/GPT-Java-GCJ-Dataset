import java.util.*;
public class Solution{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        int z = 1;
        while(t-->0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            String s = sc.next();
            boolean found = false;
            for(int i = 0;i<s.length() && !found;i++){
                char ch = s.charAt(i);
                if(ch=='N') y++;
                else if(ch=='S') y--;
                else if(ch=='E') x++;
                else x--;
                int dist = Math.abs(x)+Math.abs(y);
                if(dist<=(i+1)){
                    sb.append("Case #"+z+": "+(i+1));
                    found = true;
                }
            }
            if(!found){
                sb.append("Case #"+z+": IMPOSSIBLE");
            }
            z++;
            sb.append("\n");
        }
        System.out.print(sb);
    }
}