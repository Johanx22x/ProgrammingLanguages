KOTLINC = kotlinc
KOTLINFLAGS = -include-runtime -d

SRC_FILES = *.kt
OUTPUT_JAR = Program.jar

all: $(OUTPUT_JAR)

$(OUTPUT_JAR): $(SRC_FILES)
	$(KOTLINC) $(KOTLINFLAGS) $@ $^

clean:
	rm -f $(OUTPUT_JAR)

run: $(OUTPUT_JAR)
	java -jar $(OUTPUT_JAR)

.PHONY: all clean run
