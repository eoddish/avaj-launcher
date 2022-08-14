find * -name "*.java" > sources.txt
javac @sources.txt 
java app.Simulator scenario.txt
#cat simulation.txt
