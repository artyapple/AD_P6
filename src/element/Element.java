package element;

public class Element<T> implements IElement<T>{
	
	private long key;
	private T data;
	
	public Element(long key, T data){
		this.key = key;
		this.data = data;		
	}

	@Override
	public T getValue() {
		return data;
	}

	@Override
	public long getKey() {
		return key;
	}
	
	

}
