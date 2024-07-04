import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution{
    public static void main(String[] args){
        int t;
        String str;
        Scanner in = new Scanner(System.in);
        StringBuilder res;
        t = in.nextInt();
        str = in.nextLine();
        int testC=0;
        while(t!=0){
            str = in.nextLine();
            res = new StringBuilder();
            char[] chars = str.toCharArray();
            int n = chars.length;
            int[] d = new int[chars.length];
            for(int i=0;i<n;i++){
                d[i]=chars[i]-'0';
            }
            int leftO=0;
            for(int i=0;i<n;i++){
                if(d[i]>0){
                    if(leftO>d[i]) {
                        while (leftO != d[i]) {
                            leftO--;
                            res.append(')');
                        }
                        res.append(d[i]);
                    }
                    else {
                        while(leftO!=d[i]){
                            res.append('(');
                            leftO++;
                        }
                        res.append(d[i]);

                    }
                }
                else {
                    while(leftO!=0){
                        res.append(')');
                        leftO--;
                    }
                    res.append(d[i]);
                }
            }
            while(leftO!=0){
                res.append(')');
                leftO--;
            }

            System.out.println("Case #" + (++testC) + ": " + res.toString());
            t--;
        }
    }

}