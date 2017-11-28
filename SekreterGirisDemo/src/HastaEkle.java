import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class HastaEkle {
	
	private String kullaniciAdi;
    private String sifre;
    private String isim;
    private String soyIsim;
    private String adres;
    private String telefon;
    private String cinsiyet;
    private String uyruk;
    private Text txtKullanici;
    private Text txtSifre;
    private Text txtIsim;
    private Text txtSoyisim;
    private Text txtAdres;
    private Text txtTelefon;
    private Text txtCinsiyet;
    private Text txtUyruk;
    
    
    public HastaEkle(){
    	
    }
	public HastaEkle(String kullaniciAdi, String sifre, String isim, String soyIsim, String adres, String telefon,String cinsiyet, String uyruk) {
		super();
		this.kullaniciAdi = kullaniciAdi;
		this.sifre = sifre;
		this.isim = isim;
		this.soyIsim = soyIsim;
		this.adres = adres;
		this.telefon = telefon;
		this.cinsiyet = cinsiyet;
		this.uyruk = uyruk;
	}

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyIsim() {
		return soyIsim;
	}

	public void setSoyIsim(String soyIsim) {
		this.soyIsim = soyIsim;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	public String getUyruk() {
		return uyruk;
	}

	public void setUyruk(String uyruk) {
		this.uyruk = uyruk;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HastaEkle window = new HastaEkle();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shlHastaEkle = new Shell();
		shlHastaEkle.setSize(663, 530);
		shlHastaEkle.setText("Hasta Ekle");
		
		Label lblKullancAd = new Label(shlHastaEkle, SWT.NONE);
		lblKullancAd.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblKullancAd.setBounds(57, 67, 140, 28);
		lblKullancAd.setText("Kullanýcý adý :");
		
		Label lblifre = new Label(shlHastaEkle, SWT.NONE);
		lblifre.setText("\u015Eifre              :");
		lblifre.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblifre.setBounds(57, 101, 118, 28);
		
		Label lblIsim = new Label(shlHastaEkle, SWT.NONE);
		lblIsim.setText("\u0130sim               :");
		lblIsim.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblIsim.setBounds(57, 135, 145, 28);
		
		Label lblSoyisim = new Label(shlHastaEkle, SWT.NONE);
		lblSoyisim.setText("Soyisim        :");
		lblSoyisim.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblSoyisim.setBounds(57, 169, 140, 28);
		
		Label lblAdres = new Label(shlHastaEkle, SWT.NONE);
		lblAdres.setText("Adres            :");
		lblAdres.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblAdres.setBounds(57, 203, 140, 28);
		
		Label lblTelefon = new Label(shlHastaEkle, SWT.NONE);
		lblTelefon.setText("Telefon          :");
		lblTelefon.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblTelefon.setBounds(57, 237, 128, 28);
		
		Label lblCinsiyet = new Label(shlHastaEkle, SWT.NONE);
		lblCinsiyet.setText("Cinsiyet         :");
		lblCinsiyet.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblCinsiyet.setBounds(57, 271, 140, 28);
		
		Label lblUyruk = new Label(shlHastaEkle, SWT.NONE);
		lblUyruk.setText("Uyruk            :");
		lblUyruk.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblUyruk.setBounds(57, 305, 140, 28);
		
		txtKullanici = new Text(shlHastaEkle, SWT.BORDER);
		txtKullanici.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		txtKullanici.setBounds(203, 74, 399, 21);
		
		txtSifre = new Text(shlHastaEkle, SWT.BORDER | SWT.PASSWORD);
		txtSifre.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		txtSifre.setBounds(203, 108, 399, 21);
		
		txtIsim = new Text(shlHastaEkle, SWT.BORDER);
		txtIsim.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		txtIsim.setBounds(203, 142, 399, 21);
		
		txtSoyisim = new Text(shlHastaEkle, SWT.BORDER);
		txtSoyisim.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		txtSoyisim.setBounds(203, 176, 399, 21);
		
		txtAdres = new Text(shlHastaEkle, SWT.BORDER);
		txtAdres.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		txtAdres.setBounds(203, 210, 399, 21);
		
		txtTelefon = new Text(shlHastaEkle, SWT.BORDER);
		txtTelefon.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		txtTelefon.setBounds(203, 244, 399, 21);
		
		txtCinsiyet = new Text(shlHastaEkle, SWT.BORDER);
		txtCinsiyet.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		txtCinsiyet.setBounds(203, 278, 399, 21);
		
		txtUyruk = new Text(shlHastaEkle, SWT.BORDER);
		txtUyruk.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		txtUyruk.setBounds(203, 312, 399, 21);
		
		Button btnHastaEkle = new Button(shlHastaEkle, SWT.NONE);
		btnHastaEkle.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				HastaEkle h1 = new HastaEkle(kullaniciAdi,sifre,isim,soyIsim,adres,telefon,cinsiyet,uyruk);
				h1.setKullaniciAdi(txtKullanici.getText());
				h1.setSifre(txtSifre.getText());
				h1.setIsim(txtIsim.getText());
				h1.setSoyIsim(txtSoyisim.getText());
				h1.setAdres(txtAdres.getText());
				h1.setCinsiyet(txtCinsiyet.getText());
				h1.setUyruk(txtUyruk.getText());
				System.out.println(h1.kullaniciAdi);
				System.out.println(h1.sifre);
				System.out.println(h1.isim);
				System.out.println(h1.soyIsim);
				System.out.println(h1.adres);
				System.out.println(h1.cinsiyet);
				System.out.println(h1.uyruk);
				
			}
		});
		btnHastaEkle.setBounds(57, 430, 545, 25);
		btnHastaEkle.setText("Hasta Ekle");

		shlHastaEkle.open();
		shlHastaEkle.layout();
		while (!shlHastaEkle.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
