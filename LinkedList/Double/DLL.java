package Double;


public class DLL {
    private DLLNode first;
    private DLLNode last;
    private int dir= 1;
    private int total=0;
    private DLLNode current= null;
    private int noChange= 1;
    private int num_player;

    public DLL()
    {
        this.first= null;
        this.last= null;
    }

    public void setNum_player(int n)
    {
        num_player= n;
    }

    public int getNum_player()
    {
        return num_player;
    }

    public void reverseDirection(int t)
    {
        current= showCurrent(t);
        if(dir==1)
            dir=0;
        else
            dir=1;
    }
    public void insertNew(int t1, int t2, int player_no)
    {
        num_player++;
        DLLNode current2= showCurrent(t1);
        DLLNode newNode= new DLLNode(t2, player_no,null, null);
        if(dir==1)
        {
            newNode.prev= current2.prev;
            newNode.next= current2;
            current2.prev.next= newNode;
            current2.prev= newNode;
        }
        else
        {
            newNode.prev= current2;
            newNode.next= current2.next;
            current2.next.prev= newNode;
            current2.next= newNode;
        }
    }

    public void insertAtLast(DLLNode newNode)
    {
        if(first==null)
        {
            first= newNode;
            last= newNode;
            first.next= first;
            first.prev= first;


        }
        else
        {
            last.next= newNode;
            newNode.prev= last;
            newNode.next= first;
            first.prev= newNode;
            last= newNode;

        }

    }
    public void printFirstToLast()
    {
        DLLNode current2;
        if(current==null)
            current2= first;
        else
            current2= current;

        if(dir==1)
        {
            for(int i=0; i<num_player; i++)
            {
                System.out.print(current2.player);
                if(i< num_player-1)
                    System.out.print(", ");
                current2= current2.next;
            }
        }
        else
        {
            for(int i=0; i<num_player; i++)
            {
                System.out.print(current2.player);
                if(i< num_player-1)
                    System.out.print(", ");
                current2= current2.prev;
            }
        }
        System.out.println();

    }

    public DLLNode showCurrent( int t)
    {
        if(current==null)
            current= first;
        if(total==0)
            total= current.time;
        if (dir==1)
        {
            if(t<total)
                return current;
            else
            {
                while (t>total)
                {
                    if(noChange==0)
                    {
                        total= total+ current.time;
                        noChange= 1;
                    }
                    else
                    {
                        current= current.next;
                        total= total+ current.time;
                    }


                }
                return current;
            }
        }
        else
        {
            if(t<total)
                return current;
            else
            {
                while (t>total)
                {
                    if(noChange==0)
                    {
                        total= total+ current.time;
                        noChange= 1;
                    }
                    else
                    {
                        current= current.prev;
                        total= total+ current.time;
                    }
                }
                return current;
            }
        }



    }
    public DLLNode remove(int t)
    {
        DLLNode current1= showCurrent(t);
        if(dir==1)
            current= current1.next;
        else
            current= current1.prev;
        total= t;
        noChange= 0;
        current1.prev.next= current1.next;
        current1.next.prev= current1.prev;
        num_player--;
        return current1;
    }

}
