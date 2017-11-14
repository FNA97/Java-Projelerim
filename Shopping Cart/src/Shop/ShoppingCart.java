package Shop;

// Kullan�lan k�t�phanelerin �a��r�lmas�

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

// ShoppingCart'�m�z.. IKampanyalar interfaceinin �zelliklerini ta��yor.

public class ShoppingCart implements IMevcutKampanyalar,IEklenenKampanyalar {
	
	//Tan�mlamalar
	
	public int OperaSayac;
	public int SinemaSayac;
	public int BungeeSayac;
	public int totalPrice;
	public int val1;
	public int val2;
	public int val3;
	public int XE1;
	public int XE2;
	public int XE3;
	public int XE4;
	
	// Liste olu�turma
	
	List<Integer> arrList = new ArrayList<Integer>();
	
	// Mevcut Kampanyalar (interface)
	
	public void mevcut1() { // 3 Opera bileti alana 2 Opera bileti bedava(Mevcut kampanya)
		if(OperaSayac!=0){
			for(int i = 1;i<=OperaSayac;i++){
				if (i%3==0){
				totalPrice-=Biletler.Opera.getPrice();
				System.out.println("Opera biletinde 3 al 2 �de kampanyas� uyguland�.");
				}
			}
		}	
	}
	
	public void mevcut2() { // X tane Opera bileti alana Y tane Opera bileti bedava(Mevcut kampanya)
		if (OperaSayac<=SinemaSayac & OperaSayac!=0){
			totalPrice=totalPrice-(OperaSayac*Biletler.Sinema.getPrice());
			System.out.println(OperaSayac+" adet Opera bileti alana "+OperaSayac+" tane Sinema bileti bedava kampanyas� uyguland�.");
		}else if(OperaSayac>=SinemaSayac & SinemaSayac!=0){
			totalPrice=totalPrice-(SinemaSayac*Biletler.Sinema.getPrice());
			System.out.println(SinemaSayac+"adet Opera bileti alana "+SinemaSayac+" tane Sinema bileti bedava kampanyas� uyguland�.");
		}
	}

	public void mevcut3() { // X tane Bungee Jumping bileti alana X tane Sinema biletinde 5$ indirim(Mevcut kampanya)
		if (BungeeSayac<=SinemaSayac & BungeeSayac!=0){
			totalPrice=totalPrice-(BungeeSayac*5);
			System.out.println(BungeeSayac+" adet Bungee Jumping bileti alana "+BungeeSayac+" tane Sinema biletinde 5$ indirim kampanyas� uyguland�.");
		}else if(BungeeSayac>=SinemaSayac & SinemaSayac!=0){
			totalPrice=totalPrice-(SinemaSayac*5);
			System.out.println(SinemaSayac+" adet Bungee Jumping bileti alana "+SinemaSayac+" tane Sinema biletinde 5$ indirim kampanyas� uyguland�.");
		}
		System.out.println("Al�nan biletlerin toplam fiyat� : "+totalPrice+"$ olarak belirlendi.");
	}
	
	/*
	 * 
	 *  XE1 = 1. Bilet t�r� adeti
	 *  XE2 = 2. Bilet t�r� adeti(�ndirim uygulanan)
	 *  XE3 = 1. Bilet t�r�  (Olu�turulan ArrayListe g�re 0 Opera 1 Sinema 2 BungeeJumping)
	 *  XE4 = 2. Bilet t�r�  (Olu�turulan ArrayListe g�re 0 Opera 1 Sinema 2 BungeeJumping)
	 *  XE5 = �ndirim tutar�
	 *  
	*/
	
	
	// Eklenen Kampanyalar(�nterface)
	
