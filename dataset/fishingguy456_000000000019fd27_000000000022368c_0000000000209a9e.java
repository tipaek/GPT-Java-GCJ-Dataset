import java.util.*;
public class Solution{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), b = sc.nextInt();
        for(int j = 0; j < t; j++){
            String s = "";
            for(int i = 1; i <= b; i++){
                System.out.println(i);
                System.out.flush();
                s+=sc.next();
            }System.out.println(s);
            System.out.flush();
            String s1 = sc.next();
            if(s1.equals("N")){
                return;
            }
        }
    }
}