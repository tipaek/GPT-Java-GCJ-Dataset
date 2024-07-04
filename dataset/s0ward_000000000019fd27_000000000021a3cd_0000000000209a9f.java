import java.util.*;

class Solution{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int i=1; i<=t; i++){
      String s = in.next();
      System.out.println("Case #"+i+": "+solve(s));
    }
  }

  private static String solve(String s){
    String zeroString = _solve(s);
    String res ="";
    int index = 0;
    for(int i=0; i<zeroString.length(); i++){
      if(zeroString.charAt(i) == '0')
        res += s.charAt(index++);
      else res += zeroString.charAt(i);
    }
    return res;
  }

  private static String _solve (String s){
    if(Integer.parseInt(s) == 0)
      return s;
    String res = "";
    for(String str : getSubStrings(s)){
      if(Integer.parseInt(str) == 0)
        res += str;
      else
        res += "("+_solve(reduce(str))+")";
    }
    return res;
  }

  private static ArrayList<String> getSubStrings(String s){
    ArrayList<String> subStrings = new ArrayList<>(s.length());
    ArrayList<Integer> boundaries = getBoundaries(s);
    for(int i=0;i<boundaries.size(); i++){
      if(i==boundaries.size()-1)
        subStrings.add(s.substring(boundaries.get(i),s.length()));
      else
        subStrings.add(s.substring(boundaries.get(i),boundaries.get(i+1)));
    }
    return subStrings;
  }

  private static ArrayList<Integer> getBoundaries (String s){
    ArrayList<Integer> boundaries = new ArrayList<>(s.length());
    boundaries.add(0);
    for(int i=0; i<s.length()-1; i++){
      if(s.charAt(i) == '0' && s.charAt(i+1) != '0')
        boundaries.add(i+1);
      else if(s.charAt(i) != '0' && s.charAt(i+1) == '0')
        boundaries.add(i+1);
    }
    return boundaries;
  }


  private static String reduce(String s){
    String res = "";
    char[] charArr = s.toCharArray();
    for(int i=0; i < charArr.length; i++){
      if(charArr[i] == '0')
        res += charArr[i];
      else
        res += "" + ((int) charArr[i]-'1');
    }
    return res;
  }
}