	public void kampanyaEkle1(int XE1, int XE2, int XE3 , int XE4) { 
		if (XE3==0 & XE4==0 & XE1!=0 & XE2!=0){
			if(OperaSayac!=0){
				totalPrice-=(XE2*Biletler.Opera.getPrice());
				System.out.println("Opera biletinde "+XE1+" al "+(XE2-1)+" �de kampanyas� uyguland�."); // X tane al Y tane �de(Eklenen kampanya t�r� 1 - Opera)
				System.out.println("Yeni kampanyal� fiyat : "+totalPrice+"$");
			}	
		}
		else if (XE3==1 & XE4==1 & XE1!=0 & XE2!=0){
			if(SinemaSayac!=0){
				totalPrice-=(XE2*Biletler.Sinema.getPrice());
				System.out.println("Sinema biletinde "+XE1+" al "+(XE2-1)+" �de kampanyas� uyguland�."); // X tane al Y tane �de(Eklenen kampanya t�r� 1 - Sinema)
				System.out.println("Yeni kampanyal� fiyat : "+totalPrice+"$");
			}	
		}
		else if (XE3==2 & XE4==2 & XE1!=0 & XE2!=0){
			if(BungeeSayac!=0){
				totalPrice-=(XE2*Biletler.Bungee.getPrice());
				System.out.println("Bungee biletinde "+XE1+" al "+(XE2-1)+" �de kampanyas� uyguland�."); // X tane al Y tane �de(Eklenen kampanya t�r� 1 - Bungee Jumping)
				System.out.println("Yeni kampanyal� fiyat : "+totalPrice+"$");
			}	
		}else{
			System.out.println("Eklenen kampanya bulunamad�.(1)"); // Eklenmemi� ise console ��kt�s�
		}
		
	}
	
	public void kampanyaEkle2(int XE1,int XE2, int XE3 , int XE4) {
		if(XE3==0 & XE4==1 & XE1!=0 & XE2!=0 & SinemaSayac!=0 & OperaSayac!=0 || XE3==1 & XE4==0  & XE1!=0 & XE2!=0 & SinemaSayac!=0 & OperaSayac!=0 ){
			if(XE1>=XE2){
				totalPrice-=(XE2*Biletler.Sinema.getPrice());
				System.out.println(XE2+" Adet Opera bileti alana "+XE2+" adet Sinema bileti bedava kampanyas� uyguland�."); // X al X tane bedava (Opera->Sinema)
				System.out.println("Yeni kampanyal� fiyat : "+totalPrice+"$");
			}
			if(XE2>=XE1){
				totalPrice-=(XE1*Biletler.Opera.getPrice());
				System.out.println(XE1+" Adet Sinema bileti alana "+XE1+" adet Opera bileti bedava kampanyas� uyguland�."); // X al X tane bedava (Sinema->Opera)
				System.out.println("Yeni kampanyal� fiyat : "+totalPrice+"$");
			}
		}
		else if(XE3==1 & XE4==2 & XE1!=0 & XE2!=0 & BungeeSayac!=0 & SinemaSayac!=0 || XE3==2 & XE4==1  & XE1!=0 & XE2!=0 & BungeeSayac!=0 & SinemaSayac!=0 ){
			if(XE1>=XE2){
				totalPrice-=(XE2*Biletler.Bungee.getPrice());
				System.out.println(XE2+" Adet Sinema bileti alana "+XE2+" adet Bungee bileti bedava kampanyas� uyguland�."); // X al X tane bedava (Sinema->Bungee)
				System.out.println("Yeni kampanyal� fiyat : "+totalPrice+"$");
			}
			if(XE2>=XE1){
				totalPrice-=(XE1*Biletler.Sinema.getPrice());
				System.out.println(XE1+" Adet Bungee bileti alana "+XE1+" adet Sinema bileti bedava kampanyas� uyguland�."); // X al X tane bedava (Bungee->Sinema)
				System.out.println("Yeni kampanyal� fiyat : "+totalPrice+"$");
			}
		}
		else if(XE3==0 & XE4==2 & XE1!=0 & XE2!=0 & BungeeSayac!=0 & OperaSayac!=0 || XE3==2 & XE4==0  & XE1!=0 & XE2!=0 & XE2!=0 & BungeeSayac!=0 & OperaSayac!=0){
			if(XE1>=XE2){
				totalPrice-=(XE2*Biletler.Bungee.getPrice());
				System.out.println(XE2+" Adet Opera bileti alana "+XE2+" adet Bungee bileti bedava kampanyas� uyguland�."); // X al X tane bedava (Opera->Bungee)
				System.out.println("Yeni kampanyal� fiyat : "+totalPrice+"$");
			}
			if(XE2<=XE1){
				totalPrice-=(XE1*Biletler.Opera.getPrice());
				System.out.println(XE1+" Adet Bungee bileti alana "+XE1+" adet Opera bileti bedava kampanyas� uyguland�."); // X al X tane bedava (Bungee->Opera)
				System.out.println("Yeni kampanyal� fiyat : "+totalPrice+"$");
			}
		}
		else{
			System.out.println("Eklenen kampanya bulunamad�.(2)"); // Eklenmemi� ise console ��kt�s�
		}
		
		
	}
	
