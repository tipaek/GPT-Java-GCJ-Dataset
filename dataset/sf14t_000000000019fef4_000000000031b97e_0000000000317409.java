import java.io.*; 
import java.util.*; 
public class Solution {
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        int test=input.nextInt();
        for(int t=1;t<=test;t++) {
            int x=input.nextInt();
            int y=input.nextInt();
            String str=input.next();
            int min=-1;
            for(int i=0;i<str.length();i++) {
                if(str.charAt(i)=='N') {
                    y++;
                }
                if(str.charAt(i)=='S') {
                    y--;
                }
                if(str.charAt(i)=='E') {
                    x++;
                }
                if(str.charAt(i)=='W') {
                    x--;
                }
                int dist=Math.abs(x)+Math.abs(y);
                if(dist<=i+1) {
                    min=i+1;
                    break;
                }
            }
            if(min==-1) {
                System.out.println("Case #"+t+": "+"IMPOSSIBLE");
            }
            else {
                System.out.println("Case #"+t+": "+min);
            }
        }
    }
}
