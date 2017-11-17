package Shop;

// Kullanılan kütüphanelerin çağırılması

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

// ShoppingCart'ımız.. IMevcutKampanyalar ve IEklenenKampanyalar interfacelerinin özellik,methodlarını taşıyor.

public class ShoppingCart implements IMevcutKampanyalar,IEklenenKampanyalar {
	
	//Tanımlamalar
	
	public int OperaSayac;
	public int SinemaSayac;
	public int BungeeSayac;
	public int totalPrice;
	public int val1;
	public int val2;
	public int val3;
	public int tur1Adet;
	public int tur2Adet;
	public int biletTuru1;
	public int biletTuru2;
	public int indirimTutari;
	public int kampanyaSayac=0;
	
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
	
	// Eklenen Kampanyalar(İnterface)

	public void kampanyaEkle1(int tur1Adet,int tur2Adet,int biletTuru1) { 
		if(tur1Adet!=0 || tur2Adet!=0 || biletTuru1!=0) {
			if(OperaSayac!=0 & biletTuru1==0){
				for(int i = 1;i<=OperaSayac;i++){
					if (i%tur1Adet==0){
						totalPrice-=(tur2Adet*Biletler.Opera.getPrice());
						kampanyaSayac+=1;
						}
					}
				System.out.println("Opera biletinde "+tur1Adet*kampanyaSayac+" al "+tur2Adet*kampanyaSayac+" öde kampanyası uygulandı.");
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
				}
			else if(SinemaSayac!=0 & biletTuru1==1){
				for(int i = 1;i<=SinemaSayac;i++){
					if (i%tur1Adet==0){
						totalPrice-=(tur2Adet*Biletler.Sinema.getPrice());
						kampanyaSayac+=1;
						}
					}
				System.out.println("Sinema biletinde "+tur1Adet*kampanyaSayac+" al "+tur2Adet*kampanyaSayac+" öde kampanyası uygulandı.");
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
				}
			if(BungeeSayac!=0 & biletTuru1==2){
				for(int i = 1;i<=BungeeSayac;i++){
					if (i%tur1Adet==0){
						totalPrice-=(tur2Adet*Biletler.Bungee.getPrice());
						kampanyaSayac+=1;
						}
					}
				System.out.println("Bungee Jumping biletinde "+tur1Adet*kampanyaSayac+" al "+tur2Adet*kampanyaSayac+" öde kampanyası uygulandı.");
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
				}	
		}
		else {
			System.out.println("Eklenen kampanya bulunamadı.(1)");
			}
	}
	
	public void kampanyaEkle2(int tur1Adet, int tur2Adet, int biletTuru1, int biletTuru2) {
		if (biletTuru1==0 & biletTuru2==1) {
			if (SinemaSayac!=0 & OperaSayac!=0){
				totalPrice=totalPrice-(tur2Adet*Biletler.Sinema.getPrice());
				System.out.println(tur1Adet+" adet Opera bileti alana "+tur2Adet+" tane Sinema bileti bedava kampanyası uygulandı.");
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}
		}
		else if (biletTuru1==1 & biletTuru2==0) {
			if (SinemaSayac!=0 & OperaSayac!=0){
				totalPrice=totalPrice-(tur2Adet*Biletler.Opera.getPrice());
				System.out.println(tur1Adet+" adet Sinema bileti alana "+tur2Adet+" tane Opera bileti bedava kampanyası uygulandı.");
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}
		}
		else if (biletTuru1==1 & biletTuru2==2) {
			if (SinemaSayac!=0 & BungeeSayac!=0){
				totalPrice=totalPrice-(tur2Adet*Biletler.Bungee.getPrice());
				System.out.println(tur1Adet+" adet Sinema bileti alana "+tur2Adet+" tane Bungee Jumping bileti bedava kampanyası uygulandı.");
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}
		}
		else if (biletTuru1==2 & biletTuru2==1) {
			if (SinemaSayac!=0 & BungeeSayac!=0){
				totalPrice=totalPrice-(tur2Adet*Biletler.Sinema.getPrice());
				System.out.println(tur1Adet+" adet Bungee Jumping bileti alana "+tur2Adet+" tane Sinema bileti bedava kampanyası uygulandı.");
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}
		}
		else if (biletTuru1==0 & biletTuru2==2) {
			if (BungeeSayac!=0 & OperaSayac!=0){
				totalPrice=totalPrice-(tur2Adet*Biletler.Bungee.getPrice());
				System.out.println(tur1Adet+" adet Opera bileti alana "+tur2Adet+" tane Bungee Jumping bileti bedava kampanyası uygulandı.");
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}
		}
		else if (biletTuru1==2 & biletTuru2==0) {
			if (BungeeSayac!=0 & OperaSayac!=0){
				totalPrice=totalPrice-(tur2Adet*Biletler.Opera.getPrice());
				System.out.println(tur1Adet+" adet Bungee Jumping bileti alana "+tur2Adet+" tane Opera bileti bedava kampanyası uygulandı.");
				System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
			}
		}
		else {
			System.out.println("Eklenen kampanya bulunamadı.(2)");
		}
	}
	
