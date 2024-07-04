import java.util.*;
import java.util.ArrayList; 
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); 
    for (int i = 1; i <= t; i++) {
      String s = in.next();
      char[] arr = new char[s.length()];
      for(int j = 0; j<s.length(); j++) {
    	  arr[j]=s.charAt(j);
      }
      ArrayList<Character> al = new ArrayList<Character>();
      for(int k = 0; k<arr.length; k++) {
    	  char val = arr[k];
    	  if(k==0){
    		  if(val == '0') {
    			  al.add('0');
    		  }
    		  else if(val == '1') {
    			  al.add('(');
    			  al.add('1');
    		  }
    		  else if(val == '2') {
    			  al.add('(');
    			  al.add('(');
    			  al.add('2');
    		  }
    		  else if(val == '3') {
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('3');
    		  }
    		  else if(val == '4') {
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('4');
    		  }
    		  else if(val == '5') {
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('5');
    		  }
    		  else if(val == '6') {
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('6');
    		  }
    		  else if(val == '7') {
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('7');
    		  }
    		  else if(val == '8') {
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('8');
    		  }
    		  else {
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('9');
    		  }
    	  }  
    	  else {
    		  char temp = arr[k-1];
    		  if(val-temp==0) {
    			  al.add(val);
    		  }
    		  else if(val-temp==-1) {
    			  al.add(')');
    			  al.add(val);
    		  }
    		  else if(val-temp==-2) {
    			  al.add(')');
    			  al.add(')');
    			  al.add(val);
    		  }
    		  else if(val-temp==-3) {
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(val);
    		  }
    		  else if(val-temp==-4) {
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(val);
    		  }
    		  else if(val-temp==-5) {
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(val);
    		  }
    		  else if(val-temp==-6) {
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(val);
    		  }
    		  else if(val-temp==-7) {
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(val);
    		  }
    		  else if(val-temp==-8) {
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(val);
    		  }
    		  else if(val-temp==-9) {
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(val);
    		  }
    		  else if(val-temp==1) {
    			  al.add('(');
    			  al.add(val);
    		  }
    		  else if(val-temp==2) {
    			  al.add('(');
    			  al.add('(');
    			  al.add(val);
    		  }
    		  else if(val-temp==3) {
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add(val);
    		  }
    		  else if(val-temp==4) {
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add(val);
    		  }
    		  else if(val-temp==5) {
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add(val);
    		  }
    		  else if(val-temp==6) {
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add(val);
    		  }
    		  else if(val-temp==7) {
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add(val);
    		  }
    		  else if(val-temp==8) {
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add(val);
    		  }
    		  else if(val-temp==9) {
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add('(');
    			  al.add(val);
    		  }
    	  }
    	  if(arr.length-k==1) {
    		  if(val == '0') {
    			  
    		  }
    		  else if(val == '1') {
    			  al.add(')');
    		  }
    		  else if(val == '2') {
    			  al.add(')');
    			  al.add(')');
    		  }
    		  else if(val == '3') {
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    		  }
    		  else if(val == '4') {
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    		  }
    		  else if(val == '5') {
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    		  }
    		  else if(val == '6') {
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    		  }
    		  else if(val == '7') {
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    		  }
    		  else if(val == '8') {
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    		  }
    		  else {
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    			  al.add(')');
    		  }
    	  }
    	  
      }
      String word= new String();
      for(char c:al){
    	  word= word+ c; 
      }
      System.out.println("Case #" + i + ": " + word);
    
  }
  }
}