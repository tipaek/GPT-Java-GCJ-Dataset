import java.util.Scanner;
public class Solution{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        for(int T=1;T<=t;T++){
            int H=0,V=0,time=0;
            boolean success=false;
            String path="";
            H=scan.nextInt();
            V=scan.nextInt();
            path=scan.next();
            for(int i=0;i<path.length();i++){
                if(path.charAt(i)=='N'){
                    V+=1;
                }
                else if(path.charAt(i)=='S'){
                    V+=-1;
                }
                else if(path.charAt(i)=='E'){
                    H+=1;
                }
                else if(path.charAt(i)=='W'){
                    H+=-1;
                }
                time+=1;
                if(time>=(Math.abs(H)+Math.abs(V))){
                    success=true;
                    break;
                }
            }
            if(success)
            System.out.println("Case #"+T+": "+time+"");
            else System.out.println("Case #"+T+": "+"IMPOSSIBLE");
        }
    }
}