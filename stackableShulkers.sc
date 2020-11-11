__config() -> {'scope'->'global'};

shulker_poss = [];

__on_tick() -> (
    for(entity_list('item')~item,
        if(!_:0~'shulker_box',return());

    )
)