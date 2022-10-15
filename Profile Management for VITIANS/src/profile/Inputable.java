package profile;

/**
 * This is an generic interface Inputable contains only one abstract method that inputs the info for the properties.
 * I eventually didn't implement this interface because I wanted this method to be called by the class name itself without creating an object. And then calling using the object.
 * Therefore I created this method as static.
 * Static methods can't be declared in an interface.
 * @author sanjeev.rm
 * @param <T> --> This is return type of the abstract method in the interface.
 */
public interface Inputable<T>
{
	public T inputUserInfo();
}