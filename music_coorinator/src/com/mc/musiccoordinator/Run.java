package com.mc.musiccoordinator;

import com.google.zxing.WriterException;
import com.mc.musiccoordinator.presentation.Menu;

public class Run {
	
	public static void main(String[] args) throws WriterException{
		new Menu().menu();
	}
}
