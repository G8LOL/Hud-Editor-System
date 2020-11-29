package com.artemis.ui.hudeditor.sub;

import org.lwjgl.opengl.GL11;

import com.artemis.clickgui.utils.ColorUtil;
import com.artemis.fontrenderer.UnicodeFontRenderer;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;

public class ArmorHUD extends Component{

	 ScaledResolution scaledRes = new ScaledResolution(this.mc);
	 int locY = scaledRes.getScaledHeight() - mc.fontRendererObj.FONT_HEIGHT - 2;
	 
	public ArmorHUD() {
		super("Armor", 411, 345, 75, 10);
	}
	
	public static UnicodeFontRenderer ufr2;

   @Override
   public void renderOnGui() {
	   if (ufr2 == null)
		    ufr2 = UnicodeFontRenderer.getFontFromAssets("SourceSansPro-Light", 20, 0, 2.0F, 1.0f); 
	   
	  // System.out.println(x + "   " + y);
	   
	   //GuiButton.drawRect(this.getX(), this.getY(), this.getX() + this.getWidth() + 5, this.getY() + this.barHeight + 10, ColorUtil.white(10).getRGB());
	   GuiButton.borders((float)this.getX() - 2, (float)this.getY(), (float)79, (float)17, 1, ColorUtil.white(60), true, true, true,true);
	   //  System.out.println(x + "  ||  ");
	 //  ufr2.drawString("§7Night Vision 99:999", (float)x, (float)y , -1);
	  // ufr2.drawString("§7Regeneration II 10:00", (float)x, (float)y + 13 , -1);
	 
	  
	
	   this.renderItemStack(4, new ItemStack(net.minecraft.init.Items.diamond_boots));
	   this.renderItemStack(3, new ItemStack(net.minecraft.init.Items.diamond_leggings));
	   this.renderItemStack(2, new ItemStack(net.minecraft.init.Items.diamond_chestplate));
	   this.renderItemStack(1, new ItemStack(net.minecraft.init.Items.diamond_helmet));
	   this.renderItemStack(0, new ItemStack(net.minecraft.init.Items.diamond_sword));
	   
   }
   
   private void renderItemStack(int i, ItemStack itemstack) {
	    ScaledResolution sr = new ScaledResolution(mc);
	if(itemstack == null) {
		return;
	}
	GL11.glPushMatrix();
	int yAdd =  i * 15;
	
	RenderHelper.enableGUIStandardItemLighting();
	mc.getRenderItem().renderItemAndEffectIntoGUI(itemstack, (int)x + yAdd, (int)y);
	GL11.glPopMatrix();
	
}
   
    @Override
	public void updatePosition(int mouseX, int mouseY) {
		if(this.isDragging) {
			this.setX(mouseX - dragX);
			this.setY(mouseY - dragY);
		}
	}
	
}
