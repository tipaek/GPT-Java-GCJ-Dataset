
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
             }
             
             charMap[1] = numMap[1].get(0);
             
             int [] charHash = new int[101];
             Arrays.fill(charHash,0);
             
             int index = numMap[1].get(0) - 'A';
             
             charHash[index] = 1;
             
             
             for(int i=2;i<=9;i++){
                 
                 for(int j=0;j<numMap[i].size();j++){
                     
                     char ch = numMap[i].get(j);
                     
                     int ind = ch - 'A';
                     
                     if(charHash[ind] == 0){
                         charMap[i] = ch;
                         charHash[ind] = 1;
                         break;
                     }
                    
                 }
             }
             
             for(int i=0;i<=25;i++){
                 if(charHashOri[i] != charHash[i]){
                     
                     char ch = (char)('A' + i);
                     charMap[0] = ch;
                     break;
                 }
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
