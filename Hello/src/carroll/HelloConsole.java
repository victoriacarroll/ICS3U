package carroll;

import java.awt.Color;

import hsa_new.Console;

public class HelloConsole {
/**
		 * print console with hello
		 *  @author carroll
		 *  Feb 24 2017
		 */
	public static void main(String[] args) {
		Console c = new Console();
		c.setColor(Color.pink);
		c.fill3DRect(300,40,500,60,true);
		}
	}
