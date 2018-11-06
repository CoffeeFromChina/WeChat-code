package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

import javax.swing.JInternalFrame;
/**
 * 此示例引用了Fransonde的文章，非常感谢博主的文章。
 * @author Xuuuuu
 *
 */

public class test {

	public static void main(String[] args) {
		//先创建两个集合
		List<Person> javaProgramers = new ArrayList<Person>() {
			{  
			    add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));  
			    add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));  
			    add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));  
			    add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));  
			    add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));  
			    add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));  
			    add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));  
			    add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));  
			    add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));  
			    add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));  
			}  
		};
		List<Person> phpProgramers = new ArrayList<Person>() {
			{  
			    add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));  
			    add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));  
			    add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));  
			    add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));  
			    add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));  
			    add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));  
			    add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));  
			    add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));  
			    add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));  
			    add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));  
			}  
		};
		test t = new test();
//		t.outputName(javaProgramers);
//		t.changeSalary(javaProgramers,-4);
//		t.filterChangeSalary(javaProgramers, 1500, 4);
//		t.defineFilterChangeSalary(javaProgramers, 1300);
//		t.limitAhead(javaProgramers, 3);
//		t.sortOutput(javaProgramers);
//		t.minAndMax(javaProgramers);
//		t.parallelTest(javaProgramers);
//		t.variousAggregates();//这个方法是对数据的各种汇总
	}
	
	/**
	 * 输出姓名
	 * @param programmer List<Person> 类型的集合
	 */
	public void outputName(List<Person> programmer ) {
		System.out.println("输出所有人员的姓名：");
		//普通写法
		for(Person e: programmer) {
			System.out.println(e.getFirstName() + "." + e.getLastName());
		}
		//lambda写法
		programmer.forEach(e -> System.out.printf("%s %s\n",e.getFirstName(),e.getLastName()));
	}
	
	/**
	 * 集体改变薪资。
	 * @param programmer List<Person> 类型的集合
	 * @param money > 0,增加的百分比工资;money < 0,降低工的百分比工资
	 */
	public void changeSalary(List<Person> programmer,int money) {
			System.out.println("工资增加了" + money + "%"); 
			System.out.println("增加后的工资为：");
			
			//普通写法
//			for(Person e:programmer) {
//				e.setSalary(e.getSalary() + e.getSalary()/100 * money);
//				System.out.println(e.getSalary());
//			}
			
			//下面的代码是我参考的博主的带吗，我现在的阶段感觉没用便注释了
//			Consumer<Person> giveRaise =  e -> e.setSalary(e.getSalary() + e.getSalary()/100 * money);;
			
			//lambda写法
			programmer.forEach(e -> e.setSalary(e.getSalary() + e.getSalary()/100 * money));//增加薪水
			programmer.forEach(e -> System.out.println(e.getSalary()));//打印薪水
		
	}
	
	/**
	 * @method filter() 过滤器
	 * @param programmer List<Person> 类型的集合
	 * @param salary 要修改的高于该薪水的所有员工的薪水
	 * @param money > 0,增加的百分比工资;money < 0,降低工的百分比工资
	 */
	public void filterChangeSalary(List<Person> programmer,int salary,int money) {
		if(money > 0) {
			System.out.println("给工资高于" + salary + "的员工增加"+ money +"%的工资");
		
		}else if(money < 0) {
			System.out.println("给工资高于" + salary + "的员工降低"+ money +"%的工资");
		}
		programmer.stream()
					.filter(e -> e.getSalary() > salary)
					.forEach(e-> e.setSalary(e.getSalary() + e.getSalary()/100 * money));
		
		programmer.forEach(e -> System.out.println(e.getSalary()));//打印员工工资
	}
	
	/**
	 * 此方法只是一个演示，你自己还可以定义更多的Predicate(断言)
	 * 自己的的总结：Predicate就像是lambda语句块引用给一个Predicate类型的变量，
	 * 是我们用起来就像在运用对象一样更加方便。
	 * @param programmer List<Person> 类型的集合
	 * @param salary 要筛选的员工的工资
	 */
	public void defineFilterChangeSalary(List<Person> programmer,int salary) {
		Predicate<Person> sa = (e) -> (e.getSalary() > salary);
		System.out.println("姓名" + "\t\t" + "薪水");
		programmer.stream()
					.filter(sa)
					.forEach(e -> System.out.println(e.getFirstName()+"."
										+e.getLastName()+ "\t" +e.getSalary()));
	}

	/**
	 * 此方法打印前limit位员工
	 * @limit 限制结果个数
	 * @param programmer List<Person> 类型的集合
	 * @param limit 要打印的前几位的员工
	 */
	public void limitAhead(List<Person> programmer,int limit) {
		System.out.println("我们将显示前" + limit + "位员工");
		System.out.println("姓名" + "\t\t" + "性别" + "\t" +"薪水");
		programmer.stream()
				.limit(limit)
					.forEach(e -> System.out.println(e.getFirstName()+"."
							+e.getLastName()+ "\t" 
								+ e.getGender() + "\t" 
									+e.getSalary()));
	}

	/**
	 * 此方法还无法使用
	 * 因为 toList()会报错
	 * 此方法先根据薪水排序，在打印员工信息
	 * @param programmer List<Person> 类型的集合
	 */
	public void sortOutput(List<Person> programmer) {
//		List<Person> array = programmer
//							.stream()
//							.sorted((o1,o2) -> (o1.getSalary() - o2.getSalary()))
//							.collect(toList());
//		System.out.println("姓名" + "\t\t" +"薪水");
//		programmer.forEach(e -> System.out.println(e.getFirstName()+"."
//							+e.getLastName()+ "\t" 
//								+e.getSalary()));
									
	}
	
	/**
	 * 此方法输出薪水最高和最低的员工信息
	 * @param programmer List<Person> 类型的集合
	 */
	public void minAndMax(List<Person> programmer) {
		Person min = programmer
					.stream()  
					.min((o1,o2) -> (o1.getSalary() - o2.getSalary()))  
					.get();
		
		Person max = programmer
					.stream()
					.max((o1,o2) -> (o1.getSalary() - o2.getSalary()))  
					.get();
		
		System.out.println("最低工资的员工为：");
		System.out.println("姓名" + "\t\t" + "薪水");
		System.out.println(min.getFirstName() + "." + min.getLastName() + "\t" + min.getSalary());
	
		System.out.println("最高工资的员工为：");
		System.out.println("姓名" + "\t\t" + "薪水");
		System.out.println(max.getFirstName() + "." + max.getLastName() + "\t" + max.getSalary());
	}
	
	/**
	 * 此方法拼接字符串，目前还无法运行
	 * @param programmer List<Person> 类型的集合
	 */
	public void stringSplicing(List<Person> programmer) {
//		System.out.println("将 PHP programmers 的 first name 拼接成字符串:");  
//		String phpDevelopers = programmer.stream()  
//							          .map(Person::getFirstName)  
//							          .collect(joining(" ; "));
//		
//		System.out.println("将 Java programmers 的 first name 存放到 Set:");  
//		Set<String> javaDevelopers = programmer.stream()  
//								          .map(Person::getFirstName)  
//								          .collect(toSet());  
//		
//		System.out.println("将 Java programmers 的 first name 存放到 TreeSet:");  
//		TreeSet<String> javaDeveloper = programmer.stream()
//													.map(Person::getLastName)
//													.collect(toCollection(TreeSet::new));
	}

	/**
	 * 用parallelStream(并行流)打印总工资
	 * @param programmer List<Person> 类型的集合
	 */
	public void parallelTest(List<Person> programmer) {
		int sumSalary = programmer.parallelStream()
									.mapToInt(e -> e.getSalary())
									.sum();
		System.out.println(programmer.get(1).getJob() + "的总薪水是" + sumSalary);
	}

	/**
	 * 用summaryStatistics，实现各种数据的汇总
	 */
	public void variousAggregates() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		IntSummaryStatistics statis = numbers.stream()
											.mapToInt(x -> x)
											.summaryStatistics();
		System.out.println("List中最大的数字 : " + statis.getMax());  
		System.out.println("List中最小的数字 : " + statis.getMin());  
		System.out.println("所有数字的总和   : " + statis.getSum());  
		System.out.println("所有数字的平均值 : " + statis.getAverage());
	}

}
