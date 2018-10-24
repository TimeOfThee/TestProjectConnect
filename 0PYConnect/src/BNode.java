import java.awt.Color;
import java.awt.Graphics;

public class BNode extends Node{
	public BNode(int ox, int oy, int r, int g, int b) {
		super(ox, oy, r, g, b);
		this.prime=false;
	}
	@Override
	public void update() {
		int mx,my;
		int dir=(int)(Math.random()*5)-2;
		if(dir>1)x+=1;
		else if(dir<-1)x-=1;
		dir=(int)(Math.random()*5)-2;
		if(dir>1)y+=1;
		else if(dir<-1)y-=1;
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
