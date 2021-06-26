package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import model.cards.minions.Minion;

public class SecondWindow extends JFrame{

private JButton Mage;
private JButton Hunter;
private JButton Warlock;
private JButton Priest;
private JButton Paladin;
private JButton Mage2;
private JButton Hunter2;
private JButton Warlock2;
private JButton Priest2;
private JButton Paladin2;
private JPanel upperpart;
private JPanel lowerpart;
private JPanel Player1Part;
private JPanel Player2Part;
private JTextArea choosetoppart;
private JTextArea choosebotpart;
private JTextArea chooselowpart;
private JButton play;
public SecondWindow(){
super();
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
setSize(screenSize.width,screenSize.height);
setDefaultCloseOperation(EXIT_ON_CLOSE);

Player1Part=new JPanel();
Player1Part.setPreferredSize(new Dimension(getWidth(),getHeight()/3));
Player1Part.setBackground(Color.RED);
Player1Part.setLayout(new BorderLayout());
add(Player1Part,BorderLayout.NORTH);

upperpart = new JPanel();
upperpart.setPreferredSize(new Dimension(getWidth(),getHeight()/4));
upperpart.setBackground(Color.RED);
upperpart.setLayout(new GridLayout(0,5));
Player1Part.add(upperpart,BorderLayout.SOUTH);

choosetoppart = new JTextArea("PLAYER ONE PLEASE PICK A HERO");
choosetoppart.setPreferredSize(new Dimension(getWidth(),getHeight()/4));
choosetoppart.setFont(choosetoppart.getFont().deriveFont(40f));
   choosetoppart.setEditable(false);
Player1Part.add(choosetoppart,BorderLayout.NORTH);



Mage = new JButton("Mage");
Mage.setPreferredSize(new Dimension(100,100));
//Mage.setBackground(Color.GRAY);
Mage.setIcon(new ImageIcon("Jaina.png"));
Mage.setHorizontalTextPosition(SwingConstants.CENTER);
upperpart.add(Mage);

Hunter = new JButton("Hunter");
Hunter.setPreferredSize(new Dimension(100,100));
//Hunter.setBackground(Color.GRAY);
Hunter.setIcon(new ImageIcon("Rexxar.png"));
Hunter.setHorizontalTextPosition(SwingConstants.CENTER);
upperpart.add(Hunter);

Warlock = new JButton("Warlock");
Warlock.setPreferredSize(new Dimension(100,100));
//Warlock.setBackground(Color.GRAY);
Warlock.setIcon(new ImageIcon("Gul'dan.png"));
Warlock.setHorizontalTextPosition(SwingConstants.CENTER);
upperpart.add(Warlock);

Priest = new JButton("Priest");
Priest.setPreferredSize(new Dimension(100,100));
//Priest.setBackground(Color.GRAY);
Priest.setIcon(new ImageIcon("Anduin Wrynn.png"));
Priest.setHorizontalTextPosition(SwingConstants.CENTER);
upperpart.add(Priest);

Paladin = new JButton("Paladin");
Paladin.setPreferredSize(new Dimension(100,100));
//Paladin.setBackground(Color.GRAY);
Paladin.setIcon(new ImageIcon("Uther Lightbringer.png"));
Paladin.setHorizontalTextPosition(SwingConstants.CENTER);
upperpart.add(Paladin);


Player2Part = new JPanel();
Player2Part.setPreferredSize(new Dimension(getWidth(),getHeight()/2));
//Player2Part.setBackground(Color.RED);
Player2Part.setLayout(new BorderLayout());
add(Player2Part,BorderLayout.SOUTH);

chooselowpart = new JTextArea("PLAYER TWO PLEASE PICK A HERO");
chooselowpart.setPreferredSize(new Dimension(getWidth(),getHeight()/4));
chooselowpart.setFont(choosetoppart.getFont().deriveFont(40f));
   chooselowpart.setEditable(false);
Player2Part.add(chooselowpart,BorderLayout.NORTH);

lowerpart = new JPanel();
lowerpart.setPreferredSize(new Dimension(getWidth(),getHeight()/4));
//lowerpart.setBackground(Color.RED);
lowerpart.setLayout(new GridLayout(0,5));
Player2Part.add(lowerpart,BorderLayout.SOUTH);



Mage2 = new JButton("Mage2");
Mage2.setPreferredSize(new Dimension(100,100));
//Mage2.setBackground(Color.GRAY);
Mage2.setIcon(new ImageIcon("Jaina.png"));
Mage2.setHorizontalTextPosition(SwingConstants.CENTER);
lowerpart.add(Mage2);

Hunter2 = new JButton("Hunter2");
Hunter2.setPreferredSize(new Dimension(100,100));
//Hunter2.setBackground(Color.GRAY);
Hunter2.setIcon(new ImageIcon("Rexxar.png"));
Hunter2.setHorizontalTextPosition(SwingConstants.CENTER);
lowerpart.add(Hunter2);

Warlock2 = new JButton("Warlock2");
Warlock2.setPreferredSize(new Dimension(100,100));
//Warlock2.setBackground(Color.GRAY);
Warlock2.setIcon(new ImageIcon("Gul'dan.png"));
Warlock2.setHorizontalTextPosition(SwingConstants.CENTER);
lowerpart.add(Warlock2);

Priest2 = new JButton("Priest2");
Priest2.setPreferredSize(new Dimension(100,100));
//Priest2.setBackground(Color.GRAY);
Priest2.setIcon(new ImageIcon("Anduin Wrynn.png"));
Priest2.setHorizontalTextPosition(SwingConstants.CENTER);
lowerpart.add(Priest2);

Paladin2 = new JButton("Paladin2");
Paladin2.setPreferredSize(new Dimension(100,100));
//Paladin2.setBackground(Color.GRAY);
Paladin2.setIcon(new ImageIcon("Uther Lightbringer.png"));
Paladin2.setHorizontalTextPosition(SwingConstants.CENTER);
lowerpart.add(Paladin2);

play = new JButton("Lets Play");
play.setBackground(Color.YELLOW);
add(play);
this.revalidate();
this.repaint();
setVisible(true);
}
public static void main(String[] args) {
SecondWindow sw = new SecondWindow();
sw.setVisible(true);
}
public JButton getPlay() {
	return play;
}
public JButton getMage() {
	return Mage;
}
public JButton getHunter() {
	return Hunter;
}
public JButton getWarlock() {
	return Warlock;
}
public JButton getPriest() {
	return Priest;
}
public JButton getPaladin() {
	return Paladin;
}
public JButton getMage2() {
	return Mage2;
}
public JButton getHunter2() {
	return Hunter2;
}
public JButton getWarlock2() {
	return Warlock2;
}
public JButton getPriest2() {
	return Priest2;
}
public JButton getPaladin2() {
	return Paladin2;
}
public JPanel getUpperpart() {
	return upperpart;
}
public JPanel getLowerpart() {
	return lowerpart;
}
public JPanel getPlayer1Part() {
	return Player1Part;
}
public JPanel getPlayer2Part() {
	return Player2Part;
}
public JTextArea getChoosetoppart() {
	return choosetoppart;
}
public JTextArea getChoosebotpart() {
	return choosebotpart;
}
public JTextArea getChooselowpart() {
	return chooselowpart;
}
}
