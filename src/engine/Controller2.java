package engine;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import exceptions.FullHandException;
import model.heroes.Hero;
import model.heroes.Hunter;
import model.heroes.Mage;
import model.heroes.Paladin;
import model.heroes.Priest;
import model.heroes.Warlock;
import GUI.SecondWindow;

public class Controller2 implements ActionListener{
private Hero hero1;
private Hero hero2;
//private Game model;
//private ArrayList<JButton> player1heroes = new ArrayList<JButton>();
    //private ArrayList<JButton> player2heroes = new ArrayList<JButton>();
private SecondWindow view;
    private boolean flagPlayer1choosen;
    //private Hero hero1;
    //private Hero player2;

    public Controller2(){
    view = new SecondWindow();
    view.getMage().addActionListener(this);
    view.getHunter().addActionListener(this);
    view.getPaladin().addActionListener(this);
    view.getPriest().addActionListener(this);
    view.getWarlock().addActionListener(this);
    view.getMage2().addActionListener(this);
    view.getHunter2().addActionListener(this);
    view.getPaladin2().addActionListener(this);
    view.getPriest2().addActionListener(this);
    view.getWarlock2().addActionListener(this);
    view.getPlay().addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
    JButton b = (JButton) (e.getSource());
        if(b.getActionCommand().equals("Mage") && flagPlayer1choosen==false){
        try {
          hero1=new Mage();
            } catch (IOException | CloneNotSupportedException e1) {
// TODO Auto-generated catch block
            	JOptionPane.showMessageDialog(null, e1.getMessage());
}
        flagPlayer1choosen=true;
        }
        else if(b.getActionCommand().equals("Hunter") && flagPlayer1choosen==false){
        try {
            hero1=new Hunter();
            } catch (IOException | CloneNotSupportedException e1) {
// TODO Auto-generated catch block
            	JOptionPane.showMessageDialog(null, e1.getMessage());
}
        flagPlayer1choosen=true;
        }
        else if(b.getActionCommand().equals("Paladin") && flagPlayer1choosen==false){
        try {
            hero1=new Paladin();
             } catch (IOException | CloneNotSupportedException e1) {
// TODO Auto-generated catch block
            	 JOptionPane.showMessageDialog(null, e1.getMessage());
       }
        flagPlayer1choosen=true;
        }
        else if(b.getActionCommand().equals("Priest") && flagPlayer1choosen==false){
        try {
              hero1=new Priest();
            } catch (IOException | CloneNotSupportedException e1) {
// TODO Auto-generated catch block
            	JOptionPane.showMessageDialog(null, e1.getMessage());
         }
        flagPlayer1choosen=true;
        }
        else if(b.getActionCommand().equals("Warlock") && flagPlayer1choosen==false){
        try {
             hero1=new Warlock();
           } catch (IOException | CloneNotSupportedException e1) {
          // TODO Auto-generated catch block
        	   JOptionPane.showMessageDialog(null, e1.getMessage());
           }
        flagPlayer1choosen=true;     
        }
        else  if(b.getActionCommand().equals("Mage2") && flagPlayer1choosen==true){
        try {
          hero2=new Mage();
             } catch (IOException | CloneNotSupportedException e1) {
           // TODO Auto-generated catch block
            	 JOptionPane.showMessageDialog(null, e1.getMessage());
         }
       
        }
        else if(b.getActionCommand().equals("Hunter2") && flagPlayer1choosen==true){
        try {
         hero2=new Hunter();
          } catch (IOException | CloneNotSupportedException e1) {
// TODO Auto-generated catch block
        	  JOptionPane.showMessageDialog(null, e1.getMessage());
              }
       
        }
        else if(b.getActionCommand().equals("Paladin2") && flagPlayer1choosen==true){
        try {
          hero2=new Paladin();
            } catch (IOException | CloneNotSupportedException e1) {
       // TODO Auto-generated catch block
            	JOptionPane.showMessageDialog(null, e1.getMessage());
         }
       
        }
        else if(b.getActionCommand().equals("Priest2") && flagPlayer1choosen==true){
        try {
           hero2=new Priest();
          } catch (IOException | CloneNotSupportedException e1) {
          // TODO Auto-generated catch block
        	  JOptionPane.showMessageDialog(null, e1.getMessage());
}
       
        }
        else if(b.getActionCommand().equals("Warlock2") && flagPlayer1choosen==true){
        try {
            hero2=new Warlock();
      } catch (IOException | CloneNotSupportedException e1) {
// TODO Auto-generated catch block
    	  JOptionPane.showMessageDialog(null, e1.getMessage());
           }
       
        }
        else if(hero1==null)
        	JOptionPane.showMessageDialog(null, "Choose player1 first");
        else if(hero2==null)
        	JOptionPane.showMessageDialog(null, "Choose player2!");
        else if(b.getActionCommand().equals("Lets Play")) {
        view.setVisible(false);
        try {
        Controller c1 = new Controller(hero1,hero2);
        } catch (FullHandException | CloneNotSupportedException | IOException x) {
        // TODO Auto-generated catch block
        	JOptionPane.showMessageDialog(null, x.getMessage());
        }
        }
     //   else if(hero1==null)
       // 	JOptionPane.showMessageDialog(null, "Choose player1 first");
       // else
        //	JOptionPane.showMessageDialog(null, "Choose player2!");
   
        view.revalidate();
        view.repaint();
       
        /*if(b.getActionCommand().equals("Lets Play")){
       
        }*/
    }
    public static void main(String[] args) {
Controller2 c2 = new Controller2();


    }
public Hero getHero1() {
return hero1;
}
public Hero getHero2() {
return hero2;
}
}
