import java.io.*;

class Solution {
  public static void main(String[] args) {
    try{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t, n, inicial, finale, casoActual;
      String resp;
      boolean hayJ, hayC;
      char[] schedule = new char[24*60];
      t= Integer.parseInt(br.readLine());
      casoActual=1;
      while(t>0){
      for(int u=0; u<24*60; ++u){
          schedule[u]=0;
      }
      n=Integer.parseInt(br.readLine());
      resp="";
      while(n>0){
        hayJ = false;
        hayC = false;
        String[] aux = br.readLine().split(" ");
        inicial = Integer.parseInt(aux[0]);
        finale = Integer.parseInt(aux[1]);
        for(int i=inicial; i<finale; ++i){
          if(schedule[i]=='J'){
            hayJ=true;
          }
          else if(schedule[i]=='C'){
            hayC=true;
          }
        }
        if(!hayJ && !hayC){
          resp+="C";
          for(int i=inicial; i<finale; ++i){
            schedule[i]='C';
          }
        }
        else if(hayC && !hayJ){
          resp+="J";
          for(int i=inicial; i<finale; ++i){
            schedule[i]='J';
          }

        }
        else if(hayJ && !hayC){
          resp+="C";
          for(int i=inicial; i<finale; ++i){
            schedule[i]='C';
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