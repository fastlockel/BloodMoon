package uk.co.jacekk.bukkit.bloodmoon.entity;

import net.minecraft.server.v1_7_R4.EntityLiving;

import org.bukkit.craftbukkit.v1_7_R4.entity.CraftLivingEntity;

import uk.co.jacekk.bukkit.bloodmoon.BloodMoon;

public class BloodMoonEntityGhast extends BloodMoonEntityLiving {
	
	public BloodMoonEntityGhast(BloodMoon plugin, EntityLiving nmsEntity, CraftLivingEntity bukkitEntity, BloodMoonEntityType type){
		super(plugin, nmsEntity, bukkitEntity, type);
	}
	
	@Override
	public void onTick(){
		
	}
	
}
