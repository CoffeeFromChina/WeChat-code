package reflex;

import reflex.Employee;
import java.util.*;

public class ReflectionTest {

	public static void main(String[] args) {
		//利用Class类的方法来获取想得到的信息
		Employee em = new Employee("实验一号", 100000);
		Class cl = em.getClass();//getClass	返回Class对象，这个对象用来描述你现在所使用的对象的类信息
		String name = cl.getName();//getName	返回Class对象所代表的具体对象的名称
		
		Package mt = cl.getPackage();//获取对象的包名
		System.out.println(name);
		System.out.println(cl + " " +em.getName());
		System.out.println(mt + " " +em.getName());
		
		if(em.getClass() == Employee.class) {
			System.out.println("相等");
		}
		
		try {
			Object m = Class.forName("java.util.Random").newInstance();
			System.out.println(m);
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		System.out.println();
		
		//调用静态方法forName获取Class对象
		System.out.println("请输入一个类名");
		Scanner sc = new Scanner(System.in);
		String className = sc.nextLine();
		try {
			Class ca = Class.forName(className);
			System.out.println("对应的类名为" + ca);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
		Class l1 = Random.class;
		Class l2 = int.class;
		Class l3 = Double.class;
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
		
	}

}
