package bo9.the_broken_mod.screen;

import bo9.the_broken_mod.TheBrokenMod;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class Computer_decoder_Screen extends HandledScreen<Computer_decoder_Screen_Handler> {
    private static final Identifier TEXTURE = new Identifier(TheBrokenMod.MOD_ID, "textures/gui/computer_decoder_gui.png");

    public Computer_decoder_Screen(Computer_decoder_Screen_Handler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }



    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionProgram);
        RenderSystem.setShaderColor(1f,1f,1f,1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) /2;
        int y = (height - backgroundHeight) /2;


        context.drawTexture(TEXTURE, x, y,0,0, backgroundWidth,backgroundHeight);
        renderProgressArrow(context, x, y);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()){
            context.drawTexture(TEXTURE, x + 47, y + 33, 0, 169, handler.getScaledProgress() ,15);
//95,28
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context,mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }


}
