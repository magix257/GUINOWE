import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Notatnik2 extends JFrame implements ActionListener 
{

JLabel label1;
JButton bSzukaj;
JPopupMenu popup;
JMenu menuPlik, menuNarz�dzia, menuNarz�dziaJ�zyk, menuPomoc;
JMenuItem mOtw�rz, mZapisz, mWyj�cie, mNarz1, mNarz2, mNarzJ�z1, mpKopiuj, mpWklej, mpDo��cz, mOProgramie;
JCheckBoxMenuItem mNarzJ�z2;
JTextField tSzukany;
JTextArea notepad;
JScrollPane scrollPane;

public Notatnik2()
{
	
	setTitle("Notatnik");
	setSize(800,600);setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(null);
	
	
	JMenuBar menuBar = new JMenuBar();
	
	menuPlik = new JMenu("Plik");
	mOtw�rz = new JMenuItem("Otw�rz", 'O');
	mOtw�rz.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
	mOtw�rz.addActionListener(this);
	
	mZapisz = new JMenuItem("Zapisz");
	mZapisz.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
	mOtw�rz.addActionListener(this);
	
	mWyj�cie = new JMenuItem("Wyj�cie");
	mWyj�cie.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));
	mWyj�cie.addActionListener(this);
	
	menuPlik.add(mOtw�rz);
	menuPlik.add(mZapisz);
	menuPlik.addSeparator();
	menuPlik.add(mWyj�cie);
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
