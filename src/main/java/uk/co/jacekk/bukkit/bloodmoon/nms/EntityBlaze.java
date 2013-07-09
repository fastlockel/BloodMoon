package uk.co.jacekk.bukkit.bloodmoon.nms;

import net.minecraft.server.v1_6_R2.World;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_6_R2.CraftServer;
import org.bukkit.craftbukkit.v1_6_R2.entity.CraftBlaze;
import org.bukkit.craftbukkit.v1_6_R2.entity.CraftLivingEntity;
import org.bukkit.plugin.Plugin;

import uk.co.jacekk.bukkit.bloodmoon.BloodMoon;
import uk.co.jacekk.bukkit.bloodmoon.entity.BloodMoonEntityBlaze;
import uk.co.jacekk.bukkit.bloodmoon.entity.BloodMoonEntityType;

public class EntityBlaze extends net.minecraft.server.v1_6_R2.EntityBlaze {
	
	private BloodMoon plugin;
	private BloodMoonEntityBlaze bloodMoonEntity;
	
	public EntityBlaze(World world){
		super(world);
		
		Plugin plugin = Bukkit.getPluginManager().getPlugin("BloodMoon");
		
		if (plugin == null || !(plugin instanceof BloodMoon)){
			this.world.removeEntity(this);
			return;
		}
		
		this.plugin = (BloodMoon) plugin;
		
		this.bukkitEntity = new CraftBlaze((CraftServer) this.plugin.server, this);
		this.bloodMoonEntity = new BloodMoonEntityBlaze(this.plugin, this, (CraftLivingEntity) this.bukkitEntity, BloodMoonEntityType.BLAZE);
	}
	
	@Override
	public void bj(){
		try{
			this.bloodMoonEntity.onTick();
			super.bj();
		}catch (Exception e){
			plugin.log.warn("Exception caught while ticking entity");
			e.printStackTrace();
		}
	}
	
}
