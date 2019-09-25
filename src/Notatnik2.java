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
JMenu menuPlik, menuNarzêdzia, menuNarzêdziaJêzyk, menuPomoc;
JMenuItem mOtwórz, mZapisz, mWyjœcie, mNarz1, mNarz2, mNarzJêz1, mpKopiuj, mpWklej, mpDo³¹cz, mOProgramie;
JCheckBoxMenuItem mNarzJêz2;
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
	mOtwórz = new JMenuItem("Otwórz", 'O');
	mOtwórz.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
	mOtwórz.addActionListener(this);
	
	mZapisz = new JMenuItem("Zapisz");
	mZapisz.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
	mOtwórz.addActionListener(this);
	
	mWyjœcie = new JMenuItem("Wyjœcie");
	mWyjœcie.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));
	mWyjœcie.addActionListener(this);
	
	menuPlik.add(mOtwórz);
	menuPlik.add(mZapisz);
	menuPlik.addSeparator();
	menuPlik.add(mWyjœcie);
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
