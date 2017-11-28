import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Menu {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(1024, 768);
		shell.setText("Ana Ekran  - Hastane Otomasyon - faskN Software v1.0");
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(187, 0, 26, 729);
		
		Button btnNewButton = new Button(shell, SWT.NONE);

		btnNewButton.setBounds(10, 10, 171, 25);
		btnNewButton.setText("Hasta Ekle");
		
		Button btnHastaBilgi = new Button(shell, SWT.NONE);
		btnHastaBilgi.setText("Hasta Bilgi");
		btnHastaBilgi.setBounds(10, 41, 171, 25);
		
		Button btnMuayne = new Button(shell, SWT.NONE);
		btnMuayne.setText("Hasta Listesi");
		btnMuayne.setBounds(10, 72, 171, 25);
		
		Button btnHastaArama = new Button(shell, SWT.NONE);
		btnHastaArama.setText("Hasta Arama");
		btnHastaArama.setBounds(10, 103, 171, 25);
		
		Button btnDoktorListesi = new Button(shell, SWT.NONE);
		btnDoktorListesi.setText("Doktor Listesi");
		btnDoktorListesi.setBounds(10, 227, 171, 25);
		
		Button btnDoktorBilgi = new Button(shell, SWT.NONE);
		
		btnDoktorBilgi.setText("Doktor Bilgi");
		btnDoktorBilgi.setBounds(10, 196, 171, 25);
		
		Button btnDoktorEkle = new Button(shell, SWT.NONE);
		btnDoktorEkle.setText("Doktor Ekle");
		btnDoktorEkle.setBounds(10, 165, 171, 25);
		
		Button btnRandevu = new Button(shell, SWT.NONE);
		btnRandevu.setText("Randevu");
		btnRandevu.setBounds(10, 134, 171, 25);
		
		Button btnBranListesi = new Button(shell, SWT.NONE);
		btnBranListesi.setText("Bran\u015F Listesi");
		btnBranListesi.setBounds(10, 351, 171, 25);
		
		Button btnBranlar = new Button(shell, SWT.NONE);
		btnBranlar.setText("Bran\u015F Bilgi");
		btnBranlar.setBounds(10, 320, 171, 25);
		
		Button btnTanEkle = new Button(shell, SWT.NONE);
		btnTanEkle.setText("Bran\u015F Ekle");
		btnTanEkle.setBounds(10, 289, 171, 25);
		
		Button btnDoktorArama = new Button(shell, SWT.NONE);
		btnDoktorArama.setText("Doktor Arama");
		btnDoktorArama.setBounds(10, 258, 171, 25);
		
		Button button_11 = new Button(shell, SWT.NONE);
		button_11.setText("New Button");
		button_11.setBounds(10, 475, 171, 25);
		
		Button btnHastak = new Button(shell, SWT.NONE);
		btnHastak.setText("Hasta \u00C7\u0131k\u0131\u015F");
		btnHastak.setBounds(10, 444, 171, 25);
		
		Button btnReete = new Button(shell, SWT.NONE);
		btnReete.setText("Re\u00E7ete");
		btnReete.setBounds(10, 413, 171, 25);
		
		Button btnBranArama = new Button(shell, SWT.NONE);
		btnBranArama.setText("Bran\u015F Arama");
		btnBranArama.setBounds(10, 382, 171, 25);
		
		Button button_15 = new Button(shell, SWT.NONE);
		button_15.setText("New Button");
		button_15.setBounds(10, 599, 171, 25);
		
		Button button_16 = new Button(shell, SWT.NONE);
		button_16.setText("New Button");
		button_16.setBounds(10, 568, 171, 25);
		
		Button button_17 = new Button(shell, SWT.NONE);
		button_17.setText("New Button");
		button_17.setBounds(10, 537, 171, 25);
		
		Button button_18 = new Button(shell, SWT.NONE);
		button_18.setText("New Button");
		button_18.setBounds(10, 506, 171, 25);
		
		Button btnBranSil = new Button(shell, SWT.NONE);
		btnBranSil.setText("Bran\u015F Sil");
		btnBranSil.setBounds(10, 692, 171, 25);
		
		Button btnDoktorSil = new Button(shell, SWT.NONE);
		btnDoktorSil.setText("Doktor Sil");
		btnDoktorSil.setBounds(10, 661, 171, 25);
		
		Button btnHastaSil = new Button(shell, SWT.NONE);
		btnHastaSil.setText("Hasta Sil");
		btnHastaSil.setBounds(10, 630, 171, 25);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