	public void kampanyaEkle3(int tur1Adet, int tur2Adet, int biletTuru1, int biletTuru2, int indirimTutari) {
		if(biletTuru1==2 & biletTuru2==1) {
			if (SinemaSayac!=0 & BungeeSayac!=0){
				totalPrice-=(tur2Adet*indirimTutari);
				System.out.println(tur1Adet+" adet Bungee Jumping bileti alana "+tur2Adet+" tane Sinema biletinde "+indirimTutari+"$ indirim kampanyası uygulandı.");
			}
		}
		else if(biletTuru1==1 & biletTuru2==2) {
			if (SinemaSayac!=0 & BungeeSayac!=0){
				totalPrice-=(tur2Adet*indirimTutari);
				System.out.println(tur1Adet+" adet Sinema bileti alana "+tur2Adet+" tane Bungee biletinde "+indirimTutari+"$ indirim kampanyası uygulandı.");
			}
		}
		else if(biletTuru1==0 & biletTuru2==1) {
			if (SinemaSayac!=0 & OperaSayac!=0){
				totalPrice-=(tur2Adet*indirimTutari);
				System.out.println(tur1Adet+" adet Opera bileti alana "+tur2Adet+" tane Sinema biletinde "+indirimTutari+"$ indirim kampanyası uygulandı.");
			}
		}
		else if(biletTuru1==1 & biletTuru2==0) {
			if (SinemaSayac!=0 & OperaSayac!=0){
				totalPrice-=(tur2Adet*indirimTutari);
				System.out.println(tur1Adet+" adet Sinema bileti alana "+tur2Adet+" tane Opera biletinde "+indirimTutari+"$ indirim kampanyası uygulandı.");
			}
		}
		else if(biletTuru1==0 & biletTuru2==2) {
			if (OperaSayac!=0 & BungeeSayac!=0){
				totalPrice-=(tur2Adet*indirimTutari);
				System.out.println(tur1Adet+" adet Opera bileti alana "+tur2Adet+" tane Bungee biletinde "+indirimTutari+"$ indirim kampanyası uygulandı.");
			}
		}
		else if(biletTuru1==2 & biletTuru2==0) {
			if (OperaSayac!=0 & BungeeSayac!=0){
				totalPrice-=(tur2Adet*indirimTutari);
				System.out.println(tur1Adet+" adet Bungee bileti alana "+tur2Adet+" tane Opera biletinde "+indirimTutari+"$ indirim kampanyası uygulandı.");
			}
		}
		else {
			System.out.println("Eklenen kampanya bulunamadı.(3)");
		}
		System.out.println("Yeni kampanyalı fiyat : "+totalPrice+"$");
	}
	
	private enum Biletler { // Biletleri private enum olarak tanımladık.Hiçbir şekilde fiyatları ve isimleri değişmeyecek.
		Opera(300),
		Sinema(30),
		Bungee(100);
		
		private final int price; 
		
		Biletler(int price) {  // Biletlerin fiyatını belirlemek için int türünde bir Constructor tanımlıyoruz.
			this.price = price;
		}
		
		public int getPrice(){ // Biletlerin fiyatlarını elde etmek için getPrice methodu
			
			return this.price;  // Bilet fiyatlarını döndürüyor.
		}
	}
	
	public void add() { // Satın alınan biletleri belirleyen add methodu
		System.out.println("Kaç adet Opera bileti satın almak istiyorsunuz?");
		@SuppressWarnings("resource")
		Scanner opSay = new Scanner(System.in);
		OperaSayac = opSay.nextInt();    // Opera bilet sayısı
		int operaFiyat = Biletler.Opera.getPrice(); // Fiyatını elde edip
		arrList.add((OperaSayac)*(operaFiyat));  // Listeye ekledik.
		System.out.println("Kaç adet Sinema bileti satın almak istiyorsunuz?");
		@SuppressWarnings("resource")
		Scanner sinSay = new Scanner(System.in);
		SinemaSayac = sinSay.nextInt();	   // Sinema bilet sayısı
		int sinemaFiyat = Biletler.Sinema.getPrice(); // Fiyatını elde edip
		arrList.add((SinemaSayac)*(sinemaFiyat));  // Listeye ekledik.
		System.out.println("Kaç adet Bungee bileti satın almak istiyorsunuz?");
		@SuppressWarnings("resource")
		Scanner bunSay = new Scanner(System.in);
		BungeeSayac = bunSay.nextInt();  // Bungee Jumping bilet sayısı
		int bungeeFiyat = Biletler.Bungee.getPrice(); // Fiyatını elde edip
		arrList.add((BungeeSayac)*(bungeeFiyat));  // Listeye ekledik.
	}
	
	public void total(){ // Toplam ödenmesi gereken fiyatı belirleyen total methodumuz
		val1 = arrList.get(0);  // Listenin 0. Elemanı Opera biletlerinin toplamı
		val2 = arrList.get(1);  // Listenin 1. Elemanı Sinema biletlerinin toplamı
		val3 = arrList.get(2);  // Listenin 2. Elemanı Bungee Jumping biletlerinin toplamı
		totalPrice = (val1+val2+val3);	
	}
	
public static void main(String []args) {
	ShoppingCart biletlerim = new ShoppingCart();
	System.out.println("Lütfen mevcut kampanyalarla satın alma işlemi için 101,"+System.lineSeparator()+"Yeni kampanyalarla satın alma işlemi için 202 yi tuşlayınız."+System.lineSeparator()+"Giriş kodu : ");
	@SuppressWarnings("resource")
	Scanner islemNo1 = new Scanner(System.in);
	String islemNo = islemNo1.nextLine();
	
	switch(islemNo){  // Menu de yapılacak switch işlemi
	case "101":  //101 girilirse
		biletlerim.add();
		biletlerim.total();
		biletlerim.mevcut1();
		biletlerim.mevcut2();
		biletlerim.mevcut3();
		break;
		
	case "202": //202 girilirse
		biletlerim.add();
		biletlerim.total();
		biletlerim.kampanyaEkle1(0, 0, 0);
		biletlerim.kampanyaEkle2(0, 0, 0, 0);
		biletlerim.kampanyaEkle3(2, 3, 1, 0, 100);
		
		break;
		
	default: // Hatalı giriş yapılırsa
		System.out.println("Eksik veya hatalı bir giriş yaptınız.");
		break;
		}
	}
}
