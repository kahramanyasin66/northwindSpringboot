package kodlamaio.northwind.core.utilities.results;

public class Result { //sonuç demek
private boolean success; // işlem başarılı mı true,false
private String  message; // sonuc elde edildiğinde gösterilecek mesaj

public Result (boolean success){ // sadece işlemin durumunu göstermek isteyen kullanıcı için 
	this.success = success;
}
public Result(boolean success,String message) {
	this(success);
	this.message = message ;
	}
public boolean isSuccess() { //success getter'ı dışardan erişim için 
	return this.success;
}
public String getMessage() { //message getter'ı dışardan okunabilmesi için
	return this.message;
}
}
