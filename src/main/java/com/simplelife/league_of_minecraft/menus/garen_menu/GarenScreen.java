package com.simplelife.league_of_minecraft.menus.garen_menu;

import org.jline.reader.Parser.ParseContext;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.simplelife.league_of_minecraft.MainMod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Button.OnPress;
import net.minecraft.client.gui.font.FontManager;
import net.minecraft.client.gui.font.FontSet;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.minecraft.server.packs.resources.ResourceManager;

public class GarenScreen extends Screen {

    protected int imageWidth = 176;
    protected int imageHeight = 166;
    protected int leftPos;
    protected int topPos;

    private ReloadableResourceManager resourceManager;
    private TextureManager textureManager;
    private FontManager fontManager;
    private Font font;
    protected Button button;

    private final ResourceLocation backgroundTexture =  new ResourceLocation(MainMod.MODID, "textures/gui/garen_gui.png");

    public GarenScreen(Component title) {
        super(title);
    }

    @Override
    protected void init() {

        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;

        // this.resourceManager = new ReloadableResourceManager(PackType.CLIENT_RESOURCES);
        // ResourceManager m = ResourceManager.Empty.INSTANCE;
        // System.out.println(PackType.CLIENT_RESOURCES.getDirectory());
        // this.textureManager = new TextureManager(resourceManager);
        // this.fontManager = new FontManager(textureManager);
        // this.font = this.fontManager.createFont();
        
        button = Button.builder(
            Component.literal("button"),
                new OnPress() {
                    @Override
                    public void onPress(Button p_93751_) {
                        System.out.println("button pressed");
                    }
                }
            )
            .size(20, 20)
            .pos(50, 50)
            .build();

        this.addRenderableWidget(button);
    }

    @Override
    public void render(PoseStack pose, int mouseX, int mouseY, float particalTick) {
        
        // Render background
        // this.renderBackground(pose);
        RenderSystem.setShaderTexture(0, backgroundTexture);
        GuiComponent.blit(pose, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
        
        // GuiComponent.drawString(pose, this.font, Component.literal("String"), 70, 70, 0xff00ffff);
        super.render(pose, mouseX, mouseY, particalTick);

        // Widget render
        

    }

    @Override
    public void onClose() {
        // TODO Auto-generated method stub
        super.onClose();
    }

    @Override
    public void removed() {
        // TODO Auto-generated method stub
        super.removed();
    }

}
