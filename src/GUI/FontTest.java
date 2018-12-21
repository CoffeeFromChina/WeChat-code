package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class FontTest {

	public static void main(String[] args) {
		//创建一个 JFrame 对象
		JFrame frame = new JFrame();
		
		//将实现了 JComponent 类的对象加入到框架种
		frame.add(new FontComponent());
		
		//显示框架的首选大小
		frame.pack();
		
		//设置框架的标题
		frame.setTitle("在框架种显示文字信息");
		
		//设置关闭框架窗口时关闭程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//设置框架可以显示
		frame.setVisible(true);
		
	}
}
class FontComponent extends JComponent{
	
	//框架的默认尺寸
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HRIGHT = 200;
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		String message = "hello word";
		
		Font font = new Font("Serif", Font.BOLD, 36);
		g2.setFont(font);
		//测量字符串的的尺寸
		
		//获得设备字体属性的描述对象
		FontRenderContext context = g2.getFontRenderContext();
		//获得字符串的边框对象，即字符串的这个字符串的长宽、上坡度、下坡度等信息
		//也就是用字符串的信息，获得一个矩形对象
		Rectangle2D bounds = font.getStringBounds(message, context);
		
		//获取字符串位于框架中间时左上角的坐标.
		//所以需要获得框架的长宽，在减去字符串的长宽，再除 2
		double x = (getWidth() - bounds.getWidth()) / 2;
		double y = (getHeight() - bounds.getHeight()) / 2;
		
		//获取矩形左下角的 y 坐标，再用加 y,获取字符串的基线坐标
		double ascent = -bounds.getY();
		//字符串基线的纵坐标
		double baseY = y + ascent;
		
		//输出字符串
		
		//设置要输出的字符串的位置和字符串对象
		g2.drawString(message, (int)x, (int)baseY);
		//设置颜色
		g2.setPaint(Color.LIGHT_GRAY);
		
		//绘制基线
		g2.draw(new Line2D.Double(x, baseY, x+bounds.getWidth(), baseY));
		
		//绘制包围字符串的矩形
		Rectangle2D rect = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
		g2.draw(rect);
	}
	
	//设置框架的尺寸
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HRIGHT);
	}
	
}