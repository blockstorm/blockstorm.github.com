Marketplace
===========

Near spawn there is a marketplace where players can buy and sell almost every kind of item. It is supposed to be a central place for players to have their shops but you are allowed to open a shop wherever you want.

Buying and selling is as simple as using a chest. When taking items you automatically pay for them and you receive money when putting items in a chest. You're money is handled by the iConomy plugin, to check your balance type `/money`.

When you first join the server your account will be credited with 1000$, you can make money in three ways:

- Sell items to a shop
- Open a shop and have other players buy your items
- Vote for the server [here] (http://blockstorm.com/vote) and receive 50$ for every vote

Before opening a shop make sure to read the [market rules] (http://blockstorm.com/rules), you can also view them by typing `/rules market` in-game.

How to set up shops
===================

You will need a chest, a sign and at least one item.

1. Place the chest.
2. Put in one (or more) item(s) of the kind you want to sell/buy.
3. Place a sign above the chest.
4. Write `B:<price>` or `S:<price>` or both on it, you need at least one of them or the shop won't work. See below for a list of parameters and how to use them
5. Type `/cremove` and left-click the chest, then type `/cpublic` and left-click the chest again. This will prevent other players from destroying the chest.


Parameters
==========

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
