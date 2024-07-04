import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int z = 0; z < t; z++) {
        String S = in.nextString();
          
        String S_r="";
    	int balence = 0;
    	for ( int i = 0; i < S.length(); i++) {
    		int val = Integer.parseInt(S.substring(i,(i+1)));
    		int nb_ouvrante = val - balence;
    		for (int j = 0 ; j < nb_ouvrante ; j++) {
    			S_r += "(";
    		}
    		int nb_fermante = balence - val;
    		for (int j = 0; j < nb_fermante; j++) {
    			S_r += ")";
    		}
    		balence += nb_ouvrante;
    		S_r += val;
    	}
    	for (int j = 0; j < balence; j++) {
    		S_r += ")";
    	}
          
        System.out.println("Case #" + (z+1) + ": " + S_r);
    }
  }
}