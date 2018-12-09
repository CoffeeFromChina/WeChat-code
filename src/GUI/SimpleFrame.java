package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleFrame extends JFrame{

	public static void main(String[] args) {
		//创建演示用的框架对象和按钮对象
		JFrame f = new JFrame();
		JButton b = new JButton("我是按钮");
		
		//设置框架大小
		f.setSize(300, 200);
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
