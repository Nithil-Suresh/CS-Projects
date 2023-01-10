// Nithil Suresh
public class RobotZookeeper {
	private int monkeyScore;
	private int lionScore;
	private int elephantScore;
	
	public Food feedAnimal(Animal animal) {
	// Accepts an enum type Animal, returns an enum type Food.
		 if(animal == Animal.MONKEY)
			 return Food.FRUIT;
		 else if(animal == Animal.LION)
			 return Food.MEAT; 
		 else
			 return Food.LEAVES;
	 }
	 
	 public Toy entertainAnimal(Animal animal) {
	// Accepts an enum type Animal, returns an enum type Toy.
		 if(animal == Animal.MONKEY)
			 return Toy.BALL;
		 else if(animal == Animal.LION)
			 return Toy.BOX; 
		 else
			 return Toy.HAT;
	 }
	 
	 public Attention showAttention(Animal animal) {
	// Accepts an enum type Animal, returns an enum type Attention.
		 if(animal == Animal.MONKEY)
			 return Attention.TALKING;
		 else if(animal == Animal.LION)
			 return Attention.PETS; 
		 else
			 return Attention.SCRATCHES;
	 }
	 
	 public Animal handleRequests(AnimalNeed elephantNeed, AnimalNeed lionNeed, AnimalNeed monkeyNeed) {
		 if(getMonkeyScore() <= getLionScore() && getMonkeyScore() <= getElephantScore()) {
			 setMonkeyScore(getMonkeyScore()+1);
			 return Animal.MONKEY;
		 }
		 else if(getLionScore() <= getMonkeyScore() && getLionScore() <= getElephantScore()) {
			 setLionScore(getLionScore()+1);
			 return Animal.LION;
		 }
		 else
			 setElephantScore(getElephantScore()+1);
			 return Animal.ELEPHANT;
	 }

	public int getMonkeyScore() {
		return monkeyScore;
	}

	public void setMonkeyScore(int score) {
		this.monkeyScore = score;
	}

	public int getLionScore() {
		return lionScore;
	}

	public void setLionScore(int score) {
		this.lionScore = score;
	}

	public int getElephantScore() {
		return elephantScore;
	}

	public void setElephantScore(int score) {
		this.elephantScore = score;
	}
	 
	 
}

enum Animal{
	LION, ELEPHANT, MONKEY 
}

enum AnimalNeed{
	FOOD, TOYS, ATTENTION
}

enum Food{
	FRUIT, LEAVES, MEAT
}

enum Toy{
	BALL, HAT, BOX
}

enum Attention{
	SCRATCHES, PETS, TALKING
}
