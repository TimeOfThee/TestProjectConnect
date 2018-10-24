import java.awt.Color;
import java.awt.Graphics;

public class SNode extends Node{

	public SNode(int ox, int oy, int r, int g, int b) {
		super(ox, oy, r, g, b);
		this.prime=true;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(new Color(color[0],color[1],color[2]).darker().darker());
		g.drawOval(x-3, y-3, 6, 6);
		g.setColor(new Color(color[0],color[1],color[2]));
		g.fillRect(x-1, y-1, 2, 2);
	}

}
