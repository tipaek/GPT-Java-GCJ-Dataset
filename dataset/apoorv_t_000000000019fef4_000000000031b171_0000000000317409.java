import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int t;
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        String s;
        char ch;
        int n;
        int c =0;
        while(c++!=t){
            int x,y;
            x=in.nextInt();
            y=in.nextInt();
            s=in.nextLine();
            //System.out.println("xx" + x +"asda" + y);
            n=s.length();
            if(n<=(x+y)/2){
                System.out.println("Case #" + c+ ": IMPOSSIBLE");
                continue;
            }
            int count=0;
            boolean flag=false;
            for(int i=1;i<n;i++){
                ch=s.charAt(i);
                //System.out.println(s.charAt(0));
                //System.out.println(ch);
                if(ch=='S'){
                    y=y-1;
                }
                else if(ch=='N'){
                    y=y+1;
                }

                else if(ch=='E'){
                    x=x+1;
                }
                else{
                    x=x-1;
                }
                //System.out.println("X:" + x + " Y:"+ y);
                if(i>=Math.abs(x)+Math.abs(y)){
                    System.out.println("Case #" + c+ ": "+ (i));
                    flag=true;
                    break;
                }
            }
            if(!flag)
                System.out.println("Case #" + c+ ": IMPOSSIBLE");
        }
    }
}
