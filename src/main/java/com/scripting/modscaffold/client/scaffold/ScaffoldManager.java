package com.scripting.modscaffold.client.scaffold;

import com.scripting.modscaffold.client.config.ModConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ScaffoldManager {
    private static Minecraft mc = Minecraft.getMinecraft();

    public static void placeScaffold() {
        if (!ModConfig.scaffoldEnabled || mc.player == null) {
            return;
        }

        EntityPlayer player = mc.player;
        World world = mc.world;

        BlockPos playerPos = new BlockPos(player.posX, player.posY - 1, player.posZ);

        for (int x = -ModConfig.scaffoldRange; x <= ModConfig.scaffoldRange; x++) {
            for (int z = -ModConfig.scaffoldRange; z <= ModConfig.scaffoldRange; z++) {
                BlockPos blockPos = new BlockPos(playerPos.getX() + x, playerPos.getY(), playerPos.getZ() + z);
                Block block = world.getBlockState(blockPos).getBlock();

                if (block instanceof BlockAir) {
                    world.setBlockState(blockPos, Blocks.COBBLESTONE.getDefaultState(), 2);

                    if (ModConfig.particlesEnabled) {
                        spawnParticles(world, blockPos);
                    }

                    if (ModConfig.soundEnabled) {
                        playSound(world, blockPos);
                    }
                }
            }
        }
    }

    private static void spawnParticles(World world, BlockPos pos) {
        if (mc.world != null) {
            mc.world.spawnParticle(
                net.minecraft.util.EnumParticleTypes.BLOCK_CRACK,
                pos.getX() + 0.5,
                pos.getY() + 0.5,
                pos.getZ() + 0.5,
                0, 0, 0,
                Blocks.COBBLESTONE.getDefaultState()
            );
        }
    }

    private static void playSound(World world, BlockPos pos) {
        world.playSound(
            pos.getX() + 0.5,
            pos.getY() + 0.5,
            pos.getZ() + 0.5,
            Blocks.COBBLESTONE.getSoundType().getPlaceSound(),
            SoundCategory.BLOCKS,
            1.0f,
            1.0f,
            false
        );
    }
}