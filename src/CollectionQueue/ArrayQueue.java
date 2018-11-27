package CollectionQueue;

/**
 * 基于数组实现的顺序队列
 * @author Xuuuuu
 */
public class ArrayQueue {

	//创建数组
	private String[] items;
	private int n = 0;//队列大小
	
	//头部引用和尾部引用的索引
	private int head = 0;
	private int tail = 0;
	
	//申明对列
	public ArrayQueue(int capacity){
		n = capacity;
		items = new String[capacity];
	}
	
	//入队
	public boolean enqueue(String item) {
		//判断队列是否被占满
		if(tail == n) return false;
		//将操作的对象加入到队尾
		items[tail] = item;
		//tail 引用新插入队列的元素
		tail++;
		return true;
	}
	
	//出队
	public String dequeue() {
		//判断队列是否为 null
		if(tail == head) return null;
		String del = items[head];
		head++;
		return del;
	}
	

}
