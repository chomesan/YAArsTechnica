package net.chomesan.ars_technica.client.renderer.entity;

import net.chomesan.ars_technica.YAArsTechnicaMod;
import net.chomesan.ars_technica.common.entity.ArcanePolishEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

import javax.annotation.Nullable;

public class ArcanePolishModel extends GeoModel<ArcanePolishEntity> {

    @Override
    public void setCustomAnimations(ArcanePolishEntity entity, long uniqueID, @Nullable AnimationState<ArcanePolishEntity> customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);
    }

    @Override
    public ResourceLocation getModelResource(ArcanePolishEntity entity) {
        return new ResourceLocation(YAArsTechnicaMod.MODID, "geo/arcane_polish.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ArcanePolishEntity entity) {
        String path = "textures/entity/arcane_press.png";
        return new ResourceLocation(YAArsTechnicaMod.MODID, path);
    }

    @Override
    public ResourceLocation getAnimationResource(ArcanePolishEntity entity) {
        return new ResourceLocation(YAArsTechnicaMod.MODID, "animations/animations_arcane_polish.json");
    }
}
