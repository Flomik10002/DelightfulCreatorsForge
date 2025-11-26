package dev.flomik.delightfulcreators.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

/**
 * Tag keys for item tags used in Delightful Creators mod.
 * These tags are defined in the 'c' namespace for compatibility with other mods.
 * 
 * Usage in JSON recipes:
 *   "tag": "c:bale"
 * 
 * Usage in code:
 *   if (itemStack.is(ModTags.BALE)) { ... }
 */
public class ModTags {
    /**
     * Tag for bale items (hay blocks, rice bales, etc.)
     * Located at: data/c/tags/items/bale.json
     * Used in: horse_feed recipe
     */
    public static final TagKey<Item> BALE = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath("c", "bale")
    );

    /**
     * Tag for bone broth ingredients
     * Located at: data/c/tags/items/bone_broth_ingredients.json
     * Used in: bone_broth mixing recipe
     */
    public static final TagKey<Item> BONE_BROTH_INGREDIENTS = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath("c", "bone_broth_ingredients")
    );

    /**
     * Tag for dumplings ingredients
     * Located at: data/c/tags/items/dumplings_ingredients.json
     * Used in: dumplings sequenced_assembly recipe
     */
    public static final TagKey<Item> DUMPLINGS_INGREDIENTS = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath("c", "dumplings_ingredients")
    );

    /**
     * Tag for mushroom rice ingredients
     * Located at: data/c/tags/items/mushroom_rice_ingredients.json
     * Used in: mushroom_rice sequenced_assembly recipe
     */
    public static final TagKey<Item> MUSHROOM_RICE_INGREDIENTS = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath("c", "mushroom_rice_ingredients")
    );
}
