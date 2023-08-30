import sys

# We shall assume that the first arg will be the strategy we use
# And the next arg will be the rounds to be played out
strats = sys.argv[1]
rounds = sys.argv[2]

with open(strats, "r") as f:
    al = f.readlines()
    al = [ x.rstrip() for x in al ]

with open(rounds, "r") as f:
    ar = f.readlines()
    ar = [ x.rstrip() for x in ar ]
    

# Winning combos
# A - Y (ROCK PAPER)
# B - Z (PAPER SCISSORS)
# C - X (SCISSORS ROCK)

# Rock = 1 pt
# Paper = 2 pt
# Scissors = 3 pt
# This sets up the strategy we have to use and the value of the rounds
type_values = {"X": 1, "Y": 2, "Z": 3}
strategem = {}

for set in al:
    set = set.rstrip()
    set = set.split()
    strategem[set[0]] = set[1]


# Calculate the possible points for each round
total_points = 0
for r in ar:
    play = strategem[r]
    pair = (r, play)
    if pair == ('A', 'X') or pair == ('B', 'Y') or pair == ('C', 'Z'):
        total_points += type_values[play] * 2
    elif pair == ('A', 'Y') or pair == ('B', 'Z') or pair == ('C', 'X'):
        total_points += 6 + type_values[play]
    else:
        total_points += type_values[play]
        

print(f"The max amount of points with this strategy is {total_points}")
    