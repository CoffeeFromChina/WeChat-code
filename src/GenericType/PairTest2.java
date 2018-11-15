package GenericType;

import java.time.LocalDate;

/**
 * 演示泛型方法的使用
 * 8-2
 * @version 2018-11-10
 * @author DXC
 */
public class PairTest2 {

	public static void main(String[] args) {
		LocalDate[] birthdays = {LocalDate.of(1906, 12, 9),
								 LocalDate.of(1543, 5, 13),
								 LocalDate.of(2018, 11, 10),
								 LocalDate.of(2000, 4, 16),
								 LocalDate.of(1355, 6, 29),
								 LocalDate.of(1245, 4, 30)};
		
		Pair<LocalDate> mm = ArrayAlg2.minmax(birthdays);
		System.out.println("最小年龄的人于" + mm.getSecond() + "出生");
		System.out.println("最大年龄的人于" + mm.getFirst() + "出生");
	}

}

/**
 * 获取T类型对象的最小和最大值
 * @author DXC
 * @param a 类型为T的对象数组
 * @return 具有min和max值的Pair，如果为空或长度为0，则返回空。
 */
class ArrayAlg2{
	
	public static <T extends Comparable> Pair<T> minmax(T[] a) {
		if(a == null || a.length == 0) return null;
		T min = a[0];
		T max = a[0];
		for(T b:a) {
			if(min.compareTo(b) > 0) min = b;
			if(max.compareTo(b) < 0) max = b;
		}
		return new Pair<T>(min,max);//这里的<T>可省略，因为编译器能够推断出其类型
	}
	
}