import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {

            String s = in.next();
            int sLen = s.length();
            String ans = "";
            int st=0;
            for(int j =0 ;j<sLen;j++){
                int arr = Integer.parseInt(s.charAt(j)+"");
                if(ans == ""  && arr!=0){
                    int diff = arr;
                    while(diff-- > 0){
                        ans+="(";
                    }
                }else if(ans == ""  && arr==0){
                    ans+=arr+"";
                }else if(st>arr){
                    int diff = st-arr;
                    while(diff-- > 0){
                        ans+=")";
                    }
                }else{
                    int diff = arr-st;
                    while(diff-- > 0){
                        ans+="(";
                    }

                }
                ans+=arr+"";
                st = arr;
            }
            if(st!=0){
                while(st-- > 0){
                    ans+=")";
                }
            }
            System.out.println("Case #" + i + ": " +ans);
        }
    }
}