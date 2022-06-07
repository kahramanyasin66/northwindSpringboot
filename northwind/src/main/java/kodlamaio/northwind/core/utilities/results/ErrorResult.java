package kodlamaio.northwind.core.utilities.results;

public class ErrorResult  extends Result {
	public ErrorResult() { //mesaj geçmek istemeyen için
		super(false);
		
	} 
	public ErrorResult(String message) {
		super(false,message);
	}

}
