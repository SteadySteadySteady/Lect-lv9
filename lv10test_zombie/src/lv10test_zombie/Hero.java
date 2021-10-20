package lv10test_zombie;

public class Hero extends Unit{
	private boolean act = true;
	private int potionLeft = 3;
	public Hero(int hp, String name, int ad, int df, int pos) {
		super(hp, name, ad, df, pos);
	}
	public void upgrade(int sel) {
		if(sel == 1 && act) {
			setAd(getAd()+3);
			System.out.println("AD+3");
			act = false;
		} 
		else if(sel == 2 && act) {
			setDf(getDf()+2);
			System.out.println("DF+2");
			act = false;
		} 
		else System.out.println("잘못된 값");
	}
	public void potion() {
		if(potionLeft > 0) {
			potionLeft -= 1;
			setHp(100);
		} 
		else System.out.println("남은 포션이 없다");
	}
	public boolean getAct() {
		return act;
	}
	public void setAct(boolean act) {
		this.act = act;
	}
	public int getLeftPotions() {
		return potionLeft;
	}
	@Override
	public void attack(Unit target) {
		if(target instanceof ZombieKing) {
			if(((ZombieKing) target).getSheild() != 0) {
				((ZombieKing) target).setSheild(((ZombieKing) target).getSheild()-getAd());
				if(((ZombieKing) target).getSheild() < 0) {
					target.setHp(target.getHp()+((ZombieKing) target).getSheild());	
					((ZombieKing) target).setSheild(0);
					System.out.println("쉴드가 파괴됐다");
				} 
				else System.out.println("공격이 막혔다");
			} 
			else super.attack(target);
		} 
		else super.attack(target);
	}
}
