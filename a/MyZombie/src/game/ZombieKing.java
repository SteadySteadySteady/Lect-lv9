package game;

public class ZombieKing extends Unit{
	int sheild;
	int superAtt;
	public ZombieKing(String name, int ad, int df, int hp, int pos, int sheild) {
		super(name, ad, df, hp, pos);
		this.sheild = sheild;
		// TODO Auto-generated constructor stub
	}
	public int getSheild() {
		return sheild;
	}
	public void setSheild(int shelid) {
		this.sheild = shelid;
	}
	@Override
	public void attack(Unit target) {
		if(sheild == 0 && superAtt == 0) {
			super.setAd(35);
			super.setDf(5);
			int damage = 60-target.getDf();
			if(damage <= 0) damage = 1;
			target.setHp(target.getHp()-damage);
			System.out.printf("[%s]의 돌진 %d의 피해\n", super.getName(), damage);
			superAtt += 1;
		}
		else super.attack(target);
	}
}
