// package com.simplelife.league_of_minecraft.menus;

// import com.simplelife.league_of_minecraft.MainMod;

// import net.minecraft.world.flag.FeatureFlags;
// import net.minecraft.world.inventory.AbstractContainerMenu;
// import net.minecraft.world.inventory.MenuType;
// import net.minecraftforge.common.extensions.IForgeMenuType;
// import net.minecraftforge.eventbus.api.IEventBus;
// import net.minecraftforge.network.IContainerFactory;
// import net.minecraftforge.registries.DeferredRegister;
// import net.minecraftforge.registries.ForgeRegistries;
// import net.minecraftforge.registries.RegistryObject;

// public class MenuRegistry {
    
//     public static final DeferredRegister<MenuType<?>> MENUS =
//             DeferredRegister.create(ForgeRegistries.MENU_TYPES, MainMod.MODID);

//     public static final RegistryObject<MenuType<TigerInventoryMenu>> TIGER_INVENTORY_MENU =
//             MENUS.register("tiger_inventory_menu", () -> IForgeMenuType.create(TigerInventoryMenu::new));

//     //
//     // below method did the same as Menusupplire + IContainerFactory
//     //
//     // private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory,
//     //                                                                                               String name) {
//     //     return MENUS.register(name, () -> IForgeMenuType.create(factory));
//     // }

//     public static void register(IEventBus eventBus) {
//         MENUS.register(eventBus);
//     }
// }
