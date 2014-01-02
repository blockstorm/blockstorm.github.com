Claim
=====

**We are only testing the `/claim` command for now. It might be removed again if it doesn't work well.**

The `/claim` command lets player claim land. Only the owner and allowed players are able to build on claimed land. This is supposed to prevent griefing and conflicts between players about the ownership of land.
 
Rules
-----
1. You are not allowed to claim land another player has already built on.
2. You are not allowed to claim land close to (~4 chunks) someone's building.
3. You are not allowed to claim areas like the spawn.

Commands
--------

- `/claim info` displays information about the chunk you're standing in
- `/claim chunk` claims the chunk you're standing in unless it's already claimed by someone or too close to a chunk claimed by someone
- `/claim abandon` abandons the chunk you're standing in
- `/claim greeting <message>` changes the message players see when entering land you claimed
- `/claim allow <player>` allows `<player>` to build on land you claimed
- `/claim deny <player` denies `<player>` to build on land you claimed

You can also type `/claim` in-game to view a list of commands and use `/claim <command>` for a short explanation of how they work.
