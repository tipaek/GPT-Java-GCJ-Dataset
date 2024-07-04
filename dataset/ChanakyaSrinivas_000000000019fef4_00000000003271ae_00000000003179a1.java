import java.util.*;

public class Solution {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            int U=sc.nextInt();
            HashMap<Character,Integer> belong=new HashMap<>();
            HashSet<Character> digits=new HashSet<>();
            long M;
            for(int i=0;i<10000;i++){
                M=sc.nextLong();
                String R=sc.next();
                int c=1;
                while(M>9){
                    c++;
                    M/=10;
                }
                if(M>0&&c==R.length()){
                    if((!belong.containsKey(R.charAt(0)))||belong.get(R.charAt(0))>M)
                        belong.put(R.charAt(0),(int)M);
                for(int j=0;j<R.length();j++)
                    digits.add(R.charAt(j));
                }
            }
            char[] res=new char[10];
            for(Character ch:belong.keySet())
                res[belong.get(ch)]=ch;
            for(Character ch:digits) {
                if (!belong.containsKey(ch))
                    res[0] = ch;
            }
            System.out.print("Case #"+t+": ");
            for(int i=0;i<10;i++)
                System.out.print(res[i]);
        }
    }
}
