import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        char o = '(',c=')';
        sc.nextLine();
        ArrayList<String> ans = new ArrayList<>();
        for(int t=1;t<=T;t++){
            String s = sc.nextLine(), res ="";
            int x=0;
            for(int i=0;i<s.length();i++){
                 x = s.charAt(i)-'0';
                int prev=0;
                if(i != 0) prev = s.charAt(i-1)-'0';
                if(prev < x){
                    for(int j=0;j<x-prev;j++)
                    res+=o;
                    res+=x;
                }
                else if(prev == x)res+=x;
                else {
                    for(int j=0;j<prev-x;j++)
                    res+=c;
                    res+=x;
                }
            }
            for(int k=0;k<x;k++)res+=c;
            ans.add(new String("Case #"+t+": "+res));
        }
        ans.stream().forEach(s->System.out.println(s));
    }
}