import sys
import re


if __name__ == "__main__":
    file = sys.argv[1]
    with open(file, "r") as f:
        all_lines = f.readlines()
        all_lines = "".join(all_lines)
        parts = re.split(r"\n\n", all_lines)
        
        # List comprehension which for every list part we split up
        # We map the individual elemnts of the split to be integers
        # And turn that into a list
        all_elves = [ list(map(int, r.strip().split("\n"))) for r in parts ]
        all_sums = [ sum(e) for e in all_elves ]
        
        most_calories = max(all_sums)
        num = all_sums.index(most_calories) + 1
        
        print(f"The most calories is {most_calories} held by elf number {num}")
        
        
