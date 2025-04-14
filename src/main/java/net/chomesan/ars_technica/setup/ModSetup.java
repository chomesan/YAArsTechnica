package net.chomesan.ars_technica.setup;

import net.chomesan.ars_technica.client.events.ModParticles;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModSetup {

  public static void registers(IEventBus modEventBus) {
    BlockRegistry.register(modEventBus);
    GlyphsRegistry.registerGlyphs();
    ItemsRegistry.register(modEventBus);
    CreativeTabRegistry.register(modEventBus);
    RecipeRegistry.register(modEventBus);
    EntityRegistry.register(modEventBus);
    ModParticles.PARTICLES.register(modEventBus);
  }
}
