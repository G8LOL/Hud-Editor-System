package com.artemis.ui.hudeditor.sub;

import com.artemis.clickgui.utils.ColorUtil;
import com.artemis.fontrenderer.UnicodeFontRenderer;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

public class PotionHUD extends Component{

	 ScaledResolution scaledRes = new ScaledResolution(this.mc);
	 int locY = scaledRes.getScaledHeight() - mc.fontRendererObj.FONT_HEIGHT - 2;
	 
	public PotionHUD() {
		super("Potion", 700, 372, 100, 20);
	}
	
	public static UnicodeFontRenderer ufr2;

   @Override
   public void renderOnGui() {
	   if (ufr2 == null)
		    ufr2 = UnicodeFontRenderer.getFontFromAssets("SourceSansPro-Light", 20, 0, 2.0F, 1.0f); 
	   
	   //GuiButton.drawRect(this.getX(), this.getY(), this.getX() + this.getWidth() + 5, this.getY() + this.barHeight + 10, ColorUtil.white(10).getRGB());
	   GuiButton.borders((float)this.getX() - 2, (float)this.getY(), (float)100, (float)30, 1, ColorUtil.white(60), true, true, true,true);
	   //  System.out.println(x + "  ||  ");
	   ufr2.drawString("§7Night Vision 99:999", (float)x, (float)y , -1);
	   ufr2.drawString("§7Regeneration II 10:00", (float)x, (float)y + 13 , -1);
	   
   }
   
    @Override
	public void updatePosition(int mouseX, int mouseY) {
		if(this.isDragging) {
			this.setX(mouseX - dragX);
			this.setY(mouseY - dragY);
		}
	}
	
}
