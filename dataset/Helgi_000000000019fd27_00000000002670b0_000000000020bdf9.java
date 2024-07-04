import java.util.Scanner;
public class Solution{
  public static void main(String[] args){
    //init
    int size = 24*60+1;
    int[] C = new int[size];
    for(int i =0; i<C.length;i++)
      C[i] =0;
    int[] J = new int[size];
    for(int i =0; i<J.length;i++)
      J[i] =0;
    
    //input
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    
    //formulation
    for(int i =0; i<T; i++){
      String s = "";
      int n = scanner.nextInt();
      boolean poss = true;
      for(int j =0; j<n; j++){
        int a = scanner.nextInt();
        int b = scanner.nextInt();
      poss = true;
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
      
      else poss = false;
      }
      
      if(poss)System.out.println(s);
      else System.out.println("IMPOSSIBLE");
    }
  }
}

    