#!/bin/bash
if [ "$#" = 0 ]; then
	echo "Usage: $0 <number> [options]"
	echo "where <number> is the assignment number, and [options] are any options"
	echo "you would like to pass to the final executable"
	exit 1
fi

OUTDIR=out
FILES=$(find Assignment"$1"/edu/mdc/cop2805c/assignment"$1" -type f -name \*.java)

mkdir -p "$OUTDIR"
javac -Xlint:-options --release 8 -d "$OUTDIR" $FILES
java -cp "$OUTDIR" edu.mdc.cop2805c.assignment"$1".Main -- "${@:2}"
