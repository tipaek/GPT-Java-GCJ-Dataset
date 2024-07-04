import java.util.Scanner;

class Solution{

  static boolean isPowerOfTwo(int n)
    {
      n = Math.abs(n);
        return (int)(Math.ceil((Math.log(n) / Math.log(2))))
            == (int)(Math.floor(((Math.log(n) / Math.log(2)))));
    }

    static boolean direction(int n)
      {
          n = Math.abs(n);
          return (((Math.log(n)/Math.log(2))- Math.floor(Math.log(n) / Math.log(2)))>=0.5);
      }

      static boolean min(int x, int y){
        if(Math.abs(x)<Math.abs(y))
        return true;
        else
        return false;
      }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    if(!(T>=1 && T<=100))
    System.exit(0);
    for(int loop = 0;loop<T;loop++){

      int x=sc.nextInt();
      if(!(x>=-100 && x<=100))
      System.exit(0);
      int y=sc.nextInt();
      if(!(y>=-100 && y<=100))
      System.exit(0);

      boolean flx=false,fly=false;
      if(isPowerOfTwo(x)|| x==0)
      flx=true;
      if(isPowerOfTwo(y) || y==0)
      fly=true;
      int val=0;
      String out="";
      for(int i=0;;i++) {
        val = (int)Math.pow(2,i);
          if(!(flx && fly)){
            if(!flx){
              if(direction(x)){
                if(x>=0){
                  x-=val;
                  out=out+"E";
                }
                else{
                  x+=val;
                  out=out+"W";
                }
              }
              else{
                if(x>=0){
                  x+=val;
                  out=out+"W";
                }
                else{
                  x-=val;
                  out=out+"E";
                }
              }
              if(isPowerOfTwo(x))
              flx=true;
            }
            else if(!fly){
              if(!direction(y)){
                if(y>=0){
                  y-=val;
                  out=out+"N";
                }
                else{
                  y+=val;
                  out = out+"S";
                }
              }
              else{
                if(y>=0){
                  y+=val;
                  out=out+"S";
                }
                else{
                  y-=val;
                  out=out+"N";
                }
              }
              if(isPowerOfTwo(y))
              fly=true;
            }
          }
          else{
            if(y==0 && min(y,x)){
              if(x>=0){
                x-=val;
                out=out+"E";
              }
              else{
                x+=val;
                out=out+"W";
              }
            }
            else if(x==0 && min(x,y)){
              if(y>=0){
                y-=val;
                out=out+"N";
              }
              else{
                y+=val;
                out=out+"S";
              }
            }
            else if(min(x,y)){
              if(x>=0){
                x-=val;
                out=out+"E";
              }
              else{
                x+=val;
                out=out+"W";
              }
            }
            else{
              if(y>=0){
                y-=val;
                out=out+"N";
              }
              else{
                y+=val;
                out=out+"S";
              }
            }
          }
          if((x==0 && y==0)||(val>Math.abs(x) && val>Math.abs(y)))
          break;
      }

    System.out.print("Case "+(loop+1)+": ");
    if(!(x==0 && y==0))
    System.out.println("IMPOSSIBLE");
    else
    System.out.println(out);
  }
  }
}
