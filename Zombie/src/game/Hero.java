package game;

public class Hero extends Unit{
	private int cnt = 3;
	public Hero(String name, int hp, int att, int def, int pos) {
		super(name, hp, att, def, pos);
		// TODO Auto-generated constructor stub
	}
	
	public int getCnt() {
		return cnt;
	}
	public void drink() {
		if(cnt>0) {
			System.out.println("회복약을 마셨다.");
			System.out.println("체력이 100회복 됐다.");
			this.setHp(this.getHp()+100);
			System.out.println(this.getName()+"의 남은 체력 : "+this.getHp());
			cnt -= 1;
		} 
		else System.out.println("물약이 없다.");
	}
	public void attack(Unit target) {
		if(target instanceof ZombieKing) {
			if(((ZombieKing) target).shield>0) {
				int dam = (this.getAtt() - target.getDef())*(r.nextInt(150)+50)/100;
				if(dam <= 0) dam = 1;
				System.out.println(getName()+"의 공격");
				System.out.println(dam+"의 대미지");
				((ZombieKing) target).setShield(((ZombieKing) target).getShield()-dam);
				if(((ZombieKing) target).getShield()<=0) {
					System.out.println(target.getName()+"의 쉴드가 파괴됐다");
					((ZombieKing) target).setShield(0);
				}
				System.out.println(target.getName()+"의 남은 체력 : "+target.getHp()+" (쉴드 : "+((ZombieKing) target).getShield()+")");
			} else {
				super.attack(target);
			}
		} else {
			super.attack(target);
		}
	} 
}
