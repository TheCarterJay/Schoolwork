package rockPaperScissors;

import javax.swing.ImageIcon;

public enum Attack {
	ROCK (new ImageIcon (Attack.class.getResource("/rockPaperScissors/Resources/Rock.png"))), 
	PAPER (new ImageIcon (Attack.class.getResource("/rockPaperScissors/Resources/Paper.png"))), 
	SCISSORS (new ImageIcon (Attack.class.getResource("/rockPaperScissors/Resources/Scissors.png")));

	private ImageIcon image;
	
	private Attack (ImageIcon img) {
		image = img;
	}
	
	public ImageIcon getImageIcon() {
		return image;
	}

	public Result checkIfWin(Attack comp) {
		switch (this) {
		case ROCK:
			if (comp == Attack.SCISSORS) {
				return Result.WIN;
			}
			if (comp == Attack.PAPER) {
				return Result.LOSE;
			}
			break;
		case PAPER:
			if (comp == Attack.SCISSORS) {
				return Result.LOSE;
			}
			if (comp == Attack.ROCK) {
				return Result.WIN;
			}
			break;
		case SCISSORS:
			if (comp == Attack.PAPER) {
				return Result.WIN;
			}
			if (comp == Attack.ROCK) {
				return Result.LOSE;
			}
			break;
		}
		return Result.DRAW;
	}
}
