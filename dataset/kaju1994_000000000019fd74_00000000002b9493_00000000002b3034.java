import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t =  scanner.nextInt();
        for(int i=1;i<=t;i++){
            int n=scanner.nextInt();
            char all[][]=new char[n][10000];
            int longest = 0;
            String longestString = "";
            for(int j=0;j<n;j++){
                String pattern =  scanner.next();
                char arr[] = pattern.toCharArray();
                if(longest < pattern.length()) {
                    longest = pattern.length();
                    longestString = pattern;
                }
                for(int k=0;k<arr.length;k++)
                    all[j][k] = arr[arr.length - k - 1];
                //System.out.println(all[j]);
            }

            boolean flag = false;
            // check if all matches
            for(int j=0;j<longest;j++){
                char atChar = longestString.charAt(longest-j-1);
                for(int k=0;k<n;k++){
                    if(all[k][j] == '\0' || all[k][j]=='*' || all[k][j] == atChar){
                        continue;
                    }else{
                        flag = true;
                        break;
                    }
                }
                if(flag)
                    break;
            }
            if(flag){
                System.out.println("Case #"+i+": *");
            }else{
                System.out.println("Case #"+i+": "+longestString.replace("*",""));
            }
        }
    }
}