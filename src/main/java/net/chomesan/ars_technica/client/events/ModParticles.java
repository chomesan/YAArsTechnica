package net.chomesan.ars_technica.client.events;

import net.chomesan.ars_technica.YAArsTechnicaMod;
import net.chomesan.ars_technica.client.particles.SpiralDustParticleProvider;
import net.chomesan.ars_technica.client.particles.SpiralDustParticleType;
import net.chomesan.ars_technica.client.particles.SpiralDustParticleTypeData;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


@Mod.EventBusSubscriber(modid = YAArsTechnicaMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, YAArsTechnicaMod.MODID);

    public static final RegistryObject<ParticleType<SpiralDustParticleTypeData>> SPIRAL_DUST_TYPE = PARTICLES.register("spiral_dust", SpiralDustParticleType::new);

    @SubscribeEvent
    public static void registerFactories(RegisterParticleProvidersEvent evt) {
        Minecraft.getInstance().particleEngine.register(SPIRAL_DUST_TYPE.get(), SpiralDustParticleProvider::new);
    }


}