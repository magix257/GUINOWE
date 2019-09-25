import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
String wybranyTekst;

public Notatnik2()
{
	
	setTitle("Notatnik");
	setSize(800,600);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
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
	
	menuNarzêdzia = new JMenu("Narzêdzia");
	mNarz1 = new JMenuItem("Narzêdzia1");
	mNarz1.setEnabled(false);
	mNarz2 = new JMenuItem("Narzêdzia2");
		menuNarzêdziaJêzyk = new JMenu("Jêzyk");
		mNarzJêz1 = new JMenuItem("Jêzyk1");
		mNarzJêz2 = new JCheckBoxMenuItem("Jêzyk2");
		mNarzJêz2.addActionListener(this);
		menuNarzêdziaJêzyk.add(mNarzJêz1);
		menuNarzêdziaJêzyk.add(mNarzJêz2);
	menuNarzêdzia.add(mNarz1);
	menuNarzêdzia.add(mNarz2);
	menuNarzêdzia.add(menuNarzêdziaJêzyk);
	
	menuPomoc = new JMenu("Pomoc");
	mOProgramie = new JMenuItem("OProgramie");
	
	menuBar.add(menuPlik);
	menuBar.add(menuNarzêdzia);
	menuBar.add(menuNarzêdziaJêzyk);
	menuBar.add(menuPomoc);
	
	notepad = new JTextArea();
	//notepad.setLineWrap(true);
	
	scrollPane = new JScrollPane(notepad);
	scrollPane.setBounds(50,50,400,400);
	add(scrollPane);
	
	tSzukany = new JTextField();
	tSzukany.setBounds(50,500,100,20);
	add(tSzukany);
	
	bSzukaj = new JButton("Szukaj");
	bSzukaj.setBounds(200,500,100,20);
	add(bSzukaj);
	bSzukaj.addActionListener(this);
	
	popup = new JPopupMenu();
	mpKopiuj = new JMenuItem("Kopiuj");
	mpKopiuj.addActionListener(this);
	mpWklej = new JMenuItem("Wklej");
	mpWklej.addActionListener(this);
	mpDo³¹cz = new JMenuItem("Do³¹cz");
	mpDo³¹cz.addActionListener(this);
	
	popup.add(mpKopiuj);
	popup.add(mpWklej);
	popup.add(mpDo³¹cz);
	
	notepad.setComponentPopupMenu(popup);
	
	
	
}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String ca³oœæ = "";
		Object z = e.getSource();
		
		if (z==mWyjœcie)
		{
			int w = JOptionPane.showConfirmDialog(this, "Czy na pewno zamkn¹æ ?", "Pytanie", JOptionPane.YES_NO_OPTION);
			if (w==JOptionPane.YES_OPTION)
				dispose();
		}
		
		else if (z==mOProgramie)
		{
			JOptionPane.showConfirmDialog(null, "To jest program demonstruj¹cy JMenu \n wersja 1.0", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if (z==mOtwórz)
		{
			JFileChooser fc = new JFileChooser();
			if (fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
			{
				File plik = fc.getSelectedFile();
				
					Scanner skaner;
					try {
						skaner = new Scanner(plik);
						ca³oœæ="";
						while (skaner.hasNext())
						{
							String wiersz = skaner.nextLine();
							ca³oœæ = ca³oœæ + wiersz;
						notepad.append(wiersz + "\n");
						}
						System.out.println(ca³oœæ);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				 
				
			}
		}
		else if (z==mZapisz)
		{
		JFileChooser fc = new JFileChooser();
		if (fc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION)
		{
			PrintWriter out;
			try {
				out = new PrintWriter(fc.getSelectedFile());
				ca³oœæ=notepad.getText();
				Scanner skaner = new Scanner(ca³oœæ);
				while(skaner.hasNext())
				{
					out.println(skaner.hasNextLine());
				}
				System.out.print(ca³oœæ);
				
				JOptionPane.showMessageDialog(this, ca³oœæ);
				
				out.close();
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
		}
		else if (z==mNarzJêz2)
		{
			if (mNarzJêz2.isSelected())
				mNarz1.setEnabled(true);
			else
				mNarz1.setEnabled(false);
		}
		
		else if (z==bSzukaj)
		{
			String tekst = notepad.getText();
			String szukane = tSzukany.getText();
			String wyst¹pienia = "";
			int i = 0;
			int index;
			int startIndex = 0;
			while ((index = tekst.indexOf(szukane, startIndex)) != -1)
			{
				
				startIndex = index + szukane.length();
				i++;
				wyst¹pienia = wyst¹pienia + " " + index;
			}
			
		}
		
		else if (z==mpKopiuj)
		{
			wybranyTekst = notepad.getSelectedText();
		}
		
		else if (z==mpWklej)
		{
			notepad.insert(wybranyTekst, notepad.getCaretPosition());
		}
		else if (z==mpDo³¹cz)
		{
			notepad.append("\n" + wybranyTekst);
		}
	}

	public static void main(String[] args) {
		Notatnik2 rameczka = new Notatnik2();
		rameczka.setVisible(true);
	}
}
