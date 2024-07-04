import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    String  T = in.nextLine(); 
    int t = Integer.parseInt(T);
    
    
    for (int i = 1; i <= t; ++i) {
        String N = in.nextLine();
        char[] tempN = N.toCharArray();
     
        List<Character> listC = new ArrayList<Character>();
        for (char c : tempN) {
            listC.add(c);
        }
        
        int adder = 0;
        int ex1 = 0;
        int ex2 = 0;
        int ext = 0;
        
        for(int ii=0; ii < tempN.length-1; ii++){
            if((tempN[ii+1] - tempN[ii]) < 0 ){
                adder = (tempN[ii+1] - tempN[ii])*(-1);
                for (int y=0; y < adder; y++){
                    listC.add((ii+1)+ext,')');
                    ex1 += 1;
                }
            }else if((tempN[ii+1] - tempN[ii]) > 0){
                adder = (tempN[ii+1] - tempN[ii]);
                for (int x=0; x < adder; x++){
                    listC.add((ii+1)+ext,'(');
                    ex2 += 1;
                }
            }
            ext = ex1 + ex2;
        }
        
        int f = Integer.parseInt(listC.get(0).toString());
        int l = Integer.parseInt((listC.get(listC.size()-1).toString()));
        
        for(int fi = 0; fi < f; fi++){
            listC.add(0,'(');
        }
        
        for(int li = 0; li < l; li++){
            listC.add(listC.size(),')');
        }
        
        System.out.println(" ");
        
        String[] result = new String[listC.size()];
        
        StringBuilder builder = new StringBuilder(listC.size());
        for(Character ch: listC)
        {
            builder.append(ch);
        }

      System.out.println("Case #" + i + ": " + builder.toString());
    }
  }
}