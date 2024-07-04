import java.util.Scanner;

public class Solution {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            int X=sc.nextInt(),Y=sc.nextInt(),pos=-1;
            String path=sc.next();
            for(int i=0;i<path.length();i++){
                switch (path.charAt(i)){
                    case 'S':Y--;
                    break;
                    case 'N':Y++;
                    break;
                    case 'E':X++;
                    break;
                    case 'W':X--;
                    break;
                }
                if(Math.abs(X)+Math.abs(Y)<=i+1){
                    pos=i+1;
                    break;
                }
            }
            System.out.print("Case #"+t+": ");
            if(pos!=-1)
                System.out.println(pos);
            else
                System.out.println("IMPOSSIBLE");
        }
    }
}
