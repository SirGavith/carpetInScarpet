global_valid_tools = ['diamond_pickaxe','netherite_pickaxe', 'golden_pickaxe'];


__on_player_clicks_block(player, block, face) -> (
    tool = inventory_get(player(),player()~'selected_slot');


    //check if tool has correct enchants
    enchants = parse_nbt(tool:2:'Enchantments');
    if(enchants=='null',return());
    for(enchants,
        if(_:'id'=='minecraft:efficiency' &&_:'lvl'==5, enchants_correct = true);
    );


    if(block == 'end_stone' && global_valid_tools~(tool:0) != null && enchants_correct && query(player,'effect','haste'):0==1,

        destroy(block);
        modify(player, 'breaking_progress', null);
    );
)