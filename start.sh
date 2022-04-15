find * -name "*.java" > sources.txt
javac @sources.txt 
java Simulator scenario.txt
#cat simulation.txt
