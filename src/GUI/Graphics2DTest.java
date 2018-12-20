package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Graphics2DTest {

	public static void main(String[] args) {
		//创建一个 JFrame 对象
		JFrame frame = new JFrame();
		
		//将实现了 JComponent 类的对象加入到框架种
		frame.add(new Component2D());
		
		//显示框架的首选大小
		frame.pack();
		
		//设置框架的标题
		frame.setTitle("绘制 2D 图形");
		
		//设置关闭框架窗口时关闭程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//设置框架可以显示
		frame.setVisible(true);
	}

}

class Component2D extends JComponent{
	
	//设置默认的宽高
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HRIGHT = 400;
	
	//将绘制各个图形的方法加入到此绘制图形的方法中，以此绘制图形。
	public void paintComponent(Graphics g) {
		Component2D w = new Component2D();
		w.paintRectangle((Graphics2D) g);
		w.paintLine((Graphics2D) g);
		w.paintEllipse((Graphics2D) g);
		w.paintCircle((Graphics2D) g);
	}
	
	//坐标(左上角)和宽高
	double leftX = 100;
	double topY = 100;
	double width = 200;
	double height = 150;
	
	//绘制矩形
	public void paintRectangle(Graphics2D g2) {
		//创建矩形对象，并设定其左上角坐标和宽高
		Rectangle2D r2 = new Rectangle2D.Double(leftX, topY, width, height);
		g2.draw(r2);
	}
	
	//绘制线条
	public void paintLine(Graphics2D g2) {
		Line2D line1 = new Line2D.Double(leftX, topY, leftX+width, topY+height );
		Line2D line2 = new Line2D.Double(leftX, topY+height, leftX+width, topY);
		g2.draw(line1);
		g2.draw(line2);
	}
	
	//绘制椭圆
	public void paintEllipse(Graphics2D g2) {
		//绘制椭圆时可以传参数，也可以传入一个矩形对象
		Ellipse2D ell = new Ellipse2D.Double(leftX, topY, width, height);
		g2.draw(ell);
	}
	
	//绘制圆形
	public void paintCircle(Graphics2D g2) {
		
		//圆和椭圆是一样的。就像长方形和正方形都是矩形一样。
		Ellipse2D circle = new Ellipse2D.Double();
		//得到一个圆形内部的矩形对象，并以此矩形对象获得圆心坐标并绘制圆形。
		//这个矩形对象的参数和前面绘制的矩形对象的参数是一样的
		Rectangle2D r3 = new Rectangle2D.Double(leftX, topY, width, height);
		double centx = r3.getCenterX();
		double centy = r3.getCenterY();
		double raidus = 150.0;
		
		circle.setFrameFromCenter(centx, centy, centx+raidus, centy+raidus);
		g2.draw(circle);
	}
	
	//返回的是框架的大小
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HRIGHT);
	}
}
