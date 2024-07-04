import java.util.*;
import java.io.*;

class Solution{
   public static void main(String args[])throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int counter = 1;
         
            int C = 0, J = 0;
            char [] ansNum = new char [B+1];
            List<int[]> equals = new ArrayList<>();
            List<int[]> dif = new ArrayList<>();
            while(counter <= T){
            
               int turn = 1;
               while(turn <= B/2){
                  bw.write(turn+"\n");
                  bw.flush();
                  char cc = br.readLine().charAt(0);
                  ansNum[turn] = cc;
                  if(turn%10 == 1){
                     if(equals.size() != 0 && dif.size() != 0){
                        update(ansNum,equals,dif, bw, br);
                     }if(turn != 1){
                        int [] ind = equals.size() == 0 ? dif.get(0):equals.get(0);
                        update2(ansNum,ind[0],bw,br);  
                     }
                  }
                  bw.write((B-turn+1)+"\n");
                  bw.flush();
                  char cs = br.readLine().charAt(0);
                  ansNum[B-turn+1] = cs;
                  if(cs != cc && dif.size() == 0){
                     int [] d = {turn, cc};
                     dif.add(d);
                  }else if(equals.size() == 0){
                     int [] e  = {turn, cc};
                     equals.add(e);
                  }
                  turn++;
               }
               String ans = new String(ansNum);
               bw.write(ans.substring(1,ans.length())+"\n");
               bw.flush();
               String retro = br.readLine();
               if(retro.equals("N"))
                  break;  
               counter++;
            }
            
            bw.close();
            br.close();
      }
      
      public static void update(char [] ansNum, List<int[]>e ,List<int[]> d, BufferedWriter bw, BufferedReader br) throws IOException{
         int [] ee = e.get(0);
         int [] dd = d.get(0);
         char cE = ansNum[ee[0]];
         char cD = ansNum[dd[0]];
         
         bw.write((ee[0])+"\n");
         bw.flush();
         char cEE = br.readLine().charAt(0);
         
         bw.write((dd[0])+"\n");
         bw.flush();
         char cDD = br.readLine().charAt(0);
         
         if(cDD == cD && cEE != cE){
            complement(ansNum);
            reverse(ansNum);
         }else if(cEE != cE && cDD != cD){
            complement(ansNum);
         }else if(cEE == cE && cDD != cD){
            reverse(ansNum);
         }
      }
      
      public static void update2(char [] ansNum, int index, BufferedWriter bw, BufferedReader br)throws IOException{
         
         char c1 = ansNum[index];
         bw.write(index+"\n");
         bw.flush();
         char c2 = br.readLine().charAt(0);
         if(c1 != c2){
            complement(ansNum);
         }
      }
      
      public static void complement(char [] SS){
      
         for(int i = 0; i < SS.length; i++){
            if(SS[i] == '0'){
               SS[i] = '1';
            }else{
               SS[i] = '0';
            }
         }
      }
      
      public static void reverse(char [] SS){
         
         for(int i = 0; i < SS.length/2; i++){
            char a = SS[i];
            SS[i] = SS[SS.length-1-i];
            SS[SS.length-1-i] = a;
         }
      }
}
