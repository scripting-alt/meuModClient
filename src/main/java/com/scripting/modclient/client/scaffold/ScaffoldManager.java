package com.scripting.modclient.client.scaffold;

import com.scripting.modclient.client.config.ModConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ScaffoldManager {
    private static Minecraft mc = Minecraft.getMinecraft();
    private static long lastPlaceTime = 0;
    private static final long PLACE_DELAY = 50; // ms entre colocações

    public static void updateScaffold() {
        EntityPlayer player = mc.player;
        if (player == null || !player.onGround || !isPlayerMoving(player)) {
            return;
        }

        long currentTime = System.currentTimeMillis();
        if (currentTime - lastPlaceTime < PLACE_DELAY) {
            return;
        }

        World world = mc.world;
        if (world == null) return;

        // Encontra o bloco abaixo do jogador
        BlockPos playerPos = new BlockPos(player.posX, player.posY - 1, player.posZ);

        // Verifica blocos em um raio
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                BlockPos targetPos = playerPos.add(x, 0, z);
                if (world.isAirBlock(targetPos)) {
                    placeBlock(world, targetPos, player);
                }
            }
        }

        lastPlaceTime = currentTime;
    }

    private static boolean isPlayerMoving(EntityPlayer player) {
        return player.motionX != 0 || player.motionZ != 0;
    }

    private static void placeBlock(World world, BlockPos pos, EntityPlayer player) {
        Block blockToPlace = Blocks.OAK_PLANKS;

        if (world.getBlockState(pos).getBlock() == Blocks.AIR) {
            world.setBlockState(pos, blockToPlace.getDefaultState());

            // Partículas
            if (ModConfig.PARTICLES_ENABLED) {
                spawnParticles(world, pos);
            }

            // Som
            if (ModConfig.SOUND_ENABLED) {
                world.playSound(player, pos, blockToPlace.getSoundType().getPlaceSound(),
                        SoundCategory.BLOCKS, 0.5f, 1.0f);
            }
        }
    }

    private static void spawnParticles(World world, BlockPos pos) {
        for (int i = 0; i < 3; i++) {
            double x = pos.getX() + Math.random();
            double y = pos.getY() + Math.random();
            double z = pos.getZ() + Math.random();
            world.spawnParticle(EnumParticleTypes.BLOCK_CRACK, x, y, z,
                    Math.random() - 0.5, Math.random(), Math.random() - 0.5);
        }
    }
}