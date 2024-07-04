import java.io.*;
import java.util.*;

class Solution {

    public static void main(String... args){

      Scanner in = new Scanner(System.in);
      int T = in.nextInt();
      for(int t=1;t<=T;t++){



        int u = in.nextInt();
        double matrix[][] = new double[26][10];

        for(int i=0;i<10000;i++){

          String q = in.next();//89
          String r = in.next();//ST
          //System.out.println("q:"+q+" r:"+r);
          if(q.charAt(0)=='-'){
            continue;
          }else{
            
            if(r.length()==1){

              for(int x=1;x<10;x++){
                matrix[r.charAt(0)-'A'][x]+=0.0001;
              }
              continue;
            }

            if(r.length()<q.length()){
              
              for(int x=1;x<10;x++){
                matrix[r.charAt(0)-'A'][x]+=0.0001;
              }

              for(int index=1;index<r.length();index++){
                  for(int x=0;x<10;x++){
                    matrix[r.charAt(index)-'A'][x]+=0.0001;
                  } 
              }
              continue;
              
            }

            //q.length() == r.length() // q:89 r:ST

            //for first index
            for(int x=1;x<=Integer.parseInt(String.valueOf(q.charAt(0)));x++){
               matrix[r.charAt(0)-'A'][x]+=0.0001;
            }

            for(int index=1;index<q.length();index++){
              
              int start = 0;
              int end = Integer.parseInt(String.valueOf(q.charAt(index)));
              for(int x=start;x<=end;x++){
                matrix[r.charAt(index)-'A'][x]+=0.0001;
              }



            }


          }

        }

        char ans[] = new char[10];   

        ArrayList<Node> temp = new ArrayList<>();
        for(int i=0;i<26;i++){
          //System.out.print(((char)('A'+i))+" ");
          for(int j=0;j<10;j++){
            //System.out.print(matrix[i][j]+ " ");
            if(matrix[i][j]>0)
              temp.add(new Node(((char)('A'+i)),matrix[i][j], j));
          }
          //System.out.println();
        }

        Collections.sort(temp);

        HashSet<Character> chars = new HashSet<>();
        HashSet<Integer> poss = new HashSet<>();
        int count=0;
        for(int i=0;i<temp.size();i++){
          Node uu = temp.get(i);
          
          if(!chars.contains(uu.x) && !poss.contains(uu.pos)){
            ans[uu.pos]=uu.x;
            chars.add(uu.x);
            count++;
            if(count==10){
              break;
            }
            poss.add(uu.pos);
          }
        }

        String newans = new String(ans);
        System.out.println("Case #"+t+": " + newans);




      }



    }

    static class Node implements Comparable<Node>{
      char x;
      double f;
      int pos;
      public Node(char x, double f, int pos){
        this.x=x;
        this.f=f;
        this.pos=pos;
      }
      public int compareTo(Node o){
        
        if((o.f-this.f)<0.0d){
          return -1;
        }else if((o.f-this.f)>0.0d){
          return 1;
        }else{
          return 0;
        }
      }
    }

}