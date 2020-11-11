
__on_player_interacts_with_block(player, hand, block, face, hitvec) -> (
    if(block ~ 'bed'&& player()~'pose' == 'sleeping',
        print(format(str('y %s is sleeping',player)));
        time = 24000*(floor(day_time()/24000)+1);
        schedule(100,'_wake_up',time);
    );
);

_wake_up(time) -> day_time(time);