import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for(int i=1;i<=t;i++){
            int n = scn.nextInt();
            String[] arr = new String[n];
            for(int j=0;j<n;j++){
                arr[j] = scn.nextLine(); 
            }
            String x = "";
            for(String rstr : arr){
                if(rstr.length()>x.length()){
                    x=rstr;
                }
            }
            int y=0;
            for(String rstr : arr){
                if(x.contains(rstr.substring(1))==true){
                    y++;
                }else{
                    y=0;
                }
            }
            if(y==n){
                System.out.println("Case #" + t + ": " + x);
            }else{
                System.out.println("Case #" + t + ": *");
            }
            
            
            
        }
    }
}
