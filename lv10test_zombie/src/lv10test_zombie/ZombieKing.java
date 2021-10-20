package lv10test_zombie;

public class ZombieKing extends Unit{
	int sheild;
	boolean superAtt = true;
	public ZombieKing(int hp, String name, int ad, int df, int pos, int sheild) {
		super(hp, name, ad, df, pos);
		this.sheild = sheild;
		// TODO Auto-generated constructor stub
	}
	public int getSheild() {
		return sheild;
	}
	public void setSheild(int sheild) {
		this.sheild = sheild;
	}
	@Override
	public void attack(Unit target) {
		if(sheild == 0 && superAtt) {
			int dmg = 60 - target.getDf();
			setAd(getAd()*2);
			setDf(getDf()/2);
			target.setHp(target.getHp()-dmg);
			System.out.printf("[%s]의 *돌진 %d의 피해\n", getName(), dmg);
			superAtt = false;
		} else {
			super.attack(target);			
		}
	}
}
