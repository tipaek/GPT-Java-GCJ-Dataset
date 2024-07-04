import java.util.Scanner;
public class Solution{
  public static void main(String[] args){
    
    Scanner scanner = new Scanner(System.in);
    int T = Integer.parseInt(scanner.nextLine());
    String t = "";
    int p =0;
    for(int i =0; i<T; i++){
      t = "";
      String s = scanner.nextLine();
      s = s.concat("0");
      int fyrri =0;
      for(int j =0; j<s.length();j++){
        int n = Integer.parseInt(String.valueOf(s.charAt(j)))- fyrri;
        if(n>=0){
          t = t.concat(new String(new char[n]).replace("\0", "("));
          t = t.concat(Character.toString(s.charAt(j)));
        }
        else{
          n = -n;
          t = t.concat(new String(new char[n]).replace("\0", ")"));
          n = Integer.parseInt(String.valueOf(s.charAt(j)));
          t = t.concat(Character.toString(s.charAt(j)));
        }
        fyrri = Integer.parseInt(String.valueOf(s.charAt(j)));
      }
       t = t.substring(0,t.length()-1);
       System.out.println("Case "+ "#"+(i+1)+ ":" + " " +t);
    }
  }
}
    