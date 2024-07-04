import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution{
    public static void main(String[] args){
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
            for(int i=0;i<t;i++){
                int n=Integer.parseInt(br.readLine());
                List<pair> list=new ArrayList<>();
                for(int j=0;j<n;j++){
                    String[] ss=br.readLine().split(" ");
                    int a=Integer.parseInt(ss[0]);
                    int b=Integer.parseInt(ss[1]);
                    list.add(new pair(a,b,j));
                }
                Collections.sort(list, new Comparator<pair>() {
                    @Override
                    public int compare(pair p1, pair p2) {
                        if(p1.a>p2.a){
                            return 1;
                        }else if(p1.a<p2.a){
                            return -1;
                        }else{
                            return p1.b-p2.b;
                        }
                    }
                });
                int j=1;
                int b=list.get(0).b;

                HashSet<Integer> cam=new HashSet<>();
                cam.add(list.get(0).c);
                while(j<list.size()){
                    if(list.get(j).a>=b){
                        b=list.get(j).b;
                        cam.add(list.get(j).c);

                    }
                    j++;
                }
                j=0;
                b=0;
                boolean flag=false;
                while(j<list.size()){
                    if(!cam.contains(list.get(j).c)){
                        if(list.get(j).a>=b){
                            b=list.get(j).b;

                        }else{
                            System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
                            flag=true;
                            break;
                        }
                    }
                    j++;
                }
                StringBuilder ans=new StringBuilder("");
                if(!flag){
                    for(int k=0;k<n;k++){
                        if(cam.contains(k)){
                            ans.append("C");
                        }else{
                            ans.append("J");
                        }
                    }
                    System.out.println("Case #"+(i+1)+": "+ans);
                }
            }
        }catch(Exception e){
            System.out.println("kkkk "+e.getMessage());
        }
    }
    static class pair{
        int a,b,c;
        public pair(int a,int b,int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }
}
