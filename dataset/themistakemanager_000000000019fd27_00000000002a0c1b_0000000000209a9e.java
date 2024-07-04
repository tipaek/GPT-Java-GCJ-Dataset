import java.util.*;
public class Solution{

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();
        for(int k = 1; k<=t; k++){
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= b; i++){
                System.out.println(i);
                sb.append(String.valueOf(sc.nextInt()));
            }
            
            System.out.println(sb.toString());
        }
        
    }
}