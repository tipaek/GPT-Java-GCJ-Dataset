
import java.util.Scanner;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb=new StringBuilder();
        for (int tt = 1; tt <= t; tt++) {
            sb.append("Case #"+tt+": ");
            int y=sc.nextInt(),x=sc.nextInt();
            String s = sc.next();
            int a = 0, b = 0;
            int min=Integer.MAX_VALUE;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'S') {
                    a++;
                    if (i+1>=dis(a,b,x,y)){
//                        System.out.println(i+" "+a+" "+b+" "+x+" "+y+" "+dis(a,b,x,y));
                        min=i+1;
                        break;
                    }
                } else if (s.charAt(i) == 'N') {
                    a--;
                    if (i+1>=dis(a,b,x,y)){
                        min=i+1;
                        break;
                    }
                } else if (s.charAt(i) == 'E') {
                    b--;
                    if (i+1>=dis(a,b,x,y)){
                        min=i+1;
                        break;
                    }
                } else {
                    b++;
                    if (i+1>=dis(a,b,x,y)){
                        min=i+1;
                        break;
                    }
                }
            }
            if(min==Integer.MAX_VALUE){
                sb.append("IMPOSSIBLE");
            }else {
                sb.append(min);
            }
            if (tt!=t){
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
    static int dis(int a,int b,int x,int y){
        return Math.abs(a-x)+Math.abs(b-y);
    }
}