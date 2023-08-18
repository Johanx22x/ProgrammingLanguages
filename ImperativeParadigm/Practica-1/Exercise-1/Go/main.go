package main

import (
	"fmt"
	"os"
	"strings"
)

// File represents a file with its name and content
type File struct {
    filename string
    content string
}

// Metadata represents the metadata of a file
type Metadata struct {
    file File
    lines int
    words int 
    characters int
}

// readFile reads the content of a file 
//
// It returns an error if the file cannot be read
// It returns nil if the file is read successfully
func (f *File) readFile() error {
    content, err := os.ReadFile(f.filename)
    if err != nil {
        return err
    }

    f.content = string(content)
    return nil
}

// countLines counts the number of lines in a file
func (m *Metadata) countLines() {
    m.lines = len(strings.Split(m.file.content, "\n"))
}

// countWords counts the number of words in a file
func (m *Metadata) countWords() {
    m.words = len(strings.Fields(m.file.content))
}

// countCharacters counts the number of characters in a file
func (m *Metadata) countCharacters() {
    m.characters = len(m.file.content)
}

// collect collects the metadata of a file
func (m *Metadata) collect() {
    m.countLines()
    m.countWords()
    m.countCharacters()
}

// toString converts the metadata of a file to a string
func (m *Metadata) toString() string {
    return fmt.Sprintf("File: %s\nLines: %d\nWords: %d\nCharacters: %d\n", m.file.filename, m.lines, m.words, m.characters)
}

// This program reads the content of a file and prints its metadata
func main() {
    file := File{filename: "lorem-tiny.txt"}
    err := file.readFile()
    if err != nil {
        panic(err)
    }

    metadata := Metadata{file: file}
    metadata.collect()
    fmt.Println(metadata.toString())
}
