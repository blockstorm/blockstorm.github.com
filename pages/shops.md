Shops
=====

The new shop allows players to buy and sell items using commands.

To view instructions on how each command works type `/shop <command> help` e.g. `/shop buy help`.  
 The following commands are available:

- `/shop search help`
- `/shop price help`
- `/shop buy help`
- `/shop sell help`

Sign shops
==========

How to use sign shops
---------------------

Using sign shops is as simple as using a chest. When taking  items you automatically pay for them and you receive money when putting items in a chest.  
Your money is handled by the iConomy plugin. To check your balance type `/money`.

How to set up sign shops
------------------------

You will need a chest, a sign and at least one item.

1. Place the chest.
2. Put in one (or more) item(s) of the kind you want to sell/buy.
3. Place a sign above the chest.
4. Write `B:<price>` or `S:<price>` or both on it, you need at least one of them or the shop won't work. See below for a list of parameters and how to use them
5. Type `/cremove` and left-click the chest, then type `/cpublic` and left-click the chest again. This will prevent other players from destroying the chest.


Parameters
----------

Every shop requires at least one of `B:` or `S:` (else you could neither buy nor sell), they can have both.

- `B:<price>` (e.g. `B:4`) - The amount of money a player has to pay for *one* item
- `S:<price>` (e.g. `S:1,99`) - The amount of money a player gets when selling *one* item

Optional:

- `Min:<amount>` (e.g. `Min:10`) - The minimal amount of items in a shop, when it is reached customers won't be able to buy
- `Max:<amount>` (e.g. `Max:128`) - The maximal amount of items in a shop, when it is reached customers won't be able to sell

Min/ Max can be useful when selling expensive items to prevent players who have a lot of items from bankrupting you.

- `-i` - You won't be informed when someone uses your shop
- `-o` - While you're offline no one can use your shop

Remember not to put any of these parameters in the last line as it's used for the username.