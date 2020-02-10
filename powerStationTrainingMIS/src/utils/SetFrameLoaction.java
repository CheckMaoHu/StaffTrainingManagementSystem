package utils;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class SetFrameLoaction {

	// ÷–º‰œ‘ æ
	public SetFrameLoaction(JFrame frame) {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		int width = screen.width;
		int height = screen.height;

		int left = (width - frame.getSize().width) / 2;
		int top = (height - frame.getSize().height) / 2;

		frame.setLocation(left, top);
	}
}
