package String_Printf;

import java.util.Date;

public class PrintfTest {

	public static void main(String[] args) {
		//创建一个Date类的对象
		Date date = new Date();
		//打印date
		System.out.println(date);
		
		//调用format
		String formatDate = String.format("%tF", date);
		System.out.println("调用format后的结果："+formatDate);
		
		
		//转换格式后再打印date
		System.out.printf("直接输出使用格式转换符后的结果：%tF",date);
		System.out.println();//换行
		
		/*
		 * 在转换数据时要注意其类型，
		 * 使用什么类型的数据，就要其对于类型的转换符。比如
		 * 浮点数只能使用浮点数的转换符
		 */
		float a = 100;
		System.out.println("这是没转换的数值a:"+a);
		System.out.printf("我只要显示到小数点后两为数:%.2f;"+"\n"+"我要转化为16进制数：%.1f",a,a);
		System.out.println();//换行
		
		//打印printf标志
		int sing = 3333;
		System.out.printf("这是printf的标志范例%+d",sing);
	}

}
