package Shop;

// Kullanılan kütüphanelerin çağırılması

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

// ShoppingCart'ımız.. IKampanyalar interfaceinin özelliklerini taşıyor.

public class ShoppingCart implements IKampanyalar {
	
	//Tanımlamalar
	
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
	
	// Liste oluşturma
	
	List<Integer> arrList = new ArrayList<Integer>();
	
	// Mevcut Kampanyalar (interface)
	
	public void mevcut1() { // 3 Opera bileti alana 2 Opera bileti bedava(Mevcut kampanya)
		if(OperaSayac!=0){
			for(int i = 1;i<=OperaSayac;i++){
				if (i%3==0){
				totalPrice-=Biletler.Opera.getPrice();
				System.out.println("Opera biletinde 3 al 2 öde kampanyası uygulandı.");
				}
			}
		}	
	}
	
	public void mevcut2() { // X tane Opera bileti alana Y tane Opera bileti bedava(Mevcut kampanya)
		if (OperaSayac<=SinemaSayac & OperaSayac!=0){
			totalPrice=totalPrice-(OperaSayac*Biletler.Sinema.getPrice());
			System.out.println(OperaSayac+" adet Opera bileti alana "+OperaSayac+" tane Sinema bileti bedava kampanyası uygulandı.");
		}else if(OperaSayac>=SinemaSayac & SinemaSayac!=0){
			totalPrice=totalPrice-(SinemaSayac*Biletler.Sinema.getPrice());
			System.out.println(SinemaSayac+"adet Opera bileti alana "+SinemaSayac+" tane Sinema bileti bedava kampanyası uygulandı.");
		}
	}

	public void mevcut3() { // X tane Bungee Jumping bileti alana X tane Sinema biletinde 5$ indirim(Mevcut kampanya)
		if (BungeeSayac<=SinemaSayac & BungeeSayac!=0){
			totalPrice=totalPrice-(BungeeSayac*5);
			System.out.println(BungeeSayac+" adet Bungee Jumping bileti alana "+BungeeSayac+" tane Sinema biletinde 5$ indirim kampanyası uygulandı.");
		}else if(BungeeSayac>=SinemaSayac & SinemaSayac!=0){
			totalPrice=totalPrice-(SinemaSayac*5);
			System.out.println(SinemaSayac+" adet Bungee Jumping bileti alana "+SinemaSayac+" tane Sinema biletinde 5$ indirim kampanyası uygulandı.");
		}
		System.out.println("Alınan biletlerin toplam fiyatı : "+totalPrice+"$ olarak belirlendi.");
	}
	
	/*
	 * 
	 *  XE1 = 1. Bilet türü adeti
	 *  XE2 = 2. Bilet türü adeti(İndirim uygulanan)
	 *  XE3 = 1. Bilet türü  (Oluşturulan ArrayListe göre 0 Opera 1 Sinema 2 BungeeJumping)
	 *  XE4 = 2. Bilet türü  (Oluşturulan ArrayListe göre 0 Opera 1 Sinema 2 BungeeJumping)
	 *  XE5 = İndirim tutarı
	 *  
	*/
	
	
	// Eklenen Kampanyalar(İnterface)
	
	public void kampanyaEkle1(int XE1, int XE2, int XE3 , int XE4) { 
		if (XE3==0 & XE4==0 & XE1!=0 & XE2!=0){
			if(OperaSayac!=0){
				totalPrice-=(XE2*Biletler.Opera.getPrice());
				System.out.println("Opera biletinde "+XE1+" al "+(XE2-1)+" öde kampanyası uygulandı."); // X tane al Y tane öde(Eklenen kampanya türü 1 - Opera)
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}	
		}
		else if (XE3==1 & XE4==1 & XE1!=0 & XE2!=0){
			if(SinemaSayac!=0){
				totalPrice-=(XE2*Biletler.Sinema.getPrice());
				System.out.println("Sinema biletinde "+XE1+" al "+(XE2-1)+" öde kampanyası uygulandı."); // X tane al Y tane öde(Eklenen kampanya türü 1 - Sinema)
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}	
		}
		else if (XE3==2 & XE4==2 & XE1!=0 & XE2!=0){
			if(BungeeSayac!=0){
				totalPrice-=(XE2*Biletler.Bungee.getPrice());
				System.out.println("Bungee biletinde "+XE1+" al "+(XE2-1)+" öde kampanyası uygulandı."); // X tane al Y tane öde(Eklenen kampanya türü 1 - Bungee Jumping)
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}	
		}else{
			System.out.println("Eklenen kampanya bulunamadı.(1)"); // Eklenmemiş ise console çıktısı
		}
		
	}
	
