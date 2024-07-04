import java.util.*;

public class Solution{
    public static void process(String tmp, int caso){
	int size = tmp.length();
	System.out.print("Case #" + caso + ": ");
  if (size == 1) {
    if (tmp.charAt(0) == '1') {
      System.out.print("(" + tmp.charAt(0) + ")");
    }
    else{System.out.print(tmp.charAt(0));}
  }
  else{
    for (int i = 0; i < size; i++) {
  	    if (i == 0) {
  		if ((tmp.charAt(i) == '1') && (tmp.charAt(i+1) == '0')) {
  		    System.out.print("(" + tmp.charAt(i) + ")");
  		}
  		else {
  		    if ((tmp.charAt(i) == '1') && (tmp.charAt(i+1) == '1')) {
  			System.out.print("(" + tmp.charAt(i));
  		    }
  		    else{
            if ((tmp.charAt(i) == '0') && (tmp.charAt(i+1) == '1')) {
              System.out.print(tmp.charAt(i) + "(");
            }
            else{System.out.print(tmp.charAt(i));}
            }
  		}
  	    }
  	    else{
  		if (i == size-1) {
  		    if (tmp.charAt(i) == '1') {
  			System.out.print(tmp.charAt(i) + ")");
  		    }
  		    else{System.out.print(tmp.charAt(i));}
  		}
      else{
        if ((tmp.charAt(i) == '1') && (tmp.charAt(i+1) == '1')) {
          System.out.print(tmp.charAt(i));
        }
        else{
          if ((tmp.charAt(i) == '1') && (tmp.charAt(i+1) == '0')) {
            System.out.print(tmp.charAt(i) + ")");
          }
          else{
            if((tmp.charAt(i) == '0') && (tmp.charAt(i+1) == '1')){
              System.out.print(tmp.charAt(i) + "(");
            }
            else{System.out.print(tmp.charAt(i));}
          }
        }
      }
  	    }
  	}
  }
	System.out.println();
    }

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int cases = sc.nextInt();
	for (int i = 1; i <= cases; i++) {
	    String tmp = sc.next();
	    process(tmp, i);
	}
    }
}
