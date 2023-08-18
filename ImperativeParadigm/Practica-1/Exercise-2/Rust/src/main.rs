/// is_valid_width checks if the width is valid
/// (width > 0 and width is odd)
///
/// # Arguments
/// * `width` - The width of the diamond
///
/// # Returns
/// * `bool` - true if the width is valid, false otherwise
fn is_valid_width(width: u32) -> bool {
    if width < 1 {
        return false;
    }

    if width % 2 == 0 {
        return false;
    }

    true
}

/// create_diamond_figure creates a diamond figure
/// with the given width
///
/// # Arguments
/// * `width` - The width of the diamond
///
/// # Returns
/// * `String` - The diamond figure
fn create_diamond_figure(width: u32) -> String {
    let mut figure = String::new();

    let middle_index = (width / 2) + 1 as u32;
    let mut distance_from_middle = 0;

    for i in 0..width {
        let mut line = String::new();

        match i < middle_index - 1 {
            true => {
                line.push_str(&"  ".repeat((middle_index - distance_from_middle) as usize));
                line.push_str(&"* ".repeat((1 + distance_from_middle * 2) as usize));
                distance_from_middle += 1;
            }
            false => {
                    line.push_str(&"  ".repeat((middle_index - distance_from_middle) as usize));
                    line.push_str(&"* ".repeat((1 + distance_from_middle * 2) as usize));
                    if distance_from_middle > 0 {
                        distance_from_middle -= 1;
                    }
                }
        }

        figure.push_str(&line);
        figure.push('\n');
    }

    figure
}

fn main() {
    let width = 9;

    match !is_valid_width(width) {
        true => {
            panic!("Invalid width");
        }
        false => println!("{}", create_diamond_figure(width)),
    }
}
