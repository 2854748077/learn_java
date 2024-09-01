/*
*
*interface	non-thread-safe	    thread-safe
List	    ArrayList	        CopyOnWriteArrayList
Map	        HashMap	            ConcurrentHashMap
Set	HashSet / TreeSet	        CopyOnWriteArraySet
Queue	ArrayDeque / LinkedList	ArrayBlockingQueue / LinkedBlockingQueue
Deque	ArrayDeque / LinkedList	LinkedBlockingDeque
*
Collections.synchronizedMap();  :  旧集合转换为线程安全集合
*
*
* */


package thread_synchronization.condition;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class concurrent {

    List list=new CopyOnWriteArrayList();  //线程安全集合

    Map unsafeMap = new HashMap();
    Map threadSafeMap = Collections.synchronizedMap(unsafeMap);            //旧集合转换为线程安全集合（效率低）
}

