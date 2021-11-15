package models;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Vector;

public class MenuPanel extends Listener{
	Vector<Product> coffee;
	Vector<Product> tea;
	Vector<Product> coffeeSub;
	Vector<Product> teaSub;
	public MenuPanel() {
		setLayout(null);
		setBounds(0,0,600,1200);
		setBackground(new Color(254, 245, 237));
		setMenuBar();
		setProducts();
		setAutoscrolls(true);
	}
	private void setMenuBar() {
		for(int i = 0; i < 3; i += 1) {
			
		}
	}
//	revalidate();
//	repaint();

	private void setProducts() {
		int endNum = 16;
		coffee = new Vector<>();
		tea = new Vector<>();
		coffeeSub = new Vector<>();
		teaSub = new Vector<>();
		for(int i = 0; i < endNum; i += 1) {
			coffee.add(new Product("coffee", i+1));
			tea.add(new Product("tea", i+1));
			coffeeSub.add(new Product("coffeeSub", i+1));
			teaSub.add(new Product("teaSub", i+1));
		}
	}
}
