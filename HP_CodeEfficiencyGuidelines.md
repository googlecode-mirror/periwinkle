Guidelines for increasing running speed on low to medium end computers.

Certain tasks preformed in the game loop will naturally be slower than others. Below is a rough ordering of these tasks from slowest to fastest:

1. Rendering - will take up most of the processing power used on the game
2. collisions - brute force can be costly, but proper algorithms can make this task quite fast
3. logic - various other algorithms used in the game; these should be made as efficient as possible to not overshadow rendering and collisions.

Accomplishing this can be done by reducing the amount of nested logic and reviewing your code to spot redundancy. If your code does the same thing twice, it is because you coded it badly; you should be able to organize your tasks so that each is only done once.

Another aspect of creating efficient, workable code is to make your classes as open-ended as possible. In other words, plan ahead for your future self.