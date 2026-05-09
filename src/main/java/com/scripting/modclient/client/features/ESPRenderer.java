package com.scripting.modclient.client.features;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import org.lwjgl.opengl.GL11;

import java.util.List;

public class ESPRenderer {
    private static Minecraft mc = Minecraft.getMinecraft();

    public static void render(float partialTicks) {
        if (mc.player == null || mc.world == null) return;

        List<Entity> entities = mc.world.loadedEntityList;

        for (Entity entity : entities) {
            if (entity instanceof EntityLivingBase && entity != mc.player) {
                renderESP((EntityLivingBase) entity, partialTicks);
            }
        }
    }

    private static void renderESP(EntityLivingBase entity, float partialTicks) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(entity.posX - mc.getRenderManager().viewerPosX,
                entity.posY - mc.getRenderManager().viewerPosY,
                entity.posZ - mc.getRenderManager().viewerPosZ);

        AxisAlignedBB box = entity.getEntityBoundingBox().offset(-entity.posX, -entity.posY, -entity.posZ);

        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0f, 0.0f, 0.0f, 0.3f);

        drawBoundingBox(box);

        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    private static void drawBoundingBox(AxisAlignedBB box) {
        GL11.glBegin(GL11.GL_LINE_LOOP);
        GL11.glVertex3d(box.minX, box.minY, box.minZ);
        GL11.glVertex3d(box.maxX, box.minY, box.minZ);
        GL11.glVertex3d(box.maxX, box.minY, box.maxZ);
        GL11.glVertex3d(box.minX, box.minY, box.maxZ);
        GL11.glEnd();

        GL11.glBegin(GL11.GL_LINE_LOOP);
        GL11.glVertex3d(box.minX, box.maxY, box.minZ);
        GL11.glVertex3d(box.maxX, box.maxY, box.minZ);
        GL11.glVertex3d(box.maxX, box.maxY, box.maxZ);
        GL11.glVertex3d(box.minX, box.maxY, box.maxZ);
        GL11.glEnd();

        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex3d(box.minX, box.minY, box.minZ);
        GL11.glVertex3d(box.minX, box.maxY, box.minZ);
        GL11.glVertex3d(box.maxX, box.minY, box.minZ);
        GL11.glVertex3d(box.maxX, box.maxY, box.minZ);
        GL11.glVertex3d(box.maxX, box.minY, box.maxZ);
        GL11.glVertex3d(box.maxX, box.maxY, box.maxZ);
        GL11.glVertex3d(box.minX, box.minY, box.maxZ);
        GL11.glVertex3d(box.minX, box.maxY, box.maxZ);
        GL11.glEnd();
    }
}