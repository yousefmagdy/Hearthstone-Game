package GUI;
import javax.swing.*;

import java.awt.*;
import engine.Controller;

public class FirstWindow extends JFrame {
	private JPanel CurrHand;
	private JPanel CurrentHeroPart;
	private JPanel OpponentHeroPart;
	private JPanel OppHand;
	private JPanel CurrField;
	private JPanel OppField;
	private JButton UseHeroPower;
	private JButton UseOppPower;
	private JButton OppHeroname;
	private JButton heroname;
	public JPanel getCurrentHeroPart() {
		return CurrentHeroPart;
	}

	public JPanel getOpponentHeroPart() {
		return OpponentHeroPart;
	}

	public JButton getUseHeroPower() {
		return UseHeroPower;
	}

	public JButton getUseOppPower() {
		return UseOppPower;
	}

	public JPanel getLowerhalf() {
		return lowerhalf;
	}

	public JPanel getUpperhalf() {
		return upperhalf;
	}

	public JPanel getCurrentHeroStats() {
		return CurrentHeroStats;
	}

	public JPanel getOpponentHeroStats() {
		return OpponentHeroStats;
	}

	private JButton endturn;
	private JPanel lowerhalf;
	private JPanel upperhalf;
	private JPanel CurrentHeroStats;
	private JPanel OpponentHeroStats;
	//private JTextArea heroname;
	private JTextArea CurrentHPMana;
	//private JTextArea OppHeroname;
	private JTextArea OppCurrentHPMana;

	public JButton getOppHeroname() {
		return OppHeroname;
	}

	public JTextArea getOppCurrentHPMana() {
		return OppCurrentHPMana;
	}

	public JButton getHeroname() {
		return heroname;
	}

	public JTextArea getCurrentHPMana() {
		return CurrentHPMana;
	}

	public FirstWindow()
	{
		super();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width,screenSize.height);
		setTitle("HearthStone");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		lowerhalf = new JPanel();
		lowerhalf.setLayout(new BorderLayout());
		lowerhalf.setPreferredSize(new Dimension(getWidth(),(getHeight()/2)-50));
		add(lowerhalf,BorderLayout.SOUTH);

		CurrentHeroPart = new JPanel();
		CurrentHeroPart.setBackground(Color.BLUE);
		CurrentHeroPart.setLayout(new BorderLayout());
		CurrentHeroPart.setPreferredSize(new Dimension(getWidth(),(getHeight()/2)-150));
		lowerhalf.add(CurrentHeroPart,BorderLayout.NORTH);

		CurrentHeroStats = new JPanel();
		CurrentHeroStats.setBackground(Color.PINK);
		CurrentHeroStats.setPreferredSize(new Dimension(getWidth(),100));
		CurrentHeroStats.setLayout(new BorderLayout());
		lowerhalf.add(CurrentHeroStats,BorderLayout.SOUTH);

		CurrHand = new JPanel();
		CurrHand.setPreferredSize(new Dimension(1000,getHeight()/6));
		CurrHand.setBackground(Color.ORANGE);
		CurrHand.setLayout(new GridLayout(0,10));
		CurrentHeroPart.add(CurrHand,BorderLayout.SOUTH);

		CurrField = new JPanel();
		CurrField.setPreferredSize(new Dimension(getWidth(),getHeight()/6));
		CurrField.setBackground(Color.RED);
		CurrField.setLayout(new GridLayout(0,10));
		CurrentHeroPart.add(CurrField);

		upperhalf = new JPanel();
		upperhalf.setLayout(new BorderLayout());
		upperhalf.setPreferredSize(new Dimension(getWidth(),(getHeight()/2)-50));
		add(upperhalf,BorderLayout.NORTH);

		OpponentHeroPart = new JPanel();
		OpponentHeroPart.setPreferredSize(new Dimension(getWidth(),(getHeight()/2)-150));
		OpponentHeroPart.setLayout(new BorderLayout());
		OpponentHeroPart.setBackground(Color.GREEN);
		upperhalf.add(OpponentHeroPart,BorderLayout.SOUTH);

