import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Node {

	protected int x,y;
	protected ArrayList<Node> con;
	protected int[] color;
	protected boolean prime;
	
	public Node(int ox,int oy,int r,int g,int b) {
		this.x=ox;
		this.y=oy;
		this.color=new int[] {r,g,b};
		con=new ArrayList<Node>();
	}
	public abstract void update();
	
	public abstract void render(Graphics g);
	
	protected void checkCon(ArrayList<Node> ns) {
		for(Node n:ns) {
			if(n.equals(this) || ( color[0]==n.getColor()[0] && color[1]==n.getColor()[1] && color[2]==n.getColor()[2]))continue;
			
			if( x==n.getX() && y==n.getY() ) {
				boolean cancel=false;
				for(Node c:con) {
					if(c.equals(n))cancel=true;
					if(c.isPrime())n.prime=true;
					else if(n.isPrime())c.prime=true;
				}
				if(!cancel) {
					con.add(n);
					Plan.ripple(x, y);
				}
			}
		}
	}
	public boolean isPrime() {return prime;}
	public ArrayList<Node> getCon() {return con;}
	public int[] getColor() {return color;}
	public int getX() {return x;}
	public int getY() {return y;}
}
