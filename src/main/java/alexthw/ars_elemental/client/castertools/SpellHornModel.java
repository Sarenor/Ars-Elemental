package alexthw.ars_elemental.client.castertools;

import alexthw.ars_elemental.common.items.SpellHorn;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import static alexthw.ars_elemental.ArsElemental.prefix;

public class SpellHornModel extends AnimatedGeoModel<SpellHorn> {

    @Override
    public ResourceLocation getModelResource(SpellHorn object) {
        return prefix("geo/spell_horn.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SpellHorn object) {
        return prefix("textures/item/spell_horn.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SpellHorn animatable) {
        return prefix("animations/item/spell_horn.animation.json");
    }

}
