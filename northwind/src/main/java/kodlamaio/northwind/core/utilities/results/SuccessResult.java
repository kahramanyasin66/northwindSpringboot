package kodlamaio.northwind.core.utilities.results;

public class SuccessResult extends Result{ //İşlem sonucu Başarılı ise 

	public SuccessResult() { //mesaj geçmek istemeyen için
		super(true);
		
	} 
	public SuccessResult(String message) {
		super(true,message);
	}

}
