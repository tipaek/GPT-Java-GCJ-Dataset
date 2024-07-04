import java.io.*;
import java.util.Scanner;
class Solution { 

public static void printPascal(int n) 
{ 
 for(int line = 1; line <= n; line++) 
 { 
  
 int C=1;
 System.out.println("Case #"+n+":");
 for(int i = 1; i <= line; i++) 
 { 
  // The first value in a line is always 1 
  System.out.print(C+" "); 
  C = C * (line - i) / i; 
 } 
 System.out.println(); 
 } 
} 
// Driver code 
public static void main (String[] args) { 
    Scanner sc = new Scanner(System.in);
    int test = sc.nextInt();
    while(test>0){
 int n = sc.nextInt(); 
 printPascal(n); 
 test--;
    }
} 
}