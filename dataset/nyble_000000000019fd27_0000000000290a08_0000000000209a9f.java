import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tc = Integer.parseInt(s.nextLine());
        for (int t=0; t < tc; t++) {
            String str = s.nextLine();
            int n = str.length();
            int[] list = Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();
            StringBuilder finalStr= new StringBuilder("");
            for(int i=0;i<n;i++){
                if(i==0){
                    for(int j=0;j<list[i];j++){
                        finalStr.append("(");
                    }
                }
                finalStr.append(list[i]);
                if(i+1<n){
                    int d = list[i]-list[i+1];
                    if(d>0){
                        for(int j=0;j<d;j++){
                            finalStr.append(")");
                        }
                    }
                    else if(d<0){
                        d=-d;
                        for(int j=0;j<d;j++){
                            finalStr.append("(");
                        }
                    }
                }
                if(i==n-1){
                    for(int j=0;j<list[i];j++){
                        finalStr.append(")");
                    }
                }
            }
            System.out.println(String.format("Case #%d: %s",t+1,finalStr));
        }

    }
}
