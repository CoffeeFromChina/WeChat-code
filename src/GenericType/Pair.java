package GenericType;

/**
 * 此程序用于提供一个泛型类
 * 
 * @version 2018-11-10
 * @author DXC
 *
 * @param <T>
 */

public class Pair<T> {
	private T first;
	private T second;
	
	public Pair() {
		first = null;
		second = null;
	}
	public Pair(T first,T second) {
		this.first = first;
		this.second = second;
	}
	public T getFirst() {
		return first;
	}
	public void setFirst(T newValue) {
		this.first = newValue;
	}
	public T getSecond() {
		return second;
	}
	public void setSecond(T newValue) {
		this.second = newValue;
	}
	
	
}
