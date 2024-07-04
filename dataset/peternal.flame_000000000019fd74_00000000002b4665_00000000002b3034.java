import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int i = 1; i<=t; i++){
            int n = in.nextInt();
            ArrayList<String> toConnect = new ArrayList<>();
            String prefix = "";
            String suffix = "";
            boolean impossible = false;
            for(int j = 0; j<n; j++){
                String s = in.next();
                String[] betweenStars = s.split("[*]");
                int bl = betweenStars.length;
                if(!(prefix.indexOf(betweenStars[0])==0)){
                    if(!(betweenStars[0].indexOf(prefix)==0)){
                        impossible = true;
                    }else{
                        prefix = betweenStars[0];
                    }
                }
                if(bl>1){
                    StringBuilder revBuild = new StringBuilder(betweenStars[bl - 1]);
                    String suf = revBuild.reverse().toString();
                    if(!(suffix.indexOf(suf)==0)){
                        if(!(suf.indexOf(suffix)==0)){
                            impossible = true;
                        }else{
                            suffix = suf;
                        }
                    }
                }
                if(bl>2){
                    for(int k = 1; k<bl-1; k++){
                        toConnect.add(betweenStars[k]);
                    }
                }

            }
            if(impossible){
                System.out.println("Case #" + i + ": *");
            }else{
                StringBuilder forSuf = new StringBuilder(suffix);
                String trueSuffix = forSuf.reverse().toString();
                for(String s : toConnect){
                    prefix+=s;
                }
                prefix+=trueSuffix;
                System.out.println("Case #" + i + ": " + prefix);
            }

        }
    }

}
