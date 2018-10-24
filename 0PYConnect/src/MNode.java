import java.awt.Color;
import java.awt.Graphics;

public class MNode extends Node{
	
	private MouseManager mM;
	
	public MNode(int ox, int oy, int r, int g, int b) {
		super(ox, oy, r, g, b);
		this.prime=false;
		this.mM=Plan.getMM();
	}
	@Override
	public void update() {
		x=mM.getMX();
		y=mM.getMY();
		checkCon(Plan.nodes);
		if(con.size()>=15)prime=true;
	}
	public void render(Graphics g) {
		if(con.size()>=15) {
			int clor0=color[0]+50;
			int clor1=color[1]+50;
			int clor2=color[2]+50;
			if(clor0>255)clor0=255;
			if(clor1>255)clor1=255;
			if(clor2>255)clor2=255;
			g.setColor(new Color(clor0,clor1,clor2));
			g.drawOval(x-3, y-3, 6, 6);
		}
		
		g.setColor(new Color(color[0],color[1],color[2]));
		g.fillRect(x-1, y-1, 2, 2);
	}
}
