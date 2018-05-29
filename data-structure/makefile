.PHONY:clean
CPP=g++
FLAGS=-Wall -g
BIN=test
OBJS=main.o seqlist.o
$(BIN):$(OBJS)
	$(CPP) $(FLAGS) $^ -o $@
%.o:%.cpp
	$(CPP) $(FLAGS) -c $< -o $@
%.o:%.hpp
	$(CPP) $(FLAGS) -c $< -o $@
clean:
	rm -f *.o $(BIN)
