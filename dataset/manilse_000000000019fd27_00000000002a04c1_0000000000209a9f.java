import java.util.*;  

public class Solution {
  public static void solve(String s,int ks) {
    int n = s.length();
    System.out.print(s.charAt(0));
    int open = 0;
    int closed = 0;
    String out = "";
    if(s.charAt(0) - '0' > 0){
        for(int i=1; i<= s.charAt(0) - '0'; i++){
            out += "(";    
            open++;
        }
        out += s.charAt(0);
    } else {
        out += '0';
    }
    for(int i=1; i < n; i++){
        if(s.charAt(i-1) > s.charAt(i)){
            for(int j=1; j<= s.charAt(i-1)-
                            s.charAt(i); j++){
                out += ")";    
                closed++;
            }
            out += s.charAt(i);
        }
        if(s.charAt(i-1) < s.charAt(i)){
            for(int j=1; j<= s.charAt(i)-
                            s.charAt(i-1); j++){
                out += "(";    
                open++;
            }
            out += s.charAt(i);
        }
        
        if(s.charAt(i-1) == s.charAt(i)){
            out += s.charAt(i);
        }
    }
    
    if(open-closed > 0){
        for(int i=1; i <= open-closed; i++){
            out += ")";
        }
    }
System.out.println("Case #"+ks+": "+out);
  }

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    input.nextLine();
    for (int ks = 1; ks <= T; ks++) {
      solve(input.nextLine(),ks);
    }
  }
}
