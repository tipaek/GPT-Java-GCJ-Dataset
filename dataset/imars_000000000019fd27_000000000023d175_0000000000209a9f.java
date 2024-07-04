import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String args[]){
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int test = in.nextInt();
    for(int i=1; i<=test; ++i){
      String line = in.next();
      char elems[] = new char[line.length()];
      int prev = 0;
      String out="";
      elems = line.toCharArray();
      for(int j=0; j<elems.length; ++j){
        int numElem = Character.getNumericValue(elems[j]);
        if(prev<=numElem){
          for(int k=0; k<numElem-prev; ++k){
            out += "(";
          };
        };
        if(prev>numElem){
          for(int k=0; k<prev-numElem; ++k){
            out += ")";
          };
        };
        out +=numElem;
        prev = numElem;
      };
      for(int j=0; j<prev; ++j){
        out += ")";
      };
      System.out.println("Case #"+i+": "+out);
    };
  };
}