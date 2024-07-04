import java.util.*;
public class Solution{
    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k=t;
        while(t-->0){
            int x =sc.nextInt();
            int y = sc.nextInt();
            String s = sc.nextLine();
            s=s.substring(1);
            boolean flag=false;
            int i;
            for(i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(c == 'N') ++y;
                else if(c == 'E') ++x;
                else if(c == 'W') --x;
                else if(c == 'S') --y;
                //System.out.println(x+" -> "+y+" -> "+(i+1));
                int sum = Math.abs(x)+Math.abs(y);
                if(sum <= (i+1)){
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println("Case #"+(k-t)+": "+(i+1));
            }else{
                System.out.println("Case #"+(k-t)+": IMPOSSIBLE");
            }
        }
    }

}
