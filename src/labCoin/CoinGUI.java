package labCoin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CoinGUI extends JFrame {

	private JPanel contentPane;
	private JLabel coinInfoLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoinGUI frame = new CoinGUI();
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
	public CoinGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel coinPanel = new JPanel();
		coinPanel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(coinPanel, BorderLayout.NORTH);
		coinPanel.setLayout(new GridLayout(1, 4, 5, 5));
		
		
		coinPanel.add(createCentButton());
		
		coinPanel.add(createNickelButton());
		
		coinPanel.add(createDimeButton());
		
		coinPanel.add(createQuarterButton());
		
		contentPane.add(createCoinInfoLabel(), BorderLayout.CENTER);
	}

	private JLabel createCoinInfoLabel() {
		coinInfoLabel = new JLabel("");
		coinInfoLabel.setForeground(Color.BLACK);
		coinInfoLabel.setOpaque(true);
		coinInfoLabel.setBackground(Color.GRAY);
		coinInfoLabel.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		coinInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		return coinInfoLabel;
	}

	private JButton createQuarterButton() {
		JButton quarterButton = new JButton("");
		quarterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coinInfoLabel.setText(Coin.QUARTER.toString());
			}
		});
		quarterButton.setBorderPainted(false);
		quarterButton.setBackground(Color.LIGHT_GRAY);
		quarterButton.setIcon(new ImageIcon(CoinGUI.class.getResource("/labCoin/Resources/UsQuarter.png")));
		return quarterButton;
	}

	private JButton createDimeButton() {
		JButton dimeButton = new JButton("");
		dimeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coinInfoLabel.setText(Coin.DIME.toString());
			}
		});
		dimeButton.setBorderPainted(false);
		dimeButton.setBackground(Color.LIGHT_GRAY);
		dimeButton.setIcon(new ImageIcon(CoinGUI.class.getResource("/labCoin/Resources/UsDime.png")));
		return dimeButton;
	}

	private JButton createNickelButton() {
		JButton nickelButton = new JButton("");
		nickelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coinInfoLabel.setText(Coin.NICKEL.toString());
			}
		});
		nickelButton.setBorderPainted(false);
		nickelButton.setBackground(Color.LIGHT_GRAY);
		nickelButton.setIcon(new ImageIcon(CoinGUI.class.getResource("/labCoin/Resources/UsNickel.png")));
		return nickelButton;
	}

	private JButton createCentButton() {
		JButton centButton = new JButton("");
		centButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				coinInfoLabel.setText(Coin.CENT.toString());
			}
		});
		centButton.setBorderPainted(false);
		centButton.setBackground(Color.LIGHT_GRAY);
		centButton.setIcon(new ImageIcon(CoinGUI.class.getResource("/labCoin/Resources/UsCent.png")));
		return centButton;
	}

}
