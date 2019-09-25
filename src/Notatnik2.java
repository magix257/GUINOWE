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
JMenu menuPlik, menuNarz�dzia, menuNarz�dziaJ�zyk, menuPomoc;
JMenuItem mOtw�rz, mZapisz, mWyj�cie, mNarz1, mNarz2, mNarzJ�z1, mpKopiuj, mpWklej, mpDo��cz, mOProgramie;
JCheckBoxMenuItem mNarzJ�z2;
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
	
	menuNarz�dzia = new JMenu("Narz�dzia");
	mNarz1 = new JMenuItem("Narz�dzia1");
	mNarz1.setEnabled(false);
	mNarz2 = new JMenuItem("Narz�dzia2");
		menuNarz�dziaJ�zyk = new JMenu("J�zyk");
		mNarzJ�z1 = new JMenuItem("J�zyk1");
		mNarzJ�z2 = new JCheckBoxMenuItem("J�zyk2");
		mNarzJ�z2.addActionListener(this);
		menuNarz�dziaJ�zyk.add(mNarzJ�z1);
		menuNarz�dziaJ�zyk.add(mNarzJ�z2);
	menuNarz�dzia.add(mNarz1);
	menuNarz�dzia.add(mNarz2);
	menuNarz�dzia.add(menuNarz�dziaJ�zyk);
	
	menuPomoc = new JMenu("Pomoc");
	mOProgramie = new JMenuItem("OProgramie");
	
	menuBar.add(menuPlik);
	menuBar.add(menuNarz�dzia);
	menuBar.add(menuNarz�dziaJ�zyk);
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
	mpDo��cz = new JMenuItem("Do��cz");
	mpDo��cz.addActionListener(this);
	
	popup.add(mpKopiuj);
	popup.add(mpWklej);
	popup.add(mpDo��cz);
	
	notepad.setComponentPopupMenu(popup);
	
	
	
}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String ca�o�� = "";
		Object z = e.getSource();
		
		if (z==mWyj�cie)
		{
			int w = JOptionPane.showConfirmDialog(this, "Czy na pewno zamkn�� ?", "Pytanie", JOptionPane.YES_NO_OPTION);
			if (w==JOptionPane.YES_OPTION)
				dispose();
		}
		
		else if (z==mOProgramie)
		{
			JOptionPane.showConfirmDialog(null, "To jest program demonstruj�cy JMenu \n wersja 1.0", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if (z==mOtw�rz)
		{
			JFileChooser fc = new JFileChooser();
			if (fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
			{
				File plik = fc.getSelectedFile();
				
					Scanner skaner;
					try {
						skaner = new Scanner(plik);
						ca�o��="";
						while (skaner.hasNext())
						{
							String wiersz = skaner.nextLine();
							ca�o�� = ca�o�� + wiersz;
						notepad.append(wiersz + "\n");
						}
						System.out.println(ca�o��);
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
				ca�o��=notepad.getText();
				Scanner skaner = new Scanner(ca�o��);
				while(skaner.hasNext())
				{
					out.println(skaner.hasNextLine());
				}
				System.out.print(ca�o��);
				
				JOptionPane.showMessageDialog(this, ca�o��);
				
				out.close();
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
		}
		else if (z==mNarzJ�z2)
		{
			if (mNarzJ�z2.isSelected())
				mNarz1.setEnabled(true);
			else
				mNarz1.setEnabled(false);
		}
		
		else if (z==bSzukaj)
		{
			String tekst = notepad.getText();
			String szukane = tSzukany.getText();
			String wyst�pienia = "";
			int i = 0;
			int index;
			int startIndex = 0;
			while ((index = tekst.indexOf(szukane, startIndex)) != -1)
			{
				
				startIndex = index + szukane.length();
				i++;
				wyst�pienia = wyst�pienia + " " + index;
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
		else if (z==mpDo��cz)
		{
			notepad.append("\n" + wybranyTekst);
		}
	}

	public static void main(String[] args) {
		Notatnik2 rameczka = new Notatnik2();
		rameczka.setVisible(true);
	}
}
