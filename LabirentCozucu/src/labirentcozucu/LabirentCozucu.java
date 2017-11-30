package labirentcozucu;

public class LabirentCozucu {

	public int sayac = 0;
	boolean ileriadim=true;
	boolean geriadim=false;
	boolean bitti=true;

	public char[][] labirent =
		   			{{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
					{'1', '0', '1', '1', '1', '5', '0', '0', '1', '1'},
					{'1', '0', '0', '1', '1', '0', '1', '0', '1', '1'},
					{'1', '0', '1', '0', '1', '0', '1', '0', '1', '1'},
					{'1', '0', '0', '0', '0', '0', '1', '0', '0', '1'},
					{'1', '1', '1', '0', '1', '0', '1', '1', '1', '1'},
					{'1', '1', '1', '0', '1', '0', '1', '0', '0', '1'},
					{'1', '0', '0', '0', '0', '0', '1', '0', '1', '1'},
					{'1', '0', '1', '0', '1', '0', '0', '0', '1', '1'},
					{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},};

	// Başlangıç koordinatlarını al(x,y) ve S olarak belirle.
	
	public void coz(int x, int y) {
		if (adim(x, y)) {
			labirent[x][y] = 'S';
		}
		else {
			System.out.println("Bu labirentin bir çıkışı yok!");
			
		}
		
	}

	// Backtracking algoritması

	public boolean adim(int x, int y) {

		sayac++;
		boolean dene;

		// Bitiş noktası
		if (labirent[x][y] == 'F') {
			
			// bitişe gelince true döndür
			return bitti;
		}

		// Duvara gitme ve geldiğin yere geri dönme!
		if (labirent[x][y] == '1' || labirent[x][y] == 'X' || labirent[x][y] == '2') {
			return geriadim;
		}

		// Doğru yolu işaretle
		labirent[x][y] = 'X';

		// Sağa gitmeyi dene
		dene = adim(x, y + 1);
		if (dene) {
			return ileriadim;
		}

		// Yukarı gitmeyi dene
		dene = adim(x - 1, y);
		if (dene) {
			return ileriadim;
		}

		// Sola gitmeyi dene
		dene = adim(x, y - 1);
		if (dene) {
			return ileriadim;
		}

		// Aşağı gitmeyi dene
		dene = adim(x + 1, y);
		if (dene) {
			return ileriadim;
		}

		// Yol kapalıysa 2 yap
		labirent[x][y] = '2';

		// Geri dön
		return geriadim;
	}

	public String toString() {
		String output = "";
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				output += labirent[x][y] + "  ";
			}
			output += "\n";
			output += "\n";
		}
		return output;
	}

	public static void main(String[] args) {
		
		LabirentCozucu m = new LabirentCozucu();
		
		// Çıkışı belirle
		m.labirent[1][1] = 'F';

		// Çözmeye şu noktadan başla (7 , 2)
		m.coz(7, 2);
		System.out.println(m);
		System.out.println("Toplam kaç adımda sonuca ulaştı ?: " + m.sayac);

	}

}