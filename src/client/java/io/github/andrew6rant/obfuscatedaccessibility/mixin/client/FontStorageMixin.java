package io.github.andrew6rant.obfuscatedaccessibility.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.font.FontStorage;
import net.minecraft.client.font.Glyph;
import net.minecraft.client.font.GlyphRenderer;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static io.github.andrew6rant.obfuscatedaccessibility.config.Config.glyphspeed;

@Environment(EnvType.CLIENT)
@Mixin(FontStorage.class)
public class FontStorageMixin {
    @Shadow @Final private static Random RANDOM;

    @Inject(method = "getObfuscatedGlyphRenderer(Lnet/minecraft/client/font/Glyph;)Lnet/minecraft/client/font/GlyphRenderer;",
    at = @At(value = "HEAD"))
    public void obfuscatedaccessibility$injectSeededRandom(Glyph glyph, CallbackInfoReturnable<GlyphRenderer> cir) {
        // change the seed used for randomly choosing obfuscated font glyphs every few seconds
        RANDOM.setSeed(System.currentTimeMillis() / glyphspeed ^ glyph.hashCode());
    }
}
