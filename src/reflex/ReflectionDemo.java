package reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectionDemo {
	public static void main(String[] args) {
		String name;
		if(args.length > 0) name = args[0]; 
		else {
			try(Scanner sc = new Scanner(System.in);) {
				System.out.println("Enter class name (e.g. java.util.Collection):");
				name = sc.nextLine();
			}
		}
		
		try {
			Class cl = Class.forName(name);
			
			//打印类的修饰符和类型，并判断是否有超类，如果有，就打印超类类名
			printModifiernameAndClassnameAndSupclassname(cl, name);
			
			//判断有没有接口，如果有，则打印出来;并打印“{”
			printInterFaces(cl);
			
			//打印构造函数
			printConstructedFunction(cl); 
			
			/**
			 * 打印方法。此方法可能会打印出native关键之的方法，
			 * 这些方法是java调用的非java代码的接口，也就是说这些方法不是java的API。
			 */
			printMethod(cl);
			
			//打印字段
			printFields(cl);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	//打印类的修饰符和类型，并判断是否有超类，如果有，就打印超类类名
	public static void printModifiernameAndClassnameAndSupclassname(Class cl, String className) {
		String modifier = Modifier.toString(cl.getModifiers());//打印类的修饰符
		Class supCl = cl.getSuperclass();
		if(modifier.length() > 0) System.out.print(modifier + " ");
		System.out.print("class " + className);
		if(supCl != null && supCl != Object.class) {
			System.out.print(" extends " + supCl.getName());
		}
	}
	
	//判断有没有接口，如果有，则打印出来
	public static void printInterFaces(Class cl) {
		Class[] interFaces = cl.getInterfaces();
		if(cl.getInterfaces() == interFaces) ;
		else if(interFaces.length > 0) {
			System.out.print(" implements ");
			for(int i = 0; i < interFaces.length; i++) {
				System.out.print(interFaces[i].getName() + ", ");
				if(i == interFaces.length-1) {
					System.out.println(interFaces[i].getName()+" {");
				}
			}
		}else {
			System.out.println(" {");
		}
	}
	
	//打印构造函数
	public static void printConstructedFunction(Class cl) {
		Constructor[] construct = cl.getConstructors();
		
		if(construct.length > 0) {
			for(Constructor c:construct) {
				String name = c.getName();
				String modifier = Modifier.toString(c.getModifiers());
				if(modifier.length() > 0) 
					System.out.print("	" + modifier + " " + name + "(");
				
				//打印参数
				Class[] parameterType = c.getParameterTypes();
				for(int i = 0; i < parameterType.length; i++) {
					int y = i+1;
					if(i > 0) System.out.print(", ");
					System.out.print(parameterType[i].getName() + " param" + y);
				}
				System.out.println(");");
			}
			System.out.println();//打印空行，方便分辨构造函数和方法
		}
	}

	//打印方法
	public static void printMethod(Class cl) {
		Method[] method = cl.getMethods();
		for(Method m: method) {
			//打印修饰符
			String modifier = Modifier.toString(m.getModifiers());
			if(modifier.length() > 0) System.out.print("	" + modifier);
			
			//打印返回值类型
			Class type = m.getReturnType();
			System.out.print(" " + type.getName());
			
			//打印方法名
			String name = m.getName();
			System.out.print(" " + name + "(");
			
			//打印参数
			Class[] parameterType = m.getParameterTypes();
			for(int i = 0; i < parameterType.length; i++) {
				int y = i+1;
				if(i > 0) System.out.print(", ");
				System.out.print(parameterType[i].getName() + " param" + y);
			}
			System.out.println(");");
		}
		System.out.println();//换行
	}

	//打印字段
	public static void printFields(Class cl) {
		Field[] fileds = cl.getDeclaredFields();
		for(Field f:fileds) {
			//打印修饰符
			String modifier = Modifier.toString(f.getModifiers());
			if(modifier.length() > 0)	System.out.print("	" + modifier);
			
			//打印字段名
			String name = f.getName();
			System.out.println(" " + name + ";");
		}
		System.out.println("}");
	}

}
