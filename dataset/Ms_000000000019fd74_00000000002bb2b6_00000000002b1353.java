import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int k=1;k<=t;k++){
            int n  =sc.nextInt();
        System.out.println("Case #"+k+":");
            for(int i=1,j=1;i<=n;i++){
                System.out.println(i+" "+j);
                j++;
            }    
            
        }
    }
}