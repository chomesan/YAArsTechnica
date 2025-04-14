package net.chomesan.ars_technica.client.renderer.item;

import com.hollingsworth.arsnouveau.client.renderer.item.ArmorRenderer;
import com.hollingsworth.arsnouveau.common.armor.AnimatedMagicArmor;
import net.chomesan.ars_technica.YAArsTechnicaMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TechnomancerArmorRenderer extends ArmorRenderer {
  public TechnomancerArmorRenderer(GeoModel<AnimatedMagicArmor> modelProvider) {
    super(modelProvider);
  }

  @Override
  public ResourceLocation getTextureLocation(AnimatedMagicArmor instance) {
    return new ResourceLocation(YAArsTechnicaMod.MODID,
        "textures/armor/technomancer_medium_armor_" + instance.getColor(getCurrentStack()) + ".png");
  }
}