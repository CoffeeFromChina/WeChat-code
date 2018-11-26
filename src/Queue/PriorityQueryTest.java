package Queue;

import java.util.PriorityQueue;

/**
 * 优先级队列
 * @author Xuuuuu
 *
 */
public class PriorityQueryTest {

	public static void main(String[] args) {
		//创建一个优先级队列对象
		PriorityQueue<String> test = new PriorityQueue<>();
		
		//为队列添加元素
		for(int i = 0; i < 10; i++) {
			int a = i + 1;
			test.add("我是第" + a + "个加入队列的");
		}
		
		//遍历队列，输出元素。
		//比较是否与输入的顺序一致
		for(String a:test) {
			System.out.println(a);
		}
		
		System.out.println("-----------我是分割线------------");
		
		//优先级队列在内存不足时，优先将优先级高的元素聪队列中删除
		//这个循环是演示移除优先级最高的元素，查看元素的优先级
		while(!test.isEmpty()) {
			System.out.println(test.remove());
		}
	}

}
