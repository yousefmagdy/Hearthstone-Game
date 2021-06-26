package engine;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import model.cards.Card;
import model.cards.minions.Minion;
import model.cards.spells.AOESpell;
import model.cards.spells.FieldSpell;
import model.cards.spells.HeroTargetSpell;
import model.cards.spells.LeechingSpell;
import model.cards.spells.MinionTargetSpell;
import model.cards.spells.Spell;
import model.heroes.Hero;
import model.heroes.Hunter;
import model.heroes.Mage;
import model.heroes.Paladin;
import model.heroes.Priest;
import model.heroes.Warlock;
import exceptions.CannotAttackException;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;
import GUI.FirstWindow;
import GUI.SecondWindow;




public class Controller implements GameListener , ActionListener {
	//private Hero hero1;
	//private Hero hero2;
	private Game model;
	private FirstWindow view;
	//private SecondWindow view2;
    private ArrayList<JButton> buttons = new ArrayList<JButton>();
    private ArrayList<JButton> buttons2 = new ArrayList<JButton>();
    private ArrayList<JButton> buttons3 = new ArrayList<JButton>();
    private ArrayList<JButton> buttons4 = new ArrayList<JButton>();
    private ArrayList<JButton> buttons5 = new ArrayList<JButton>();
    private ArrayList<JButton> buttons6 = new ArrayList<JButton>();
    private Card selectedMinion;
    private boolean flagSpell;
    private boolean flagAttack;
    private JButton jA;
    private JButton j;
    private boolean flag1;
    private boolean flag2;
    private boolean flagHeroPower;
    private JButton JHeroPower;
    private int k;
    private Spell target;
    private boolean flag3;
    private boolean flag4;
    
    //private JButton clicked;
    
   // private JButton endturn = new JButton("EndTurn");
    
    public Controller(Hero hero1,Hero hero2) throws FullHandException, CloneNotSupportedException, IOException{
    	//view2 = new SecondWindow();
    	//hero1 = new Priest();
    	//hero2 = new Mage();
    	model = new Game(hero1,hero2);
    	model.setListener(this);
    	view = new FirstWindow();
    	ArrayList<Card> Curr = model.getCurrentHero().getDeck();
    	ArrayList<Card> Opp = model.getOpponent().getDeck();
    	ArrayList<Card> CurrHand = model.getCurrentHero().getHand();
    	ArrayList<Card> OppHand = model.getOpponent().getHand();
    	for(int i=0 ; i<Curr.size() ; i++){
    		JButton jb = new JButton();
        	JTextArea text = new JTextArea();
    		if(Curr.get(i) instanceof Minion){
    			text.append(((Minion)Curr.get(i)).toString());
    			text.setEditable(false);
    			jb.add(text);
    		}
    		else{
    			text.append(Curr.get(i).toString());
    			text.setEditable(false);
    			jb.add(text);
    		}
    		buttons.add(jb);
    	}
    	for(int i=0 ; i<Opp.size() ; i++){
        	JTextArea text = new JTextArea();
    		JButton jb = new JButton();
    		if(Opp.get(i) instanceof Minion){
    			text.append(((Minion)Opp.get(i)).toString());
    			text.setEditable(false);
    			jb.add(text);
    		}
    		else{
    			text.append(Opp.get(i).toString());
    			text.setEditable(false);
    			jb.add(text);
    		}
    		buttons2.add(jb);
    		jb.addActionListener(this);
    	}
    	for(int i=0 ; i<CurrHand.size() ;i++){
        	JTextArea text = new JTextArea();
    		JButton jb = new JButton();
    		if(CurrHand.get(i) instanceof Minion){
    			text.append(((Minion)CurrHand.get(i)).toString());
    			text.setEditable(false);
    			jb.add(text);
    		}
    		else{
    			text.append(CurrHand.get(i).toString());
    			text.setEditable(false);
    			jb.add(text);
    		}
			buttons3.add(jb);
			view.getCurrHand().add(jb);
    		jb.addActionListener(this);
    	}
    	for(int i=0 ; i<OppHand.size() ;i++){
        	JTextArea text = new JTextArea();
    		JButton jb = new JButton();
    		if(OppHand.get(i) instanceof Minion){
    			text.append(((Minion)OppHand.get(i)).toString());
    			text.setEditable(false);
    			//jb.add(text);
    		}
    		else{
    			text.append(OppHand.get(i).toString());
    			text.setEditable(false);
    			//jb.add(text);
    		}
    		//jb.addActionListener(this);
			buttons4.add(jb);
			view.getOppHand().add(jb);
    		jb.addActionListener(this);
    	}
    	view.getEndturn().addActionListener(this);
    	view.getUseHeroPower().addActionListener(this);
    	view.getUseOppPower().addActionListener(this);
       // view.getCurrHand().add(view.getEndturn());
    	String currentHPmana = "HP " + model.getCurrentHero().getCurrentHP() + "\n" 
    			           + "Mana " + model.getCurrentHero().getCurrentManaCrystals() + "/" + model.getCurrentHero().getTotalManaCrystals() + "\n"
    			        +  model.getCurrentHero().getName() + " DeckSize " + model.getCurrentHero().getDeck().size();
    	
    	view.getCurrentHPMana().setText(currentHPmana);
    	String opponentHPmana = "HP " + model.getOpponent().getCurrentHP() + "\n" 
		           + "Mana " + model.getOpponent().getCurrentManaCrystals() + "/" + model.getOpponent().getTotalManaCrystals() + "\n"
		           + model.getOpponent().getName()+ " DeckSize " + model.getOpponent().getDeck().size();
        view.getOppCurrentHPMana().setText(opponentHPmana);
        view.getOppHeroname().addActionListener(this);
        view.getHeroname().addActionListener(this);
    	view.revalidate();
		view.repaint();
    }
    //public void pSpell (Spell s){
    	//spell = true;
    	
