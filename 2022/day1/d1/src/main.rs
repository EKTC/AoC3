use std::env;
use std::fs;

fn main() {
    // Grabs all the args which will be the file path
    // And then gets the file path
    let args: Vec<String> = env::args().collect();
    let fp = &args[1];

    // Gets all the contents of the file to a string
    // Splits the string based on \n\n which returns a Split Object
    let contents = fs::read_to_string(fp).expect("Invalid File");
    let elves = contents.split("\n\n");

    // Initialise variables to get the max calories and the elf associated
    let mut count = 1;
    let mut final_count = 1;
    let mut final_max = -1;

    // Loops through each elf split object
    // Splits them again and collects them into a vec
    // We loop through the new vec of &str in which we parse it to an int
    // And then sum it all up
    for elf in elves {
        let sum = elf.split("\n");
        let all_sums = sum.collect::<Vec<&str>>();

        let mut max = 0;
        for t in &all_sums {
            let n: i32 = t.parse().unwrap();
            max += n;
        }

        // If condition to reassign the max calories
        if max >= final_max {
            final_max = max;
            final_count = count;
        }
        count += 1;
    }

    println!(
        "Elf {} has the most calories which is {}",
        final_count, final_max
    )
}
