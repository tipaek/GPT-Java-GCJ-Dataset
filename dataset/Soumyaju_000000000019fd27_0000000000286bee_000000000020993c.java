import java.io.*;
import java.util.Scanner;
 
 class Main
 {
  public static void main(String args[]){

    Scanner ob = new Scanner(System.in);
    int T = ob.nextInt();
    int N;
    int K;
    int remain;
    int a[];
    int rem = 0;
    boolean flag = false;
    int temp = 0;

//input section
    for(int i = 1; i <= T; i++){
      N = ob.nextInt();
      K = ob.nextInt();
      a = new int[N];
      for(int j = 0; j < a.length; j++){
        a[j] = ob.nextInt();
      }

      //checking the logic
      int h = 0;
      while (h < a.length - 1) {
        if (a[h] >= 5 ) {
          rem = a[h] - 5;
          flag = true;
        }
        else{
        flag = false;
        temp = h+1;
        }

        h++;
        a[h] += rem;
      }
      if (flag == true){
        System.out.println("YES");
      }
      else{
        System.out.println("NO " + temp);
      }
    }
  }
}
