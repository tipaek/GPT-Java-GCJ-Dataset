import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int k=1;k<=tc;k++){
//            System.out.println("Case"+k);
            String res = "";
            int ptrn = sc.nextInt();
            List<String> ptrns = new ArrayList<>();
            for(int i=0;i<=ptrn;i++){
                ptrns.add(sc.nextLine());
            }
            System.out.println(ptrns);
            List<String> c1 = new ArrayList<>();
            List<String> c2 = new ArrayList<>();
            List<String> c3 = new ArrayList<>();


            String c_res_s = "";
            String c_res_f = "";
            for(String i:ptrns){
                if(i.length()>0){
                    System.out.println(i);
                    if(!(i.charAt(2)=='*')){
                        System.out.println("--"+i);
                        if(c_res_s.length()==0){
                            c_res_s = c_res_s+i.charAt(2);
                        }
                        else{
                            res="*";
                            break;
                        }
                    }

                    if(!(i.charAt(i.length()-1)=='*')){
                        System.out.println("--"+i);
                        if(c_res_f.length()==0){
                            c_res_f = c_res_f+i.charAt(i.length()-1);
                        }
                        else{
                            res="*";
                            break;
                        }
                    }

                }

            }



            if(res.length()==0){
                if(c_res_s.length()==0 && c_res_f.length()==0){
                    for(String j:ptrns){
                        for(int h=2;h<j.length();h++){
                            if(!(j.charAt(h)=='*')){
                                res=res+j.charAt(h);
                            }
                        }
                    }
//                res = c_res;
                }

                else{
                    res=res+c_res_s;
                    for(String j:ptrns){
                        for(int h=2;h<j.length();h++){
                            if(!(j.charAt(h)=='*')){
                                res=res+j.charAt(h);
                            }
                        }
                    }
                    res=res+c_res_f;
                }
                for(String i:ptrns){
                    if(i.length()>0){
                        //String[] comp = i.split("\\*",3);
                        List<String> comp = new ArrayList<>();
                        String c = "";
                        for(int l=0;l<i.length();l++){
                            if(!(i.charAt(l)=='*')){
                                c=c+i.charAt(l);
                            }
                            else{
                                comp.add(c);
                                c="";
                            }
                        }
                        if(c.length()!=0){
                            comp.add(c);
                        }
                        System.out.println(comp);
                        if(comp.size()==1){
                            c1.add(comp.get(0));
                        }
                        else if(comp.size()==2){
                            c1.add(comp.get(0));
                            c2.add(comp.get(1));
                        }
                        else if(comp.size()==3){
                            c1.add(comp.get(0));
                            c2.add(comp.get(1));
                            c3.add(comp.get(2));
                        }
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
            }



            System.out.println("Case #"+k+": "+res);
        }
    }
}