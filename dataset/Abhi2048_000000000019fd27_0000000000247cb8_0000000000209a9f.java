import java.util.*;
 class Solution{
    public static  void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=t;i++){
            char ch[]=sc.next().toCharArray();

            LinkedList<Character> l=new LinkedList<>();
            int c=0;
            for(int j=0;j<ch.length;j++){
                int curr=(ch[j]-'0');

                if(curr>c){
                    while(curr!=c)
                    {
                        l.add('(');
                        c++;
                    }

                }else if(curr<c){
                    while(curr!=c){
                        l.add(')');
                        c--;
                    }

                }
                c=curr;
                l.add(ch[j]);
            }
            if(c!=0){
                while(c!=0){
                    l.add(')');
                    c--;
                }
            }

            int n=l.size();
            sb.append("Case #");
            sb.append(i+": ");

            for(int j=0;j<n;j++){
                sb.append(l.get((j)));
            }

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}