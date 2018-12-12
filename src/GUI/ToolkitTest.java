package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ToolkitTest extends JFrame{

	public static void main(String[] args) {
		
		//获取当前屏幕的尺寸
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int width = d.width;
		int height = d.height;
		
		//创建演示用的框架对象和按钮对象
		JFrame f = new JFrame();
		JButton b = new JButton("我是按钮");
		
		//设置框架大小
		f.setSize(width, height);
		//设置框架标题
		f.setTitle("我是标题");
		//向框架中添加按钮
		f.add(b);
		//设置框架大小不可改变
		f.setResizable(false);
		//设置在关闭窗口时结束程序
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//显示窗口
		f.setVisible(true);
		
		
	}

}
