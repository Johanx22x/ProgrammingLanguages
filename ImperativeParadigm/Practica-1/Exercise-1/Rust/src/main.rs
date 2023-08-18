struct File {
    name: String,
    data: Vec<u8>,
}

impl File {
    fn new(name: &str) -> File {
        File {
            name: String::from(name),
            data: Vec::new(),
        }
    }

    fn read(&mut self) {
        self.data = std::fs::read(&self.name).unwrap();
    }
}

struct Metadata {
    file: File,
    lines: u32,
    words: u32,
    chars: u32,
}

impl Metadata {
    fn new(file: File) -> Metadata {
        Metadata {
            file,
            lines: 0,
            words: 0,
            chars: 0,
        }
    }

    fn count_lines(&mut self) {
        let mut lines = 0;
        for byte in &self.file.data {
            if *byte == b'\n' {
                lines += 1;
            }
        }
        self.lines = lines;
    }

    fn count_words(&mut self) {
        let mut words = 0;
        let mut in_word = false;
        for byte in &self.file.data {
            match *byte {
                b'\n' | b'\t' | b' ' => {
                    if in_word {
                        in_word = false;
                        words += 1;
                    }
                }
                _ => in_word = true,
            }
        }
        self.words = words;
    }

    fn count_chars(&mut self) {
        self.chars = self.file.data.len() as u32;
    }

    fn collect(&mut self) {
        self.count_lines();
        self.count_words();
        self.count_chars();
    }
}

fn main() {
    let mut file = File::new("lorem-tiny.txt");
    file.read();

    let mut metadata = Metadata::new(file);
    metadata.collect();

    println!(
        "lines: {}, words: {}, chars: {}",
        metadata.lines, metadata.words, metadata.chars
    );
}
