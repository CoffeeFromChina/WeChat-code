package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * 此程序的实现思路是用一个类继承 Component 类，
 * 并重载 paintComponent 实现组件的绘制；
 * 重载 getPreferredSize 返回框架的大小；
 * 再用主类加载程序。
 * 这样用其余类继承功能类，再将该对象加入到主类种的思路，
 * 可以实现多个不同的类的功能。
 * @author DXC
 *
 */

//此类负责加载程序
public class JComponentTest{
	
	public JComponentTest() {
		//创建一个 JFrame 对象
		JFrame frame = new JFrame();
		
		//将实现了 JComponent 类的对象加入到框架种
		frame.add(new TxtComponent());
		
		//显示框架的首选大小
		frame.pack();
		
		//设置框架的标题
		frame.setTitle("在框架种显示文字信息");
		
		//设置关闭框架窗口时关闭程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//设置框架可以显示
		frame.setVisible(true);
	}
	
	//加载程序的入口
	public static void main(String[] args) {
		JComponentTest j = new JComponentTest();
	}

}

class TxtComponent extends JComponent{

	//使用上一节介绍的  Toolkit 类来等获得显示器大小
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension dm = tk.getScreenSize();
	
	//文字信息的显示位置
	int Twidth = dm.width/10;
	int Theight = dm.height/12;
	
	//框架的大小
	int Fwidth = dm.width/4;
	int Fheight = dm.height/6;
	
	String txt = "hello word";

	//txt 就是我们想显示在组将种的薪资，另外两个参数是该信息的放置的位置
	public void paintComponent(Graphics g) {
		g.drawString(txt, Twidth, Theight);
	}
	
	//获得优先尺寸
	//返回的是框架的大小
	public Dimension getPreferredSize() {
		return new Dimension(Fwidth, Fheight);
	}
}