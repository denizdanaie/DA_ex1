# DA_ex1

Currently, the Main contains hardcoded simulation of the [Example 1][1] :  
Compile and run with:  
```
javac Main.java Event.java Process.java Message.java
java Main
```

TODO:
- processList, messageList and eventList could be converted to List if needed
- Event interface pretty ugly atm `new Event(processList[2], Event.Type.SEND, messageList[0]),`  
  better would be sth like `new Event(1, Type.SEND, 1),  // new Event(int processId, Type t, int messageId),` or sth

- implement classes properly (vector clock, msg buffer, history...)
- implement algorithm logic (splitted between onReceiveEvent and onSendEvent -> look at flowchart)
- test if it works correctly (try multiple scenarios)
- convert it to distributed system, using RMI
- test again


[1]: https://youtu.be/y5HvzJjYhv8?t=176  