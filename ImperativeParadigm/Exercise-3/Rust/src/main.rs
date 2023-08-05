#[derive(Debug, Copy, Clone)]
enum Direction {
    Left = 0,
    Right = 1
}

fn rotate_vec<T>(elements: &mut Vec<T>, direction: Direction, amount: usize) {
    match direction {
        Direction::Left => {
            for _ in 0..amount {
                let first = elements.remove(0);
                elements.push(first);
            }
        }
        Direction::Right => {
            for _ in 0..amount {
                let last = elements.pop().unwrap();
                elements.insert(0, last);
            }
        }
    }
}

fn main() {
    let mut elements = vec![1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
    println!("Original:\n{:?}", elements);
    println!();

    for _ in 0..10 {
        // Randomly rotate left or right 
        let direction = if rand::random() { Direction::Left } else { Direction::Right };
        let amount = (rand::random::<usize>() % (elements.len() - 1)) + 1;

        rotate_vec(&mut elements, direction, amount);

        println!("Rotated {:?} by {} elements:", direction, amount);
        println!("{:?}", elements);
        println!();
    }
}
