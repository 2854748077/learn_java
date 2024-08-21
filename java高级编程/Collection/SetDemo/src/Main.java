
/*
*      ┌───┐
       │Set│
       └───┘
         ▲
    ┌────┴─────┐
    │          │
┌───────┐ ┌─────────┐
│HashSet│ │SortedSet│
└───────┘ └─────────┘
               ▲
               │
          ┌─────────┐
          │ TreeSet │
          └─────────┘
* */

//add()
//remove（）
//contain（）


import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Message> received = List.of(
                new Message(1, "Hello!"),
                new Message(2, "发工资了吗？"),
                new Message(2, "发工资了吗？"),
                new Message(3, "去哪吃饭？"),
                new Message(3, "去哪吃饭？"),
                new Message(4, "Bye")
        );
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }

    static List<Message> process(List<Message> received) {
        // TODO: 按sequence去除重复消息
        Set<Message> squ=new HashSet<>();
        for(Message m :received){
            squ.add(m);
        }
/*        List<Message> list=new ArrayList<>();
        for(Message m:squ){
            list.add(m);
        }*/

        return new ArrayList<>(squ);
    }
}

class Message {
    public final int sequence;
    public final String text;
    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }
    public boolean equals(Object obj){                           //覆写equals(Object obj)
        if (obj instanceof Message){
            if(((Message) obj).sequence==this.sequence)
                return true;
        }
        return false;
    }
    public int hashCode(){                                      //覆写hashCode（）
        int h=0;
        h=31*h+sequence;
        return h;
    }
}