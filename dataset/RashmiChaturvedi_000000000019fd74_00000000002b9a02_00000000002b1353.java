import java.io.*; 
class GFG { 

//Pascal function to print
public static void Pascal(int n) 
{ 
 for(int l = 1; l <= n; l++) 
 { 
  
 int C=1;// used to represent C(l, i) 
 for(int i = 1; i <= l; i++) 
 { 
  // The first value in a line is always 1 
  System.out.print(C+" "); 
  C = C * (l - i) / i; 
 } 
 System.out.println(); 
 } 
} 

// Driver code 
public static void main (String[] args) { 
 int n = 5; 
 Pascal(n); 
} 
}