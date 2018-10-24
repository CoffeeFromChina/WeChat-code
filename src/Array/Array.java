package Array;

public class Array {
	/*
	 * 静态申明数组格式：type[] arrayName = {array_ele1,array_ele2.....};
	 * 动态申明数组格式：type[] arrayName = new type[arraySize]
	 */
	public static void main(String[] args) {
		//我们以动态申明一个int类型的数组为例
		//申明一个数组，长度为3
		
		System.out.println("下面是动态申明数组的结果");
		int[] a = new int[4];
		
		//用for循环为数组赋值
		//.length() 可以获取数组的长度
		for(int i = 0; i < a.length; i++) {
			a[i] = i+1;
		}
		
		//打印数组数据
		for(int i = 0; i < a.length; i++) {
			System.out.print("\t"+a[i]);
		}
		System.out.println();
		System.out.println("下面是两种for循环的结果");
		
		//下面是实现两种for循环的代码，还是以上的数组a为例
		
		//先用第一种for循环改变数组的元素值；
		for(int i = 1; i < a.length; i++) {//如果i=0,数组下标会越界,编译器会报错
			a[i] = a[i] + a[i-1];
		}
		
		//用加强版的for循环输出数组a的值
		for(int b:a) {
			System.out.print("\t"+b);
		}
	}
}
