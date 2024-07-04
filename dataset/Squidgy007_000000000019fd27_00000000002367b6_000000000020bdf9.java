import java.util.*;
public class Solution {
    public static class Pairss{
        int a,b, index;
        String string;
        Pairss(int a, int b, int index){
            this.a=a;
            this.b=b;
            this.string="";
            this.index=index;
        }
    }
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int T=scn.nextInt();
        for(int t=1;t<=T;t++){
            int N=scn.nextInt();
            int a,b;
            String outPutString="";
            List<Pairss> list=new ArrayList<>();
            for(int i=0;i<N;i++){
                a=scn.nextInt();
                b=scn.nextInt();
                list.add(new Pairss(a, b, i));
            }
            Collections.sort(list, new Comparator<Pairss>() {
                @Override
                public int compare(Pairss obj1, Pairss obj2) {
                    return obj1.a-obj2.a;
                }
            });

            int J_end=0, C_end=0;
            int impossibleFlag=0;
            int start=0;
            for(int i=0;i<N;i++){
                start=list.get(i).a;
                if(start<C_end&&start<J_end){
                    impossibleFlag=1;
                    break;
                }
                else{
                    if(start<C_end){
                        list.get(i).string="J";
                        J_end=list.get(i).b;
                    }
                    else{
                        list.get(i).string="C";
                        C_end=list.get(i).b;
                    }
                }
            }
            if(impossibleFlag==1){
                System.out.println("Case #" + t +": "+ "IMPOSSIBLE");
            }
            else{
                Collections.sort(list, new Comparator<Pairss>() {
                    @Override
                    public int compare(Pairss obj1, Pairss obj2) {
                        return obj1.index-obj2.index;
                    }
                });

                Iterator<Pairss> iterator=list.iterator();
                while (iterator.hasNext()){
                    outPutString=outPutString+iterator.next().string;
                }
                System.out.println("Case #" + t +": "+ outPutString);
            }

        }
    }
}