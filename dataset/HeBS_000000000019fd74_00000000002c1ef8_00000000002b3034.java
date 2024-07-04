import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[]args)throws Exception{
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            String garbo = sc.nextLine();
            String s = sc.nextLine();
            String longest = s.substring(1,s.length());
            boolean works = true;
            for(int j = 0; j < n-1; j++){
                String useless = sc.nextLine();
                String current = useless.substring(1,useless.length());
                if(longest.length()>current.length() && longest.substring(longest.length()-current.length()).contains(current)){
                    continue;
                }
                else if(current.length()>longest.length() && current.substring(current.length()-longest.length()).contains(longest)){
                    longest = current;
                }
                else{
                    works = false;
                }
            }
            int f = i + 1;
            if(works){
                System.out.println("Case #" + f + ": " + longest);
            }
            else{
                System.out.println("Case #" + f + ": " + "*");
            }
        }
    }
}
