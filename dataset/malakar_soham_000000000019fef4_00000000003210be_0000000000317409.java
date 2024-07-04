import java.util.Scanner;
class Solution{

  static int x,y,flag,count=0,sum=0;
  static boolean reachflg=false;

  //flag = 1(y--),2(x--),3(y++),4(x++)

  static boolean move(char dir){
    if(dir == 'N'){
      y+=1;
      flag = 3;
    }
    else if(dir == 'S'){
      y-=1;
      flag = 1;
    }
    else if(dir == 'E'){
      x-=1;
      flag = 2;
    }
    else{
      x+=1;
      flag  = 4;
    }

    x = Math.abs(x);
    y = Math.abs(y);

    count++;

    if(x+y!=0){

      if(flag == 1){
        if(x==0)
        y-=1;
        else
        x-=1;
      }
      else if (flag == 2) {
        if(y==0)
        x-=1;
        else
        y-=1;
      }
      else if (flag == 3) {
        y-=1;
      }
      else{
        x-=1;
      }


     //System.out.println(x+" "+y);


      if(x+y>sum)
      return false;
      else if(x+y==0){
        sum = x+y;
        return (reachflg=true);
      }
      else
      return true;
    }

    return (reachflg=true);

  }

  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int T = sc.nextInt();
    if(!(T>=1 && T<=100))
    System.exit(0);
    for(int t = 0; t<T;t++){
      x = sc.nextInt();
      y = sc.nextInt();
      String s = sc.next();
      if(!(x>=0 && x<=1000))
      System.exit(0);
      if(!(y>=0 && y<=1000))
      System.exit(0);
      int M = s.length();
      if(!(M>=0 && M<=1000))
      System.exit(0);
      sum = x+y;
      count=0;
      flag=0;
      reachflg = false;

      for(int i =0;i<M && reachflg==false;i++){
        if(!move(s.charAt(i))){
          break;
        }
      }

      System.out.print("Case #"+t+": ");
      if(!reachflg)
      System.out.println("IMPOSSIBLE");
      else
      System.out.println(count);
    }
  }
}
