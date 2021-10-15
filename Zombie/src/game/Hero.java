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
			System.out.println("ȸ������ ���̴�.");
			System.out.println("ü���� 100ȸ�� �ƴ�.");
			this.setHp(this.getHp()+100);
			System.out.println(this.getName()+"�� ���� ü�� : "+this.getHp());
			cnt -= 1;
		} 
		else System.out.println("������ ����.");
	}
	public void attack(Unit target) {
		if(target instanceof ZombieKing) {
			if(((ZombieKing) target).shield>0) {
				int dam = (this.getAtt() - target.getDef())*(r.nextInt(150)+50)/100;
				if(dam <= 0) dam = 1;
				System.out.println(getName()+"�� ����");
				System.out.println(dam+"�� �����");
				((ZombieKing) target).setShield(((ZombieKing) target).getShield()-dam);
				if(((ZombieKing) target).getShield()<=0) {
					System.out.println(target.getName()+"�� ���尡 �ı��ƴ�");
					((ZombieKing) target).setShield(0);
				}
				System.out.println(target.getName()+"�� ���� ü�� : "+target.getHp()+" (���� : "+((ZombieKing) target).getShield()+")");
			} else {
				super.attack(target);
			}
		} else {
			super.attack(target);
		}
	} 
}
