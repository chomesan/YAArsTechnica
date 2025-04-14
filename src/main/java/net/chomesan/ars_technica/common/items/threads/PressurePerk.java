package net.chomesan.ars_technica.common.items.threads;
import com.hollingsworth.arsnouveau.api.perk.Perk;

import net.chomesan.ars_technica.YAArsTechnicaMod;
import net.minecraft.resources.ResourceLocation;

public class PressurePerk extends Perk {

    public static PressurePerk INSTANCE = new PressurePerk();

    public PressurePerk() {
        super(new ResourceLocation(YAArsTechnicaMod.MODID, "thread_pressure"));
    }

    @Override
    public String getLangDescription() {
        return "Grants the wielder ultra-high-pressure air within a thread to be used for other tools";
    }

    @Override
    public String getLangName() {
        return "Pressure";
    }

}