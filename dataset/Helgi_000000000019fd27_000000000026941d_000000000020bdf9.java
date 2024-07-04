import java.util.Scanner;
public class Solution{
  public static void main(String[] args){
    
    //input
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    
    //formulation
    for(int i =0; i<T; i++){
      
      
     //init
    int size = 24*60+1;
    int[] C = new int[size];
    for(int h =0; h<C.length;h++)
      C[h] =0;
    int[] J = new int[size];
    for(int h =0; h<J.length;h++)
      J[h] =0;
    
      
      
      
      String s = "";
      int n = scanner.nextInt();
      boolean poss = true;
      for(int j =0; j<n; j++){
        int a = scanner.nextInt();
        int b = scanner.nextInt();
      boolean jamie = true;
      boolean cameron = true;
      
      for(int k = a; k<b;k++){
        if(C[k] == 1){
         cameron = false; 
        }
      }
      
      for(int k = a; k<b;k++){
        if(J[k] == 1){
         jamie = false; 
        }
      }
      
      if(cameron){
        for(int r = a; r<b;r++){
                  C[r] = 1;
                }
        s = s.concat("C");
      }
      
      else if(jamie)
        {
        for(int r = a; r<b;r++){
                  J[r] = 1;
                }
        s = s.concat("J");
      }
      
      if(!cameron && !jamie) poss = false;
      }
      
      if(poss)System.out.println("Case " + "#"+(i+1)+": "+ s);
      else System.out.println("Case " + "#"+(i+1)+": " + "IMPOSSIBLE");
    }
  }
}

    