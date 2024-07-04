import java.util.Scanner;
class Solution{
  public static String findString(String s, int n){
    String firstPart = new String();
    String secPart = new String();
    if(s.length() == 0){
      return new String();
    }
    int[] a = new int[s.length()];
    for(int i = 0;i < s.length();i++){
      a[i] = (int) Integer.parseInt(s.substring(i,i + 1));
    }
    int temp = 0;
    int min = a[0];
    for(int j = 1; j < s.length();j++){
      if(a[j] < min){
        min = a[j];
        temp = j;
      }
    }
   firstPart = s.substring(0,temp);
    if(temp != s.length() - 1){
      secPart = s.substring(temp + 1,s.length());
    }
    String sol = findString(firstPart,min) + String.valueOf(min) + findString(secPart,min);
    for(int t = 0;t < min - n;t++){
      sol = "(" + sol + ")";
    }
    return sol;
  }
  public static void main(String[] arg){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String s;
    for(int i = 0;i < n;i++){
      s = in.next();
      System.out.println("Case #" + (i + 1) + ": " + findString(s,0));
    }
    in.close();
  }
}