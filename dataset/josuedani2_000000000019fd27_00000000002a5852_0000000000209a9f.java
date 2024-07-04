import java.util.*;
import java.io.*;
public class Solution{


  public static String balancea(int i, int[] digits, String[] digits2){
    String n="";
    
    int ant =0;
    for (int k=0; k<digits.length; k++){
        
        //System.out.println("k:"+digits[k]);

        if (ant<digits[k]){
            digits2[k*2]=concatenar(1, 0);
        }else if (ant>digits[k]){
            digits2[k*2]=concatenar(0, 1);   
        }
        
        if (k==digits.length-1 && (digits[k]>ant|| digits[k]==1)){
            digits2[k*2+2]=concatenar(0, 1);   
        }

        ant = digits[k];
        
    }

    
    for (int j=0; j<digits2.length; j++){
        if (digits2[j]!=null)
        n += digits2[j];
    }
    return "Case #" + i + ": " + n;
  }

  public static String concatenar(int open, int close){

    String abre="", cierra="";

    for (int i=0; i<open; i++){
        abre +="(";
    }

    for (int i=0; i<close; i++){
        cierra +=")";
    }


    return cierra+abre;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String n = in.next();
      
      String number = String.valueOf(n);
      char[] digits = number.toCharArray();
      int[] digits2 = new int[number.length()];
      String[] digits1 = new String[(digits.length*2)+1];
      
      for (int j=0; j<digits.length; j++){
        digits1[j*2+1] = String.valueOf(digits[j]);
      }

      for (int j=0; j<digits2.length; j++){
        digits2[j] = Integer.parseInt(String.valueOf(digits[j]));
        //System.out.print(digits2[j]+" ");
      }
      //System.out.print("\n");


      System.out.println(balancea(i, digits2, digits1));

    }
  }
}