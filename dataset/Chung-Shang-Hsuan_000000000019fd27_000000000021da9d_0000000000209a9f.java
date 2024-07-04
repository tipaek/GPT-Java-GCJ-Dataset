import java.util.*;

public class Solution{

  String s;

  public Solution(StringBuffer str){
    int count = 0;
    int position = 0;
    while (position < str.length()){
      if (count > Integer.parseInt(str.substring(position,position+1))){
        while (count > Integer.parseInt(str.substring(position,position+1))){
          str.insert(position,')');
          position ++;
          count --;
        }
      }else if (count < Integer.parseInt(str.substring(position,position+1))){
        while (count < Integer.parseInt(str.substring(position,position+1))){
          str.insert(position,'(');
          position ++;
          count ++;
        }
      }else{
        position ++;
      }
    }
    while (count > 0){
      str.append(')');
      count --;
    }
    s = str.toString();
  }

  public static void main(String args[]){
    Scanner sc1 = new Scanner(System.in);
    int cases = sc1.nextInt();
    sc1.nextLine();
    for (int c = 1; c < cases+1; c ++){
      String str = sc1.nextLine().trim();
      Solution b = new Solution(new StringBuffer(str));
      System.out.println("Case #" + c + ": " + b.s);
    }
  }
}
