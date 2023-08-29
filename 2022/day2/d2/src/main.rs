use std::collections::HashMap;
use std::env;
use std::fs;

fn main() {
    // Assuming arg1 is the strategy file
    // Arg2 is the file containing the choices for the rounds
    let args: Vec<String> = env::args().collect();
    let strat = &args[1];
    let round = &args[2];

    // Extract the strategy out and store it in the hashmap strategem
    // win_pairs holds the possible wins
    // draw_pairs holds the possible draws
    // points holds the values to help calculate the total points
    let mut strategem: HashMap<String, String> = HashMap::new();
    let win_pairs = HashMap::from([("A", "Y"), ("B", "Z"), ("C", "X")]);
    let draw_pairs = HashMap::from([("A", "X"), ("B", "Y"), ("C", "Z")]);
    let points = HashMap::from([("X", 1), ("Y", 2), ("Z", 3)]);

    let strat_contents = fs::read_to_string(strat).expect("Invalid File");
    let all_strats = strat_contents.split("\n");

    // Extract the strategy plan to be used
    for s in all_strats {
        let tmp = s.to_string();
        let parts = tmp.split(" ");
        let collection: Vec<&str> = parts.collect();

        strategem.insert(collection[0].to_string(), collection[1].to_string());
    }

    let mut total_points = 0;
    let round_contents = fs::read_to_string(round).expect("Invalid File");
    let all_rounds = round_contents.split("\n");

    // Determines the points in each round for all rounds
    for r in all_rounds {
        // This is a bit unclean i dunno abt this &&str and probs can refine it
        // better
        let choice = strategem.get(r).unwrap().as_str();
        let win_check = win_pairs.get(r).unwrap();
        let draw_check = draw_pairs.get(r).unwrap();

        if win_check == &choice {
            total_points += 6 + points.get(choice).unwrap();
        } else if draw_check == &choice {
            total_points += points.get(choice).unwrap() * 2;
        } else {
            total_points += points.get(choice).unwrap()
        }
    }
    println!(
        "The max amount of points with this strategy is {}",
        total_points
    );
}
