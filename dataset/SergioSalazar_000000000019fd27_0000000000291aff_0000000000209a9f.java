import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] Args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n=in.nextInt();
        in.nextLine();
        for(int m=1;m<=n;m++){
            String s=in.nextLine();
            String sol="";
            for(int p=0;p<s.length();p++){
                int k = s.charAt(p)-48;
                if(p==0){
                    for(int i=0;i<k;i++){
                        sol=sol+"(";
                    }
                }
                if(p!=0){
                    int j= s.charAt(p-1)-48;
                    sol=sol+j;
                    if(j>k){
                        for(int i=0;i<j-k;i++){
                            sol=sol+")";
                        }
                    }else if(j<k){
                        for(int i=0;i<k-j;i++){
                            sol=sol+"(";
                        }
                    }
                }
            }

            int k=s.charAt(s.length()-1)-48;
            sol=sol+k;
            for(int i=0;i<k;i++){
                sol=sol+")";
            }
            System.out.println("Case #"+ m+": "+sol);

        }

    }
}

