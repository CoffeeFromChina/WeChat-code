package reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		String name;
		if(args.length > 0) name = args[0]; 
		else {
			//控制栏输入类名
//			Scanner sc = new Scanner(System.in);
//			System.out.println("请输入类名(e.g.java.util.Date)");
//			name = sc.next();
			
			//指定特定的类名
			name = "reflex.Employee";
		}
		
		Class cl;
		try {
			cl = Class.forName(name);
			Class supercl = cl.getSuperclass();
			String modifiers = Modifier.toString(cl.getModifiers());//修饰符
			if(modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print("class " + name);//打印类名
			if(supercl != null && supercl != Object.class) System.out.print(" extends "
					+ supercl.getName());//打印超类名
			System.out.println("{\n");
			printConstructors(cl);//打印构造函数
			System.out.println();
			printMethods(cl);//打印方法
			System.out.println();
			printFields(cl);//打印域
			System.out.println("}");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public static void printConstructors(Class cl) {
		Constructor[] constructor = cl.getDeclaredConstructors();
		
		for(Constructor c:constructor) {
			String name = c.getName();//获取构造函数名称
			System.out.print(" ");
			String modifiers = Modifier.toString(c.getModifiers( ));//获取构造函数修饰符
			if(modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print(name + "(");//打印构造函数名
			
			Class[] paramTypes = c.getParameterTypes();//获取参数类型
			for(int j = 0; j < paramTypes.length; j++) {
				if(j > 0) System.out.print(",");//如果有多分参数，用逗号分开
				System.out.print(paramTypes[j].getName() + " "+j);//打印参数名
			}
			System.out.println(")");//方法名打印完成
		}
	}

	public static void printMethods(Class cl) {
		Method[] methods = cl.getDeclaredMethods();
		
		for(Method m:methods) {
			Class retType = m.getReturnType();//获取返回类型
			String name = m.getName();//获取方法
			
			System.out.print(" ");
			String modifiers = Modifier.toString(m.getModifiers());//获取状态修饰符
			if(modifiers.length() > 0) System.out.print(modifiers + " ");//打印状态修饰符
			System.out.print(retType.getName() + " " + name + "(");
			Class[] paramTypes = m.getParameterTypes();//获取方法参数
			for(int j = 0; j < paramTypes.length; j++) {
				System.out.print(paramTypes[j].getName() + " " + j);//打印参数
			}
			System.out.println(")");//方法结束
		}
		
	}

	public static void printFields(Class cl) {
		Field[] fields = cl.getDeclaredFields();
		for(Field f:fields) {
			Class type = f.getType();//获取域
			String name = f.getName();//获取域名
			System.out.print(" ");
			String modifiers = Modifier.toString(f.getModifiers());//获取域的类型
			if(modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.println(type.getName() + " " + name + ";");
		}
		
	}
}
