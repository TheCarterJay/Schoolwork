package rockPaperScissors;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.MatteBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class gameGui extends JFrame {

	private JPanel contentPane;
	private JLabel gameMessage = new JLabel();
	private JButton computerAttack = new JButton();
	private JButton playerAttack = new JButton();
	private JButton scissorsButton = new JButton();
	private JButton paperButton = new JButton();
	private JButton rockButton = new JButton();
	private JLabel playerChoiceLbl = new JLabel();
	private JLabel computerChoiceLbl = new JLabel();

	private Attack compAttack() {
		Random rand = new Random();
		Attack compAttack = null;
		switch (rand.nextInt(3)) {
		case 0:
			compAttack = Attack.ROCK;
			computerChoiceLbl.setText("Computer Choice: Rock");
			computerAttack.setIcon(Attack.ROCK.getImageIcon());
			break;

		case 1:
			compAttack = Attack.PAPER;
			computerChoiceLbl.setText("Computer Choice: Paper");
			computerAttack.setIcon(Attack.PAPER.getImageIcon());
			break;

		case 2:
			compAttack = Attack.SCISSORS;
			computerChoiceLbl.setText("Computer Choice: Scissors");
			computerAttack.setIcon(Attack.SCISSORS.getImageIcon());
			break;

		}
		return compAttack;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameGui frame = new gameGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gameGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel userChoicesPanel = new JPanel();
		contentPane.add(userChoicesPanel, BorderLayout.SOUTH);
		userChoicesPanel.setLayout(new GridLayout(1, 3, 0, 0));

		JPanel battlePanel = new JPanel();
		contentPane.add(battlePanel, BorderLayout.CENTER);

		JButton rockButton = createRockButton();
		rockButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		userChoicesPanel.add(rockButton);

		JButton paperButton = createPaperButton();
		paperButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		userChoicesPanel.add(paperButton);

		JButton scissorsButton = createScissorsButton();
		scissorsButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		userChoicesPanel.add(scissorsButton);
		
		GridBagLayout gbl_battlePanel = new GridBagLayout();
		gbl_battlePanel.columnWidths = new int[]{262, 262, 0};
		gbl_battlePanel.rowHeights = new int[]{45, 229, 0};
		gbl_battlePanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_battlePanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		battlePanel.setLayout(gbl_battlePanel);
				playerChoiceLbl.setHorizontalAlignment(SwingConstants.CENTER);
				
				GridBagConstraints gbc_playerChoiceLbl = new GridBagConstraints();
				gbc_playerChoiceLbl.fill = GridBagConstraints.BOTH;
				gbc_playerChoiceLbl.insets = new Insets(0, 0, 5, 5);
				gbc_playerChoiceLbl.gridx = 0;
				gbc_playerChoiceLbl.gridy = 0;
				battlePanel.add(playerChoiceLbl, gbc_playerChoiceLbl);
				computerChoiceLbl.setHorizontalAlignment(SwingConstants.CENTER);
				
				GridBagConstraints gbc_computerChoiceLbl = new GridBagConstraints();
				gbc_computerChoiceLbl.fill = GridBagConstraints.BOTH;
				gbc_computerChoiceLbl.insets = new Insets(0, 0, 5, 0);
				gbc_computerChoiceLbl.gridx = 1;
				gbc_computerChoiceLbl.gridy = 0;
				battlePanel.add(computerChoiceLbl, gbc_computerChoiceLbl);
		
				JButton playerAttack = createPlayerAttackButton();
				GridBagConstraints gbc_playerAttack = new GridBagConstraints();
				gbc_playerAttack.fill = GridBagConstraints.BOTH;
				gbc_playerAttack.insets = new Insets(0, 0, 0, 5);
				gbc_playerAttack.gridx = 0;
				gbc_playerAttack.gridy = 1;
				playerAttack.setBackground(Color.WHITE);
				playerAttack.setContentAreaFilled(false);
				playerAttack.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				battlePanel.add(playerAttack, gbc_playerAttack);
		
				JButton computerAttack = createComputerAttackButton();
				GridBagConstraints gbc_computerAttack = new GridBagConstraints();
				gbc_computerAttack.fill = GridBagConstraints.BOTH;
				gbc_computerAttack.gridx = 1;
				gbc_computerAttack.gridy = 1;
				computerAttack.setBackground(Color.WHITE);
				computerAttack.setContentAreaFilled(false);
				computerAttack.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				battlePanel.add(computerAttack, gbc_computerAttack);

		JLabel gameMessage = createGameMessageLbl();
		contentPane.add(gameMessage, BorderLayout.NORTH);
	}

	private JLabel createGameMessageLbl() {
		gameMessage.setText("Attack Wisely!");
		gameMessage.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		gameMessage.setHorizontalAlignment(SwingConstants.CENTER);
		return gameMessage;
	}

	private JButton createComputerAttackButton() {
		return computerAttack;
	}

	private JButton createPlayerAttackButton() {
		return playerAttack;
	}

	private JButton createScissorsButton() {
		scissorsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				playerChoiceLbl.setText("User Choice: Scissors");
				playerAttack.setIcon(Attack.SCISSORS.getImageIcon());
				
				Result userWinStatus = Attack.SCISSORS.checkIfWin(compAttack());
				switch (userWinStatus) {
				case WIN:
					gameMessage.setText("User Wins!");
					break;

				case LOSE:
					gameMessage.setText("User Loses!");
					break;

				case DRAW:
					gameMessage.setText("Draw!");
					break;
				}
			}
		});
		scissorsButton.setIcon(new ImageIcon(gameGui.class.getResource("/rockPaperScissors/Resources/Scissors.png")));
		return scissorsButton;
	}

	private JButton createPaperButton() {
		paperButton.setIcon(new ImageIcon(gameGui.class.getResource("/rockPaperScissors/Resources/Paper.png")));
		paperButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				playerChoiceLbl.setText("User Choice: Paper");
				playerAttack.setIcon(Attack.PAPER.getImageIcon());
				
				Result userWinStatus = Attack.PAPER.checkIfWin(compAttack());
				switch (userWinStatus) {
				case WIN:
					gameMessage.setText("User Wins!");
					break;

				case LOSE:
					gameMessage.setText("User Loses!");
					break;

				case DRAW:
					gameMessage.setText("Draw!");
					break;
				}
			}
		});
		return paperButton;
	}

	private JButton createRockButton() {
		rockButton.setIcon(new ImageIcon(gameGui.class.getResource("/rockPaperScissors/Resources/Rock.png")));
		rockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				playerChoiceLbl.setText("User Choice: Rock");
				playerAttack.setIcon(Attack.ROCK.getImageIcon());
				
				Result userWinStatus = Attack.ROCK.checkIfWin(compAttack());
				switch (userWinStatus) {
				case WIN:
					gameMessage.setText("User Wins!");
					break;

				case LOSE:
					gameMessage.setText("User Loses!");
					break;

				case DRAW:
					gameMessage.setText("Draw!");
					break;
				}

			}
		});
		return rockButton;
	}

}
