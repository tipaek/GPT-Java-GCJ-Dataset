import java.io.*;
class Trace{
  public static void main(String[] args) throws IOException{
    BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
    int t=Integer.parseInt(input.readLine());
    String output="";
    for(int i=1;i<=t;++i){
      int n=Integer.parseInt(input.readLine());
      double[][] m=matrixinput(n);
      double tr=0;
      int rr=0;
      int rc=0;
      for (int j=0;j<n;++j){
        tr=tr+m[j][j];
        c:
        for(int k=0;k<n;++k){
          for(int l=k+1;l<n;++l){
            if(m[j][k]==m[j][l]){
              ++rr;
            break c;}
          }
        }
          }
          for (int kk=0;kk<n;++kk){
            cc:
            for(int jj=0;jj<n;++jj){
              for(int ll=jj+1;ll<n;++ll){
                if(m[jj][kk]==m[ll][kk]){
                  ++rc;
                break cc;}
              }}
            }
    output=output+"Case #"+i+": "+(int)tr+" "+rr+" "+rc+"\n";
  }
  System.out.print(output);}
  public static double[][] matrixinput(int zz) throws IOException{
    String m1="";
    int count=0;
    BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
    while(true){
      String n=input.readLine();
      ++count;
      if(n.equals("") )
          break;
      else if(count==zz){
        m1=m1+n+"\n";
        break;
      }
      else
        m1=m1+n+"\n";}
    int sm1=0,nlm1=0;
    for(int i=0;i<=m1.length()-1;++i){
      if(Character.toString(m1.charAt(i)).equals(" ")){
        ++sm1;}
      else if(Character.toString(m1.charAt(i)).equals("\n")){
        ++nlm1;}}
    double[][] mat1=new double[nlm1][(sm1/nlm1)+1];
    int osm1=0,c1=0,r1=0;
    for(int i=0;i<=m1.length()-1;++i){
      if(Character.toString(m1.charAt(i)).equals(" ")){
        mat1[c1][r1]=Double.parseDouble(m1.substring(osm1,i));
        osm1=i+1;
        ++r1;}
      else if(Character.toString(m1.charAt(i)).equals("\n")){
        mat1[c1][r1]=Double.parseDouble(m1.substring(osm1,i));
        osm1=i+1;
        ++c1;
        r1=0;}}
    return mat1;}
  }
