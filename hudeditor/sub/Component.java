package com.artemis.ui.hudeditor.sub;

import java.util.ArrayList;

import com.artemis.clickgui.test.component.Frame;
import com.artemis.fontrenderer.UnicodeFontRenderer;
import com.artemis.module.Category;

import net.minecraft.client.Minecraft;

public class Component {

	protected Minecraft mc = Minecraft.getMinecraft();
	public String name;
	public int width;
	public double y;
	public double x;
	public int barHeight;
	public boolean isDragging;
	public double dragX;
	public double dragY;
	
	public Component(String name, double x, double y, int width, int height) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.barHeight = height;
	}
	
	public void setX(double d) {
		this.x = d;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setY(double newY) {
		this.y = newY;
	}
	
	public void setDrag(boolean drag) {
		this.isDragging = drag;
	}
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void renderOnGui() {}
	
	public void updatePosition(int mouseX, int mouseY) {}
	
	public boolean isWithinHeader(int x, int y) {
		if(x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.barHeight) {
			return true;
		}
		return false;
	}
	
}
