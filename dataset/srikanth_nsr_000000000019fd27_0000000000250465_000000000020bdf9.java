import java.util.*;

class MyClass {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    
    for(int i=0;i<t;i++){
        int n = sc.nextInt();
        int time[]=new int[1441];
        for(int tl=0;tl<1441;tl++)time[tl]=0;
        for(int p=0;p<n;p++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            time[a]=(p+1);
            time[b]=(p+1);
            System.out.println(time[a]+" "+time[b]);
        }
    }
  }
}