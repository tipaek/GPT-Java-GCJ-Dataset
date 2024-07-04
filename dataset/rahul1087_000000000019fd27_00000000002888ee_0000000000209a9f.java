import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));;
        int t = sc.nextInt();
        for(int x=1; x<=t; x++){
            
        char[] ch = sc.next().toCharArray();
        String st1 = "";
        String st2 = "";
        String fst = "";
        for(int i=0; i<ch.length;i++){
            if(ch[i] != '0'){
                st1 = st1 + ch[i];
            }else{
                if(st1 != ""){
                    fst = fst +"("+st1+")";
                    st1 = "";
                }
                fst = fst + ch[i];
            }
        }
        if(st1 != ""){
             fst = fst +"("+st1+")";
                    st1 = "";
        }
        
        System.out.println("Case #"+x+": "+fst);
        }
    }
}