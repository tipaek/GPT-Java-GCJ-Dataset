import java.util.*;
public class Solution {
    public static void main(String... args){
        
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        sc.nextLine();
        for(int i = 1;i<=testcase;i++){
            String n = sc.nextLine();
            int x =0 , y = 0;
            String r = "";
            for(char c : n.toCharArray()){
                if(c!='(' && c!=')'){
                    
                    int j = Integer.parseInt(""+c);
                    //System.out.println(j +" x" + x +""+c+"r"+r);
                      while(x>j){
                          r+=")";
                          x--;
                      } 
                      while(x<j){
                          r+="(";
                          x++;
                      }  
                      r+=c;
                }
            }
            while(x > 0){
              r+=")";
              x--;
            } 
            System.out.println("Case #"+ i +": "+r);
        }
    }
}