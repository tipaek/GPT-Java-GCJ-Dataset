import java.util.Scanner;
import java.util.*;
class Tree{
    int x;
    int y;
    int path;
    int[][] child; 
    Tree parent;
    public Tree(int x,int y, Tree parent, int path){
        this.x = x;
        this.y = y;
        this.child = new int[2][4];
        this.parent=parent;
        this.path = path;
    }
}
class Solution{
    static int jump=0;
    static int[] value = new int[31];
    static List<Tree> list = new ArrayList<>();
    static int[] size = new int[3];
    static int index = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        value[0] = 1;
        for(int i=1;i<31;i++){
            value[i] = value[i-1]*2;
        }
        
        
        int[][] testcases = new int[testcase][2];
        
        for(int test=0;test<testcase;test++){
            testcases[test][0]= sc.nextInt();
            testcases[test][1]= sc.nextInt();
            if(mod(testcases[test][0])>size[index] || 
                mod(testcases[test][1])>size[index])
                    index++;
        }
        
        
        list.add(new Tree(size[index],size[index],null,-1));
        Iterator<Tree> itr = list.iterator();
        while(itr.hasNext()){
            Tree t = itr.next();
            populate(t);
        }
        
        
        for(int test=1;test<=testcase;test++){
            int X = testcases[test-1][0] + size[index];
            int Y = testcases[test-1][1] + size[index];
            
            Iterator<Tree> iterator = list.iterator();
            String result = "";
            while(iterator.hasNext()){
                Tree t = iterator.next();
                if(t.x==X && t.y==Y){
                    Tree tree = t.parent;
                    int path = t.path;
                    while(tree.path!=-1){
                        result += getPath(path);
                        path = tree.path;
                        tree = tree.parent;
                    }
                }
            }
            if(result.equals("")){
                System.out.println("Case #" + test + ": " + "IMPOSSIBLE");
            }else{
                StringBuilder b = new StringBuilder(result);
                System.out.println("Case #" + test + ": " + b.reverse());
            }
        }
    }
    public static char getPath(int c){
        if(c==0)
            return 'N';
        if(c==1)
            return 'E';
        if(c==2)
            return 'S';
        if(c==3)
            return 'W';
    }
    
    public static Tree populate(Tree t){
        if(value[jump]<(2*size[index])+1){
            if(feasible(t.y+value[jump])){
                t.child[0][0] = t.x;
                t.child[0][1] = t.y + value[jump];
                list.add(new Tree(t.child[0][0] , t.child[0][1], t, 0));
            }else{
                t.child[0][0] = -1;
                t.child[0][1] = -1;
            }
            if(feasible(t.x+value[jump])){
                t.child[1][0] = t.x + value[jump];
                t.child[1][1] = t.y;
                list.add(new Tree(t.child[1][0] , t.child[1][1], t, 1));
            }
            else{
                t.child[1][0] = -1;
                t.child[1][1] = -1;
            }
            if(feasible(t.y-value[jump])){
                t.child[2][0] = t.x;
                t.child[2][1] = t.y - value[jump];
                list.add(new Tree(t.child[2][0] , t.child[2][1], t, 2));
            }else{
                t.child[2][0] = -1;
                t.child[2][1] = -1;
            }
            if(feasible(t.x+value[jump])){
                t.child[3][0] = t.x - value[jump];
                t.child[3][1] = t.y;
                list.add(new Tree(t.child[3][0] , t.child[3][1], t, 3));
            }else{
                t.child[3][0] = -1;
                t.child[3][1] = -1;
            }
            jump++;
        }
        return t;
    }
    
    public static int mod(int n){
        return n>0?n:-n;
    } 
    public static boolean feasible(int n){
        if(n>=0 && n<(2*size[index])+1)
            return true;
        return false;
    }
}