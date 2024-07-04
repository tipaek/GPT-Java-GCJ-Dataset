import java.util.*;
import java.io.*;
 
 
public class Solution {
    
    static class query{
        long M;
        String re;
        
        public query(long val,String s){
            this.M = val;
            this.re = s;
        }
    }
    
    public static ArrayList<String> perm;
    public static StringBuilder answer;
    
    public static void makeans(HashSet<Integer> hs,ArrayList<Integer> arr,boolean[][] dp,String ans){
        if(ans.length()==10){
            answer = new StringBuilder(ans);
        }
       // System.out.println(ans);
        int pos = ans.length();
        if(pos>=10)return;
        for(int i = 0;i<arr.size();i++){
            int val = arr.get(i);
            if(!hs.contains(val) && dp[val][pos]){
                hs.add(val);
                char c = (char)('A'+val);
                makeans(hs,arr,dp,ans+c);
                hs.remove(val);
            }
        }
    }
    
        
    public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            int tc = sc.nextInt();
            for(int q = 1;q<=tc;q++){
                System.out.print("Case #"+q+": ");
                int max = 10000;
                int U = sc.nextInt();
                ArrayList<query> list = new ArrayList<>();
                for(int i = 0;i<max;i++){
                    list.add(new query(sc.nextLong(),sc.next()));
                }
                boolean[][] dp = new boolean[26][10];
                boolean[] visited = new boolean[26];
                for(int i = 0;i<max;i++){
                    long limit = list.get(i).M;
                    String st = list.get(i).re;
                    for(int j = 0;j<st.length();j++){
                        int ch = st.charAt(j) - 'A';
                        if(!visited[ch]){
                            Arrays.fill(dp[ch],true);
                            visited[ch] = true;
                        }
                        if(j==0)dp[ch][0] = false;
                    }
                    int len = st.length();
                    if((limit/len)==0){
                        int ch = st.charAt(0) - 'a';
                        for(int j = 9;j>=ch-1;j--)dp[ch][j] = false;
                    }
                }
                int count = 10;
                for(int i = 0;i<26;i++){
                    if(visited[i])count--;
                }
                for(int i = 0;i<26;i++){
                    if(count>0 && !visited[i]){
                        visited[i] = true;
                        Arrays.fill(dp[i],true);
                        count--;
                    }
                }
                answer = new StringBuilder();
                ArrayList<Integer> arr = new ArrayList<>();
                HashSet<Integer> hs = new HashSet<>();
                for(int i = 0;i<26;i++){
                    if(visited[i]){
                        arr.add(i);
                    }
                }
                makeans(hs,arr,dp,"");
                System.out.println(answer.toString());
            }
              
            
              
    }
}