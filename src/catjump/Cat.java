package catjump;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import Menu.EscMenu;



public class Cat {
	Keying k;
	int KatzePosLinks, Katzenbewegung, KatzePosHoehe, KatzenbewegungHoehe;
	Image catImg;
	ImageIcon i = new ImageIcon("Katze.png");
	boolean jumping = false;
	
	public Cat() {
		catImg = i.getImage();
		KatzePosLinks = 0;
	}
	
	public void move() {
		KatzePosLinks = KatzePosLinks + Katzenbewegung;
		}

	public int getX() {
		return KatzePosLinks;
	}

	public int getY() {
		return KatzePosHoehe;
	}

	public Image getImage() {
		return catImg;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_D) {
			Katzenbewegung = 2;
		}
		if (key == KeyEvent.VK_A) {
			Katzenbewegung = -1;
		}
		if (key == KeyEvent.VK_SPACE) {
			jumping = true;
			new Thread(new thread()).start();
		}
		if (key == KeyEvent.VK_W) {
			KatzenbewegungHoehe = 1;
		}
		if (key == KeyEvent.VK_ESCAPE) {
			EscMenu.main(null);
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_D) {
			Katzenbewegung = 0;
		}
		if (key == KeyEvent.VK_A) {
			Katzenbewegung = 0;
		}
		if (key == KeyEvent.VK_SPACE) {
			KatzenbewegungHoehe = 0;
		}
		if (key == KeyEvent.VK_W) {
			KatzenbewegungHoehe = 0;
		}
	}


	public int getKatzePosLinks() {
		return KatzePosLinks;
	}


	public void setKatzePosLinks(int katzePosLinks) {
		KatzePosLinks = katzePosLinks;
	}


	public int getKatzePosHoehe() {
		return KatzePosHoehe;
	}


	public void setKatzePosHoehe(int katzePosHoehe) {
		KatzePosHoehe = katzePosHoehe;
	}
	
	public Rectangle getCatBoundingBox() {
		return new Rectangle(getKatzePosLinks(), getKatzePosHoehe(), 182, 100);
	}
}
