package com.artemis.ui.hudeditor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.artemis.Artemis;
import com.artemis.clickgui.test.component.Frame;
import com.artemis.clickgui.utils.ColorUtil;
import com.artemis.fontrenderer.UnicodeFontRenderer;
import com.artemis.module.Category;
import com.artemis.module.Module;
import com.artemis.ui.CleanTextField;
import com.artemis.ui.hudeditor.sub.ArmorHUD;
import com.artemis.ui.hudeditor.sub.Component;
import com.artemis.ui.hudeditor.sub.InfoHUD;
import com.artemis.ui.hudeditor.sub.PotionHUD;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

public class GuiHudEditor extends GuiScreen{
	
	
	public static ArrayList<Component> frames;
	
	public static UnicodeFontRenderer ufr2;
	
	public static GuiHudEditor instance;
	
	public GuiHudEditor() {
	}
	
	
	public static void onInitClient() {
	    frames = new ArrayList<Component>();
		
		//Components
	    frames.add(new InfoHUD());
	    frames.add(new ArmorHUD());
	    frames.add(new PotionHUD());
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		  if (ufr2 == null)
		      ufr2 = UnicodeFontRenderer.getFontFromAssets("SourceSansPro-Light", 20, 0, 2.0F, 1.0f); 
		  for(Component frame : frames) {				
				frame.updatePosition(mouseX, mouseY);
				frame.renderOnGui();
			
			}
	}
	
	@Override
	public void initGui() {

    
       
	   super.initGui();
	}
	
	
	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}
	
	@Override
	public void mouseClicked(int mouseX, int mouseY, int button) throws IOException {
		for(Component frame : frames) {
			if(frame.isWithinHeader(mouseX, mouseY) && button == 0) {
				frame.setDrag(true);
				frame.dragX = mouseX - frame.getX();
				frame.dragY = mouseY - frame.getY();
			}
		}
		
		super.mouseClicked(mouseX, mouseY, button);
	}
	
	@Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {

        
        super.keyTyped(typedChar, keyCode);
    }
	
	@Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
		for(Component frame : frames) {
			frame.setDrag(false);
		}
	}
	
	   public ArrayList<Component> getComponents() {
	        return frames;
	    }
}
