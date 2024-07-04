import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1;i<=t;i++){
            String str = sc.next();
            String result ="";
            int open = 0;
            for(int j = 0 ;j <str.length() ; j++){
                int num = Integer.parseInt(str.charAt(j)+"");
                if(num > open){
                    while(open<num){
                        result+='(';
                        open++;
                    }
                }else if(num < open) {
                    while(open>num){
                        result+=')';
                        open--;
                    }
                }
                result+=num;
            }
            while(open!=0){
                result+=')';
                open--;
            }
            System.out.println("Case #"+i+": "+result);
        }
    }
}