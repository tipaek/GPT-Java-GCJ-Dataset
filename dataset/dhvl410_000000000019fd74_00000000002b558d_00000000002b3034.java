import java.util.*;
class Solution {
public static void main(String args[]) {
 Scanner sc=new Scanner(System.in);
 int t=sc.nextInt();
 while(t>0) {
     int n=sc.nextInt();
     String a[]=new String[n];
     for(int j=0;j<n;j++) {
         a[i]=sc.next();
     }
     String m;
     for(int i=1;i<n;i++) {
         m=match(a[i-1],a[i]);
     }
        
 t--;
 }
 return 0;
}
    static String match(String a,String b) {
        char[] s1=a.toCharArray();
        char[] s2=b.toCharArray();
        int c, d, e, text_length, pattern_length, position = -1;

  text_length    = strlen(s1);
  pattern_length = strlen(s2);

  if (pattern_length > text_length) {
    return -1;
  }

  for (c = 0; c <= text_length - pattern_length; c++) {
    position = e = c;

    for (d = 0; d < pattern_length; d++) {
      if (s2[d] == s1[e]) {
        e++;
      }
      else {
        break;
      }
    }
    if (d == pattern_length) {
      return position;
    }
  }

  return "*";
    }
}