	public void kampanyaEkle3(int XE1, int XE2, int XE3 , int XE4 , int XE5) {
		if(XE3==0 & XE4==1 & XE1!=0 & XE2!=0 & SinemaSayac!=0 & OperaSayac!=0 || XE3==1 & XE4==0  & XE1!=0 & XE2!=0 & XE2!=0 & SinemaSayac!=0 & OperaSayac!=0 ){
			if(XE1>=XE2){
				totalPrice-=(XE2*XE5);
				System.out.println(XE2+" Adet Opera bileti alana "+XE2+" adet Sinema biletinde "+XE5+"$ indirim kampanyas� uyguland�."); // X al X tanesinde XE5 kadar indirim (Opera->Sinema)
				System.out.println("Yeni kampanyal� fiyat : "+totalPrice+"$");
			}
			if(XE2>=XE1){
				totalPrice-=(XE1*XE5);
				System.out.println(XE1+" Adet Sinema bileti alana "+XE1+" adet Opera biletinde "+XE5+"$ indirim kampanyas� uyguland�."); //  X al X tanesinde XE5 kadar indirim (Sinema->Opera)
				System.out.println("Yeni kampanyal� fiyat : "+totalPrice+"$");
			}
		}
		else if(XE3==1 & XE4==2 & XE1!=0 & XE2!=0 & BungeeSayac!=0 & SinemaSayac!=0 || XE3==2 & XE4==1  & XE1!=0 & XE2!=0 & BungeeSayac!=0 & SinemaSayac!=0 ){
			if(XE1>=XE2){
				totalPrice-=(XE2*XE5);
				System.out.println(XE2+" Adet Sinema bileti alana "+XE2+" adet Bungee biletinde "+XE5+"$ indirim kampanyas� uyguland�."); // X al X tane bedava (Sinema->Bungee)
				System.out.println("Yeni kampanyal� fiyat : "+totalPrice+"$");
			}
			if(XE2>=XE1){
				totalPrice-=(XE1*XE5);
				System.out.println(XE1+" Adet Bungee bileti alana "+XE1+" adet Sinema biletinde "+XE5+"$ indirim kampanyas� uyguland�."); // X al X tane bedava (Bungee->Sinema)
				System.out.println("Yeni kampanyal� fiyat : "+totalPrice+"$");
			}
		}
		else if(XE3==0 & XE4==2 & XE1!=0 & XE2!=0 & BungeeSayac!=0 & OperaSayac!=0 || XE3==2 & XE4==0  & XE1!=0 & XE2!=0 & XE2!=0 & BungeeSayac!=0 & OperaSayac!=0 ){
			if(XE1>=XE2){
				totalPrice-=(XE2*XE5);
				System.out.println(XE2+" Adet Opera bileti alana "+XE2+" adet Bungee biletinde "+XE5+"$ indirim kampanyas� uyguland�."); // X al X tane bedava (Opera->Bungee)
				System.out.println("Yeni kampanyal� fiyat : "+totalPrice+"$");
			}
			if(XE2>=XE1){
				totalPrice-=(XE1*XE5);
				System.out.println(XE1+" Adet Bungee bileti alana "+XE1+" adet Opera biletinde "+XE5+"$ indirim kampanyas� uyguland�."); // X al X tane bedava (Bungee->Opera)
				System.out.println("Yeni kampanyal� fiyat : "+totalPrice+"$");
			}
		}
		else{
			System.out.println("Eklenen kampanya bulunamad�.(3)"); // Eklenmemi� ise console ��kt�s�
		}
		
		
	}
	
	private enum Biletler { // Biletleri private enum olarak tan�mlad�k.Hi�bir �ekilde fiyatlar� ve isimleri de�i�meyecek.
		Opera(300),
		Sinema(30),
		Bungee(100);
		