	public void kampanyaEkle2(int XE1,int XE2, int XE3 , int XE4) {
		if(XE3==0 & XE4==1 & XE1!=0 & XE2!=0 || XE3==1 & XE4==0  & XE1!=0 & XE2!=0 ){
			if(XE1>=XE2 & SinemaSayac!=0){
				totalPrice-=(XE2*Biletler.Sinema.getPrice());
				System.out.println(XE2+" Adet Opera bileti alana "+XE2+" adet Sinema bileti bedava kampanyası uygulandı."); // X al X tane bedava (Opera->Sinema)
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}
			if(XE2>=XE1 & OperaSayac!=0){
				totalPrice-=(XE1*Biletler.Opera.getPrice());
				System.out.println(XE1+" Adet Sinema bileti alana "+XE1+" adet Opera bileti bedava kampanyası uygulandı."); // X al X tane bedava (Sinema->Opera)
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}
		}
		else if(XE3==1 & XE4==2 & XE1!=0 & XE2!=0 || XE3==2 & XE4==1  & XE1!=0 & XE2!=0 ){
			if(XE1>=XE2 & BungeeSayac!=0){
				totalPrice-=(XE2*Biletler.Bungee.getPrice());
				System.out.println(XE2+" Adet Sinema bileti alana "+XE2+" adet Bungee bileti bedava kampanyası uygulandı."); // X al X tane bedava (Sinema->Bungee)
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}
			if(XE2>=XE1 & SinemaSayac!=0){
				totalPrice-=(XE1*Biletler.Sinema.getPrice());
				System.out.println(XE1+" Adet Bungee bileti alana "+XE1+" adet Sinema bileti bedava kampanyası uygulandı."); // X al X tane bedava (Bungee->Sinema)
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}
		}
		else if(XE3==0 & XE4==2 & XE1!=0 & XE2!=0 || XE3==2 & XE4==0  & XE1!=0 & XE2!=0 ){
			if(XE1>=XE2 & BungeeSayac!=0){
				totalPrice-=(XE2*Biletler.Bungee.getPrice());
				System.out.println(XE2+" Adet Opera bileti alana "+XE2+" adet Bungee bileti bedava kampanyası uygulandı."); // X al X tane bedava (Opera->Bungee)
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}
			if(XE2>=XE1 & OperaSayac!=0){
				totalPrice-=(XE1*Biletler.Opera.getPrice());
				System.out.println(XE1+" Adet Bungee bileti alana "+XE1+" adet Opera bileti bedava kampanyası uygulandı."); // X al X tane bedava (Bungee->Opera)
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}
		}
		else{
			System.out.println("Eklenen kampanya bulunamadı.(2)"); // Eklenmemiş ise console çıktısı
		}
		
		
	}
	
	public void kampanyaEkle3(int XE1, int XE2, int XE3 , int XE4 , int XE5) {
		if(XE3==0 & XE4==1 & XE1!=0 & XE2!=0 || XE3==1 & XE4==0  & XE1!=0 & XE2!=0 ){
			if(XE1>=XE2 & SinemaSayac!=0){
				totalPrice-=(XE2*XE5);
				System.out.println(XE2+" Adet Opera bileti alana "+XE2+" adet Sinema biletinde "+XE5+"$ indirim kampanyası uygulandı."); // X al X tanesinde XE5 kadar indirim (Opera->Sinema)
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}
			if(XE2>=XE1 & OperaSayac!=0){
				totalPrice-=(XE1*XE5);
				System.out.println(XE1+" Adet Sinema bileti alana "+XE1+" adet Opera biletinde "+XE5+"$ indirim kampanyası uygulandı."); //  X al X tanesinde XE5 kadar indirim (Sinema->Opera)
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}
		}
		else if(XE3==1 & XE4==2 & XE1!=0 & XE2!=0 || XE3==2 & XE4==1  & XE1!=0 & XE2!=0 ){
			if(XE1>=XE2 & BungeeSayac!=0){
				totalPrice-=(XE2*XE5);
				System.out.println(XE2+" Adet Sinema bileti alana "+XE2+" adet Bungee biletinde "+XE5+"$ indirim kampanyası uygulandı."); // X al X tane bedava (Sinema->Bungee)
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}
			if(XE2>=XE1 & SinemaSayac!=0){
				totalPrice-=(XE1*XE5);
				System.out.println(XE1+" Adet Bungee bileti alana "+XE1+" adet Sinema biletinde "+XE5+"$ indirim kampanyası uygulandı."); // X al X tane bedava (Bungee->Sinema)
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}
		}
		else if(XE3==0 & XE4==2 & XE1!=0 & XE2!=0 || XE3==2 & XE4==0  & XE1!=0 & XE2!=0 ){
			if(XE1>=XE2 & BungeeSayac!=0){
				totalPrice-=(XE2*XE5);
				System.out.println(XE2+" Adet Opera bileti alana "+XE2+" adet Bungee biletinde "+XE5+"$ indirim kampanyası uygulandı."); // X al X tane bedava (Opera->Bungee)
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}
			if(XE2>=XE1 & OperaSayac!=0){
				totalPrice-=(XE1*XE5);
				System.out.println(XE1+" Adet Bungee bileti alana "+XE1+" adet Opera biletinde "+XE5+"$ indirim kampanyası uygulandı."); // X al X tane bedava (Bungee->Opera)
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}
		}
		else{
			System.out.println("Eklenen kampanya bulunamadı.(3)"); // Eklenmemiş ise console çıktısı
		}
		
		
	}
	
