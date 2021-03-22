package Double;

public class DLLNode {
    protected int time;
    protected int player;
    protected DLLNode prev, next;

    DLLNode(int time,int player,  DLLNode prev, DLLNode next)
    {
        this.time= time;
        this.player= player;
        this.prev= prev;
        this.next= next;
    }
    public int getPlayer()
    {
        return player;
    }

}