		OpponentHeroStats = new JPanel();
		OpponentHeroStats.setBackground(Color.PINK);
		OpponentHeroStats.setPreferredSize(new Dimension(getWidth(),100));
		OpponentHeroStats.setLayout(new BorderLayout());
		upperhalf.add(OpponentHeroStats,BorderLayout.NORTH);


		OppHand = new JPanel();
		OppHand.setPreferredSize(new Dimension(getWidth(),getHeight()/6));
		OppHand.setLayout(new GridLayout(0,10));
		OppHand.setBackground(Color.ORANGE);
		OpponentHeroPart.add(OppHand,BorderLayout.NORTH);

		OppField = new JPanel();
		OppField.setPreferredSize(new Dimension(getWidth(),getHeight()/6));
		OppField.setBackground(Color.RED);
		OppField.setLayout(new GridLayout(0,10));
		OpponentHeroPart.add(OppField);

		UseHeroPower = new JButton("HERO POWER1");
		UseHeroPower.setPreferredSize(new Dimension(100,100));
		UseHeroPower.setBackground(Color.GRAY);
		CurrentHeroStats.add(UseHeroPower,BorderLayout.EAST);

		UseOppPower = new JButton("HERO POWER");
		UseOppPower.setPreferredSize(new Dimension(100,100));
		UseOppPower.setBackground(Color.GRAY);
		OpponentHeroStats.add(UseOppPower,BorderLayout.EAST);

		endturn = new JButton("END TURN");
		endturn.setPreferredSize(new Dimension(100,100));
		endturn.setBackground(Color.GREEN);
		add(endturn,BorderLayout.EAST);

		JButton test1 = new JButton("test1");
		JButton test2 = new JButton("test2");
		JButton test3 = new JButton("test3");
		//OppField.add(test1);
		//OppField.add(test3);
		//OppHand.add(test1);
		//OppHand.add(test2);
		//CurrField.add(test2);
		 OppHeroname = new JButton("OpponentHero");
		OppCurrentHPMana = new JTextArea("CurrentHP");
		OppCurrentHPMana.setPreferredSize(new Dimension(getWidth()/5,getHeight()));
		OppHeroname.setFont(OppHeroname.getFont().deriveFont(48f));
		OppCurrentHPMana.setFont(OppCurrentHPMana.getFont().deriveFont(24f));
		OpponentHeroStats.add(OppCurrentHPMana , BorderLayout.WEST);
		OpponentHeroStats.add(OppHeroname , BorderLayout.CENTER);
		//OppHeroname.setEditable(false);
		OppCurrentHPMana.setEditable(false);
		 heroname = new JButton("CurrentHero");
		CurrentHPMana = new JTextArea("CurrentHP");
		CurrentHPMana.setPreferredSize(new Dimension(getWidth()/5,getHeight()));
		heroname.setFont(heroname.getFont().deriveFont(48f));
		CurrentHPMana.setFont(CurrentHPMana.getFont().deriveFont(24f));
		CurrentHeroStats.add(CurrentHPMana , BorderLayout.WEST);
		CurrentHeroStats.add(heroname , BorderLayout.CENTER);
		//heroname.setEditable(false);
		CurrentHPMana.setEditable(false);
	    

		this.revalidate();
		this.repaint();
		setVisible(true);

		}

		public JButton getEndturn() {
		return endturn;
	}

		public JPanel getOppField() {
		return OppField;
		}

		public void setOppField(JPanel oppField) {
		OppField = oppField;
		}

		public JPanel getCurrField() {
		return CurrField;
		}

		public void setCurrField(JPanel currField) {
		CurrField = currField;
		}

		public JPanel getOppHand() {
		return OppHand;
		}

		public void setOppHand(JPanel oppHand) {
		OppHand = oppHand;
		}

		public JPanel getCurrHand() {
		return CurrHand;
		}
		public void setCurrHand(JPanel currHand) {
		CurrHand = currHand;
		}

		public static void main(String[] args)
		{
		FirstWindow sp = new FirstWindow();
		sp.setVisible(true);

		}
}
