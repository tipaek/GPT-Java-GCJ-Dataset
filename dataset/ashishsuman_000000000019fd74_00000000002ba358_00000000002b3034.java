import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int k=1;k<=tc;k++){
            // System.out.println("Case"+k);
            String res = "";
            int ptrn = sc.nextInt();
            List<String> ptrns = new ArrayList<>();
            for(int i=0;i<=ptrn;i++){
                ptrns.add(sc.nextLine());
            }
            // System.out.println(ptrns);
            List<String> c1 = new ArrayList<>();
            List<String> c2 = new ArrayList<>();
            List<String> c3 = new ArrayList<>();

            for(String i:ptrns){
                String[] comp = i.split("\\*",3);
                if(comp.length==1){
                    c1.add(comp[0]);
                }
                else if(comp.length==2){
                    c1.add(comp[0]);
                    c2.add(comp[1]);
                }
                else if(comp.length==3){
                    c1.add(comp[0]);
                    c2.add(comp[1]);
                    c3.add(comp[2]);
                }
            }
            String curr1=" ";
            String curr2=" ";
            String curr3=" ";
            for(String i:c1){
                if(i.length()>curr1.length()){
                    curr1=i;
                }
            }
            for(String j:c1){
                if(!curr1.contains(j)){
                    res = "*";
                }
            }
            if(c2.size()>0 && res.length()==0){
                for(String i:c2){
                    if(i.length()>curr2.length()){
                        curr2=i;
                    }
                }
                for(String j:c2){
                    if(!curr2.contains(j)){
                        res = "*";
                    }
                }
            }
            if(c3.size()>0 && res.length()==0){
                for(String i:c3){
                    if(i.length()>curr3.length()){
                        curr3=i;
                    }
                }
                for(String j:c3){
                    if(!curr3.contains(j)){
                        res = "*";
                    }
                }
            }
            if(res.length()==0){
                res =  curr1+curr2+curr3;
            }

            System.out.println("Case #"+k+": "+res);
        }
    }
}