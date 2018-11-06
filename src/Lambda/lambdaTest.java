package Lambda;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.swing.JPanel;

public class lambdaTest {

	public static void main(String[] args) {
		lambdaTest x = new lambdaTest();
//		x.listTest();
//		x.RunnableTest();
//		x.mapTest();
//		x.GUITest();
//		x.sortTest();
	}

	//lambda表达式用得最多的场合就是替代匿名内部类
	//演示实现Runnable接口
	public void RunnableTest() {
		//如果不想匿名的话，可以加上引用
		
		//普通匿名类写法
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("这是内部匿名类的写法");
			}
		}).start();
		Runnable t1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("这是内部类的写法");
			}
			
		};
		t1.run();
		
		//lambda写法
		//用()->就可以代替整个匿名内部类	
		new Thread(() -> System.out.println("这是Lambda的写法")).start();
		
		Runnable t2 = new Thread(() -> System.out.println("这是带引用的Lambda的写法"));
		t2.run();
	}
	
	//演示实现迭代集合
	public void listTest() {
		String[] number = {"1","2","3","4","5","6","7","8","9"};
		List<String> array = Arrays.asList(number);
		//以前的for循环写法
		for(String a:array) {
			System.out.println("这是普通写法的第" + a + "个字符");
		}
		
		//lambda写法
		array.forEach((e)-> System.out.println("这是lambda写法的第" + e + "个"));
		
		//这个也是lambda写法，:: 代表应用方法
		array.forEach(System.out::println);
	}
	
	//演示实现map
	public void mapTest() {
		Double[] num = {1.0,2.0,3.0};
		List<Double> array = Arrays.asList(num);
		
		//先给集合的值加i*0.5,在打印
		
	 	//普通for循环写法
		int i = 1;
		for(double a: array) {
			a = a + i*0.5;
			System.out.println(a);
		}
		
		//lambda写法
		array.stream().map(x-> x+x*0.5).forEach((e)-> System.out.println(e));
	}
	
	//演示实现的是GUI界面的普通匿名内部类写法和lambda写法
	public void GUITest() {
		Frame f = new Frame();
		JPanel p = new JPanel();
		
		//b1按钮采用匿名内部类写法
		Button b1 = new Button("普通写法");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("这是普通的匿名内部类写法");
			}
		});
		//b2按钮采用lambda写法
		Button b2 = new Button("lambda写法");
		b2.addActionListener((ActionEvent e) -> System.out.println("这是lambda写法"));
		
		p.add(b1);
		p.add(b2);
		f.add(BorderLayout.CENTER, p);
		f.setVisible(true);
		f.setSize(200, 100);
	}

	//演示排序集合Arrays.sort()
	public void sortTest() {
		//这些数组内的内容全是随便打的
		//更具数组元素的长度排序
		String[] array = {"sadsad","hjg","etyew","vcbvcd",
							"dsadasffte","shgfhf","rtweeqwr","bvcbgfj","piuoiu",
								"hgtj","v","a",};
		//普通内部匿名类写法
		Arrays.sort(array,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		//遍历输出数组
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		//lambda写法
		Arrays.sort(array,(String o1,String o2) -> (o1.length() - o2.length()));
		List<String> a = Arrays.asList(array);
		a.forEach(e -> System.out.println(e));
	}

}
