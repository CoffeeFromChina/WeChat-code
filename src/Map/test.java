package Map;

import java.util.HashMap;
import java.util.Map;

public class test {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		//键值不为空时
		map.put("测试键值不为空时更新数据", 1);
		//更新测试一个的数据
		map.put("测试键值不为空时更新数据", map.get("测试键值不为空时更新数据")+1);
		System.out.println(map.get("测试键值不为空时更新数据"));
		
		//因为运行此程序会抛出异常，为了部影响后面程序的运行，和方便与文字顺序向批评，故将其注释。
//		//键值为空时程序抛出 NullPointerException
//		map.put("测试键值为空时更新数据", null);
//		map.put("测试键值为空时更新数据", map.get("测试键值为空时更新数据")+1);
//		System.out.println(map.get("测试键值为空时更新数据"));
		
		//存在 key，而 value 为 null
		map.put("存在 key，而 value 为 null", null);
		map.putIfAbsent("存在 key，而 value 为 null", 0);
		map.put("存在 key，而 value 为 null", map.get("存在 key，而 value 为 null")+1);
		System.out.println(map.get("存在 key，而 value 为 null"));
		
		//第一次出现的键
		map.put("我第一次出现", map.getOrDefault("我第一次出现", 0)+1);
		System.out.println(map.get("我第一次出现"));
		
		//第一次出现的键
		//如果这个键是第一出现的话，就与 1 组合，不然就调用 Integer 类的 sum 与原值进行求和
		//这个方法也就不用担心这个键是否第一次出现或者键值为空的情况。
		map.merge("我也是第一次出现", 1, Integer::sum);
		map.merge("我也是第一次出现", 3, Integer::sum);
		System.out.println(map.get("我也是第一次出现"));
	}

}