		private final int price; 
		
		Biletler(int price) {  // Biletlerin fiyat�n� belirlemek i�in int t�r�nde bir Constructor tan�ml�yoruz.
			this.price = price;
		}
		
		public int getPrice(){ // Biletlerin fiyatlar�n� elde etmek i�in getPrice methodu
			
			return this.price;  // Bilet fiyatlar�n� d�nd�r�yor.
		}
	}
	
	public void add() { // Sat�n al�nan biletleri belirleyen add methodu
		System.out.println("Ka� adet Opera bileti sat�n almak istiyorsunuz?");
		@SuppressWarnings("resource")
		Scanner opSay = new Scanner(System.in);
		OperaSayac = opSay.nextInt();    // Opera bilet say�s�
		int operaFiyat = Biletler.Opera.getPrice(); // Fiyat�n� elde edip
		arrList.add((OperaSayac)*(operaFiyat));  // Listeye ekledik.
		System.out.println("Ka� adet Sinema bileti sat�n almak istiyorsunuz?");
		@SuppressWarnings("resource")
		Scanner sinSay = new Scanner(System.in);
		SinemaSayac = sinSay.nextInt();	   // Sinema bilet say�s�
		int sinemaFiyat = Biletler.Sinema.getPrice(); // Fiyat�n� elde edip
		arrList.add((SinemaSayac)*(sinemaFiyat));  // Listeye ekledik.
		System.out.println("Ka� adet Bungee bileti sat�n almak istiyorsunuz?");
		@SuppressWarnings("resource")
		Scanner bunSay = new Scanner(System.in);
		BungeeSayac = bunSay.nextInt();  // Bungee Jumping bilet say�s�
		int bungeeFiyat = Biletler.Bungee.getPrice(); // Fiyat�n� elde edip
		arrList.add((BungeeSayac)*(bungeeFiyat));  // Listeye ekledik.
	}
	
	public void total(){ // Toplam �denmesi gereken fiyat� belirleyen total methodumuz
		val1 = arrList.get(0);  // Listenin 0. Eleman� Opera biletlerinin toplam�
		val2 = arrList.get(1);  // Listenin 1. Eleman� Sinema biletlerinin toplam�
		val3 = arrList.get(2);  // Listenin 2. Eleman� Bungee Jumping biletlerinin toplam�
		totalPrice = (val1+val2+val3);	
	}
	
public static void main(String []args) {
	ShoppingCart biletlerim = new ShoppingCart();
	System.out.println("L�tfen mevcut kampanyalarla sat�n alma i�lemi i�in 101,"+System.lineSeparator()+"Yeni kampanyalarla sat�n alma i�lemi i�in 202 yi tu�lay�n�z."+System.lineSeparator()+"Giri� kodu : ");
	@SuppressWarnings("resource")
	Scanner islemNo1 = new Scanner(System.in);
	int islemNo = islemNo1.nextInt();
	
	switch(islemNo){  // Menu de yap�lacak switch i�lemi
	case 101:  //101 girilirse
		biletlerim.add();
		biletlerim.total();
		biletlerim.mevcut1();
		biletlerim.mevcut2();
		biletlerim.mevcut3();
		break;
		
	case 202: //202 girilirse
		biletlerim.add();
		biletlerim.total();
		biletlerim.kampanyaEkle1(0, 0, 0, 0);
		biletlerim.kampanyaEkle2(0, 0, 0, 0);
		biletlerim.kampanyaEkle3(0, 0, 0, 0, 0);
		break;
		
	default: // Hatal� giri� yap�l�rsa
		System.out.println("Eksik veya hatal� bir giri� yapt�n�z.");
		break;
	}
	
	
	/*
	 * 
	 *  XE1 = 1. Bilet t�r� adeti
	 *  XE2 = 2. Bilet t�r� adeti(�ndirim uygulanan)
	 *  XE3 = 1. Bilet t�r�  (Olu�turulan ArrayListe g�re 0 Opera 1 Sinema 2 BungeeJumping)
	 *  XE4 = 2. Bilet t�r�  (Olu�turulan ArrayListe g�re 0 Opera 1 Sinema 2 BungeeJumping)
	 *  XE5 = �ndirim tutar�
	 *  
	*/
	
	}
}
