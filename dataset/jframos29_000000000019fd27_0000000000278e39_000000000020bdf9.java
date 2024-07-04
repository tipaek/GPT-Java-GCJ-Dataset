import java.io.*;

class Solution {
  public static void main(String[] args) {
    try{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t, n, inicial, finale, casoActual;
      String resp;
      boolean puedeJ, puedeC;
      char[] scheduleC = new char[24*60];
      char[] scheduleJ = new char[24*60];
      t= Integer.parseInt(br.readLine());
      casoActual=1;
      while(t>0){
      for(int u=0; u<24*60; ++u){
          scheduleC[u]=0;
          scheduleJ[u]=0;
      }
      n=Integer.parseInt(br.readLine());
      resp="";
      while(n>0){
        puedeJ = true;
        puedeC = true;
        String[] aux = br.readLine().split(" ");
        inicial = Integer.parseInt(aux[0]);
        finale = Integer.parseInt(aux[1]);
        for(int i=inicial; i<finale; ++i){
          if(scheduleJ[i]=='J'){
            puedeJ=false;
          }
          if(scheduleC[i]=='C'){
            puedeC=false;
          }
        }
        if(puedeC && puedeJ){
          resp+="C";
          for(int i=inicial; i<finale; ++i){
            scheduleC[i]='C';
          }
        }
        else if(!puedeC && puedeJ){
          resp+="J";
          for(int i=inicial; i<finale; ++i){
            scheduleJ[i]='J';
          }

        }
        else if(!puedeJ && puedeC){
          resp+="C";
          for(int i=inicial; i<finale; ++i){
            scheduleC[i]='C';
          }
        }
        else{
          resp="IMPOSSIBLE";
          break;
        }
        n--;
      }
      String finalResp="Case #"+casoActual+": "+resp;
      System.out.println(finalResp);
      casoActual++;
      t--;
    }
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}