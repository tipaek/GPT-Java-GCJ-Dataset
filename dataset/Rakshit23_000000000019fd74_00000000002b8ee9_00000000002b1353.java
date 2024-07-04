import java.util.*;

public class Solution {
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int t=0; t<T; t++){
            int n = s.nextInt();
            if(n<=500){
                for(int i=1; i<=n; i++){
                    System.out.println(i+" 1");
                }
            }
        }
    }
    
}