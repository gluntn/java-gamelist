
public class GameStorage {
	private String publisher;
	private String name;
	private int age;

	/*
	 * Simply a class harbouring two Strings, one for name and one for publisher.
	 * There is also an Integer that shows the published age, and this number should be
	 * only four digits long. This has to be dealt with.
	 * Check if age is between 0 and 9999.
	 * 
	 * TODO: Add four-digit restriction on int age.
	 */
	public GameStorage(String name, String publisher, int age) {
		this.name = name;
		this.publisher = publisher;
		this.age = clamp(age, 0, 9999);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getPublisher() {
		return this.publisher;
	}
	
	public void setAge(int age) {
		this.age = clamp(age, 0, 9999);
	}
	
	public int getAge() {
		return this.age;
	}
	
	// Maybe a bit unnecessary, but used to check if age is between 0 and 9999
	private int clamp(int val, int min, int max) {
		if(val < min) return min;
		else if (val > max) return max;
		else return val;
	}
}
