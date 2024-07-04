class Solution1{



  public static void main(String[] args){
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for(int i=0;i<=t;++i){
      String s = Integer.toString(in.nextInt());
      solvef(s,i);
    }
    in.close();

  }
}
