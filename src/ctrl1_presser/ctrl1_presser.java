package ctrl1_presser;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class ctrl1_presser implements NativeKeyListener {

	private Robot r;

	public ctrl1_presser() throws Exception {
		this.r = new Robot();
		//KeyEvent.getExtendedKeyCodeForChar('1');
	}

	public void nativeKeyPressed(NativeKeyEvent e) {

		if (e.getKeyCode() == NativeKeyEvent.VC_UP || e.getKeyCode() ==NativeKeyEvent.VC_DOWN || e.getKeyCode() ==NativeKeyEvent.VC_LEFT || e.getKeyCode() ==NativeKeyEvent.VC_RIGHT) {
			
			this.r.keyPress(KeyEvent.VK_CONTROL);
			this.r.keyPress(KeyEvent.VK_1);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.r.keyRelease(KeyEvent.VK_CONTROL);
			this.r.keyRelease(KeyEvent.VK_1);
		}
		
	}

	public void nativeKeyReleased(NativeKeyEvent e) {

	}

	public void nativeKeyTyped(NativeKeyEvent e) {

	}

	public static void main(String[] args) throws Exception {

		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}

		GlobalScreen.addNativeKeyListener(new ctrl1_presser());
	}
}
