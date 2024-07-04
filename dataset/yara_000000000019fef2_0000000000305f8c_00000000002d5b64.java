import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=0; i<t; i++){
            int r = s.nextInt();
            int s2 = s.nextInt();
            String s3="";
            for(int j=0; j<s2; j++){
                for(int k=1; k<=r; k++){
                    s3+=k;
                }
            }
            ArrayList<Integer> a = new ArrayList<>();
            check(s3,0,a);
            for(int j=0; j<a.size(); j++)
                System.out.print(a.get(j)+" ");
        }
    }
    public static void check(String s3, int n, ArrayList<Integer> a){
            int l=0;
            while(l<s3.length()-1){
                if(s3.charAt(l) > s3.charAt(l+1)){
                    break;
                }
                l++;
            }
            int m=s3.length()-1;
            while(m>=l){
                if(s3.charAt(m) > s3.charAt(l)){
                    break;
                }
                m--;
            }
            if(m == l)
                return;
            a.add(l+1);
            a.add(m-s3.length());
            s3 = s3.substring(l-1, m).
                    concat(s3.substring(0, l+1).
                            concat(s3.substring(m, s3.length())));
            check(s3, n, a);
    }
}
