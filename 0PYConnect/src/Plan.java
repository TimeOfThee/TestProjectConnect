import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class Plan {
	
	private KeyManager kM;
	private static MouseManager mM;
	public static ArrayList<Node> nodes;
	public static ArrayList<int[]> ripl;
	
	boolean hidden=false,tog;
	
	//put variables here
	
	public Plan(KeyManager km,MouseManager mm) {
		this.kM=km;
		this.mM=mm;
		
		ripl=new ArrayList<int[]>();
		nodes=new ArrayList<Node>();
		int ox=(int)(Math.random()*400)+200;
		int oy=(int)(Math.random()*300)+100;
		for(int a=0;a<50;a++)nodes.add(new BNode(ox,oy,200,50,0));
		ox=(int)(Math.random()*400)+200;
		oy=(int)(Math.random()*300)+100;
		for(int a=0;a<50;a++)nodes.add(new BNode(ox,oy,0,200,50));
		ox=(int)(Math.random()*400)+200;
		oy=(int)(Math.random()*300)+100;
		for(int a=0;a<50;a++)nodes.add(new BNode(ox,oy,0,50,200));
		ox=(int)(Math.random()*400)+200;
		oy=(int)(Math.random()*300)+100;
		for(int a=0;a<50;a++)nodes.add(new BNode(ox,oy,100,0,150));
		
		nodes.add(new MNode(0,0,254,255,255));
		
		for(int a=0;a<2;a++) {
			for(int b=0;b<2;b++) {
				nodes.add(new SNode(300+(a*200),200+(b*200),255,255,255));
			}
		}
	}
	
	public void update() {
		if(kM.kSP) {
			if(tog) {
				hidden=!hidden;
				tog=false;
			}
		}else tog=true;
		
		for(Node n:nodes) {
			n.update();
		}
	}
	public void render(Graphics g) {
		for(Node c:nodes) {
			for(Node n:c.getCon()) {
				if(n.isPrime()) {
					g.setColor(new Color( (c.getColor()[0]+c.getColor()[0]+n.getColor()[0])/3,(c.getColor()[1]+c.getColor()[1]+n.getColor()[1])/3,(c.getColor()[2]+c.getColor()[2]+n.getColor()[2])/3 ));
				}else g.setColor(new Color( (c.getColor()[0]+n.getColor()[0])/2,(c.getColor()[1]+n.getColor()[1])/2,(c.getColor()[2]+n.getColor()[2])/2 ).darker());
				g.drawLine(c.getX(), c.getY(), n.getX(), n.getY());
			}
		}
		if(!hidden)
			for(Node n:nodes) {
				n.render(g);
			}
		Iterator<int[]> it=ripl.iterator();
		while(it.hasNext()) {
			int[] r=it.next();
			if(r[3]>0) {
				g.setColor(new Color(180,180,180,r[3]));
				g.fillOval(r[0]-r[2], r[1]-r[2], r[2]*2, r[2]*2);
				r[2]++;
				r[3]-=30;
			}else it.remove();
		}
	}
	public static void ripple(int x,int y) {
		ripl.add(new int[] {x,y,2,180});
	}
	public static MouseManager getMM() {return mM;}
}
