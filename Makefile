pkg=edu/mdc/cop2805c
opts=--release 8 -d out

run:
	mkdir -p out
	@read -p "Assignment #: " a; \
		javac $(opts) \
			Assignment$$a/$(pkg)/assignment$$a/*.java \
			Assignment$$a/$(pkg)/assignment$$a/*/*.java
	cd out && java edu.mdc.cop2805c.assignment1.Main
