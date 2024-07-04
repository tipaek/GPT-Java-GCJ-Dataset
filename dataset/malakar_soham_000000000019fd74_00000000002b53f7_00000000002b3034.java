import java.util.Scanner;

class Solution{

  boolean check(String ref, String two){
    for(int i=two.length()-1,j=ref.length()-1;i>=1;i--, j--){
      if(two.charAt(i)!=ref.charAt(j))
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int T = sc.nextInt();
    if(!(T>=1 && T<=100))
    System.exit(0);
    for(int t=0;t<T;t++){
    int N = sc.nextInt();
    if(!(N>=2 && N<=50))
    System.exit(0);
    for(int n=0;n<N;n++){
    String[] P = new String[N];
    int index = 0; boolean flag = true;
    for(int i=0;i<N;i++){
      P[i] = sc.next();
      if(!(P[i].length()>=2 && P[i].length()<=100))
      System.exit(0);
    }
    for(int i=0;i<N-1;i++){
      if(P[i].length()<P[i+1].length())
      index = i+1;
    }
    for(int i=0;i<N;i++){
      if(i==index)
      continue;
      if(!obj.check(P[index],P[i])){
        flag = false;
        break;
      }
    }

    if(flag)
    System.out.println(P[index].substring(1));
    else
    System.out.println("*");
  }
}
}

}
