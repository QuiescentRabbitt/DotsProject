import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//@QuiescentRabbitt
//DotsProject 4/19/18

public class DotsPanel extends JPanel {

	private final int WIDTH = 300, HEIGHT = 200;
	private int radius = 1;
	
	private ArrayList<Point> pointList; 
	private ArrayList<Color> colorList;
	private int count;
	private int dotsAdded = 5000;
	private int countDots = -1;  
	private int colorsGenerated = 4000;
	private int radiusRandom = 0;
	private int lockedDots = 0;
	private int slowdownFactor = 50;
	public DotsPanel()
	{ 
		pointList = new ArrayList<Point>();
		colorList = new ArrayList<Color>();
		count = pointList.size();
		
		addMouseListener (new DotsListener());
		addMouseMotionListener (new DotsDeleter());

		
		
		setBackground (Color.black);
		setPreferredSize (new Dimension(WIDTH,HEIGHT));
		
		for (int i = 0; i < colorsGenerated; i++) {
		Random colorGenerator = new Random();
		int r = 0;
		int g = 0;
		int b = 0;
		
		r = colorGenerator.nextInt(255);
		g = colorGenerator.nextInt(255);
		b = colorGenerator.nextInt(255);
		
		colorList.add(new Color(r,g,b));
		
		}
	
	}
	
	public void paintComponent (Graphics page)  {
	
		super.paintComponent(page);
		
		for (Point drawPoint : pointList) {
			
			countDots+=1;
			count = pointList.size();
			
	
			
			Random radiusRandomer = new Random();
			int radiusRandom = 10;
			radiusRandom = radiusRandomer.nextInt(radius + 1);
			page.setColor(colorList.get((countDots / dotsAdded) % colorsGenerated));
			
			
			page.fillRect(drawPoint.x - radiusRandom, drawPoint.y - radiusRandom, radiusRandom * 2, radiusRandom * 2);	
		
			
		}
		page.drawString("Count: " + count, 5, 15);
		countDots = -1;
		
		
	}
	
	
	private class DotsListener implements MouseListener {
		
		public void mousePressed(MouseEvent event) {
			if (event.getButton() == event.BUTTON1) {
			Random generator = new Random();
			count+=dotsAdded;
			for (int i = 0; i < dotsAdded; i++) {
				pointList.add(new Point(generator.nextInt(1920), generator.nextInt(1080)));
				}	
			
			int tempLength = pointList.size();
			
			
			
			
			
			repaint();
			} else if (event.getButton() == event.BUTTON2) {
				radius+=1;
				repaint();
			} else if (event.getButton() == event.BUTTON3) {
				radius-=1;
				repaint();
			}
	
			
			
			
			
			
		}
		
		public void mouseClicked (MouseEvent event) {}
		public void mouseReleased (MouseEvent event) {
			lockedDots=count;
		}
		public void mouseEntered (MouseEvent event) {}
		public void mouseExited (MouseEvent event) {}

		
		
		
		
		
		
		
		
	}
	
	private class DotsDeleter implements MouseMotionListener {
		Random randomScatter = new Random();
		int randomMover;
		public void mouseDragged(MouseEvent e) {
			
			//pointList.add(e.getPoint());
			//count+=1;
			repaint();
			int tempLength = pointList.size();
			
			for (int i = 0 + lockedDots; i < tempLength; i++) { //Remove "lockeddots" in order to get rid of the freezing effect
				
			randomMover = randomScatter.nextInt(100) - 100;
			
			pointList.add(new Point((int)(pointList.get(i).getX() * slowdownFactor + e.getX() + randomMover) / (2+slowdownFactor - 1) , ((int)pointList.get(i).getY() * slowdownFactor + e.getY() + randomMover) / (2+slowdownFactor - 1)));
			pointList.remove(i+1);
				
			}
		
			
			
		}
		

	
		public void mouseMoved(MouseEvent e) {
			
		}
		
		
		
	
	}
	

	
	
	
	
	
	
}


