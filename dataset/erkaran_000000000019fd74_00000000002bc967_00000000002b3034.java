import java.util.*;

public class Solution{
    public static void main(String args[]){
         Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        
        for(int o=1 ;o<=t;o++){
            int n = Integer.parseInt(sc.nextLine());
            String arr[] = new String[n];
            for(int i = 0; i<n;i++){
                arr[i] = sc.nextLine();
            }
            Arrays.sort(arr,(String s1, String s2)->s2.length()-s1.length());
            boolean flag = true;
            char last = arr[0].charAt(arr[0].length() -1);
            String sub = arr[0].substring(1,arr[0].length() );
            for(int i = 1; i<n;i++){
                if(last == arr[i].charAt(arr[i].length() -1)){
                    if(sub.indexOf(arr[i].substring(1,arr[i].length())) == -1){
                    flag = false;
                    break;
                }
                }
                else{
                    flag = false;
                    break;
                }
                
            }
            if(flag)
             System.out.println("Case #"+o+": "+sub);
            else 
             System.out.println("Case #"+o+": *");
        }
    }
}