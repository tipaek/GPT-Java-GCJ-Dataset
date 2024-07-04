import java.util.*;

class myTask
{
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        String tokens[] = scanner.nextLine().split(" ");
        int testcase = Integer.parseInt(tokens[0]);
        List<Unit> list = new ArrayList<Unit>();
        int i=0; int j=0; int k=0;
        for( i=1; i<=testcase; i++)
        {

            tokens = scanner.nextLine().split(" ");
            /* allocate # of Units */
            int units =  Integer.parseInt(tokens[0]);
            Unit u = new Unit();


            for (j=1; j<=units; j++)
            {
                tokens = scanner.nextLine().split(" ");
                cell c = new cell(); 
                c.timestart=Integer.parseInt(tokens[0]); 
                c.timeend=Integer.parseInt(tokens[1]);

                
                u.list.add(c);
            }
            
            u.id=i;
            list.add(u);

        }

        for (i=1; i<=testcase; i++)
        {
            Unit u = list.get(i-1);
            u.list.get(0).id=0;

            for(j=0; j<u.list.size();j++) u.list.get(j).id=0;

            for (j=0; j<u.list.size();j++)

            {
                

                for(k=j+1; k<u.list.size();k++)
                {

                    if (u.list.get(j).goodTime( u.list.get(k) )) 
                       {u.list.get(k).id =(++u.list.get(j).id)%2; }
                    else {u.list.get(k).id = u.list.get(j).id=0;}

                }
                
            }

        }

        for(i=0; i<testcase; i++)
        {
            System.out.print("\nCase #"+(1+i)+":");
            Unit u = list.get(i);
            for (j=0; j<u.list.size();j++)
            { 
                System.out.print(" "+u.list.get(j).id);
            
            }

        }

    }
}
class cell
{   int id;
    int timestart;
    int timeend;

    boolean goodTime( cell b) {
        if (( this.timestart > b.timestart) && (this.timestart< b.timeend))
            return false;
        if (( b.timestart > this.timestart) && (b.timestart<this.timeend))
            return false;

        return true;
    }
 
}
class Unit
{   int id;
    List<cell> list;
    public Unit () {
        list = new ArrayList<cell>();
    }
}
