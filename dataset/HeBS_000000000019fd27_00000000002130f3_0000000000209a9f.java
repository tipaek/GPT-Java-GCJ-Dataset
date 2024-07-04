import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[]args){
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();
        String useless = sc.nextLine();
        for(int i = 0; i < t; i++){
            String s = sc.nextLine();
            String ans = "";
            for(int j = 0; j < s.length(); j++){
                if(j == 0){
                    int a;
                    if(s.charAt(j) == '0'){
                        a = 0;
                    }
                    else{
                        a = s.charAt(j) - '0';
                    }
                    for(int k = 0; k < a; k++){
                        ans+='(';
                    }
                    ans+=a;
                }
                else{
                    int a,b;
                    if(s.charAt(j) == '0'){
                        a = 0;
                    }
                    else{
                        a = s.charAt(j) - '0';
                    }
                    if(s.charAt(j-1) == '0'){
                        b = 0;
                    }
                    else{
                        b = s.charAt(j-1) - '0';
                    }
                    if(a == b){
                        ans+=a;
                    }
                    else if(a-b>0){
                        for(int k = 0; k < a-b; k++){
                            ans+='(';
                        }
                        ans+=a;
                    }
                    else{
                        for(int k = 0; k < b-a; k++){
                            ans+=')';
                        }
                        ans+=a;
                    }
                }
            }
            int f;
            if(ans.charAt(ans.length()-1) == '0'){
                f = 0;
            }
            else{
                f = ans.charAt(ans.length()-1) - '0';
            }
            for(int j = 0; j < f; j++){
                ans+=')';
            }
            System.out.println("Case #" + (i+1) + ": " + ans);
        }
    }

}
