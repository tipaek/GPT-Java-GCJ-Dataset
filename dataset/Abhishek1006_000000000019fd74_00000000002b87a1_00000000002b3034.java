import java.util.Scanner;

public class Solution {

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            int size = Integer.parseInt(in.nextLine());
            String[] allStrings = new String[size];
            int k=0;
            int longestLength = 0;
            while (size-- >0){
                StringBuilder a = new StringBuilder(in.nextLine());
                allStrings[k] = a.reverse().toString();
                int len = allStrings[k].length();
                if(len>longestLength) longestLength = len;
                k++;
            }
           findPattern(allStrings,i,longestLength);
        }
    }

    public static void findPattern(String[] patterns,int caseNumber,int longestLength){

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < longestLength; i++) {
            char c = '*';
            char lastC = '*';
            boolean added = false;
            for (String pat :
                    patterns) {
                if(i<pat.length()){
                    c = pat.charAt(i);
                }else{
                    c = '*';
                }


                if (c==lastC || c=='*' || lastC=='*'){
                    if(c!='*' && !added){
                        ans.append(c);
                        added = true;
                    }
                }else {
                    System.out.println("Case #" + caseNumber + ": " + "*");
                    return;
                }

                lastC = c;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + ans.reverse());

    }
}
