package kodlamaio.northwind.core.utilities.results;

public class DataResult<T> extends Result{

	private T data;
	
	public DataResult(T data ,boolean success, String message) { //message geçmek isteyen için constructor
		super(success, message);  // base sınıfın constructorlarını çalıştırıyor.
		this.data = data ;
	}
	public DataResult(T data,boolean success) {
		super(success);
		this.data = data;
	}
	
	public T getData() { //data'nın getter'ı diğerlerininki base sınıfta var
		return this.data;
	}	

}
