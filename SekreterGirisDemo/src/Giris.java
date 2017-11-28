import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class Giris {

	protected Shell shell;
	private Text txtGirisID;
	private Text txtGirisSifre;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Giris window = new Giris();
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
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblHastaneOtomasyonunaHogeldiniz = new Label(shell, SWT.NONE);
		lblHastaneOtomasyonunaHogeldiniz.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblHastaneOtomasyonunaHogeldiniz.setBounds(10, 10, 378, 42);
		lblHastaneOtomasyonunaHogeldiniz.setText("Hastane Otomasyonuna Hoþgeldiniz.");
		
		Label lblKullancAdnz = new Label(shell, SWT.NONE);
		lblKullancAdnz.setBounds(79, 100, 138, 15);
		lblKullancAdnz.setText("Kullanýcý Adýnýz :");
		
		Label lblifreniz = new Label(shell, SWT.NONE);
		lblifreniz.setBounds(79, 135, 138, 15);
		lblifreniz.setText("Þifreniz :");
		
		txtGirisID = new Text(shell, SWT.BORDER);
		txtGirisID.setText("faskN");
		txtGirisID.setBounds(223, 100, 130, 21);
		
		txtGirisSifre = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		txtGirisSifre.setText("12345");
		txtGirisSifre.setBounds(223, 129, 130, 21);
		
		Button btnGiri = new Button(shell, SWT.NONE);
		btnGiri.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(txtGirisID.getText().equals("faskN") & txtGirisSifre.getText().equals("12345")) {
					JOptionPane.showMessageDialog(null, "Giriþ baþarýlý!", "Giriþ", 2);
				}else {
					JOptionPane.showMessageDialog(null, "Giriþ baþarýsýz!", "Giriþ", 0);
				}
			}
		});
		btnGiri.setBounds(278, 171, 75, 25);
		btnGiri.setText("Giriþ");

	}
}
