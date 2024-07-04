
class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testCases = in.nextInt();
    for(int i=1;i<=testCases;i++) {
      long a = in.nextLong();
      long b = in.nextLong();
      lessThan5(in,a,b);
    }
  }
  
  public static void lessThan5(Scanner in , long a, long b) {
    long x = 1000000000 -5;
    long y = 1000000000 -5;
    for(int i=0;i<10;i++) {
      for(int j=0;j<10;j++) {
        System.out.println((x+i)+" "+(y+j));
        String str = in.nextLine();
        if("CENTER".equals(str)) {
          return;
        }
      }
    }
    while(true) {
      int randX = (int) Math.random() * 100;
      int randY = (int) Math.random() * 100;
      System.out.println((x+randX)+" "+(y+randY));
      
    }
  }
  
}