	private enum Biletler {
		Opera(300),
		Sinema(30),
		Bungee(100);
		
		private final int price;
		
		Biletler(int price) {
			this.price = price;
		}
		
		public int getPrice(){
			
			return this.price;
		}
	}
	
	public void add() {
		System.out.println("Kaç adet Opera bileti satın almak istiyorsunuz?");
		@SuppressWarnings("resource")
		Scanner opSay = new Scanner(System.in);
		OperaSayac = opSay.nextInt();
		int operaFiyat = Biletler.Opera.getPrice();
		arrList.add((OperaSayac)*(operaFiyat));
		System.out.println("Kaç adet Sinema bileti satın almak istiyorsunuz?");
		@SuppressWarnings("resource")
		Scanner sinSay = new Scanner(System.in);
		SinemaSayac = sinSay.nextInt();
		int sinemaFiyat = Biletler.Sinema.getPrice();
		arrList.add((SinemaSayac)*(sinemaFiyat));
		System.out.println("Kaç adet Bungee bileti satın almak istiyorsunuz?");
		@SuppressWarnings("resource")
		Scanner bunSay = new Scanner(System.in);
		BungeeSayac = bunSay.nextInt();
		int bungeeFiyat = Biletler.Bungee.getPrice();
		arrList.add((BungeeSayac)*(bungeeFiyat));
	}
	
	public void total(){
		val1 = arrList.get(0);
		val2 = arrList.get(1);
		val3 = arrList.get(2);
		totalPrice = (val1+val2+val3);	
	}
	
public static void main(String []args) {
	ShoppingCart biletlerim = new ShoppingCart();
	System.out.println("Lütfen mevcut kampanyalarla satın alma işlemi için 101,"+System.lineSeparator()+"Yeni kampanyalarla satın alma işlemi için 202 yi tuşlayınız."+System.lineSeparator()+"Giriş kodu : ");
	@SuppressWarnings("resource")
	Scanner islemNo1 = new Scanner(System.in);
	int islemNo = islemNo1.nextInt();
	
	switch(islemNo){
	case 101:
		biletlerim.add();
		biletlerim.total();
		biletlerim.mevcut1();
		biletlerim.mevcut2();
		biletlerim.mevcut3();
		break;
		
	case 202:
		biletlerim.add();
		biletlerim.total();
		biletlerim.kampanyaEkle1(0, 0, 0, 0);
		biletlerim.kampanyaEkle2(0, 0, 0, 0);
		biletlerim.kampanyaEkle3(0, 0, 0, 0, 0);
		break;
		
	default:
		System.out.println("Eksik veya hatalı bir giriş yaptınız.");
		break;
	}
	
	
	/*
	 * 
	 *  XE1 = 1. Bilet türü adeti
	 *  XE2 = 2. Bilet türü adeti(İndirim uygulanan)
	 *  XE3 = 1. Bilet türü  (Oluşturulan ArrayListe göre 0 Opera 1 Sinema 2 BungeeJumping)
	 *  XE4 = 2. Bilet türü  (Oluşturulan ArrayListe göre 0 Opera 1 Sinema 2 BungeeJumping)
	 *  XE5 = İndirim tutarı
	 *  
	*/
	
	}
}
