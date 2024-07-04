
import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    
    static class FastReader{
        
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        long nextLong()
        {
           return Long.parseLong(next());
        }
        
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
         
       String nextLine()
       {
           String str = "";
           try
           {
               str = br.readLine();
           }
           catch (IOException e)
           {
               e.printStackTrace();
           }
           return str;
       }

    }
    
    public static String maxsuffix(ArrayList<String> suffixes){
        
        int maxLengthIndex = 0;
        String maxSuffix = suffixes.get(0);
        
        for(int i=1;i<suffixes.size();i++){
            
            if(suffixes.get(i).length() > maxSuffix.length()){
                maxSuffix = suffixes.get(i);
                maxLengthIndex = i;
            }
        }
        
        boolean issuffix = true;
        
        for(int i=0;i<suffixes.size();i++){
            
            String s = suffixes.get(i);
            
            
            
            int p = maxSuffix.length() - 1;
            
            for(int j=s.length()-1;j>=0;j--){
                
                if(s.charAt(j) != maxSuffix.charAt(p)){
                    issuffix = false;
                    break;
                }
                
                p--;
            }
            
            if(issuffix == false)
                break;
            
        }
        
        if(issuffix)
            return maxSuffix;
        else
            return "";
        
    }
    
    public static String maxPrefix(ArrayList<String> prefixes){
        
        int maxLengthIndex = 0;
        String maxPrefix = prefixes.get(0);
        
        for(int i=1;i<prefixes.size();i++){
            
            if(prefixes.get(i).length() > maxPrefix.length()){
                maxPrefix = prefixes.get(i);
                maxLengthIndex = i;
            }
        }
        
        boolean isprefix = true;
        
        for(int i=0;i<prefixes.size();i++){
            
            String s = prefixes.get(i);
            
            
            
            for(int j=0;j<s.length();j++){
                
                if(s.charAt(j) != maxPrefix.charAt(j)){
                    isprefix = false;
                    break;
                }
            }
            
            if(isprefix == false)
                break;
            
        }
        
        if(isprefix)
            return maxPrefix;
        else
            return "";
        
    }
  

  public static void main(String[] args) {
   
    FastReader fastRead = new FastReader();
    PrintWriter out = new PrintWriter(System.out);
    int t = fastRead.nextInt();
    int caseNum = 0;
      
    while (t-- > 0) {
        
        int n = fastRead.nextInt();
        
        ArrayList<String> prefixes = new ArrayList<String>();
        ArrayList<String> suffixes = new ArrayList<String>();
        ArrayList<String> strlist = new ArrayList<String>();
        
        String answer = new String();
        
        for(int i=1;i<=n;i++){
            String s = fastRead.nextLine();
            strlist.add(s);
        }
        
        for(int i=0;i<strlist.size();i++){
            
            String s = strlist.get(i);
            
            int asteriskIndex = 0;
            
            for(int j=0;j<s.length();j++){
                if(s.charAt(j) == '*'){
                    asteriskIndex = j;
                    break;
                }
            }
            
            
            if(asteriskIndex > 0){
                String prefix = s.substring(0,asteriskIndex);
                prefixes.add(prefix);
            }
            
            if(asteriskIndex < s.length()-1){
                String suffix = s.substring(asteriskIndex+1);
                suffixes.add(suffix);
            }
            
        }
        
        boolean isPossible = true;
        String maxprefix = new String();
        String maxsuffix = new String();
        
        if(prefixes.size() > 0){
            
            maxprefix = maxPrefix(prefixes);
            
            if(maxprefix.length() == 0){
                isPossible = false;
            }
        }
        
        caseNum++;
        
        if(isPossible){
            
            
            if(suffixes.size() > 0){
                
                maxsuffix = maxsuffix(suffixes);
                
                if(maxsuffix.length() == 0){
                    isPossible = false;
                }
            }
            
            if(isPossible){
                answer = answer.concat(maxprefix);
                answer = answer.concat(maxsuffix);
                out.println("Case #"+caseNum+": "+answer);
            }
            else{
                out.println("Case #"+caseNum+": *");
            }
            
        }
        else{
            out.println("Case #"+caseNum+": *");
        }
    }
    
      out.close();
  }
}