    //}
    public void actionPerformed2(){
    	
        buttons3.clear();
        buttons4.clear();
        buttons5.clear();
        buttons6.clear();
        view.getCurrHand().removeAll();
        view.getOppHand().removeAll();
        view.getCurrentHPMana().removeAll();
        view.getOppCurrentHPMana().removeAll();
        view.getCurrField().removeAll();
        view.getOppField().removeAll();
        view.revalidate();
		 view.repaint();
		 String currentHPmana = "HP " + model.getCurrentHero().getCurrentHP() + "\n" 
		           + "Mana " + model.getCurrentHero().getCurrentManaCrystals() + "/" + model.getCurrentHero().getTotalManaCrystals() + "\n"
		           +  model.getCurrentHero().getName() + " DeckSize " + model.getCurrentHero().getDeck().size();
         view.getCurrentHPMana().setText(currentHPmana);
         String opponentHPmana = "HP " + model.getOpponent().getCurrentHP() + "\n" 
                   + "Mana " + model.getOpponent().getCurrentManaCrystals() + "/" + model.getOpponent().getTotalManaCrystals() + "\n"
                   +  model.getOpponent().getName() + " DeckSize " + model.getOpponent().getDeck().size();
         view.getOppCurrentHPMana().setText(opponentHPmana);
		for(int i=0 ; i<model.getCurrentHero().getHand().size() ;i++){
      	JTextArea text = new JTextArea();
   		JButton jb = new JButton();
   		if(model.getCurrentHero().getHand().get(i) instanceof Minion){
   			text.append(((Minion)model.getCurrentHero().getHand().get(i)).toString());
   			text.setEditable(false);
   			jb.add(text);
   		}
   		else{
   			text.append(model.getCurrentHero().getHand().get(i).toString());
   			text.setEditable(false);
   			jb.add(text);
   		}
			buttons3.add(jb);
			view.getCurrHand().add(jb);
	   		jb.addActionListener(this);
   	}
		for(int i=0 ; i<model.getOpponent().getHand().size() ;i++){
       	JTextArea text = new JTextArea();
   		JButton jb = new JButton();
   		if(model.getOpponent().getHand().get(i) instanceof Minion){
   			text.append(((Minion)model.getOpponent().getHand().get(i)).toString());
   			text.setEditable(false);
   			//jb.add(text);
   		}
   		else{
   			text.append(model.getOpponent().getHand().get(i).toString());
   			text.setEditable(false);
   			//jb.add(text);
   		}
			buttons4.add(jb);
			view.getOppHand().add(jb);
	   		jb.addActionListener(this);
   	}
		for(int i=0 ; i<model.getCurrentHero().getField().size() ;i++){
	      	JTextArea text = new JTextArea();
	   		JButton jb = new JButton();
	   		if(model.getCurrentHero().getField().get(i) instanceof Minion){
	   			text.append(((Minion)model.getCurrentHero().getField().get(i)).toString());
	   			text.setEditable(false);
	   			jb.add(text);
	   		}
	   		else{
	   			text.append(model.getCurrentHero().getField().get(i).toString());
	   			text.setEditable(false);
	   			jb.add(text);
	   		}
				buttons5.add(jb);
				view.getCurrField().add(jb);
		   		jb.addActionListener(this);
	   	}
		for(int i=0 ; i<model.getOpponent().getField().size() ;i++){
	      	JTextArea text = new JTextArea();
	   		JButton jb = new JButton();
	   		if(model.getOpponent().getField().get(i) instanceof Minion){
	   			text.append(((Minion)model.getOpponent().getField().get(i)).toString());
	   			text.setEditable(false);
	   			jb.add(text);
	   		}
	   		else{
	   			text.append(model.getOpponent().getField().get(i).toString());
	   			text.setEditable(false);
	   			jb.add(text);
	   		}
				buttons6.add(jb);
				view.getOppField().add(jb);
		   		jb.addActionListener(this);
	   	}
		if(model.getCurrentHero().getCurrentHP()==0 || model.getOpponent().getCurrentHP()==0)
			onGameOver();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) (e.getSource());
		for(int i=0 ; i<buttons3.size() ; i++){
			if(b==buttons3.get(i)){
				flag1=true;
				break;
			}
		}
		if(b.getActionCommand().equals("OpponentHero") && flagSpell ==false && flagAttack == false && flagHeroPower==false)
			JOptionPane.showMessageDialog(null, "No action to be performed!");
		else if(b.getActionCommand().equals("CurrentHero") && flagSpell ==false && flagAttack == false&&flagHeroPower==false)
			JOptionPane.showMessageDialog(null, "No action to be performed!");
		else if(b.getActionCommand().equals("END TURN")){
			try {
				model.endTurn();        
			} catch (FullHandException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage() + "\n" + e1.getBurned());
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
			actionPerformed2();
		}
		else  if(((model.getCurrentHero() instanceof Mage && flagHeroPower == true) ||
				(model.getCurrentHero() instanceof Mage && JHeroPower !=null) ||
				(model.getCurrentHero() instanceof Mage && b.getActionCommand().equals("HERO POWER1")))
				&& flag1==false){
			if(b.getActionCommand().equals("HERO POWER1") || JHeroPower !=null){
				if(flagHeroPower==false){
					JHeroPower = b;
					flagHeroPower=true;
				}
				else if (flagHeroPower==true){
					if(b.getActionCommand().equals("CurrentHero")){
					  try {
						((Mage) (model.getCurrentHero())).useHeroPower(model.getCurrentHero());
						 actionPerformed2();
					} catch (NotEnoughManaException
							| HeroPowerAlreadyUsedException
							| NotYourTurnException | FullHandException
							| FullFieldException | CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} 
						flag1=false;
						flag2=false;
						flagHeroPower=false;
						selectedMinion = null;
						JHeroPower = null;
					}
					else if(b.getActionCommand().equals("OpponentHero")){
						try {
							((Mage) (model.getCurrentHero())).useHeroPower(model.getOpponent());
						} catch (NotEnoughManaException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						} catch (HeroPowerAlreadyUsedException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						} catch (NotYourTurnException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						} catch (FullHandException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage() + "\n" + e1.getBurned());
						} catch (FullFieldException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						} catch (CloneNotSupportedException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						 actionPerformed2(); 
						flag1=false;
						flag2=false;
						flagHeroPower=false;
						selectedMinion = null;
						JHeroPower = null;
					}
					else{
					for(int i=0 ; i<buttons5.size() ; i++){
						if(b==buttons5.get(i)){
							flag1=true;
							break;
						}
					}
					for(int i=0 ; i<buttons6.size() ; i++){
						if(b==buttons6.get(i)){
							flag2=true;
							break;
						}
					}
					if(flag1==true){
						int r = buttons5.indexOf(b);
						selectedMinion = model.getCurrentHero().getField().get(r);
						try {
							((Mage) (model.getCurrentHero())).useHeroPower((Minion) selectedMinion);
							actionPerformed2();
						} catch (NotEnoughManaException
								| HeroPowerAlreadyUsedException
								| NotYourTurnException | FullHandException
								| FullFieldException
								| CloneNotSupportedException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						flag1=false;
						flag2=false;
						flagHeroPower=false;
						selectedMinion = null;
						JHeroPower = null;
					}
					else if(flag2==true){
						int r = buttons6.indexOf(b);
						selectedMinion = model.getOpponent().getField().get(r);
						try {
							((Mage) (model.getCurrentHero())).useHeroPower((Minion) selectedMinion);
							actionPerformed2();
						} catch (NotEnoughManaException
								| HeroPowerAlreadyUsedException
								| NotYourTurnException | FullHandException
								| FullFieldException
								| CloneNotSupportedException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						flag1=false;
						flag2=false;
						flagHeroPower=false;
						selectedMinion = null;
						JHeroPower = null;
					}
					else
						JOptionPane.showMessageDialog(null,"Choose a valid Target");
					}
					//for(int i=0 ; i<buttons3.size() ; i++){
						//if(b==buttons3.get(i)){
						//	flag1=true;
						//	break;
						//}
					//}
					//for(int i=0 ; i<buttons3.size() ; i++){
					//	if(b==buttons3.get(i)){
					//		flag1=true;
					//		break;
					//	}
				//	}
				}
			}
		}
		else if(((model.getCurrentHero() instanceof Priest && flagHeroPower == true) ||
				(model.getCurrentHero() instanceof Priest && JHeroPower !=null) ||
				(model.getCurrentHero() instanceof Priest && b.getActionCommand().equals("HERO POWER1")))
				 && flag1==false){
			if(b.getActionCommand().equals("HERO POWER1") || JHeroPower !=null){
				if(flagHeroPower==false){
					JHeroPower = b;
					flagHeroPower=true;
				}
				else if (flagHeroPower==true){
					if(b.getActionCommand().equals("CurrentHero")){
					  try {
						((Priest) (model.getCurrentHero())).useHeroPower(model.getCurrentHero());
						actionPerformed2();
					} catch (NotEnoughManaException
							| HeroPowerAlreadyUsedException
							| NotYourTurnException | FullHandException
							| FullFieldException | CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} 
						flag4=false;
						flag2=false;
						flagHeroPower=false;
						selectedMinion = null;
						JHeroPower = null;
					}
					else if(b.getActionCommand().equals("OpponentHero")){
						try {
							((Priest) (model.getCurrentHero())).useHeroPower(model.getOpponent());
							actionPerformed2();
						} catch (NotEnoughManaException
								| HeroPowerAlreadyUsedException
								| NotYourTurnException | FullHandException
								| FullFieldException
								| CloneNotSupportedException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						flag4=false;
						flag2=false;
						flagHeroPower=false;
						selectedMinion = null;
						JHeroPower = null;
					}
					else{
					for(int i=0 ; i<buttons5.size() ; i++){
						if(b==buttons5.get(i)){
							flag4=true;
							break;
						}
					}
					for(int i=0 ; i<buttons6.size() ; i++){
						if(b==buttons6.get(i)){
							flag2=true;
							break;
						}
					}
					if(flag4==true){
						int r = buttons5.indexOf(b);
						selectedMinion = model.getCurrentHero().getField().get(r);
						try {
							((Priest) (model.getCurrentHero())).useHeroPower((Minion) selectedMinion);
							actionPerformed2();
						} catch (NotEnoughManaException
								| HeroPowerAlreadyUsedException
								| NotYourTurnException | FullHandException
								| FullFieldException
								| CloneNotSupportedException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						flag4=false;
						flag2=false;
						flagHeroPower=false;
						selectedMinion = null;
						JHeroPower = null;
					}
					else if(flag2==true){
						int r = buttons6.indexOf(b);
						selectedMinion = model.getOpponent().getField().get(r);
						try {
							((Priest) (model.getCurrentHero())).useHeroPower((Minion) selectedMinion);
							actionPerformed2();
						} catch (NotEnoughManaException
								| HeroPowerAlreadyUsedException
								| NotYourTurnException | FullHandException
								| FullFieldException
								| CloneNotSupportedException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						flag4=false;
						flag2=false;
						flagHeroPower=false;
						selectedMinion = null;
						JHeroPower = null;
					}
					else
						JOptionPane.showMessageDialog(null, "Choose a valid Target");
				}
			}
		}
		}
			else if (b.getActionCommand().equals("HERO POWER1")){
			try {
				model.getCurrentHero().useHeroPower();
			} catch (NotEnoughManaException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch (HeroPowerAlreadyUsedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch (NotYourTurnException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch (FullHandException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage() + "\n" + e1.getBurned());
			} catch (FullFieldException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
			actionPerformed2();
			}
		else if(b.getActionCommand().equals("HERO POWER"))
			try {
				model.getOpponent().useHeroPower();
				actionPerformed2();
			} catch (NotEnoughManaException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch (HeroPowerAlreadyUsedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch (NotYourTurnException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch (FullHandException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch (FullFieldException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());;
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		else{
			for(int i=0 ; i<buttons3.size() ; i++){
				if(b==buttons3.get(i)){
					flag1=true;
					break;
				}
			}
			for(int i=0 ; i<buttons5.size();i++){
				if(b==buttons5.get(i)){
					flag2=true;
					break;
				}
			}
			for(int i=0 ; i<buttons4.size() ;i++){
				if(b==buttons4.get(i)){
					flag3=true;
					break;
				}
			}
		if(flag1==true || j!=null){
			if(flagSpell==false || flag1==true){
		    int r= buttons3.indexOf(b);
		    selectedMinion = model.getCurrentHero().getHand().get(r);
			}
			else{
				for(int i=0 ; i<buttons5.size() ;i++){
					if(b==buttons5.get(i)){
						int r = buttons5.indexOf(b);
						selectedMinion = model.getCurrentHero().getField().get(r);
						break;
					}    
				}
				for(int j=0 ; j<buttons6.size();j++){
					if(b==buttons6.get(j)){
						int r = buttons6.indexOf(b);
						selectedMinion = model.getOpponent().getField().get(r);
						break;
					}
						}
			}
		if(selectedMinion instanceof Minion && flag1==true){
		   // Minion m = (Minion)c;
		    try {
		model.getCurrentHero().playMinion((Minion) selectedMinion);
		actionPerformed2();
		//JButton temp=buttons3.remove(r);
		//buttons5.add(temp);
		//view.getCurrHand().remove(r);
		//view.getCurrField().add(temp);
		} catch (NotYourTurnException | NotEnoughManaException
		| FullFieldException e1) {
		// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		    selectedMinion=null;
		    flagSpell=false;
		    flagAttack=false;
		    }
		
		else {
		//if(selectedMinion instanceof Spell){
		//Spell s =(Spell) c;
		if(selectedMinion instanceof FieldSpell){
		try {
		model.getCurrentHero().castSpell((FieldSpell) selectedMinion);
		actionPerformed2();
		//JButton temp=buttons3.remove(r);
		//view.getCurrHand().remove(r);
		} catch (NotYourTurnException | NotEnoughManaException e1) {
		// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		flagSpell=false;
		}

		else {
		if(selectedMinion instanceof AOESpell){
		try {
		model.getCurrentHero().castSpell((AOESpell)selectedMinion, model.getOpponent().getField());
		actionPerformed2();
		//JButton temp=buttons3.remove(r);
		//view.getCurrHand().remove(r);
		} catch (NotYourTurnException | NotEnoughManaException e1) {
		// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		flagSpell=false;
		}
		else {
			if(selectedMinion instanceof MinionTargetSpell && flagSpell == false && selectedMinion instanceof HeroTargetSpell){
				j=b;
				flagSpell=true;
				k = buttons3.indexOf(j);
				target= (Spell) model.getCurrentHero().getHand().get(k);
			}
			else if(flagSpell==true && target instanceof MinionTargetSpell && target instanceof HeroTargetSpell && flag1==false){
			    if(flag3==true)
			    	JOptionPane.showMessageDialog(null, "Choose a valid Target");
			    else if(b.getActionCommand().equals("OpponentHero")){
					try {
						model.getCurrentHero().castSpell((HeroTargetSpell)target, model.getOpponent());
					} catch (NotYourTurnException | NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					flagSpell=false;
					selectedMinion = null;
					actionPerformed2();
					j=null;
				}
				else if(b.getActionCommand().equals("CurrentHero")){
					try {
						model.getCurrentHero().castSpell((HeroTargetSpell)target, model.getCurrentHero());
					} catch (NotYourTurnException | NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					flagSpell=false;
					selectedMinion = null;
					actionPerformed2();
					j=null;
	
				}
				else{
					try {
						model.getCurrentHero().castSpell((MinionTargetSpell)target, (Minion) selectedMinion);
					} catch (NotYourTurnException | NotEnoughManaException
							| InvalidTargetException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					flagSpell=false;
					selectedMinion = null;
					actionPerformed2();
					j=null;
				}
			}
			//}
			else if(selectedMinion instanceof MinionTargetSpell && flagSpell == false){
			j = b;
			flagSpell = true;
			 k = buttons3.indexOf(j);
			 target= (Spell) model.getCurrentHero().getHand().get(k);
		}
			else if(flagSpell==true && target instanceof MinionTargetSpell && flag1==false){
				if(flag3==true)
					JOptionPane.showMessageDialog(null, "Choose a valid Target!");
				else if(b.getActionCommand().equals("CurrentHero"))
					JOptionPane.showMessageDialog(null, "Choose a valid Target");
				else if(b.getActionCommand().equals("OpponentHero"))
					JOptionPane.showMessageDialog(null, "Choose a valid Target");
				else{
	            	try {
		               model.getCurrentHero().castSpell((MinionTargetSpell) target,(Minion) selectedMinion);
		               } catch (NotYourTurnException | NotEnoughManaException
		                 | InvalidTargetException e1) {
		             // TODO Auto-generated catch block
			            JOptionPane.showMessageDialog(null, e1.getMessage());
		     }
	        		actionPerformed2();
	        		flagSpell = false;
	        		j = null;
				}

		}
			//}
		else {
		if(selectedMinion instanceof HeroTargetSpell && flagSpell==false){
			j = b;
			flagSpell = true;
			 k = buttons3.indexOf(j);
			 target= (Spell) model.getCurrentHero().getHand().get(k);
		}
		else if(flagSpell==true && target instanceof HeroTargetSpell){
			j=null;
			if(b.getActionCommand().equals("OpponentHero")){
		try {
		model.getCurrentHero().castSpell((HeroTargetSpell)target, model.getOpponent());
		} catch (NotYourTurnException | NotEnoughManaException e1) {
		// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		selectedMinion=null;
		flagSpell=false;
		actionPerformed2();
			}
			else if(b.getActionCommand().equals("CurrentHero")){
				try {
					model.getCurrentHero().castSpell((HeroTargetSpell)target, model.getCurrentHero());
				} catch (NotYourTurnException | NotEnoughManaException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				selectedMinion=null;
				flagSpell=false;
				actionPerformed2();
			}
		}

		else {

		if(selectedMinion instanceof LeechingSpell && flagSpell==false){
		 j = b;
		flagSpell = true;
		 k = buttons3.indexOf(j);
		 target= (Spell) model.getCurrentHero().getHand().get(k);
		JOptionPane.showMessageDialog(null,"choose target");
		}
		else if(flagSpell == true && target instanceof LeechingSpell && flag1==false){
	      if(b.getActionCommand().equals("CurrentHero"))
	    	JOptionPane.showMessageDialog(null, "Choose a valid Target");
	    else if(b.getActionCommand().equals("OpponentHero"))
	    	JOptionPane.showMessageDialog(null, "Choose a valid Target");
	    else if(flag3)
	    	JOptionPane.showMessageDialog(null, "Choose a valid Target");
	    else{
		try {
		model.getCurrentHero().castSpell((LeechingSpell)target,(Minion) selectedMinion);
		//JButton temp=buttons3.remove(r);
		//view.getCurrHand().remove(r);
		} catch (NotYourTurnException
		| NotEnoughManaException e1) {
		// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		actionPerformed2();
		flagSpell=false;
		j = null;
	    }
		}
		}
		}
		}
		}
		}
		//}
		//}
		selectedMinion=null;
		flag1=false;
		flag3=false;
		}
		else if (flag2==true || jA!=null){
			if(flagAttack==false){
				jA = b;
				flagAttack = true;
			}
			else if(flagAttack==true){
				int a = buttons5.indexOf(jA);
				Minion target1 = (Minion) model.getCurrentHero().getField().get(a);
				if(b.getActionCommand().equals("OpponentHero")){
					try {
						model.getCurrentHero().attackWithMinion(target1,model.getOpponent());
					} catch (CannotAttackException | NotYourTurnException
							| TauntBypassException | NotSummonedException
							| InvalidTargetException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					actionPerformed2();
					jA=null;
					flagAttack=false;
				}
				else{
					if(b.getActionCommand().equals("CurrentHero"))
						JOptionPane.showMessageDialog(null, "Choose a valid Target!");
					else {
						if(flag3)
							JOptionPane.showMessageDialog(null, "Choose a valid Target!");
						else{
							for(int i=0 ; i<buttons5.size() ;i++){
								if(b==buttons5.get(i))
									flag2=true;
							}
							if(flag2){
								int c = buttons5.indexOf(b);
								selectedMinion = model.getCurrentHero().getHand().get(c);
								try {
									model.getCurrentHero().attackWithMinion(target1, (Minion) selectedMinion);
								} catch (CannotAttackException | NotYourTurnException
										| TauntBypassException | InvalidTargetException
										| NotSummonedException e1) {
									// TODO Auto-generated catch block
									JOptionPane.showMessageDialog(null, e1.getMessage());
								}
								actionPerformed2();
								jA = null;
								flagAttack = false;
							}
							else{
								int c = buttons6.indexOf(b);
								selectedMinion = model.getOpponent().getField().get(c);
								try {
									model.getCurrentHero().attackWithMinion(target1, (Minion) selectedMinion);
								} catch (CannotAttackException | NotYourTurnException
										| TauntBypassException | InvalidTargetException
										| NotSummonedException e1) {
									// TODO Auto-generated catch block
									JOptionPane.showMessageDialog(null, e1.getMessage());
								}
								actionPerformed2();
								jA = null;
								flagAttack = false;
							}
								
						}
					}
			}
			}
			flag2=false;
			flag3=false;
			selectedMinion = null;
		}
		}
	    view.revalidate();
		view.repaint();
	}	

	@Override
	public void onGameOver() {
		if(model.getCurrentHero().getCurrentHP()==0)
		JOptionPane.showMessageDialog(null, "GAME OVER! " + model.getOpponent().getName() + " wins" );
		if(model.getOpponent().getCurrentHP()==0)
		JOptionPane.showMessageDialog(null, "GAME OVER! " + model.getCurrentHero().getName() + " wins" );
		view.setVisible(false);
		view.dispose();
	}
	public static void main(String[]args) throws FullHandException, CloneNotSupportedException, IOException{
	//	new Controller();
	}

	public Game getModel() {
		return model;
	}
}
