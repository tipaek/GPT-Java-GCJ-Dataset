
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String[] list=new String[n];
            String max="";
            for (int j = 0; j < n; j++) {
                String s=sc.next().substring(1);
                list[j]=s;
                if(s.length()>max.length()){
                    max=s;
                }
            }
            boolean valid=true;
            for (int j = 0; j < list.length; j++) {
                if(!max.endsWith(list[j])){
                    valid=false;
                    break;
                }
            }
            if(valid){
                System.out.println("Case #"+(i+1)+": "+max);
            }else{
                 System.out.println("Case #"+(i+1)+": *");
            }

        }
    }

    

}
