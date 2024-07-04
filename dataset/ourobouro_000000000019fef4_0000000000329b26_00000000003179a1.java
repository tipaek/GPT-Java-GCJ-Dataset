
import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    
    static class FastReader{
        
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            
//             try {
//                                        br = new BufferedReader(
//                                        new FileReader("input.txt"));
//
//                                    } catch (IOException e) {
//                                        e.printStackTrace();
//                                    }
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
    
    public static class CharVal{

        char ch;
        int high;

        CharVal(char ch,int high){
            this.ch = ch;
            this.high = high;
        }
    }
    
    public static class CompareNums implements Comparator<CharVal>{
        
        public int compare(CharVal v1, CharVal v2){
            return (v1.high - v2.high);
        }
    }
    
   

  public static void main(String[] args) {
      
      FastReader fastRead = new FastReader();
      PrintWriter out = new PrintWriter(System.out);
      
//      PrintWriter out =  new PrintWriter(System.out);
//
//           try {
//                      out = new PrintWriter(new
//                         BufferedWriter(new FileWriter("output.txt")));
//
//                  } catch (IOException e) {
//                      e.printStackTrace();
//                  }
//
      
         int t = fastRead.nextInt();
         
         int caseNum = 0;
           
         while (t-- > 0) {
             
             int d = fastRead.nextInt();
             
             //ArrayList<Character> [] numMap = new ArrayList[10];
             
             ArrayList<Character>[] numMap = new ArrayList[10];
             
             int [] charHashOri = new int[101];
             Arrays.fill(charHashOri,0);
             
             for(int i=0;i<10;i++){
                 numMap[i] = new ArrayList<Character>();
             }
             
             char [] charMap = new char [10];
             
             int [] charMax = new int[101];
             Arrays.fill(charMax,10);
             
             for(int i=0;i<10000;i++){
                 int num = fastRead.nextInt();
                 String str = fastRead.next();
                 
                 for(int l=0;l<str.length();l++){
                     
                     char ch = str.charAt(l);
                     
                     int in = ch - 'A';
                     
                     charHashOri[in] = 1;
                 }
                 
                 if(num >=1 && num <= 9){
                     numMap[num].add(str.charAt(0));
                 }
                 
                 String numStr = String.valueOf(num);
                 
                 if(numStr.length() == str.length()){
                     
                     char ch = str.charAt(0);
                     
                     char numFirst = numStr.charAt(0);
                     
                     int digit = Integer.parseInt(String.valueOf(numFirst));
                     
                     if(charMax[ch-'A'] > digit){
                         charMax[ch-'A'] = digit;
                     }
                     
                 }
                 
             }
             
            ArrayList<CharVal> nums = new ArrayList<CharVal>();
             
             for(int i=0;i<=25;i++){
                 
                 if(charHashOri[i] == 1 && (charMax[i] != 10)){
                     nums.add(new CharVal((char)('A'+i),charMax[i]));
                 }
                 
                 if(charHashOri[i] == 1 && (charMax[i] == 10)){
                     charMap[0] = (char) ('A' + i);
                 }
             }
             
             Collections.sort(nums, new CompareNums());
             
             
             for(int i=0;i<nums.size();i++){
                 
                 char ch = nums.get(i).ch;
                 charMap[i+1] = ch;
             }
             
             
             caseNum++;
             out.print("Case #"+caseNum+": ");
             
             for(int i=0;i<=9;i++){
                 out.print(charMap[i]);
             }
             
             out.println("");
             
         }
         
      out.close();
                         
  }
}
