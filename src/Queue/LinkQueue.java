package Queue;

/**
 * 基于链表实现的队列
 * @author Xuuuuu
 *
 */
public class LinkQueue {
	//头部引用和尾部引用的索引
	private Node head = null;
	private Node tail = null;	
	
	//入队
	public void enqueue(String value) {
		//判断队列是否为空
		if(tail == null) {
			//创建队列，并为 head 和 tail 赋初节点
			Node newNode = new Node(value,null);
			head = newNode;
			tail = newNode;
		}else {
			//将 next 设置为新的尾节点
			tail.next = new Node(value, null);
			//将尾节点转移到新的尾节点上
			tail = tail.next;
		}
	}
	
	//出队
	public String dequeue() {
		//判断首节点是否为空
		if(head != null) {
			//转移 head 的值
			String value = head.data;
			//将首节点转移到下一个节点上
			head = head.next;
			//再次判断转移后的首节点是否为空
			//这样是为了判断该链表是否只有一个元素
			if(head == null) {
				return null;
			}
			//返回值
			return value;
		}else {
			return null;
		}
	}
	
	//遍历输出
	public void pringAll() {
		//将首节点赋给一个遍历节点
		Node value = head;
		//while 循环打印链表数据
		while(value != null) {
			System.out.println(value.data);
			value = value.next;
		}
	}
	
	//测试
	public static void main(String[] args) {
		LinkQueue ss =new LinkQueue();
		for(int i = 0; i < 10; i++) {
			String a = String.valueOf(i);
			ss.enqueue(a);
		}
		ss.pringAll();
	}
	 	
	static class Node{
		private String data;
		private Node next;
		
		public Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		public String getData() {
			return data;
		}
	}

}
