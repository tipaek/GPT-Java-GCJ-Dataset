import java.util.*;
public class Solution{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1; i<=t; i++){
            String res = "";
            int len = 0;
            int n = sc.nextInt();
            System.out.print("Case #" + i + ": ");
            String[] str = new String[n];
            for(int j = 0; j<n; j++){
                str[j] = sc.next();
                if(str[j].length()>len){
                    len = str[j].length();
                    res = str[j];
                }
            }
            boolean flag = true;
            for(String st : str){
                if(!res.substring(1).contains(st.substring(1)) && flag){
                    flag = false;
                    System.out.println("*");
                }
            }
            if(flag)
                System.out.println(res.substring(1));
        }
    }

}