__config() -> {'scope'->'global'};

global_settings = {};
global_saplings = ['oak_sapling','spruce_sapling','birch_sapling','jungle_sapling','acacia_sapling','dark_oak_sapling'];

__command() -> null;

settingset(setting,value) -> (
    global_settings:setting = value;
);

__on_tick() -> (
    if(
        global_settings:'desert_shrubs',
        _desert_shrubs();
    );
);


_desert_shrubs() -> (
    for(_blocks(global_saplings),
        has_water = false;
        scan(_,[-4, -4, -4],[4, 1, 4],
            if(_=='water',has_water = true);
        );
        if(!has_water,set(_,'dead_bush'));
    );
);


//things I hope get implemented so I dont have to write them myself.

_blocks(blocktype) -> (
    blocklist = [];
    player_distance = 16*(system_info('game_view_distance')+1)
    for(players(),
        scan([pos(_):0,0,pos(_):2],[player_distance,256,player_distance],
            if(_==blocktype,blocklist+=_);
        );
    );
    return(blocklist);
);