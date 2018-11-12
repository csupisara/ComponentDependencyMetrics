data <- read.csv(file="./Record.csv", header=T)
plot(data, xlim=c(0,1), ylim= c(0,1))
abline(1,-1)