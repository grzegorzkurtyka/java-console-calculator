JFLAGS = -g -d classes -sourcepath ./src
JC = javac

.SUFFIXES: .java .class

SRC_PATH:=./src
SRC = $(wildcard src/calc/**/*.java) $(wildcard src/calc/**/**/*.java) $(wildcard src/calc/*.java)
CLASS=$(subst src/,classes/, $(SRC:.java=.class))

all: $(CLASS)

x:
		echo ${SRC}
		echo ${CLASS}

classes/%.class: src/%.java
		$(JC) $(JFLAGS) $<

.java.class:
	$(JC) $(JFLAGS) "$<"

clean:
		$(RM) ${CLASS}

# $(CLASS):
# $(JC) $(JFLAGS) "$<"
#%.class: %.java
#	$(JC) $(JFLAGS) "$<"
